package com.example.myapplication.Screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun Inicio() {

    var textoSaludar by rememberSaveable { mutableStateOf("") }


}