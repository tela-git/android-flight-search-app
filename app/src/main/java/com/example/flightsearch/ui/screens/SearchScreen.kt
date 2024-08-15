import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.flightsearch.data.Airport
import com.example.flightsearch.ui.appuicomponents.AirportSearchDropDown



@Composable
fun SearchScreen(
    searchQuery: String,
    response: List<Airport>,
    onAirportCardClicked: (Airport)-> Unit
) {
    if (searchQuery.isEmpty()) {
        Text(
            "These are your favorite routes"
        )
    } else if (response.isNotEmpty()) {
        AirportSearchDropDown(
            airportSearchList = response,
            onAirportCardClicked = onAirportCardClicked
        )
    } else {
        Text(
            text = "No airport found..."
        )
    }
}
