package com.example.flightsearch.ui.appuicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flightsearch.data.Airport


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightSearchBar(
    onSearchValueChange: (String) -> Unit,
    searchQuery: String,
    onSearchBarActiveChange: (Boolean) -> Unit,
    isActive: Boolean,
    response: List<Airport>,
    onAirportCardClicked: (Airport) -> Unit,
    navController: NavController,
    isLoading: Boolean,
    modifier: Modifier
) {
    SearchBar(
        active = isActive,
        onActiveChange = {
            onSearchBarActiveChange(it)
        },
        onQueryChange = { onSearchValueChange(it) },
        onSearch = {},
        query = searchQuery,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        placeholder = {
            Text(
                text = "Search for departure airports"
            )
        },
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        tonalElevation = 10.dp,
        shadowElevation = 8.dp,
        modifier = Modifier
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
                    onAirportCardClicked = onAirportCardClicked,
                    modifier = modifier
                )
            } else {
                Text(
                    text = "No airport found !"
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AirportSearchDropDown(
    airportSearchList: List<Airport>,
    modifier: Modifier = Modifier,
    onAirportCardClicked: (Airport)-> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(
            items = airportSearchList
        ) { item->
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 0.dp),
                shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            ) {
                AirportCard(
                    airportInSearch = item,
                    onAirportCardClicked = onAirportCardClicked
                )

            }
        }

    }

}


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
