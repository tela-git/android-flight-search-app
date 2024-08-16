
import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flightsearch.R
import com.example.flightsearch.data.Airport
import com.example.flightsearch.data.Route
import com.example.flightsearch.ui.RouteDetails
import com.example.flightsearch.ui.appuicomponents.AppTopBar
import com.example.flightsearch.ui.appuicomponents.FlightSearchBar
import com.example.flightsearch.ui.screens.FavRouteScreen
import com.example.flightsearch.ui.screens.RouteScreen


@Composable
fun HomeScreen(
    modifier: Modifier,
    searchQuery: String,
    onSearchValueChange: (String)->Unit,
    response: List<Airport>,
    error: String?,
    isLoading: Boolean,
    favRoutes: List<RouteDetails>,
    addRouteToFavorites: (String, String) -> Unit,
    removeRouteFromFavorites: (String, String) -> Unit,
    isSearchBarActive: Boolean,
    onSearchBarActiveChange: (Boolean) -> Unit
) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            AppTopBar()
        },
        modifier = modifier,
    ) {innerPadding->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FlightSearchBar(
                    modifier = modifier,
                    onSearchValueChange = onSearchValueChange,
                    searchQuery = searchQuery,
                    onSearchBarActiveChange = onSearchBarActiveChange,
                    isActive = isSearchBarActive,
                    response = response,
                    onAirportCardClicked = {},
                    navController = navController,
                    isLoading = isLoading
                )

                NavHost(
                    navController = navController,
                    startDestination = "FavoritesScreen"
                ) {
                    composable(route = "FavoritesScreen") {
                        FavRouteScreen(
                            favRoutes = favRoutes,
                            addRouteToFavorites = addRouteToFavorites,
                            removeRouteFromFavorites = removeRouteFromFavorites
                        )
                    }
                    composable(route = "RouteScreen") {
                        RouteScreen()
                    }
                }


            }

    }
}





@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier.fillMaxSize(),
        searchQuery = "",
        onSearchValueChange = { },
        response = listOf(
            Airport(
                id = 0,
                name = "Rajiv Gandhi International Airport",
                iataCode = "HYD",
                passengers = 0
            ),
            Airport(
                id = 1,
                name = "Chhatrapati Shivaji Maharaj International Airport",
                iataCode = "BOM",
                passengers = 13
            )
        ),
        error = "",
        isLoading = false,
        addRouteToFavorites = {a,b ->},
        removeRouteFromFavorites = {a,b ->},
        isSearchBarActive = false,
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

            ),
        onSearchBarActiveChange = {}
    )
}