package com.example.futportuguese.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.futportuguese.databinding.ActivityLoginBinding
import com.example.futportuguese.extensions.vaiPara

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotaoEntrar()
        configuraBotaoRegistrar()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun configuraBotaoEntrar() {
        binding.btnAccess.setOnClickListener {
            val usuario = binding.name.text.toString()
            val senha = binding.password.text.toString()
            Log.i("LoginActivity", "onCreate: $usuario - $senha")
            vaiPara(ListaJogosActivity::class.java)
        }
    }

    fun configuraBotaoRegistrar() {
        binding.btnRegister.setOnClickListener {
            vaiPara(RegisterActivity::class.java)
        }
    }
}