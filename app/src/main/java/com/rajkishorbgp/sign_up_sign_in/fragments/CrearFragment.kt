package com.rajkishorbgp.sign_up_sign_in.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rajkishorbgp.sign_up_sign_in.R
import com.rajkishorbgp.sign_up_sign_in.databinding.FragmentCrearBinding

class CrearFragment : Fragment() {

    private var _binding: FragmentCrearBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrearBinding.inflate(inflater, container, false)

        val opciones = mapOf(
            binding.cardStartup to "Startup",
            binding.cardProyecto to "Proyecto",
            binding.cardGrupo to "Grupo Estudiantil",
            binding.cardSemillero to "Semillero",
            binding.cardOtro to "Otro"
        )

        opciones.forEach { (card, tipo) ->
            card.setOnClickListener {
                val bundle = Bundle().apply {
                    putString("tipo", tipo)
                }
                findNavController().navigate(R.id.crearOportunidadFragment, bundle)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
