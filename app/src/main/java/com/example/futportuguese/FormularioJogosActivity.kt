package com.example.futportuguese

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.futportuguese.database.AppDatabase
import com.example.futportuguese.databinding.ActivityFormularioJogosBinding
import com.example.futportuguese.extensions.tentaCarregarImagem
import com.example.futportuguese.model.Jogos
import com.example.futportuguese.ui.activity.CHAVE_JOGOS
import com.example.futportuguese.ui.dialog.FormularioImagemDialog
import java.math.BigDecimal


class FormularioJogosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormularioJogosBinding

    private var url: String? = null
    private var idJogo = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioJogosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityFormularioJogoImagem.setOnClickListener {
            FormularioImagemDialog(this)
                .mostra(url) { imagem ->
                    url = imagem
                    binding.activityFormularioJogoImagem.tentaCarregarImagem(url)
                }
        }
        intent.getParcelableExtra<Jogos>(CHAVE_JOGOS)?.let { jogoCarregado ->
            title = "Alterar Jogo"
            idJogo = jogoCarregado.id
            url = jogoCarregado.imagem
            binding.activityFormularioJogoImagem
                .tentaCarregarImagem(jogoCarregado.imagem)
            binding.formularioJogoTextinputEditTextNomeDoOrganizador
                .setText(jogoCarregado.nomeDoOrganizador)
            binding.formularioJogoTextinputEditTextNumeroParaContato
                .setText(jogoCarregado.numeroParaContato)
            binding.dataDoJogoTextInputLayout
                .setText(jogoCarregado.diaDaSemana)
            binding.horarioDeInicioTextInputLayout
                .setText(jogoCarregado.horarioDoInicioDoJogo)
            binding.horarioDoTerminoTextInputLayout
                .setText(jogoCarregado.horarioDoFimDoJogo)
            binding.valorAPagarTextInputLayout
                .setText(jogoCarregado.valorDoJogo.toPlainString())
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        configuraBotaoSalvar()
    }

    //Configurei o botao salvar com o banco de dados
    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.activityFormularioJogoBotaoSalvar
        val db = AppDatabase.instancia(this)
        val jogosDao = db.jogosDao()
        botaoSalvar.setOnClickListener {
            val jogoNovo = criaProduto()
            if (idJogo > 0) {
                jogosDao.atualiza(jogoNovo)
            } else {
                jogosDao.salva(jogoNovo)
            }
            finish()
        }
    }

    private fun criaProduto(): Jogos {
        val nomeDoOrganizador =
            binding.formularioJogoTextinputlayoutNomeDoOrganizador.editText?.text.toString()
        val numeroParaContato =
            binding.formularioJogoTextinputlayoutNumeroParaContato.editText?.text.toString()
        val dataDoJogo =
            binding.formularioJogoTextinputlayoutDataDoJogo.editText?.text.toString()
        val horarioDeInicioDoJogo =
            binding.formularioJogoTextinputlayoutHorarioDeInicioDoJogo.editText?.text.toString()
        val horarioDoFimDoJogo =
            binding.formularioJogoTextinputlayoutHorarioDeTerminoDoJogo.editText?.text.toString()
        val valorAPagarEmTexto =
            binding.formularioJogoTextinputlayoutValorAPagar.editText?.text.toString()
        val valorAPagar = if (valorAPagarEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorAPagarEmTexto)
        }

        return Jogos(
            id = idJogo,
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