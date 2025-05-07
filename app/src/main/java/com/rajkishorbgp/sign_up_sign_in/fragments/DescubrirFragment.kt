package com.rajkishorbgp.sign_up_sign_in.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajkishorbgp.sign_up_sign_in.adapters.OportunidadesAdapter
import com.rajkishorbgp.sign_up_sign_in.databinding.FragmentDescubrirBinding
import com.rajkishorbgp.sign_up_sign_in.model.Oportunidad

class DescubrirFragment : Fragment() {

    private var _binding: FragmentDescubrirBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDescubrirBinding.inflate(inflater, container, false)

        // Lista de oportunidades
        val oportunidades = listOf(
            Oportunidad("Impulse", "@officialImpulse", "Impulsalo"),
            Oportunidad("BUCKS", "@Bucks.off", "Impulsando"),
            Oportunidad("JAVEX", "@javerobotix", "Únete")
        )

        // Configurar el adaptador para RecyclerView
        val adapter = OportunidadesAdapter(oportunidades)
        binding.recyclerOportunidades.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerOportunidades.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

