package com.example.flightsearch.ui.appuicomponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsearch.data.Airport


@Composable
fun AirportCard(
    modifier: Modifier = Modifier,
    airportInSearch: Airport,
    onAirportCardClicked:(Airport) -> Unit
) {
    val nm = airportInSearch.name.length
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 0.dp)
            .heightIn(max = 28f.dp),
        colors = CardColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = MaterialTheme.colorScheme.outline,
            disabledContentColor = MaterialTheme.colorScheme.outline
        ),
        onClick = {
            onAirportCardClicked(airportInSearch)
        }
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

@Composable
@Preview
fun AirportCardPreview() {
    AirportCard(
        airportInSearch = Airport(1,"Rajiv Gandhi International Airport","HYD",234),
        onAirportCardClicked = {}
    )
}