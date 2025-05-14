package com.rajkishorbgp.sign_up_sign_in.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rajkishorbgp.sign_up_sign_in.model.Message
import java.io.File

object ChatMessagesRepository {

    fun agregarMensaje(context: Context, chatName: String, message: Message) {
        val mensajes = obtenerMensajes(context, chatName).toMutableList()
        mensajes.add(message)
        guardarMensajes(context, chatName, mensajes)
    }

    fun obtenerMensajes(context: Context, chatName: String): List<Message> {
        val file = File(context.filesDir, "mensajes_${chatName}.json")
        if (!file.exists()) return emptyList()

        val json = file.readText()
        val type = object : TypeToken<List<Message>>() {}.type
        return Gson().fromJson(json, type)
    }

    private fun guardarMensajes(context: Context, chatName: String, mensajes: List<Message>) {
        val file = File(context.filesDir, "mensajes_${chatName}.json")
        file.writeText(Gson().toJson(mensajes))
    }
}
