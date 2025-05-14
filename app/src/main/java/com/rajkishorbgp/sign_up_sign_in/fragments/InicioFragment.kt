package com.rajkishorbgp.sign_up_sign_in.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajkishorbgp.sign_up_sign_in.adapters.PublicacionesAdapter
import com.rajkishorbgp.sign_up_sign_in.data.PublicacionesRepository
import com.rajkishorbgp.sign_up_sign_in.data.UsuarioRepository
import com.rajkishorbgp.sign_up_sign_in.databinding.FragmentInicioBinding
import com.rajkishorbgp.sign_up_sign_in.model.Publicacion

class InicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PublicacionesAdapter
    private val publicaciones = mutableListOf<Publicacion>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PublicacionesAdapter(publicaciones)
        binding.rvFeed.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFeed.adapter = adapter

        cargarPublicaciones()
        configurarBotonPublicar()
    }

    private fun cargarPublicaciones() {
        publicaciones.clear()
        publicaciones.addAll(PublicacionesRepository.obtenerTodas(requireContext()))
        adapter.notifyDataSetChanged()
    }

    private fun configurarBotonPublicar() {
        binding.btnPublicar.setOnClickListener {
            val texto = binding.etNuevaPublicacion.text.toString().trim()
            val usuario = UsuarioRepository.obtenerSesion(requireContext())

            if (texto.isNotEmpty() && usuario != null) {
                val nueva = Publicacion(
                    nombre = usuario.nombre,
                    usuario = "@${usuario.username}",
                    contenido = texto
                )
                PublicacionesRepository.agregar(requireContext(), nueva)
                binding.etNuevaPublicacion.text.clear()
                cargarPublicaciones()
                Toast.makeText(requireContext(), "Publicado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Escribe algo o inicia sesión", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
