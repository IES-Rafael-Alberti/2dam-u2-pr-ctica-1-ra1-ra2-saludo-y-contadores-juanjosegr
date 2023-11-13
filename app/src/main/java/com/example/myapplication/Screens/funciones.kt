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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun Inicio() {

    val textoSaludar by rememberSaveable { mutableStateOf("") }
    var mostrarDialogo by rememberSaveable { mutableStateOf(false) }

    PantallaInicio(
        textoMostrar = textoSaludar,
        mostrarDialogo = false,
        onDismiss = { mostrarDialogo = true })

    if (mostrarDialogo) {
        TextoDialogo(
            mostrarDialogo = mostrarDialogo,
            onDismiss = { mostrarDialogo = true},
            textoMostrar = textoSaludar)

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

@Composable
fun TextoDialogo(
    mostrarDialogo: Boolean,
    onDismiss: (Boolean) -> Unit,
    textoMostrar: String
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
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )


        }
    }

}