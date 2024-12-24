package com.example.futportuguese

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil3.load
import com.example.futportuguese.dao.JogosDao
import com.example.futportuguese.databinding.ActivityFormularioJogosBinding
import com.example.futportuguese.databinding.FormularioImagemBinding
import com.example.futportuguese.model.Jogos
import java.math.BigDecimal


class FormularioJogosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioJogosBinding

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioJogosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityFormularioJogoImagem.setOnClickListener {
           val bindingFormularioImagem = FormularioImagemBinding.inflate(layoutInflater)
            bindingFormularioImagem.formularioImagemBotaoCarregar.setOnClickListener{
               val url = bindingFormularioImagem.formularioImagemUrl.text.toString()
                bindingFormularioImagem.formularioImagemImageview.load(url)
            }
            AlertDialog.Builder(this)
                .setView(bindingFormularioImagem.root)
                .setPositiveButton("Confirmar") { _, _ ->
                    url = bindingFormularioImagem.formularioImagemUrl.text.toString()
                    binding.activityFormularioJogoImagem.load(url)
                }
                .setNegativeButton("Cancelar") { _, _ ->

                }
                .show()
        }

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
        val nomeDoOrganizador = binding.formularioJogoTextinputlayoutNomeDoOrganizador.editText?.text.toString()
        val numeroParaContato = binding.formularioJogoTextinputlayoutNumeroParaContato.editText?.text.toString()
        val dataDoJogo = binding.formularioJogoTextinputlayoutDataDoJogo.editText?.text.toString()
        val horarioDeInicioDoJogo = binding.formularioJogoTextinputlayoutHorarioDeInicioDoJogo.editText?.text.toString()
        val horarioDoFimDoJogo = binding.formularioJogoTextinputlayoutHorarioDeTerminoDoJogo.editText?.text.toString()
        val valorAPagarEmTexto = binding.formularioJogoTextinputlayoutValorAPagar.editText?.text.toString()
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
            valorDoJogo = valorAPagar,
            imagem = url
        )
    }
}