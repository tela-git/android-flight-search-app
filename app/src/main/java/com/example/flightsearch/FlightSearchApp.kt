package com.example.flightsearch

import HomeScreen
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.flightsearch.ui.FlightSearchUiState
import com.example.flightsearch.ui.FlightSearchViewModel
import com.example.flightsearch.ui.RouteDetails


@Composable
fun FlightSearchApp(
    modifier: Modifier
) {
    val appViewModel: FlightSearchViewModel= hiltViewModel()
    val appUiState: FlightSearchUiState by appViewModel.uiState.collectAsState()
    HomeScreen(
        modifier = modifier
            .fillMaxSize(),
        searchQuery = appUiState.searchString,
        onSearchValueChange = { appViewModel.updateSearchString(it) },
        response = appUiState.response,
        error = appUiState.error,
        isLoading = appUiState.isLoading,
        favRoutes = appUiState.favRoutesList,
        addRouteToFavorites = { departCode,arriveCode-> appViewModel.addRouteToFav(departAirportCode = departCode, arriveAirportCode = arriveCode) },
        removeRouteFromFavorites =  { departCode, arriveCode -> appViewModel.removeRouteFromFav(departCode,arriveCode) },
        isSearchBarActive = appUiState.isSearchBarActive,
        onSearchBarActiveChange = { appViewModel.changeSearchBarActiveStatus(it)},
        getroutesListFromAnAirport = { appViewModel.routesListFromAirport(it) }
    )
}
