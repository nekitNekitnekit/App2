package com.example.app2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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

@Preview(showBackground = true)
@Composable
fun App2Preview() {
    App2Theme {
        App2()
    }
}

@Composable
fun App2(modifier: Modifier = Modifier) {
    Column {

        Image(painter = painterResource(R.drawable.image), contentDescription = "Image")

        Text("Header 1", style = MaterialTheme.typography.h5)

        Text("Header 2", style = MaterialTheme.typography.h6)

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