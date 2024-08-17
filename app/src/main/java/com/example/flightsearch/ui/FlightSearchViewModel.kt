package com.example.flightsearch.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearch.data.FlightSearchRepository
import com.example.flightsearch.data.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.system.exitProcess

@HiltViewModel
class FlightSearchViewModel @Inject constructor(
    private val flightSearchRepo: FlightSearchRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(FlightSearchUiState())
    val uiState = _uiState.asStateFlow()

    //function that converts Route table entity to RouteDetails data class which takes two extra parameters(airport names)
    private suspend fun toRouteDetails(routes: List<Route>): List<RouteDetails> {
        return routes.map{ route->
            RouteDetails(
                id = route.id,
                arriveAirportCode = route.arriveCode,
                departAirportCode = route.departCode,
                arriveAirport = flightSearchRepo.getAirportNameByCode(route.arriveCode)?: "Error fetching airport name !",
                departAirport = flightSearchRepo.getAirportNameByCode(route.departCode)?: "Error fetching airport name !",
                isFav = route.isFav
           )
        }
    }

    //function to update the searchQuery typed in the searchBar and get all the airport names matching with the name or code
    fun updateSearchString(changedString: String) {
        _uiState.update {
            it.copy(
                searchString = changedString,
                isLoading = true,
                error = null // Reset error on new search
            )
        }
        viewModelScope.launch {
            try {
                if(changedString.isNotEmpty()) {
                    flightSearchRepo.getAirport(changedString).collect { airports ->
                        _uiState.update { state ->
                            state.copy(
                                response = airports,
                                isLoading = false
                            )
                        }
                    }
                }
            } catch (e: Exception) {
                _uiState.update { state ->
                    state.copy(
                        isLoading = false,
                        error = e.message ?: "An unexpected error occurred"
                    )
                }
            }
        }
    }

    //function to get a list of routes with the provided airport for departure
    fun routesListFromAirport(deptAirportCode: String?): RoutesFromAirport {
        try {
            if (deptAirportCode.isNullOrBlank()) {
                return RoutesFromAirport(
                    routesList = emptyList(),
                    isEmpty = true
                )
            } else {
                viewModelScope.launch {
                    flightSearchRepo.getRoutesList(deptAirportCode)
                        .map { routes ->
                            if(routes.isNotEmpty()) toRouteDetails(routes) else emptyList()
                        }
                        .collect { routes ->
                            if(routes.isNotEmpty()){
                                _uiState.update { state ->
                                    state.copy(
                                        routesFromAirport = RoutesFromAirport(
                                            routesList = routes,
                                            isEmpty = false
                                        )
                                    )
                                }
                            } else {
                                _uiState.update { state->
                                    state.copy(
                                        routesFromAirport = RoutesFromAirport(
                                            routesList = emptyList(),
                                            isEmpty = true
                                        )
                                    )
                                }
                            }
                        }
                }
                return uiState.value.routesFromAirport
            }
        } catch (e: Exception) {
            return uiState.value.routesFromAirport
        }
    }

    fun addRouteToFav(departAirportCode: String, arriveAirportCode: String) {
        viewModelScope.launch {
            flightSearchRepo.addToFavorite(departCode = departAirportCode, arriveCode = arriveAirportCode)
        }
    }

    fun removeRouteFromFav(departAirportCode: String, arriveAirportCode: String) {
        viewModelScope.launch {
            flightSearchRepo.removeFromFavorite(departAirportCode, arriveAirportCode)
        }
    }

    fun changeSearchBarActiveStatus(isActive: Boolean) {
        _uiState.update {
            it.copy(
                isSearchBarActive = isActive
            )
        }
    }

    init {
        viewModelScope.launch {
            flightSearchRepo.getFavoriteRoutesList()
                .map { routes -> toRouteDetails(routes) }
                .collect { routeDetails ->
                    _uiState.update {
                        it.copy(favRoutesList = routeDetails)
                    }
                }
        }
    }
}


data class AirportDetails(
    val id: Int,
    val iataCode: String,
    val name: String,
    val passengers: Int
)

data class RouteDetails(
    val id: Int,
    val departAirport: String,
    val arriveAirport: String,
    val departAirportCode: String,
    val arriveAirportCode: String,
    val isFav: Boolean
)


