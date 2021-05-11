package id.revan.tryjetpackcompose.fragment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.revan.tryjetpackcompose.R

@Composable
@Preview
fun SuccessContent(onClick: () -> Unit = {}) {
    Column(
        Modifier.padding(16.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.ic_verified),
            contentDescription = null,
            modifier = Modifier.size(100.dp).padding(bottom = 16.dp)
        )
        Text(
            "Info!", style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ), modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            stringResource(R.string.dummy_text1),
            modifier = Modifier.padding(bottom = 16.dp),
            style = TextStyle(textAlign = TextAlign.Center),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Button({
            onClick()
        }) {
            Text("Close")
        }
    }
}