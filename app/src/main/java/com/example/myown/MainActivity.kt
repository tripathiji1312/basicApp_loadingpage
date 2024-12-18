package com.example.myown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myown.ui.theme.MyOwnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyOwnTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FrontPage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun LogoPart(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.chat)
    val fontss = FontFamily(
        Font(R.font.kanit, FontWeight.Normal),
        Font(R.font.kanit_thin, FontWeight.Thin),
        Font(R.font.kanit_bold, FontWeight.Bold)
    )
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        Text(
            text = stringResource(R.string.title),
            modifier.padding(
                top = 15.dp,
                bottom = 10.dp
            ),
            fontSize = 35.sp,
            fontFamily = fontss,
            fontWeight = FontWeight.Bold,

        )
        Text(
            text = stringResource(R.string.subheading),
            fontSize = 20.sp,
            fontFamily = fontss
        )
    }
}

@Composable
fun ContactPart(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.baseline_call_24)
    Row(modifier) {
        Image(
            painter = image,
            contentDescription = null,
        )
        Spacer(modifier.width(10.dp))
        Text(
            text = stringResource(R.string.phone),
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Composable
fun FrontPage(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .padding(
                top = 16.dp
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        LogoPart()
    }
    Column(
        modifier
            .fillMaxSize()
            .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactPart()
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "PV")
@Composable
fun GreetingPreview() {
    MyOwnTheme {
        FrontPage()
    }
}