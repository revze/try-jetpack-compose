package id.revan.tryjetpackcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.revan.tryjetpackcompose.entity.Sample

@Composable
fun CustomTopAppBar(
    title: String,
    backButtonEnabled: Boolean = false,
    onClickBackButton: () -> Unit = {}
) {
    TopAppBar {
        if (backButtonEnabled) {
            Icon(
                Icons.Rounded.ChevronLeft,
                contentDescription = "Back Button",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
                    .clickable {
                        onClickBackButton()
                    }
            )
        }
        Text(
            text = title,
            style = TextStyle(fontSize = 16.sp, color = Color.White),
            fontWeight = FontWeight.Bold,
            modifier = if (!backButtonEnabled)
                Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            else
                Modifier
                    .align(Alignment.CenterVertically)
                    .padding(
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
        )
    }
}

@Composable
fun SampleDropdownMenu(samples: List<Sample>, selectedSample: Sample, onSelect: (Sample) -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Column(Modifier.padding(16.dp)) {
        Text(
            text = "Select Sample:",
            modifier = Modifier.padding(bottom = 8.dp),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp)
        )
        Box {
            Card(
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        expanded = true
                    }, border = BorderStroke(1.dp, color = Color.LightGray)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedSample.name,
                    )
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }
            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }, modifier = Modifier.fillMaxWidth()) {
                samples.forEach { item ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        onSelect(item)
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = item.name)
                    }
                }
            }
        }

    }
}
