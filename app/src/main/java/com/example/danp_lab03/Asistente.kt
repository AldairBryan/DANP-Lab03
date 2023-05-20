package com.example.danp_lab03

class Asistente {
    var nombre: String =""
    var apellidoP: String = ""
    var apellidoM: String = ""
    var fechaInscripcion: String = ""
    var tipoSangre: String = ""
    var telefono: Int = 0
    var correo: String = ""
    var montopagado: Double = 0.0

    constructor(
        nombre: String,
        apellidoP: String,
        apellidoM: String,
        fechaInscripcion: String,
        tipoSangre: String,
        telefono: Int,
        correo: String,
        montopagado: Double
    ) {
        this.nombre = nombre
        this.apellidoP = apellidoP
        this.apellidoM = apellidoM
        this.fechaInscripcion = fechaInscripcion
        this.tipoSangre = tipoSangre
        this.telefono = telefono
        this.correo = correo
        this.montopagado = montopagado
    }


}