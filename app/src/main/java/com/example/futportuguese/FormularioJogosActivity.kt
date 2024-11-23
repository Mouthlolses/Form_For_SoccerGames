package com.example.futportuguese

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.futportuguese.dao.JogosDao
import com.example.futportuguese.model.Jogos
import java.math.BigDecimal

class FormularioJogosActivity : AppCompatActivity(R.layout.activity_formulario_jogos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_jogo_botaoSalvar)
        botaoSalvar.setOnClickListener {
            val jogoCriado = criaProduto()
            val dao = JogosDao()
            dao.adiciona(jogoCriado)
            finish()
        }
    }

    private fun criaProduto(): Jogos {
        val campoNomeDoOrganizador = findViewById<EditText>(R.id.activity_formulario_jogo_nomeDoOrganizador)
        val nomeDoOrganizador = campoNomeDoOrganizador.text.toString()
        val campoNumeroParaContato = findViewById<EditText>(R.id.activity_formulario_jogo_numeroParaContato)
        val numeroParaContato = campoNumeroParaContato.text.toString()
        val campoDataDoJogo = findViewById<EditText>(R.id.activity_formulario_jogo_diaDojogo)
        val dataDoJogo = campoDataDoJogo.text.toString()
        val campoHorarioDeInicioDoJogo = findViewById<EditText>(R.id.activity_formulario_jogo_horarioDoInicioDoJogo)
        val horarioDeInicioDoJogo = campoHorarioDeInicioDoJogo.text.toString()
        val campoHorarioDeTerminoDoJogo = findViewById<EditText>(R.id.acitivity_formulario_jogo_horarioDeFimDoJogo)
        val horarioDoFimDoJogo = campoHorarioDeTerminoDoJogo.text.toString()
        val campoValor = findViewById<EditText>(R.id.activity_formulario_jogo_valorAPagar)
        val valorAPagarEmTexto = campoValor.text.toString()
        val valorAPagar = if (valorAPagarEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorAPagarEmTexto)
        }

       return Jogos (
            nomeDoOrganizador = nomeDoOrganizador,
            numeroParaContato = numeroParaContato,
            diaDaSemana = dataDoJogo,
            horarioDoInicioDoJogo = horarioDeInicioDoJogo,
            horarioDoFimDoJogo = horarioDoFimDoJogo,
            valorDoJogo = valorAPagar
        )
    }
}