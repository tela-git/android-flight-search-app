package com.example.flightsearch.ui.appuicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsearch.R
import com.example.flightsearch.data.Airport
import com.example.flightsearch.data.Route



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightSearchBar(
    modifier: Modifier,
    onSearchValueChange: (String) -> Unit,
    searchQuery: String,
    interactionSource: MutableInteractionSource
) {

    OutlinedTextField(
        value = searchQuery,
        onValueChange = { onSearchValueChange(it) },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.small)),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search bar"
            )
        },
        shape = RoundedCornerShape(30.dp),
        placeholder = {
            Text(
                text = "Search for departure airports"
            )
        },
        singleLine = true,
        interactionSource = interactionSource
        )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AirportSearchDropDown(
    airportSearchList: List<Airport>,
    modifier: Modifier = Modifier,
    onAirportCardClicked: (Airport)-> Unit
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
                        airportInSearch = it,
                        onAirportCardClicked = onAirportCardClicked
                    )
                }
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
    )
}
