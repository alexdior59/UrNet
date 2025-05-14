package com.rajkishorbgp.sign_up_sign_in.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rajkishorbgp.sign_up_sign_in.R
import com.rajkishorbgp.sign_up_sign_in.model.Publicacion

class PublicacionesAdapter(private val publicaciones: List<Publicacion>) :
    RecyclerView.Adapter<PublicacionesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre: TextView = view.findViewById(R.id.tvNombrePublicacion)
        val usuario: TextView = view.findViewById(R.id.tvUsuarioPublicacion)
        val contenido: TextView = view.findViewById(R.id.tvContenidoPublicacion)
        val oportunidades: TextView = view.findViewById(R.id.tvOportunidadesLigadas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_publicacion, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val publicacion = publicaciones[position]
        holder.nombre.text = publicacion.nombre
        holder.usuario.text = publicacion.usuario
        holder.contenido.text = publicacion.contenido
        if (publicacion.oportunidadesLigadas.isNotEmpty()) {
            holder.oportunidades.visibility = View.VISIBLE
            holder.oportunidades.text = "Oportunidades: " +
                    publicacion.oportunidadesLigadas.joinToString { it.nombre }
        } else {
            holder.oportunidades.visibility = View.GONE
        }
    }

    override fun getItemCount() = publicaciones.size
}
