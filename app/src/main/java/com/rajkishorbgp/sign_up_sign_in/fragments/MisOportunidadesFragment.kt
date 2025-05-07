package com.rajkishorbgp.sign_up_sign_in.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajkishorbgp.sign_up_sign_in.adapters.OportunidadesAdapter
import com.rajkishorbgp.sign_up_sign_in.data.OportunidadesRepository
import com.rajkishorbgp.sign_up_sign_in.databinding.FragmentMisOportunidadesBinding

class MisOportunidadesFragment : Fragment() {

    private var _binding: FragmentMisOportunidadesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMisOportunidadesBinding.inflate(inflater, container, false)

        // Leer las oportunidades desde el repositorio
        val oportunidades = OportunidadesRepository.obtenerMisOportunidades(requireContext())

        // Configurar el RecyclerView con las oportunidades
        val adapter = OportunidadesAdapter(oportunidades)
        binding.recyclerMisOportunidades.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerMisOportunidades.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
