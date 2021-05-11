package id.revan.tryjetpackcompose

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(vararg onClick: () -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .padding(16.dp)
            .scrollable(scrollState, Orientation.Vertical)
    ) {
        CustomButton(text = "Layouts Sample") {
            onClick[0].invoke()
        }
        CustomButton(text = "Basic Widgets Sample") {
            onClick[1].invoke()
        }
        CustomButton(text = "Lists Sample") {
            onClick[2].invoke()
        }
        CustomButton(text = "ViewModel & LiveData Sample") {
            onClick[3].invoke()
        }
        CustomButton(text = "Compose in Fragment Sample") {
            onClick[4].invoke()
        }
    }
}

@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = {
            onClick()
        },
        Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(text = text)
    }
}