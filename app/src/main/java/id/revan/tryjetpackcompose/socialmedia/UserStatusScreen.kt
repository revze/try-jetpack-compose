package id.revan.tryjetpackcompose.socialmedia

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.rounded.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.glide.GlideImage
import id.revan.tryjetpackcompose.core.Error
import id.revan.tryjetpackcompose.entity.UserStatus

@Composable
@Preview("Top App Bar")
fun TopAppBarContent() {
    TopAppBar(backgroundColor = Color.Blue) {
        Text(
            text = "Home",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(color = Color.White, fontSize = 18.sp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
@Preview("All content")
fun UserStatusContent(
    viewModel: UserStatusViewModel = viewModel(),
    onClick: (UserStatus) -> Unit = {}
) {
    val isLoading: Boolean by viewModel.isLoading.observeAsState(false)
    val userStatus: List<UserStatus> by viewModel.userStatus.observeAsState(emptyList())
    val error: Error? by viewModel.error.observeAsState()

    if (isLoading) {
        CircularLoader()
    }

    if (userStatus.isNotEmpty()) {
        UserStatusList(userStatus) {
            onClick(it)
        }
    }

    if (error != null) {
        ErrorContent(error?.message ?: "")
    }
}

@Composable
@Preview
fun UserStatusList(userStatus: List<UserStatus> = listOf(), onClick: (UserStatus) -> Unit = {}) {
    LazyColumn {
        items(userStatus) { item ->
            Box(Modifier.clickable {
                onClick(item)
            }) {
                Row(
                    Modifier
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    GlideImage(
                        item.photoUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape),
                    )
                    Column(
                        Modifier
                            .weight(1f)
                            .padding(start = 16.dp)
                    ) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = item.user,
                                style = MaterialTheme.typography.h6,
                            )
                            Text(
                                text = item.date,
                                style = TextStyle(color = Color.Gray)
                            )
                        }
                        Text(text = item.status)
                    }
                }
            }
            Divider(Modifier.background(Color.LightGray))
        }
        item {
            Spacer(Modifier.height(56.dp))
        }
    }
}

@Composable
@Preview
fun CircularLoader() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(Modifier.size(60.dp), color = Color.Blue)
    }
}

@Composable
@Preview
fun ErrorContent(message: String = "") {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Rounded.Error,
            contentDescription = null,
            modifier = Modifier.size(120.dp),
            tint = Color.Blue
        )
        Text(
            text = message,
            style = TextStyle(fontSize = 24.sp),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun FloatingActionButtonContent() {
    FloatingActionButton(backgroundColor = Color.Blue, onClick = {
        // On click
    }) {
        Icon(Icons.Default.AddAPhoto, contentDescription = null, tint = Color.White)
    }
}

@Composable
@Preview
fun BottomAppBarContent() {
    BottomAppBar(backgroundColor = Color.Blue) {
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            BottomAppBarMenuItem("Home", Icons.Default.Home)
            BottomAppBarMenuItem("Profile", Icons.Default.VerifiedUser)
            BottomAppBarMenuItem("Settings", Icons.Default.Settings)
        }
    }
}

@Composable
fun BottomAppBarMenuItem(text: String, icon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = null, tint = Color.White)
        Text(text = text, style = TextStyle(color = Color.White))
    }
}