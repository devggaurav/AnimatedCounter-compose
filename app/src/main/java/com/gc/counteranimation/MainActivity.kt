package com.gc.counteranimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gc.counteranimation.ui.theme.CounterAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var count by remember {
            mutableStateOf(0)
        }
        var increment by remember {
            mutableStateOf(true)
        }

        AnimatedCounter(count = count, increment = increment)

        Button(onClick = {
            count++
            increment = true
        }) {
            Text(text = "Increment Counter")
        }

        Button(onClick = {
            if (count > 0) count--
            increment = false
        }) {
            Text(text = "Decrement Counter")

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CounterAnimationTheme {
        Greeting("Android")
    }
}