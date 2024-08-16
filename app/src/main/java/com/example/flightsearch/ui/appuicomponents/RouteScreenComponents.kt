package com.example.flightsearch.ui.appuicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import com.example.flightsearch.ui.RouteDetails


@Composable
fun RouteCard(
    modifier: Modifier = Modifier,
    route: RouteDetails,
    isFav: Boolean,
    addRouteToFavorites: (departCode: String, arriveCode: String)-> Unit,
    removeRouteFromFavorites: (departCode: String,arriveCode: String) -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth()
    )  {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ){
            val scrollState = rememberScrollState()

            Column(
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp, 10.dp, 0.dp, 2.dp)
                ) {
                    val sl = route.departAirport.length
                    Row() {
                        Text(
                            text = "Depart: "
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .horizontalScroll(scrollState)
                    ) {
                        Text(
                            text = route.departAirportCode,
                            modifier = Modifier.padding(horizontal = 10.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
//                            text = if (sl <= 23) {
                                route.departAirport,
//                            } else {
//                                route.departAirport.take(21) + "..."
//                            },
                            maxLines = 1
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(10.dp, 2.dp, 0.dp, 10.dp)
                ) {
                    val sl = route.arriveAirport.length
                    Row() {
                        Text(
                            text = "Arrive: "
                        )
                    }
                    Row(
                        modifier = Modifier.padding(4.dp)
                            .horizontalScroll(scrollState)
                    ) {
                        Text(
                            text = route.arriveAirportCode,
                            modifier = Modifier.padding(horizontal = 10.dp),
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
//                            text = if (sl <= 23) {
                                route.arriveAirport,
//                            } else {
//                                route.departAirport.take(21) + "..."
//                            },
                            maxLines = 1
                        )
                    }
                }
            }
            IconButton(
                onClick =  {
                    if(isFav)  {
                        removeRouteFromFavorites(route.departAirportCode,route.arriveAirportCode)
                    } else  {
                        addRouteToFavorites(route.departAirportCode,route.arriveAirportCode)
                    }
                },
                modifier = Modifier

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
            arriveAirport = "Chhatrapathi Shivaji Maharaj International Airport",
            departAirportCode = "HYD",
            arriveAirportCode = "KMP"
        ),
        isFav = false,
        addRouteToFavorites = {a,b->},
        removeRouteFromFavorites = {a,b-> }
    )
}
