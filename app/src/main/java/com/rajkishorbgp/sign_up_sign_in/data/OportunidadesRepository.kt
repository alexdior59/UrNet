package com.rajkishorbgp.sign_up_sign_in.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rajkishorbgp.sign_up_sign_in.model.Oportunidad
import java.io.File

object OportunidadesRepository {

    private const val FILE_NAME = "oportunidades.json"

    // Función para agregar una nueva oportunidad
    fun agregar(context: Context, oportunidad: Oportunidad) {
        val oportunidades = obtenerMisOportunidades(context).toMutableList()
        oportunidades.add(oportunidad)

        // Guardamos las oportunidades en el archivo JSON
        val json = Gson().toJson(oportunidades)
        val file = File(context.filesDir, FILE_NAME)
        file.writeText(json)
    }

    // Función para obtener todas las oportunidades guardadas
    fun obtenerMisOportunidades(context: Context): List<Oportunidad> {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) {
            return emptyList() // Si no existe el archivo, devolvemos una lista vacía
        }

        val json = file.readText()
        val type = object : TypeToken<List<Oportunidad>>() {}.type
        return Gson().fromJson(json, type)
    }
}