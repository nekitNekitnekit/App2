package com.example.app2

import android.graphics.pdf.PdfDocument.Page
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

    var currentState by remember { mutableStateOf(1)    }

    val image = when(currentState){
        1 -> R.drawable.image1
        2 -> R.drawable.image2
        3 -> R.drawable.image3
        4 -> R.drawable.image4
        5 -> R.drawable.image5
        6 -> R.drawable.image6
        7 -> R.drawable.image7
        else -> R.drawable.image8
    }

    val textTitle = when(currentState){
        1 -> R.string.title1
        2 -> R.string.title2
        3 -> R.string.title3
        4 -> R.string.title4
        5 -> R.string.title5
        6 -> R.string.title6
        7 -> R.string.title7
        else -> R.string.title8
    }

    val textInfo = when(currentState){
        1 -> R.string.info1
        2 -> R.string.info2
        3 -> R.string.info3
        4 -> R.string.info4
        5 -> R.string.info5
        6 -> R.string.info6
        7 -> R.string.info7
        else -> R.string.info8
    }

    Column (
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Page(
            image = image,
            textTitle = textTitle,
            textInfo = textInfo
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Button(onClick = {
                if (currentState == 2 || currentState == 3 || currentState == 4
                    || currentState == 5 || currentState == 6
                    || currentState == 7 || currentState == 8) {
                    currentState -= 1
                } else if (currentState == 1) {
                    currentState = 8
                }
            },
                modifier = Modifier
                    .width(120.dp)) {
                Text(text = "Previous")
            }

            Button(onClick = {
                if (currentState == 1 || currentState == 2 || currentState == 3
                    || currentState == 4 || currentState == 5
                    || currentState == 6 || currentState == 7) {
                currentState += 1
            } else if (currentState == 8) {
                currentState = 1
            }
            },
                modifier = Modifier
                    .width(120.dp)) {
                Text(text = "Next")
            }
        }

    }
}

@Composable
fun Page(
    @DrawableRes image: Int,
    @StringRes textTitle: Int,
    @StringRes textInfo: Int
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(image),

            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 500.dp, width = 500.dp)
        )
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(horizontal = 50.dp)
                .padding(vertical = 15.dp)
        ) {

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(textTitle),
                    fontSize = 40.sp,
                    modifier = Modifier
                )

                Text(
                    text = stringResource(textInfo),
                    fontSize = 20.sp,
                    modifier = Modifier
                )
            }

        }
    }
}