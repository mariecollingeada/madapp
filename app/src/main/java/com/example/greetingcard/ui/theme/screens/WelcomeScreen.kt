import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.greetingcard.R
import com.example.greetingcard.composables.FilterChips
import com.example.greetingcard.composables.SearchBar
import com.example.greetingcard.composables.VendorResults
import com.example.greetingcard.viewmodels.VendorViewModel

@ExperimentalMaterial3Api
@Composable
fun WelcomeScreen(viewModel: VendorViewModel, navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                ),
                title = {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Header(modifier = Modifier.height(200.dp)) // Ensure this matches the height set in the Header
                    }
                }
            )
        },
//        bottomBar = {
//            BottomAppBar(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                contentColor = MaterialTheme.colorScheme.primary,
//            ) {
//                Text(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    textAlign = TextAlign.Center,
//                    text = "Bottom app bar",
//                )
//            }
//        },
    )
    { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "Plan your perfect party!\n" +
                        "From birthdays to baby showers, christenings to engagements, whatever the occasion - we've got you covered."
            )
            SearchBar(viewModel)
            FilterChips(viewModel)
            VendorResults(viewModel, navController)
        }
    }
}

@Composable
fun Header(modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.header), contentDescription = null)
}