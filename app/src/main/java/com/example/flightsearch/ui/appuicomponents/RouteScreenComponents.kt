package com.example.flightsearch.ui.appuicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsearch.R
import com.example.flightsearch.data.Route
import com.example.flightsearch.ui.RouteDetails


@Composable
fun RouteCard(
    modifier: Modifier = Modifier,
    route: RouteDetails,
    isFav: Boolean
) {
    Card(
        modifier = modifier.fillMaxWidth()
    )  {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ){
            Column(

            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp, 10.dp, 0.dp, 2.dp)
                ) {
                    Row() {
                        Text(
                            text = "Depart: "
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ) {
                        Text(
                            text = route.departAirportCode,
                            modifier = Modifier.padding(horizontal = 10.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = route.departAirport
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(10.dp, 2.dp, 0.dp, 10.dp)
                ) {
                    Row() {
                        Text(
                            text = "Arrive: "
                        )
                    }
                    Row(
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(
                            text = route.arriveAirportCode,
                            modifier = Modifier.padding(horizontal = 10.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = route.arriveAirport
                        )
                    }
                }
            }

            IconButton(
                onClick =  {},
            ) {
                when(isFav){
                    true ->
                        Image(
                            painter = painterResource(R.drawable.filled_star),
                            contentDescription = "Remove from favorites",
                            modifier = Modifier.padding(10.dp)
                        )
                    false ->
                        Image(
                            painter = painterResource(R.drawable.outlined_star),
                            contentDescription = "Add to favorites",
                            modifier = Modifier.padding(10.dp)
                        )
                }
            }
        }
    }
}




@Preview
@Composable
fun RouteCardPreview() {
    RouteCard(
        modifier = Modifier.fillMaxWidth(),
        route = RouteDetails(
            id = 1,
            departAirport = "Rajiv Gandhi International Airport",
            arriveAirport = "Kempegowda International Airport",
            departAirportCode = "HYD",
            arriveAirportCode = "KMP"
        ),
        isFav = false
    )
}
