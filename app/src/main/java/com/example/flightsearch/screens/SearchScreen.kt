import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.flightsearch.data.Airport
import com.example.flightsearch.ui.airportcomponent.AirportSearchDropDown



@Composable
fun SearchScreen(
    searchQuery: String,
    response: List<Airport>
) {
    if (searchQuery.isEmpty()) {
        Text(
            "These are your favorite routes"
        )
    } else if (response.isNotEmpty()) {
        AirportSearchDropDown(
            airportSearchList = response
        )
    } else {
        Text(
            text = "No airport found..."
        )
    }
}
