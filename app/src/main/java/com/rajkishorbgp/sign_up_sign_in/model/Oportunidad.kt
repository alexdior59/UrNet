package com.rajkishorbgp.sign_up_sign_in.model

import java.io.Serializable

data class Oportunidad(
    val nombre: String,
    val usuario: String,
    val tipoBoton: String,
    val descripcion: String? = null,
    val interesados: List<String>? = null, // Aquí agregué la coma
    val imagen: Int? = null // Este campo es para la imagen, puedes usar un recurso drawable
) : Serializable
