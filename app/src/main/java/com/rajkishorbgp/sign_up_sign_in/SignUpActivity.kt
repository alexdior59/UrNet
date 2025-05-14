package com.rajkishorbgp.sign_up_sign_in

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rajkishorbgp.sign_up_sign_in.data.UsuarioRepository
import com.rajkishorbgp.sign_up_sign_in.databinding.ActivitySignUpBinding
import com.rajkishorbgp.sign_up_sign_in.model.Usuario

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginTab.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }

        binding.signupButton.setOnClickListener {
            val name = binding.signupName.text.toString()
            val email = binding.signupEmail.text.toString()
            val password = binding.signupPassword.text.toString()
            val confirmPassword = binding.signupConfirm.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password == confirmPassword) {
                val usuario = Usuario(nombre = name, email = email, password = password)
                val registrado = UsuarioRepository.registrar(this, usuario)

                if (registrado) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, SignInActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Ya existe una cuenta con ese correo", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Revisa los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}