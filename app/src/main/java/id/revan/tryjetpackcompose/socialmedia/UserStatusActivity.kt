package id.revan.tryjetpackcompose.socialmedia

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.lifecycle.ViewModelProvider
import id.revan.tryjetpackcompose.repository.SocialMediaRepositoryImpl

class UserStatusActivity : AppCompatActivity() {

    private val repository by lazy {
        SocialMediaRepositoryImpl(application)
    }
    private lateinit var userStatusViewModel: UserStatusViewModel
    private val viewModelFactory by lazy {
        UserStatusViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userStatusViewModel =
            ViewModelProvider(this, viewModelFactory)[UserStatusViewModel::class.java]
        setContent {
            MaterialTheme {
                Scaffold(
                    topBar = {
                        TopAppBarContent()
                    },
                    floatingActionButton = {
                        FloatingActionButtonContent()
                    },
                    bottomBar = {
                        BottomAppBarContent()
                    }
                ) {
                    UserStatusContent(userStatusViewModel) {
                        Toast.makeText(this, "${it.user} status clicked.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }
}