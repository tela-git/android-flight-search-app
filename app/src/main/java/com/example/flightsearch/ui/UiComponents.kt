package com.example.flightsearch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.flightsearch.data.Airport


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AirportSearchDropDown(
    airportSearchList: List<Airport>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            ) {
                airportSearchList.forEach {
                    AirportCard(
                        airportInSearch = it
                    )
                }
            }
        }

    }

}


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

@Preview
@Composable
fun AirportCardPreview() {
    AirportCard(
        modifier = Modifier.fillMaxWidth(),
            Airport(
                id = 1,
                name = "Rajiv Gandhi International Airport Hyderabad",
                iataCode = "HYD",
                passengers = 234
            )

    )
}