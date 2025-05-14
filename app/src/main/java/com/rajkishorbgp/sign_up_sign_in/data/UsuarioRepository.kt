package com.rajkishorbgp.sign_up_sign_in.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rajkishorbgp.sign_up_sign_in.model.Usuario
import java.io.File

object UsuarioRepository {
    private const val FILE_NAME = "usuarios.json"
    private const val FILE_SESION = "sesion_actual.json"

    private fun getUsuarios(context: Context): MutableList<Usuario> {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) return mutableListOf()
        val json = file.readText()
        val type = object : TypeToken<MutableList<Usuario>>() {}.type
        return Gson().fromJson(json, type)
    }

    fun registrar(context: Context, usuario: Usuario): Boolean {
        val usuarios = getUsuarios(context)
        if (usuarios.any { it.email == usuario.email }) return false
        usuarios.add(usuario)
        File(context.filesDir, FILE_NAME).writeText(Gson().toJson(usuarios))
        return true
    }

    fun autenticar(context: Context, email: String, password: String): Usuario? {
        return getUsuarios(context).find { it.email == email && it.password == password }
    }

    fun guardarSesion(context: Context, usuario: Usuario) {
        File(context.filesDir, FILE_SESION).writeText(Gson().toJson(usuario))
    }

    fun obtenerSesion(context: Context): Usuario? {
        val file = File(context.filesDir, FILE_SESION)
        if (!file.exists()) return null
        val json = file.readText()
        return Gson().fromJson(json, Usuario::class.java)
    }

    fun cerrarSesion(context: Context) {
        File(context.filesDir, FILE_SESION).delete()
    }
}
