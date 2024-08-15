package com.example.flightsearch.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.flightsearch.data.Favorite
import com.example.flightsearch.data.Route
import com.example.flightsearch.ui.RouteDetails
import com.example.flightsearch.ui.appuicomponents.RouteCard

@Composable
fun FavRouteScreen(
    modifier: Modifier = Modifier,
    favRoutes: List<RouteDetails>
) {
    LazyColumn(
        modifier = modifier
    ) {
        favRoutes.forEach { favRoute->
            item {
                RouteCard(
                    isFav = true,
                    route = favRoute
                )
            }
        }
    }
}

