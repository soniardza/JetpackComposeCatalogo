package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyColumn()
                }
            }
        }
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                ),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(text = "Esto es un EJEMPLO")
        }
    }
}

@Composable
fun MyColumn() {
    /* Ejemplo usando Weight

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Cyan).weight(1f))
        Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Blue).weight(2f))
        Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Red).weight(1f))
    } */
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Gray))
        Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Blue))
        Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Red))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
//        MyBox()
        MyColumn()
    }
}
