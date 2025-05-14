package com.rajkishorbgp.sign_up_sign_in.model

import java.io.Serializable

data class Chat(
    val name: String,
    val lastMessage: String,
    val time: String
) : Serializable
