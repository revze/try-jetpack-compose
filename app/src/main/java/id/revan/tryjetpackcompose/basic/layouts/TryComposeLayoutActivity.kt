package id.revan.tryjetpackcompose.basic.layouts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import id.revan.tryjetpackcompose.CustomTopAppBar

class TryComposeLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold(topBar = {
                    CustomTopAppBar(
                        title = "Layouts Sample",
                        backButtonEnabled = true,
                        onClickBackButton = {
                            finish()
                        })
                }) {
                    TryComposeLayoutScreen()
                }
            }
        }
    }
}