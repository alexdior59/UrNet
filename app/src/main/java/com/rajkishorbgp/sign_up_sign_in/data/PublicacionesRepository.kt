package com.rajkishorbgp.sign_up_sign_in.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rajkishorbgp.sign_up_sign_in.model.Publicacion
import java.io.File

object PublicacionesRepository {

    private const val FILE_NAME = "publicaciones.json"

    fun agregar(context: Context, publicacion: Publicacion) {
        val publicaciones = obtenerTodas(context).toMutableList()
        publicaciones.add(0, publicacion) // la más reciente arriba
        guardar(context, publicaciones)
    }

    fun obtenerTodas(context: Context): List<Publicacion> {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) return emptyList()

        val json = file.readText()
        val type = object : TypeToken<List<Publicacion>>() {}.type
        return Gson().fromJson(json, type)
    }

    private fun guardar(context: Context, publicaciones: List<Publicacion>) {
        val json = Gson().toJson(publicaciones)
        val file = File(context.filesDir, FILE_NAME)
        file.writeText(json)
    }
}
