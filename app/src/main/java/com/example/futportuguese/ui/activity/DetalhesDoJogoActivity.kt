package com.example.futportuguese.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.futportuguese.R
import com.example.futportuguese.databinding.ActivityDetalhesDoJogoBinding
import com.example.futportuguese.extensions.formataParaMoedaBrasileira
import com.example.futportuguese.extensions.tentaCarregarImagem
import com.example.futportuguese.model.Jogos

class DetalhesDoJogoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetalhesDoJogoBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tentaCarregarJogo()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun tentaCarregarJogo() {
        intent.getParcelableExtra<Jogos>(CHAVE_JOGOS)?.let { jogoCarregado ->
            preencheCampos(jogoCarregado)
        } ?: finish()
    }

    private fun preencheCampos(jogoCarregado: Jogos) {
        with(binding) {
            activityDetalhesDoJogoImagem.tentaCarregarImagem(jogoCarregado.imagem)
            activityDetalhesDoJogoNome.text = jogoCarregado.nomeDoOrganizador
            activityDetalhesDoJogoNumeroParaContato.text = jogoCarregado.numeroParaContato
            activityDetalhesDoJogoDiaDaSemana.text = jogoCarregado.diaDaSemana
            activityDetalhesDoJogoHorarioDeInicio.text = jogoCarregado.horarioDoInicioDoJogo
            activityDetalhesDoJogoHorarioDoFim.text = jogoCarregado.horarioDoFimDoJogo
            activityDetalhesDoJogoValor.text =
            jogoCarregado.valorDoJogo.formataParaMoedaBrasileira()
        }
    }
}