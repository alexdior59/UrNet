package com.rajkishorbgp.sign_up_sign_in.fragments

import com.rajkishorbgp.sign_up_sign_in.R

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rajkishorbgp.sign_up_sign_in.databinding.FragmentCrearBinding

class CrearFragment : Fragment() {

    private var _binding: FragmentCrearBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrearBinding.inflate(inflater, container, false)

        // Acciones para cada tarjeta
        binding.cardStartup.setOnClickListener {
            navegarConTipo("Startup")
        }

        binding.cardProyecto.setOnClickListener {
            navegarConTipo("Proyecto")
        }

        binding.cardGrupo.setOnClickListener {
            navegarConTipo("Grupo Estudiantil")
        }

        binding.cardSemillero.setOnClickListener {
            navegarConTipo("Semillero")
        }

        binding.cardOtro.setOnClickListener {
            navegarConTipo("Otro")
        }

        return binding.root
    }

    private fun navegarConTipo(tipo: String) {
        val bundle = Bundle().apply {
            putString("tipo", tipo)
        }
        findNavController().navigate(R.id.crearOportunidadFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
