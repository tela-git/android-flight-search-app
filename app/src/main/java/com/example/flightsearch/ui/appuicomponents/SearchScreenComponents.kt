package com.example.flightsearch.ui.appuicomponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.flightsearch.data.Airport


@Composable
fun AirportCard(
    modifier: Modifier = Modifier,
    airportInSearch: Airport
) {
    val nm = airportInSearch.name.length
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 2.dp),
        //.fillMaxHeight(0.1f),
        colors = CardColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = MaterialTheme.colorScheme.outline,
            disabledContentColor = MaterialTheme.colorScheme.outline
        )
    ) {
        if(nm <= 35){
            Text(
                text = "${airportInSearch.iataCode} : ${airportInSearch.name}",
                maxLines = 1
            )
        } else {
            Text(
                text = "${airportInSearch.iataCode} : ${airportInSearch.name.dropLast(nm-34)}...",
                maxLines = 1
            )
        }
    }
}
