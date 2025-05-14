package com.rajkishorbgp.sign_up_sign_in.model

import java.io.Serializable

data class Oportunidad(
    val nombre: String,
    val usuario: String,
    val tipoBoton: String,
    val descripcion: String? = null,
    val interesados: List<String>? = null,
    val imagen: Int? = null
) : Serializable
