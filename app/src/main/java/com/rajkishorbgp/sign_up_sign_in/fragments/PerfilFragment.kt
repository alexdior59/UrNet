package com.rajkishorbgp.sign_up_sign_in.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rajkishorbgp.sign_up_sign_in.R
import com.rajkishorbgp.sign_up_sign_in.data.UsuarioRepository
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
        configurarGuardarPerfil()
    }

    private fun cargarDatosUsuario() {
        val usuario = UsuarioRepository.obtenerSesion(requireContext())
        if (usuario != null) {
            binding.etNombre.setText(usuario.nombre)
            binding.tvUsuario.text = usuario.username
            binding.etDescripcion.setText(usuario.descripcion)
            binding.tvSocios.text = "0"
            binding.tvOportunidades.text = "0"
        }
    }

    private fun configurarCerrarSesion() {
        binding.btnCerrarSesion.setOnClickListener {
            UsuarioRepository.cerrarSesion(requireContext())

            findNavController().navigate(R.id.action_perfilFragment_to_signInActivity)
            requireActivity().finish()
        }
    }


    private fun configurarVerOportunidades() {
        binding.btnVerOportunidades.setOnClickListener {
            findNavController().navigate(R.id.action_perfilFragment_to_misOportunidadesFragment)
        }
    }

    private fun configurarGuardarPerfil() {
        binding.btnGuardarPerfil.setOnClickListener {
            val usuarioActual = UsuarioRepository.obtenerSesion(requireContext()) ?: return@setOnClickListener
            val nuevoNombre = binding.etNombre.text.toString()
            val nuevaDescripcion = binding.etDescripcion.text.toString()

            val usuarioEditado = usuarioActual.copy(
                nombre = nuevoNombre,
                descripcion = nuevaDescripcion
            )

            UsuarioRepository.registrar(requireContext(), usuarioEditado) // sobrescribe si existe
            UsuarioRepository.guardarSesion(requireContext(), usuarioEditado)

            Toast.makeText(requireContext(), "Perfil actualizado", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}