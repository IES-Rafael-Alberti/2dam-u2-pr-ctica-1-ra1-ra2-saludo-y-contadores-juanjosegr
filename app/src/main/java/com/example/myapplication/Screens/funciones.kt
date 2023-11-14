package com.example.myapplication.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.myapplication.R


@Composable
fun Inicio() {

    var textoSaludar by rememberSaveable { mutableStateOf("") }
    var mostrarDialogo by rememberSaveable { mutableStateOf(false) }
    var contAccept by rememberSaveable { mutableStateOf(0) }
    var contCancel by rememberSaveable { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.saludo),
                contentScale = ContentScale.FillBounds
            )
    ) {
        PantallaInicio(
            textoMostrar = textoSaludar,
            mostrarDialogo = false,
            onDismiss = { mostrarDialogo = true })

        if (mostrarDialogo) {
            TextoDialogo(
                mostrarDialogo = mostrarDialogo,
                textoMostrar = textoSaludar,

                onCambio = { textoSaludar = it },
                onCambioNombre = { textoSaludar = it },

                onDismiss = { mostrarDialogo = true },
                onDismissOn = { mostrarDialogo = false },

                onLimpiar = { textoSaludar = "" },

                contAccept = contAccept,
                contCancel = contCancel,
                suma = {
                    if (contAccept == it) {
                        contAccept++
                    } else if (contCancel == it) {
                        contCancel++
                    }
                }
            )

        }
    }
}

@Composable
fun PantallaInicio(
    textoMostrar: String,
    mostrarDialogo: Boolean,
    onDismiss: (Boolean) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onDismiss(mostrarDialogo) },
            modifier = Modifier
                .padding(10.dp),
            colors = ButtonDefaults.textButtonColors(Color.Blue),
        ) {
            Text("Saludos", color = Color.White)
        }
        Text(
            textoMostrar,
            fontSize = 20.sp,
            color= Color.Red,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .border(2.dp, Color.Black)
                .align(Alignment.CenterHorizontally)
                .height(50.dp)
                .width(250.dp)
                .background(Color.LightGray)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextoDialogo(
    mostrarDialogo: Boolean,
    textoMostrar: String,

    onCambio: (String) -> Unit,
    onCambioNombre: (String) -> Unit,

    onDismiss: (Boolean) -> Unit,
    onDismissOn: (Boolean) -> Unit,

    contAccept: Int,
    contCancel: Int,
    suma: (Int) -> Unit,

    onLimpiar: (String) -> Unit,

    ) {
    Dialog(
        onDismissRequest = { onDismiss(mostrarDialogo) },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Column(
            modifier = Modifier
                .padding(top = 15.dp, bottom = 20.dp)
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Configuración",
                modifier = Modifier
                    .padding(bottom = 15.dp, start = 185.dp),
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(
                value = textoMostrar,
                onValueChange = {
                    onCambio(it)
                },
                label = { Text(text = "Introduce tu nombre.") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Red,
                    unfocusedBorderColor = Color.Blue,
                    textColor = Color.Green
                )
            )
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)

            ) {
                Button(
                    onClick = {
                        onDismissOn(mostrarDialogo)
                        onCambioNombre(textoMostrar)
                        suma(contAccept)
                    },
                    Modifier.padding(end = 30.dp)
                ) {
                    Text(
                        text = "aceptar $contAccept",
                        fontSize = 10.sp,
                    )
                }
                Button(
                    onClick = {
                        onLimpiar(textoMostrar)
                    },
                    Modifier.padding(end = 30.dp)
                ) {
                    Text(
                        text = "C",
                        fontSize = 10.sp,
                    )
                }
                Button(onClick = {
                    onDismissOn(mostrarDialogo)
                    suma(contCancel)
                }
                ) {
                    Text(
                        text = "Cancelar $contCancel",
                        fontSize = 10.sp,
                    )
                }
            }

        }
    }

}