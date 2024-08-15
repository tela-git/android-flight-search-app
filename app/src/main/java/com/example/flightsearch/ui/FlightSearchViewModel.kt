package com.example.flightsearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsearch.data.FlightSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlightSearchViewModel @Inject constructor(
    private val flightSearchRepo: FlightSearchRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(FlightSearchUiState())
    val uiState = _uiState.asStateFlow()

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
    val arriveAirportCode: String
)


