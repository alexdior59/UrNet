package com.rajkishorbgp.sign_up_sign_in.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rajkishorbgp.sign_up_sign_in.R
import com.rajkishorbgp.sign_up_sign_in.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cargarDatosUsuario()
        configurarCerrarSesion()
        configurarVerOportunidades()
    }

    private fun cargarDatosUsuario() {
        binding.tvNombre.text = "Santiago Morales"
        binding.tvUsuario.text = "@tomcrulse"
        binding.tvDescripcion.text = "Apasionado por conectar talento y crear nuevas oportunidades para todos."

        binding.tvSocios.text = "79"
        binding.tvOportunidades.text = "5"
    }

    private fun configurarCerrarSesion() {
        binding.btnCerrarSesion.setOnClickListener {
            findNavController().navigate(R.id.action_perfilFragment_to_signInActivity)
            requireActivity().finish()
        }
    }

    private fun configurarVerOportunidades() {
        binding.btnVerOportunidades.setOnClickListener {
            findNavController().navigate(R.id.action_perfilFragment_to_misOportunidadesFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}