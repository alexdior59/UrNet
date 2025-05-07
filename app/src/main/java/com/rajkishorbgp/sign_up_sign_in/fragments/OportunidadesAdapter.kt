package com.rajkishorbgp.sign_up_sign_in.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rajkishorbgp.sign_up_sign_in.databinding.ItemOportunidadBinding
import com.rajkishorbgp.sign_up_sign_in.model.Oportunidad

class OportunidadesAdapter(private val oportunidades: List<Oportunidad>) :
    RecyclerView.Adapter<OportunidadesAdapter.OportunidadViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OportunidadViewHolder {
        val binding = ItemOportunidadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OportunidadViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OportunidadViewHolder, position: Int) {
        val oportunidad = oportunidades[position]
        holder.bind(oportunidad)
    }

    override fun getItemCount(): Int = oportunidades.size

    inner class OportunidadViewHolder(private val binding: ItemOportunidadBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(oportunidad: Oportunidad) {
            binding.tvNombreOportunidad.text = oportunidad.nombre
            binding.tvUsuarioOportunidad.text = oportunidad.usuario
            binding.tvTipoOportunidad.text = oportunidad.tipoBoton
        }
    }
}
