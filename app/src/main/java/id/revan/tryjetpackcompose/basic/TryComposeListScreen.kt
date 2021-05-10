package id.revan.tryjetpackcompose.basic

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.GlideImage
import id.revan.tryjetpackcompose.R

@ExperimentalFoundationApi
@Composable
@Preview("All content")
fun TryComposeListScreen() {
    val lazyColumnPage = 1
    val lazyRowPage = 2
    val lazyVerticalGridPage = 3
    var page by remember {
        mutableStateOf(lazyColumnPage)
    }

    Column {
        LazyRow(Modifier.padding(16.dp)) {
            item {
                Button(onClick = { page = lazyColumnPage }) {
                    Text(text = "LazyColumn Sample")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { page = lazyRowPage }) {
                    Text(text = "LazyRow Sample")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { page = lazyVerticalGridPage }) {
                    Text(text = "LazyVerticalGrid Sample")
                }
            }
        }

        // Main content
        Crossfade(targetState = page) {
            when (it) {
                lazyColumnPage -> SampleLazyColumnList()
                lazyRowPage -> SampleLazyRowList()
                lazyVerticalGridPage -> SampleLazyVerticalGridList()
            }
        }
    }
}

@Composable
@Preview("Lazy Column Content")
fun SampleLazyColumnList() {
    val items = listOf(
        "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",
        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque",
        "Li Europan lingues es membres del sam familie. Lor separat existentie es un myth",
        "A wonderful serenity has taken possession of my entire soul",
        "One morning, when Gregor Samsa woke from troubled dreams"
    )
    LazyColumn {
        items(items) { item ->
            Text(item, Modifier.padding(16.dp))
            Divider()
        }
    }
}

@Composable
@Preview("Lazy Row Content")
fun SampleLazyRowList() {
    val items = listOf(
        "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",
        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque",
        "Li Europan lingues es membres del sam familie. Lor separat existentie es un myth",
        "A wonderful serenity has taken possession of my entire soul",
        "One morning, when Gregor Samsa woke from troubled dreams"
    )
    LazyRow {
        items(items) { item ->
            Card(
                Modifier
                    .padding(8.dp)
                    .width(160.dp)) {
                Column {
                    Image(
                        painterResource(R.drawable.bg_mount),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(160.dp)
                            .height(80.dp)
                    )
                    Text(
                        item,
                        Modifier.padding(16.dp),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
@Preview("LazyVerticalGrid Content")
fun SampleLazyVerticalGridList() {
    val items = listOf(
        "https://picsum.photos/id/233/400/350",
        "https://picsum.photos/id/234/400/350",
        "https://picsum.photos/id/235/400/350",
        "https://picsum.photos/id/236/400/350",
        "https://picsum.photos/id/237/400/350",
        "https://picsum.photos/id/238/400/350",
        "https://picsum.photos/id/239/400/350",
        "https://picsum.photos/id/240/400/350",
        "https://picsum.photos/id/241/400/350",
    )
    LazyVerticalGrid(cells = GridCells.Fixed(3)) {
        items(items) { item ->
            Card(Modifier.padding(4.dp)) {
                GlideImage(
                    item,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}