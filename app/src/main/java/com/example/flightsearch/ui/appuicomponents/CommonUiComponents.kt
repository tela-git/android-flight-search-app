package com.example.flightsearch.ui.appuicomponents

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.flightsearch.data.Airport


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = "Flight Search",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
        }
    )
}


@Preview
@Composable
fun SearchScreenPreview() {
    AirportSearchDropDown(
        airportSearchList = listOf(
            Airport(1, "Rajiv Gandhi International Airport", "HYD", 3223),
            Airport(2, "Chhatrapati Shivaji Maharaj International Airport", "BOM", 4231),
            Airport(3, "Kempegowda International Airport", "BLR", 3500),
            Airport(4, "Chennai International Airport", "MAA", 2890),
            Airport(5, "Netaji Subhas Chandra Bose International Airport", "CCU", 3100),
            Airport(6, "Indira Gandhi International Airport", "DEL", 5000),
            Airport(7, "Cochin International Airport", "COK", 2800),
            Airport(8, "Pune International Airport", "PNQ", 1900),
            Airport(9, "Trivandrum International Airport", "TRV", 1700),
            Airport(10, "Goa International Airport", "GOI", 2100),
            Airport(11, "Sardar Vallabhbhai Patel International Airport", "AMD", 2400)

        ),
        onAirportCardClicked = {},
    )
}
