package id.revan.tryjetpackcompose.basic

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class TryComposeLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val columnPage = 1
                val rowPage = 2
                val boxPage = 3
                val constraintPage = 4
                var page by remember {
                    mutableStateOf(columnPage)
                }

                Column {
                    LazyRow(Modifier.padding(16.dp)) {
                        item {
                            Button(onClick = { page = columnPage }) {
                                Text(text = "Column Sample")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = { page = rowPage }) {
                                Text(text = "Row Sample")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = { page = boxPage }) {
                                Text(text = "Box Sample")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = { page = constraintPage }) {
                                Text(text = "Constraint Sample")
                            }
                        }
                    }

                    // Main content
                    Crossfade(targetState = page) {
                        when (it) {
                            columnPage -> ColumnContent()
                            rowPage -> RowContent()
                            boxPage -> BoxContent()
                            constraintPage -> ConstraintLayoutContent()
                        }
                    }
                }
            }
        }
    }
}