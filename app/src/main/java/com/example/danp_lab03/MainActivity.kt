package com.example.danp_lab03

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.danp_lab03.ui.theme.DANPLab03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DANPLab03Theme {
                val congreso= remember { mutableStateListOf<Asistente>()
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box (modifier = Modifier.fillMaxSize()){

                        ScreenCRUD(congreso)
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenCRUD( congreso: MutableList<Asistente>){

    var nombre by remember { mutableStateOf("") }
    var apellidoP by remember { mutableStateOf("") }
    var apellidoM by remember { mutableStateOf("") }
    var fechaInscripcion by remember { mutableStateOf("") }
    var tipoSangre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf(0) }
    var correo by remember { mutableStateOf("") }
    var montopagado by remember { mutableStateOf(0.0) }

    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar Asistente") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(395.dp)
        ) {
            Formulario (
                nombre = nombre,
                funNombre = {nombre = it},
                apellidoP = apellidoP,
                funapellidoP = {apellidoP = it},
                apellidoM = apellidoM,
                funapellidoM = {apellidoM = it},
                fechaInscripcion = fechaInscripcion,
                funfechaInscripcion = {fechaInscripcion = it},
                tipoSangre = tipoSangre,
                funtipoSangre = {tipoSangre = it},
                telefono = telefono,
                funtelefono = {telefono = it},
                correo = correo,
                funcorreo = {correo = it},
                montopagado = montopagado,
                funmontopagado = {montopagado = it},
                isEditando = isEditando,
                funisEditando = {isEditando = false},
                textButton = textButton,
                funtextButton = {textButton = it},

                congreso=congreso,
                funResetCampos = {
                    nombre = ""
                    apellidoP = ""
                    apellidoM = ""
                    fechaInscripcion = ""
                    tipoSangre = ""
                    telefono = 0
                    correo = ""
                    montopagado = 0.0
                }
            )

        }
        Column (modifier= Modifier.fillMaxSize()){
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(congreso) { asistente ->
                    CardAsistente(
                        funNombre = {nombre = it} ,
                        funapellidoP = {apellidoP = it},
                        funapellidoM = {apellidoM = it},
                        funfechaInscripcion = {fechaInscripcion = it},
                        funtipoSangre = {tipoSangre = it},
                        funtelefono = {telefono = it},
                        funcorreo = {correo = it},
                        funmontopagado = {montopagado = it},

                        funTextButton = {textButton = it} ,
                        funIsEditando = {isEditando = it} ,
                        funBorrarAsistente = { borrarAsistente(it, congreso)} ,
                        asistente=asistente
                    )
                }
            }
        }
    }
}

fun agregarAsistente(nombre:String , apellidoP:String, apellidoM: String, fechaInscripcion: String,
tipoSangre: String, telefono: Int, correo: String, montoPagado: Double,
congreso: MutableList<Asistente>){
    congreso.add(Asistente(nombre,apellidoP,apellidoM,fechaInscripcion,tipoSangre,telefono,correo,montoPagado))
}

fun editarAsistente(nombre:String , apellidoP:String, apellidoM: String, fechaInscripcion: String,
                     tipoSangre: String, telefono: Int, correo: String, montoPagado: Double,
                     congreso: MutableList<Asistente>){
    congreso.forEach{ asistente ->
        if (asistente.nombre == nombre){
            asistente.apellidoP= apellidoP
            asistente.apellidoM= apellidoM
            asistente.fechaInscripcion= fechaInscripcion
            asistente.tipoSangre= tipoSangre
            asistente.telefono= telefono
            asistente.correo= correo
            asistente.montopagado= montoPagado
        }
    }
}

fun borrarAsistente(nombre:String , congreso: MutableList<Asistente>){
    congreso.forEach{ asistente ->
        if (asistente.nombre == nombre){
            congreso.remove(asistente)
        }
    }
}