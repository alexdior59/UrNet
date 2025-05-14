package com.rajkishorbgp.sign_up_sign_in.model

import java.io.Serializable

data class Usuario(
    val nombre: String,
    val email: String,
    val password: String,
    val descripcion: String = "",
    val username: String = "@" + email.substringBefore("@")
) : Serializable
