package com.example.myapplication.Screens

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun Inicio() {

    val textoSaludar by rememberSaveable { mutableStateOf("") }
    var mostrarDialogo by rememberSaveable { mutableStateOf(false) }

    PantallaInicio(
        textoMostrar = textoSaludar,
        mostrarDialogo = false,
        onDismiss = { mostrarDialogo = true })

    if (mostrarDialogo) {
        AlertDialog(
            onDismissRequest = { mostrarDialogo = false },
            title = {
                Text(
                    text = "Configuración",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            },
            text = {
                Text("Contenido del cuadro de diálogo")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        mostrarDialogo = false
                    }
                ) {
                    Text("OK")
                }
            }
        )
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
            colors = ButtonDefaults.textButtonColors(Color.Red),
        ) {
            Text("Saludos", color = Color.Black)
        }
        Text(
            textoMostrar,
            fontSize = 20.sp,
            modifier = Modifier
                .border(2.dp, Color.Black)
                .wrapContentHeight(Alignment.CenterVertically)
                .height(50.dp)
                .width(250.dp)
        )
    }
}
