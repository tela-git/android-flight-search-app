package com.example.flightsearch.ui.appuicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.flightsearch.data.Airport
import com.example.flightsearch.ui.screens.SearchSuggestionsScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightSearchBar(
    onSearchValueChange: (String) -> Unit,
    searchQuery: String,
    onSearchBarActiveChange: (Boolean) -> Unit,
    isActive: Boolean,
    response: List<Airport>,
    onAirportCardClicked: (Airport) -> Unit,
    navController: NavHostController,
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
            if(isActive.not()){
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            } else {
                IconButton(
                    onClick = {
                        onSearchBarActiveChange(false)
                        navController.navigate("FavoritesScreen") {
                            popUpTo("FavoritesScreen") {inclusive = false}
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "Navigate Up"
                    )
                }
            }
        },
        trailingIcon = {
            if(isActive){
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
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

        SearchSuggestionsScreen(
            searchQuery = searchQuery,
            isLoading = isLoading,
            response = response,
            onAirportCardClicked = { Airport ->
                navController.navigate("RoutesFromAnAirportScreen/${Airport.iataCode}") {
                    popUpTo("RoutesFromAnAirportScreen") {inclusive = false}
                }
                onSearchBarActiveChange(false)

            }
        )
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
