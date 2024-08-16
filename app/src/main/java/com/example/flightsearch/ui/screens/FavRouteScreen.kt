package com.example.flightsearch.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(
            items = favRoutes
        ) { item->
            RouteCard(
                route = item,
                isFav = true,
                addRouteToFavorites = addRouteToFavorites,
                removeRouteFromFavorites = removeRouteFromFavorites
            )
        }
    }
}
