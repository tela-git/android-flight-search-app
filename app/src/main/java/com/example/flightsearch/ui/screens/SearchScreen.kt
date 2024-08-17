package com.example.flightsearch.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearch.data.Airport
import com.example.flightsearch.ui.appuicomponents.AirportSearchDropDown


@Composable
fun SearchSuggestionsScreen(
    searchQuery: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    response: List<Airport>,
    onAirportCardClicked: (Airport)-> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){ if(searchQuery.isEmpty()) {
        Text(
            text = "Try searching DEL or Indira...",
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
    } else if(isLoading) {
        modifier
            .height(150.dp)
            .align(Alignment.CenterHorizontally)
        CircularProgressIndicator(
        )
    } else if (response.isNotEmpty()) {
        AirportSearchDropDown(
            airportSearchList = response,
            modifier = modifier,
            onAirportCardClicked = onAirportCardClicked
        )
    } else {
        Text(
            text = "No airport found !"
        )
    }
    }
}
