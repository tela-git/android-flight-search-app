
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
    interactionSource: MutableInteractionSource
) {
   var isSearchBarFocused: Boolean = interactionSource.collectIsFocusedAsState().value
    Scaffold(
        topBar = {
            AppTopBar()
        },
        modifier = modifier,
    ) {innerPadding->
        val navController = rememberNavController()

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(dimensionResource(R.dimen.small)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FlightSearchBar(
                modifier = Modifier,
                onSearchValueChange = onSearchValueChange,
                searchQuery = searchQuery,
                interactionSource = interactionSource
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Button(
                    onClick = { navController.navigate("SearchScreen") }
                ) {
                    Text(
                        text = "Search"
                    )
                }
                Button(
                    onClick = { navController.navigate("SearchScreen") }
                ) {
                    Text("Favorites"
                    )
                }
            }

            NavHost(
                navController = navController,
                startDestination = "FavoritesScreen"
            ) {
                val favRoutes: List<RouteDetails> = listOf()
                composable(route = "FavoritesScreen") {
                    FavRouteScreen(favRoutes = favRoutes)
                }
                composable(route = "SearchScreen") {
                    SearchScreen(
                        searchQuery = searchQuery,
                        response = response,
                        onAirportCardClicked = { isSearchBarFocused = false }
                    )
                }
                composable(route = "RouteScreen") {
                    RouteScreen()
                }
            }



        }
    }
}





//@Preview
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen(
//        modifier = Modifier.fillMaxSize(),
//        searchQuery = "",
//        onSearchValueChange = { },
//        response = listOf(
//            Airport(
//                id = 0,
//                name = "Rajiv Gandhi International Airport",
//                iataCode = "HYD",
//                passengers = 0
//            ),
//            Airport(
//                id = 1,
//                name = "Chhatrapati Shivaji Maharaj International Airport",
//                iataCode = "BOM",
//                passengers = 13
//            )
//        ),
//        error = "",
//        isLoading = true,
//        isSearchBarFocused = true,
//        interactionSource =
//    )
//}