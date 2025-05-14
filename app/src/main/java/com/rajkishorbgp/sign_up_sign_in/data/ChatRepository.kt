package com.rajkishorbgp.sign_up_sign_in.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rajkishorbgp.sign_up_sign_in.model.Chat
import java.io.File

object ChatRepository {
    private const val FILE_NAME = "chats.json"

    fun agregar(context: Context, chat: Chat) {
        val chats = obtenerTodos(context).toMutableList()
        if (!chats.any { it.name == chat.name }) {
            chats.add(chat)
            guardar(context, chats)
        }
    }

    fun obtenerTodos(context: Context): List<Chat> {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) return emptyList()

        val json = file.readText()
        val type = object : TypeToken<List<Chat>>() {}.type
        return Gson().fromJson(json, type)
    }

    private fun guardar(context: Context, chats: List<Chat>) {
        val file = File(context.filesDir, FILE_NAME)
        file.writeText(Gson().toJson(chats))
    }
}
