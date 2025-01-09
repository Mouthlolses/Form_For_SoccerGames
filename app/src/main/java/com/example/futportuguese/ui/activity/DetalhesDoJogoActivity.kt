package com.example.futportuguese.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.futportuguese.FormularioJogosActivity
import com.example.futportuguese.R
import com.example.futportuguese.database.AppDatabase
import com.example.futportuguese.databinding.ActivityDetalhesDoJogoBinding
import com.example.futportuguese.extensions.formataParaMoedaBrasileira
import com.example.futportuguese.extensions.tentaCarregarImagem
import com.example.futportuguese.model.Jogos

class DetalhesDoJogoActivity : AppCompatActivity() {

    private lateinit var jogo: Jogos
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

    //Menu de Opções
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalhes_jogo, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Configurando Listener para menu de detalhes com as funções remover e editar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (::jogo.isInitialized) {
            val db = AppDatabase.instancia(this)
            val jogosDao = db.jogosDao()
            when (item.itemId) {
                R.id.menu_detalhes_jogo_remover -> {
                    jogosDao.remove(jogo)
                    finish()
                }

                R.id.menu_detalhes_jogo_editar -> {
                    Intent(this, FormularioJogosActivity::class.java).apply {
                        putExtra(CHAVE_JOGOS, jogo)
                        startActivity(this)
                    }
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun tentaCarregarJogo() {
        intent.getParcelableExtra<Jogos>(CHAVE_JOGOS)?.let { jogoCarregado ->
            jogo = jogoCarregado
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