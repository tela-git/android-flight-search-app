
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsearch.R
import com.example.flightsearch.data.Airport
import com.example.flightsearch.ui.AirportSearchDropDown

@Composable
fun HomeScreen(
    modifier: Modifier,
    searchQuery: String,
    onSearchValueChange: (String)->Unit,
    response: List<Airport>,
    error: String?,
    isLoading: Boolean
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
            if(response.isNotEmpty()){
                AirportSearchDropDown(
                    airportSearchList = response
                )
            } else {
                Text(
                    text = "Try search your favorite airports..."
                )
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightSearchBar(
    modifier: Modifier,
    onSearchValueChange: (String) -> Unit,
    searchQuery: String
) {

   OutlinedTextField(
       value = searchQuery,
       onValueChange = onSearchValueChange,
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

   )
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
        isLoading = true
    )
}