package com.example.jetpackcomposecatalogo.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    /* Column() {
                        var myText by remember {
                            mutableStateOf("")
                        }
                        MyStateHoisting(myText) { myText = it }
                    } */
                    MyButtonState()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
//        MyBox()
//        MyColumn()
//        MyRow()
//        MyComplexLayout()
//        MyStateExample()
//        MyText()
//        MyTextField()
//        MyTextFieldAdvanced()
//        MyTextFieldOutlined()
//        MyButton()
        MyButtonState()
    }
}

@Composable
fun MyButtonState() {
    var enabled by rememberSaveable {
        mutableStateOf(true)
    }
    val context = LocalContext.current
    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Button(
            onClick = {
                myToast(context, "Has hecho click")
                enabled = false
            },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.White
            ),
            border = BorderStroke(5.dp, Color.Cyan)
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = {
                myToast(context, "Has hecho click")
                enabled = false
            },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.White,
                disabledBackgroundColor = Color.Blue,
                disabledContentColor = Color.Red
            )
        ) {
            Text(text = "Hola")
        }
    }
}

@Composable
fun MyButton() {
    val context = LocalContext.current
    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Button(
            onClick = { myToast(context, "Has hecho click") },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.White
            ),
            border = BorderStroke(5.dp, Color.Cyan)
        ) {
            Text(text = "Hola")
        }
    }
}

private fun myToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

@Composable
fun MyStateHoisting(name: String, onValueChange: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChange })
}

@Composable
fun MyTextFieldOutlined() {
    var myText by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Holiii") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyTextFieldAdvanced() {
    var myText by remember {
        mutableStateOf("")
    }
    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text(text = "Introduce tu nombre") }
    )
}

@Composable
fun MyTextField() {
    var myText by remember {
        mutableStateOf("")
    }
    TextField(value = myText, onValueChange = { myText = it })
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", fontFamily = FontFamily.Cursive)
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo",
            textDecoration = TextDecoration.Underline // si solo usamos un atributo para modificar el estilo, no es necesario usar style
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.Underline,
                        TextDecoration.LineThrough
                    )
                )
            )
        )
        Text(
            text = "Esto es un ejemplo",
            fontSize = 30.sp
        )
    }
}

@Composable
fun MyStateExample() {
    var counter by rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado $counter veces")
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
        Text(
            text = "Ejemplo 1",
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ejemplo 2",
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            text = "Ejemplo 3",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(80.dp)
        )
    }
}

@Composable
fun MyRow() {
    /*Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejemplo 1")
        Text(text = "Ejemplo 2")
        Text(text = "Ejemplo 3")
    }*/
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier.width(100.dp))
    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }

        MySpacer(size = 30)

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Hola, soy Sonia!")
            }
        }

        MySpacer(size = 80)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}
