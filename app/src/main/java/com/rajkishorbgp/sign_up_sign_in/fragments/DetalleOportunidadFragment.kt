package com.rajkishorbgp.sign_up_sign_in.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rajkishorbgp.sign_up_sign_in.databinding.FragmentDetalleOportunidadBinding
import com.rajkishorbgp.sign_up_sign_in.model.Oportunidad

class DetalleOportunidadFragment : Fragment() {

    private var _binding: FragmentDetalleOportunidadBinding? = null
    private val binding get() = _binding!!

    private var oportunidad: Oportunidad? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        oportunidad = arguments?.getSerializable("oportunidad") as? Oportunidad
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalleOportunidadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        oportunidad?.let { o ->
            binding.tvDetalleTitulo.text = o.nombre
            binding.tvDetalleUsuario.text = o.usuario
            binding.tvDetalleTipo.text = o.tipoBoton
            binding.tvDetalleDescripcion.text = o.descripcion ?: "Sin descripción disponible"
            binding.tvInteresados.text = "${o.interesados?.size ?: 0} interesados aún"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
