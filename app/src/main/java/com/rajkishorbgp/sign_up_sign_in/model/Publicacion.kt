package com.rajkishorbgp.sign_up_sign_in.model

import java.io.Serializable

data class Publicacion(
    val usuario: String,
    val nombre: String,
    val contenido: String,
    val oportunidadesLigadas: List<Oportunidad> = emptyList()
) : Serializable
