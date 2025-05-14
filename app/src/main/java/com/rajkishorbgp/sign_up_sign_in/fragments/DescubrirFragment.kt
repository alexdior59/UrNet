package com.rajkishorbgp.sign_up_sign_in.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajkishorbgp.sign_up_sign_in.R
import com.rajkishorbgp.sign_up_sign_in.adapters.OportunidadesAdapter
import com.rajkishorbgp.sign_up_sign_in.data.OportunidadesRepository
import com.rajkishorbgp.sign_up_sign_in.databinding.FragmentDescubrirBinding
import com.rajkishorbgp.sign_up_sign_in.model.Oportunidad

class DescubrirFragment : Fragment() {

    private var _binding: FragmentDescubrirBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDescubrirBinding.inflate(inflater, container, false)

        val predeterminadas = listOf(
            Oportunidad("Impulse", "@officialImpulse", "Impúlsalo"),
            Oportunidad("BUCKS", "@Bucks.off", "Impulsando"),
            Oportunidad("JAVEX", "@javerobotix", "Únete")
        )

        val creadas = OportunidadesRepository.obtenerMisOportunidades(requireContext())
        val todas = predeterminadas + creadas

        val adapter = OportunidadesAdapter(
            oportunidades = todas,
            onAplicarClick = { oportunidadSeleccionada ->
                val bundle = Bundle().apply {
                    putSerializable("oportunidad", oportunidadSeleccionada)
                }
                findNavController().navigate(R.id.action_descubrirFragment_to_detalleOportunidadFragment, bundle)
            },
            mostrarBoton = true // ✅ aquí se activa el botón visual
        )

        binding.recyclerOportunidades.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerOportunidades.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
