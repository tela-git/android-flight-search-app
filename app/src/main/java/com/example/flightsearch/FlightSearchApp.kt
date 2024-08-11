package com.example.flightsearch

import HomeScreen
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearch.ui.FlightSearchUiState
import com.example.flightsearch.ui.FlightSearchViewModel


@Composable
fun flightSearchApp(
    modifier: Modifier
) {
    val appViewModel: FlightSearchViewModel= hiltViewModel()
    val appUiState: FlightSearchUiState by appViewModel.uiState.collectAsState()
    HomeScreen(
        modifier = modifier
            .fillMaxSize(),
        searchQuery = appUiState.searchString,
        onSearchValueChange = { appViewModel.updateSearchString(it) }
    )
}
