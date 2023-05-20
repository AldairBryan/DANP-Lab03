package com.example.danp_lab03

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Formulario(
    nombre : String,
    funNombre : (String) -> Unit,
    apellidoP : String,
    funapellidoP : (String) -> Unit,
    apellidoM : String,
    funapellidoM : (String) -> Unit,
    fechaInscripcion : String,
    funfechaInscripcion : (String) -> Unit,
    tipoSangre : String,
    funtipoSangre : (String) -> Unit,
    telefono : Int,
    funtelefono : (Int) -> Unit,
    correo : String,
    funcorreo : (String) -> Unit,
    montopagado : Double,
    funmontopagado : (Double) -> Unit,
    isEditando : Boolean,
    funisEditando : () -> Unit,
    textButton : String,
    funtextButton : (String) -> Unit,
    congreso: MutableList<Asistente>,
    funResetCampos: () ->Unit
) {
    LazyColumn(modifier = Modifier.padding(12.dp)) {
        item {
            OutlinedTextField (
                modifier = Modifier.fillMaxWidth(),
                value = nombre,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                maxLines = 1,
                onValueChange = {funNombre(it)},
                label = { Text(text= "Nombre")},
                enabled = !isEditando
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
        }
        item{
            OutlinedTextField (
                modifier = Modifier.fillMaxWidth(),
                value = apellidoP,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                maxLines = 1,
                onValueChange = {funapellidoP(it)},
                label = { Text(text= "Apellido Paterno")},
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
        }
        item{
            OutlinedTextField (
                modifier = Modifier.fillMaxWidth(),
                value = apellidoM,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                maxLines = 1,
                onValueChange = {funapellidoM(it)},
                label = { Text(text= "Apellido Materno")},
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
        }
        item{
            OutlinedTextField (
                modifier = Modifier.fillMaxWidth(),
                value = fechaInscripcion,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                maxLines = 1,
                onValueChange = {funfechaInscripcion(it)},
                label = { Text(text= "Fecha Inscripcion")},
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
        }
        item{
            OutlinedTextField (
                modifier = Modifier.fillMaxWidth(),
                value = tipoSangre,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                maxLines = 1,
                onValueChange = {funtipoSangre(it)},
                label = { Text(text= "Tipo de Sangre")},
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
        }
        item{
            OutlinedTextField (
                modifier = Modifier.fillMaxWidth(),
                value = telefono.toString(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                maxLines = 1,
                onValueChange = { newValue ->
                    val numberValue = newValue.toIntOrNull()
                    if (numberValue != null) {
                        funtelefono(numberValue)
                    }
                },
                label = { Text(text= "Telefono")},
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
        }
        item{
            OutlinedTextField (
                modifier = Modifier.fillMaxWidth(),
                value = correo,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                maxLines = 1,
                onValueChange = {funcorreo(it)},
                label = { Text(text= "Correo")},
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
        }
        item{
            OutlinedTextField (
                modifier = Modifier.fillMaxWidth(),
                value = montopagado.toString(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                maxLines = 1,
                onValueChange = { newValue ->
                    val numberValue = newValue.toDoubleOrNull()
                    if (numberValue != null) {
                        funmontopagado(numberValue)
                    }
                },
                label = { Text(text= "Monto Pagado")},
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
        }
        item {
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                onClick = {
                    if (isEditando){
                        editarAsistente(nombre,apellidoP,apellidoM,fechaInscripcion,tipoSangre,telefono,correo,montopagado,congreso)
                        funtextButton("Agregar Asistente")
                        funisEditando()
                    } else {
                        agregarAsistente(nombre,apellidoP,apellidoM,fechaInscripcion,tipoSangre,telefono,correo,montopagado,congreso)
                    }
                    funResetCampos()
                }){
                Text(
                    color = Color.White,
                    text = textButton
                )
            }
        }
    }
}