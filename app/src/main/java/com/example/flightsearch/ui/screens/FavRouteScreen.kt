package com.example.flightsearch.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsearch.ui.RouteDetails
import com.example.flightsearch.ui.appuicomponents.RouteCard

@Composable
fun FavRouteScreen(
    modifier: Modifier = Modifier,
    favRoutes: List<RouteDetails>
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
                isFav = true
            )
        }
    }
}


@Preview
@Composable
fun FavRouteScreenPreview() {
    FavRouteScreen(
        favRoutes = listOf(
                        RouteDetails(
                            id = 1,
                            departAirport = "Sardar Vallabhbhai Patel International Airport",
                            arriveAirport = "Srinagar International Airport",
                            departAirportCode = "SVP",
                            arriveAirportCode = "SIA"
                        ),
                        RouteDetails(
                            id = 2,
                            departAirport = "Indira Gandhi International Airport",
                            arriveAirport = "Chhatrapati Shivaji Maharaj International Airport",
                            departAirportCode = "DEL",
                            arriveAirportCode = "BOM"
                        ),

                        RouteDetails(
                            id = 3,
                            departAirport = "Kempegowda International Airport",
                            arriveAirport = "Netaji Subhas Chandra Bose",
                            departAirportCode = "BLR",
                            arriveAirportCode = "CCU"
                        ),

                        RouteDetails(
                            id = 4,
                            departAirport = "Rajiv Gandhi International Airport",
                            arriveAirport = "Cochin International Airport",
                            departAirportCode = "HYD",
                            arriveAirportCode = "COK"
                        ),

                        RouteDetails(
                            id = 5,
                            departAirport = "Chennai International Airport",
                            arriveAirport = "Goa International Airport",
                            departAirportCode = "MAA",
                            arriveAirportCode = "GOI"
                        ),

                        RouteDetails(
                            id = 6,
                            departAirport = "Pune International Airport",
                            arriveAirport = "Jaipur International Airport",
                            departAirportCode = "PNQ",
                            arriveAirportCode = "JAI"
                        ),

                        RouteDetails(
                            id = 7,
                            departAirport = "Trivandrum International Airport",
                            arriveAirport = "Chaudhary Charan Singh International Airport",
                            departAirportCode = "TRV",
                            arriveAirportCode = "LKO"
                        ),

                        RouteDetails(
                            id = 8,
                            departAirport = "Surat International Airport",
                            arriveAirport = "Veer Savarkar International Airport",
                            departAirportCode = "STV",
                            arriveAirportCode = "IXZ"
                        ),

                        RouteDetails(
                            id = 9,
                            departAirport = "Madurai Airport",
                            arriveAirport = "Lokpriya Gopinath Bordoloi International Airport",
                            departAirportCode = "IXM",
                            arriveAirportCode = "GAU"
                        ),

                        RouteDetails(
                            id = 10,
                            departAirport = "Vadodara Airport",
                            arriveAirport = "Lal Bahadur Shastri International Airport",
                            departAirportCode = "BDQ",
                            arriveAirportCode = "VNS"
                        ),

                        RouteDetails(
                            id = 11,
                            departAirport = "Visakhapatnam Airport",
                            arriveAirport = "Biju Patnaik International Airport",
                            departAirportCode = "VTZ",
                            arriveAirportCode = "BBI"
                        ),


        )
    )
}

