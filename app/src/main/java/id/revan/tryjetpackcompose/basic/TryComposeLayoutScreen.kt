package id.revan.tryjetpackcompose.basic

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import id.revan.tryjetpackcompose.R

@Composable
@Preview("All content")
fun TryComposeLayoutScreen() {
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

@Preview("Column Content")
@Composable
fun ColumnContent() {
    Column {
        TextField("", {}, label = {
            Text("Email")
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp))
        TextField("", {}, label = {
            Text("Password")
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
        )
        Button({},
            Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()) {
            Text("Submit")
        }
    }
}

@Preview("Row Content")
@Composable
fun RowContent() {
    Row {
        Image(
            painterResource(R.drawable.bg_dog),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .padding(16.dp)
                .align(Alignment.CenterVertically)
                .clip(CircleShape)
        )
        Text(
            "Revando",
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            style = TextStyle(fontSize = 16.sp)
        )
        Button({},
            Modifier
                .padding(horizontal = 16.dp)
                .align(Alignment.CenterVertically)) {
            Text("Follow")
        }
    }
}

@Preview("ConstraintLayout Content")
@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        val thumbnail = createRef()
        val title = createRef()
        val description = createRef()

        Image(
            painterResource(R.drawable.bg_mount),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(95.dp)
                .constrainAs(thumbnail) {
                    start.linkTo(parent.start, margin = 16.dp)
                    top.linkTo(parent.top, margin = 16.dp)
                })
        Text(
            "Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(title) {
                    end.linkTo(parent.end, margin = 16.dp)
                    start.linkTo(thumbnail.end, margin = 16.dp)
                    top.linkTo(parent.top, margin = 16.dp)
                    width = Dimension.preferredWrapContent
                }
                .fillMaxWidth()
        )
        Text(
            stringResource(R.string.dummy_text3),
            modifier = Modifier.constrainAs(description) {
                start.linkTo(thumbnail.end, margin = 16.dp)
                top.linkTo(title.bottom, margin = 8.dp)
                end.linkTo(parent.end, margin = 16.dp)
                width = Dimension.preferredWrapContent
            }.fillMaxWidth(), maxLines = 3, overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
@Preview("Box Content")
fun BoxContent() {
    Box {
        Image(
            painterResource(R.drawable.bg_mount),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        Image(
            painterResource(R.drawable.bg_dog),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .align(Alignment.TopCenter),
            alignment = Alignment.Center
        )
        Text(
            "Text 2",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp),
            modifier = Modifier.align(Alignment.CenterStart)
        )
        Text(
            "Text 3",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp),
            modifier = Modifier.align(Alignment.CenterEnd)
        )
        Text(
            "Text 4",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}