package com.rajkishorbgp.sign_up_sign_in.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rajkishorbgp.sign_up_sign_in.data.OportunidadesRepository
import com.rajkishorbgp.sign_up_sign_in.data.UsuarioRepository
import com.rajkishorbgp.sign_up_sign_in.databinding.FragmentCrearOportunidadBinding
import com.rajkishorbgp.sign_up_sign_in.model.Oportunidad

class CrearOportunidadFragment : Fragment() {

    private var _binding: FragmentCrearOportunidadBinding? = null
    private val binding get() = _binding!!

    private var tipoSeleccionado: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrearOportunidadBinding.inflate(inflater, container, false)

        tipoSeleccionado = arguments?.getString("tipo")
        binding.tituloTipo.text = "Crear $tipoSeleccionado"

        binding.btnPublicar.setOnClickListener {
            val nombre = binding.etNombre.text.toString().trim()
            val descripcion = binding.etDescripcion.text.toString().trim()
            val esPrivada = binding.switchPrivada.isChecked

            if (nombre.isEmpty() || descripcion.isEmpty()) {
                Toast.makeText(requireContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = UsuarioRepository.obtenerSesion(requireContext())
            val oportunidad = Oportunidad(
                nombre = nombre,
                usuario = usuario?.username ?: "@anonimo",
                tipoBoton = if (esPrivada) "Privada" else "Pública",
                descripcion = descripcion
            )


            OportunidadesRepository.agregar(requireContext(), oportunidad)

            Toast.makeText(requireContext(), "$tipoSeleccionado publicada 👏", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
