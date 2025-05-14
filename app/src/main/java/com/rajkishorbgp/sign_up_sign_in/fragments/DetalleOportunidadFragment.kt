package com.rajkishorbgp.sign_up_sign_in.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rajkishorbgp.sign_up_sign_in.R
import com.rajkishorbgp.sign_up_sign_in.data.ChatRepository
import com.rajkishorbgp.sign_up_sign_in.databinding.FragmentDetalleOportunidadBinding
import com.rajkishorbgp.sign_up_sign_in.model.Chat
import com.rajkishorbgp.sign_up_sign_in.model.Oportunidad
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetalleOportunidadFragment : Fragment() {

    private var _binding: FragmentDetalleOportunidadBinding? = null
    private val binding get() = _binding!!

    private lateinit var oportunidad: Oportunidad

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalleOportunidadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        oportunidad = requireArguments().getSerializable("oportunidad") as Oportunidad

        binding.tvNombre.text = oportunidad.nombre
        binding.tvUsuario.text = oportunidad.usuario
        binding.tvDescripcion.text = oportunidad.descripcion ?: "Sin descripción"
        binding.tvTipo.text = oportunidad.tipoBoton

        binding.btnChatear.setOnClickListener {

            val chat = Chat(
                name = oportunidad.nombre,
                lastMessage = "¡Hola! Estoy interesado en esta oportunidad.",
                time = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
            )

            ChatRepository.agregar(requireContext(), chat)

            val bundle = Bundle().apply {
                putString("nombreChat", oportunidad.nombre)
            }
            findNavController().navigate(R.id.action_detalleOportunidadFragment_to_chatDetailFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
