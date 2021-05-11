package id.revan.tryjetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import id.revan.tryjetpackcompose.basic.layouts.TryComposeLayoutActivity
import id.revan.tryjetpackcompose.basic.lists.TryComposeListActivity
import id.revan.tryjetpackcompose.basic.widgets.TryComposeBasicWidgetActivity
import id.revan.tryjetpackcompose.fragment.InfoDialogFragment
import id.revan.tryjetpackcompose.socialmedia.UserStatusActivity

class MainActivity : AppCompatActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold(
                    topBar = {
                        CustomTopAppBar(title = "Try Jetpack Compose")
                    }
                ) {
                    MainScreen({
                        startActivity(
                            Intent(
                                this@MainActivity,
                                TryComposeLayoutActivity::class.java
                            )
                        )
                    }, {
                        startActivity(
                            Intent(
                                this@MainActivity,
                                TryComposeBasicWidgetActivity::class.java
                            )
                        )
                    }, {
                        startActivity(
                            Intent(
                                this@MainActivity,
                                TryComposeListActivity::class.java
                            )
                        )
                    }, {
                        startActivity(
                            Intent(
                                this@MainActivity,
                                UserStatusActivity::class.java
                            )
                        )
                    }, {
                        InfoDialogFragment.newInstance().show(supportFragmentManager, "")
                    })
                }
            }
        }

    }
}