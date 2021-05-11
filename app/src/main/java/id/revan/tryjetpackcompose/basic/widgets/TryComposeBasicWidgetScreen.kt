package id.revan.tryjetpackcompose.basic.widgets

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.revan.tryjetpackcompose.R
import id.revan.tryjetpackcompose.SampleDropdownMenu
import id.revan.tryjetpackcompose.entity.Sample

@Composable
@Preview("All content")
fun TryComposeBasicWidgetScreen() {
    val samples = listOf(
        Sample(id = 1, name = "Text Sample"),
        Sample(id = 2, name = "Button Sample"),
        Sample(id = 3, name = "TextField Sample"),
        Sample(id = 4, name = "Image & Icon Sample"),
        Sample(id = 5, name = "DropdownMenu Sample"),
        Sample(id = 6, name = "Checkbox Sample"),
        Sample(id = 7, name = "RadioButton Sample")
    )
    var selectedSample by remember {
        mutableStateOf(samples[0])
    }
    val scrollState = rememberScrollState()
    Column(Modifier.scrollable(scrollState, Orientation.Vertical)) {
        SampleDropdownMenu(samples = samples, selectedSample = selectedSample) {
            selectedSample = it
        }

        // Main content
        Crossfade(targetState = selectedSample) {
            when (it.id) {
                1 -> SampleTextContent()
                2 -> SampleButtonContent()
                3 -> SampleTextFieldContent()
                4 -> SampleImageContent()
                5 -> SampleDropdownContent()
                6 -> SampleCheckboxContent()
                7 -> SampleRadioButtonContent()
            }
        }
    }
}


@Composable
@Preview("Sample Text Content")
fun SampleTextContent() {
    Column(Modifier.padding(16.dp)) {
        Text("Just Text")
        Text(stringResource(R.string.text_from_string_resource))
        Text("Colored Text", color = Color.Blue)
        Text("Italic Text", fontStyle = FontStyle.Italic)
        Text("Bold Text", fontWeight = FontWeight.Bold)
        Text(
            "Text with underline",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            "Text with line through",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text("Text align center", Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text("Text with custom font size", style = TextStyle(fontSize = 18.sp))
        Text(
            "Text with custom font family",
            style = TextStyle(fontFamily = FontFamily.Cursive)
        )
    }
}

@Composable
@Preview("Sample Button Content")
fun SampleButtonContent() {
    Column(Modifier.padding(16.dp)) {
        Button({
            // Handle click event
        }) {
            Text("Submit")
        }
        Spacer(Modifier.height(8.dp))
        OutlinedButton({
            // Handle click event
        }) {
            Text("Submit Outlined Button")
        }
        Spacer(Modifier.height(8.dp))
        TextButton({
            // Handle click event
        }) {
            Text("Submit Text Button")
        }
        Spacer(Modifier.height(8.dp))
        IconButton({
            // Handle click event
        }) {
            Icon(Icons.Rounded.Download, contentDescription = null)
        }
        Spacer(Modifier.height(8.dp))
        FloatingActionButton({
            // Handle click event
        }) {
            Icon(Icons.Rounded.Search, contentDescription = null)
        }
    }
}

@Composable
@Preview("Text Field Content")
fun SampleTextFieldContent() {
    Column(Modifier.padding(16.dp)) {
        TextField("", {
            // Handle on value changed event
        }, label = {
            Text("Sample Label")
        }, placeholder = {
            Text("Sample Placeholder")
        }, modifier = Modifier.padding(bottom = 16.dp))
        OutlinedTextField("", {
            // Handle on value changed event
        }, label = {
            Text("Sample Label")
        }, placeholder = {
            Text("Sample Placeholder")
        })
    }
}

@Composable
@Preview("Sample Image Content")
fun SampleImageContent() {
    Column(Modifier.padding(16.dp)) {
        Image(
            painterResource(R.drawable.ic_verified),
            contentDescription = "Verified Icon",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Image(
            painterResource(R.drawable.bg_mount),
            contentDescription = null,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Image(
            painterResource(R.drawable.bg_mount),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp, 300.dp)
                .padding(bottom = 16.dp)
        )
        Icon(
            Icons.Rounded.Settings,
            contentDescription = null,
            tint = Color.Green
        )
    }
}

@Composable
@Preview("Sample Dropdown Content")
fun SampleDropdownContent() {
    Box(Modifier.padding(16.dp)) {
        val options = listOf(
            "Select City",
            "Jakarta Timur",
            "Jakarta Barat",
            "Jakarta Selatan",
            "Jakarta Utara",
            "Jakarta Pusat"
        )
        var isExpanded by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf(options[0]) }

        Card(modifier = Modifier
            .clickable {
                isExpanded = true
            }
            .fillMaxWidth()
            .align(Alignment.TopStart), border = BorderStroke(1.dp, Color.DarkGray)) {
            Text(selectedOption, Modifier.padding(16.dp))
        }
        DropdownMenu(isExpanded, {
            // On dismissed
            isExpanded = false
        },
            Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)) {
            options.forEach {
                DropdownMenuItem({
                    // On item selected
                    isExpanded = false
                    selectedOption = it
                }) {
                    Text(it, Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@Composable
@Preview("Sample Checkbox Content")
fun SampleCheckboxContent() {
    var isChecked by remember { mutableStateOf(false) }
    Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(isChecked, {
            // On click checkbox
            isChecked = it
        })
        Text("I agree to the terms & conditions.", Modifier.padding(start = 8.dp))
    }
}

@Composable
@Preview("Sample RadioButton Content")
fun SampleRadioButtonContent() {
    var gender by remember { mutableStateOf("male") }
    Column(Modifier.padding(16.dp)) {
        Text("Select gender:", modifier = Modifier.padding(bottom = 16.dp))
        Row(Modifier.padding(bottom = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(gender == "male", {
                // on click radio button
                gender = "male"
            })
            Text("Male", Modifier.padding(start = 8.dp))
        }
        Row(Modifier.padding(bottom = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(gender == "female", {
                // on click radio button
                gender = "female"
            })
            Text("Female", Modifier.padding(start = 8.dp))
        }
    }
}