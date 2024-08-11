package com.example.flightsearch.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FlightSearchViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(FlightSearchUiState())
    val uiState = _uiState.asStateFlow()

    fun updateSearchString(changedString: String) {
        _uiState.update { it.copy(
            searchString = changedString
        ) }
    }

}


data class Airport(
    val id: Int,
    val iataCode: String,
    val name: String,
    val passengers: Int
)

data class Route(
    val id: Int,
    val departCode: String,
    val arriveCode: String
)
