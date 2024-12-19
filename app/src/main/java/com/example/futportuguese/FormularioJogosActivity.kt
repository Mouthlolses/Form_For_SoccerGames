package com.example.futportuguese

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.futportuguese.dao.JogosDao
import com.example.futportuguese.databinding.ActivityFormularioJogosBinding
import com.example.futportuguese.model.Jogos
import java.math.BigDecimal


class FormularioJogosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioJogosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioJogosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        binding.activityFormularioJogoBotaoSalvar.setOnClickListener {
            val jogoCriado = criaProduto()
            val dao = JogosDao()
            dao.adiciona(jogoCriado)
            finish()
        }
    }

    private fun criaProduto(): Jogos {
        val nomeDoOrganizador = binding.activityFormularioJogoNomeDoOrganizador.text.toString()
        val numeroParaContato = binding.activityFormularioJogoNumeroParaContato.text.toString()
        val dataDoJogo = binding.activityFormularioJogoDiaDojogo.text.toString()
        val horarioDeInicioDoJogo = binding.activityFormularioJogoHorarioDoInicioDoJogo.text.toString()
        val horarioDoFimDoJogo = binding.acitivityFormularioJogoHorarioDeFimDoJogo.text.toString()
        val valorAPagarEmTexto = binding.activityFormularioJogoValorAPagar.text.toString()
        val valorAPagar = if (valorAPagarEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorAPagarEmTexto)
        }

        return Jogos(
            nomeDoOrganizador = nomeDoOrganizador,
            numeroParaContato = numeroParaContato,
            diaDaSemana = dataDoJogo,
            horarioDoInicioDoJogo = horarioDeInicioDoJogo,
            horarioDoFimDoJogo = horarioDoFimDoJogo,
            valorDoJogo = valorAPagar
        )
    }
}