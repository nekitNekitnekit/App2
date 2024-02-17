package com.example.app2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app2.ui.theme.App2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App2()
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
    )
@Composable
fun App2Preview() {
    App2Theme {
        App2()
    }
}

@Composable
fun App2(modifier: Modifier = Modifier) {

    val images = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,
        R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8,)

    var currentImageIndex by remember { mutableStateOf(0) }

    Column (
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(painter = painterResource(R.drawable.image1), contentDescription = "Image")

        Text("Header 1", fontSize = 40.sp, lineHeight = 40.sp)

        Text("Header 2", fontSize = 20.sp, lineHeight = 20.sp)

        Row {
            Button(onClick = { /*...*/ }) {
                Text("Button 1")
            }

            Button(onClick = { /*...*/ }) {
                Text("Button 2")
            }
        }

    }
}