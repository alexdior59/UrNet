package com.rajkishorbgp.sign_up_sign_in.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rajkishorbgp.sign_up_sign_in.model.Oportunidad
import java.io.File

object OportunidadesRepository {

    private const val FILE_NAME = "oportunidades.json"

    fun agregar(context: Context, oportunidad: Oportunidad) {
        val oportunidades = obtenerMisOportunidades(context).toMutableList()
        oportunidades.add(oportunidad)

        val json = Gson().toJson(oportunidades)
        val file = File(context.filesDir, FILE_NAME)
        file.writeText(json)
    }

    fun obtenerMisOportunidades(context: Context): List<Oportunidad> {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) {
            return emptyList()
        }

        val json = file.readText()
        val type = object : TypeToken<List<Oportunidad>>() {}.type
        return Gson().fromJson(json, type)
    }

    fun obtenerMisOportunidadesPorUsuario(context: Context, usuarioActual: String): List<Oportunidad> {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) return emptyList()

        val json = file.readText()
        val type = object : TypeToken<List<Oportunidad>>() {}.type
        val todas = Gson().fromJson<List<Oportunidad>>(json, type)
        return todas.filter { it.usuario == usuarioActual }
    }
}