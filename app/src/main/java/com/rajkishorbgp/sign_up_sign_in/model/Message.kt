package com.rajkishorbgp.sign_up_sign_in.model

import java.io.Serializable

data class Message(
    val text: String,
    val timestamp: String,
    val isSent: Boolean
) : Serializable
