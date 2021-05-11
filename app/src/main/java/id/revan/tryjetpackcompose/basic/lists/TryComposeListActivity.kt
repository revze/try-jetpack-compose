package id.revan.tryjetpackcompose.basic.lists

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import id.revan.tryjetpackcompose.CustomTopAppBar

class TryComposeListActivity : AppCompatActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold(topBar = {
                    CustomTopAppBar(
                        title = "Lists Sample",
                        backButtonEnabled = true,
                        onClickBackButton = {
                            finish()
                        })
                }) {
                    TryComposeListScreen()
                }
            }
        }
    }
}