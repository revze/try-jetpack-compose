package id.revan.tryjetpackcompose.basic.widgets

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import id.revan.tryjetpackcompose.CustomTopAppBar

class TryComposeBasicWidgetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold(topBar = {
                    CustomTopAppBar(
                        title = "Basic Widgets Sample",
                        backButtonEnabled = true,
                        onClickBackButton = {
                            finish()
                        })
                }) {
                    TryComposeBasicWidgetScreen()
                }
            }
        }
    }
}