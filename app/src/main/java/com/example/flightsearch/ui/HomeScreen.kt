
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.flightsearch.R
import com.example.flightsearch.data.Airport
import com.example.flightsearch.ui.appuicomponents.AppTopBar
import com.example.flightsearch.ui.appuicomponents.FlightSearchBar
import com.example.flightsearch.ui.screens.RouteScreen

@Composable
fun HomeScreen(
    modifier: Modifier,
    searchQuery: String,
    onSearchValueChange: (String)->Unit,
    response: List<Airport>,
    error: String?,
    isLoading: Boolean,
    isSearchActive: Boolean
) {
    Scaffold(
        topBar = {
            AppTopBar()
        },
        modifier = modifier,
    ) {innerPadding->
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
                searchQuery = searchQuery
            )

            when(isSearchActive) {
               true-> SearchScreen(
                   searchQuery = searchQuery,
                   response = response
               )

                false -> {
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
        isLoading = true,
        isSearchActive = true
    )
}