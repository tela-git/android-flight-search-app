package com.example.flightsearch.ui

import android.hardware.camera2.CameraExtensionSession.StillCaptureLatency
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.runtime.State
import com.example.flightsearch.data.Airport
import com.example.flightsearch.data.Route
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


data class FlightSearchUiState(
    val searchString: String = "",
    val response: List<Airport> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val interactionSource: MutableInteractionSource = MutableInteractionSource(),
    val favRoutesList: List<RouteDetails> = emptyList()

)

