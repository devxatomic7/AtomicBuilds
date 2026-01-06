package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                Scaffold() {innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ArticleImage(
                            stringResource(R.string.jetpack_compose_tutorial),
                            stringResource(R.string.jetpack_compose_definition),
                            stringResource(R.string.jetpack_compose_description)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ArticleText(
    title: String,
    shortDescription: String,
    longDescription: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = shortDescription,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
private fun ArticleImage(message: String, from: String,to:String, modifier: Modifier = Modifier) {

    Column(modifier) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
        )
        ArticleText(
            title = message,
            shortDescription = from,
            longDescription = to,
            modifier = Modifier
        )
    }
}
@Preview(showBackground = true)
@Composable
private fun ComposeArticlePreview() {
    ComposeArticleTheme {
        ArticleImage(
            stringResource(R.string.jetpack_compose_tutorial),
            stringResource(R.string.jetpack_compose_definition),
            stringResource(R.string.jetpack_compose_description)
        )
    }
}