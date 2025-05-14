package com.rajkishorbgp.sign_up_sign_in.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rajkishorbgp.sign_up_sign_in.R
import com.rajkishorbgp.sign_up_sign_in.model.Oportunidad

class OportunidadesAdapter(
    private val oportunidades: List<Oportunidad>,
    private val onAplicarClick: (Oportunidad) -> Unit,
    private val mostrarBoton: Boolean = true
) : RecyclerView.Adapter<OportunidadesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre: TextView = view.findViewById(R.id.txtNombre)
        val usuario: TextView = view.findViewById(R.id.txtUsuario)
        val boton: TextView = view.findViewById(R.id.txtBoton)
        val btnAplicar: Button = view.findViewById(R.id.btnAplicar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_oportunidad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val oportunidad = oportunidades[position]
        holder.nombre.text = oportunidad.nombre
        holder.usuario.text = oportunidad.usuario
        holder.boton.text = oportunidad.tipoBoton

        if (mostrarBoton) {
            holder.btnAplicar.visibility = View.VISIBLE
            holder.btnAplicar.setOnClickListener {
                onAplicarClick(oportunidad)
            }
        } else {
            holder.btnAplicar.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = oportunidades.size
}
