package com.example.flightsearch.ui

import android.hardware.camera2.CameraExtensionSession.StillCaptureLatency
import com.example.flightsearch.data.Airport
import com.example.flightsearch.data.Route


data class FlightSearchUiState(
    val searchString: String = "",
    val response: List<Airport> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSearchActive: Boolean = false
)
