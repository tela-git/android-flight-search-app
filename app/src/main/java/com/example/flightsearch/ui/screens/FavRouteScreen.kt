package com.example.flightsearch.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearch.ui.RouteDetails
import com.example.flightsearch.ui.appuicomponents.RouteCard

@Composable
fun FavRouteScreen(
    modifier: Modifier = Modifier,
    favRoutes: List<RouteDetails> = emptyList(),
    addRouteToFavorites: (String, String) -> Unit,
    removeRouteFromFavorites: (String, String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.heightIn(15.dp, 20.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Favorite Routes",
                style = MaterialTheme.typography.titleMedium
            )
        }
        LazyColumn(
            modifier = modifier
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(4.dp)
        ) {
            items(
                items = favRoutes
            ) { item ->
                RouteCard(
                    route = item,
                    addRouteToFavorites = addRouteToFavorites,
                    removeRouteFromFavorites = removeRouteFromFavorites
                )
            }
        }
    }
}
