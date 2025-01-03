package com.example.futportuguese.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.futportuguese.FormularioJogosActivity
import com.example.futportuguese.dao.JogosDao
import com.example.futportuguese.database.AppDatabase
import com.example.futportuguese.databinding.ActivityListaDeJogosBinding
import com.example.futportuguese.model.Jogos
import com.example.futportuguese.ui.recyclerview.adapter.ListaDeJogosAdapter
import java.math.BigDecimal

class ListaJogosActivity : AppCompatActivity() {
    private val dao = JogosDao()
    private val adapter = ListaDeJogosAdapter(context = this, jogos = dao.buscaTodos())
    private lateinit var binding: ActivityListaDeJogosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaDeJogosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        configuraRecyclerView()
        configuraFab()


        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "futPortuguese.db"
        ).allowMainThreadQueries()
            .build()

        val jogosDao = db.jogosDao()
        jogosDao.salva(
            Jogos(
                nomeDoOrganizador = "Zeca",
                numeroParaContato = "8866754683",
                diaDaSemana = "15/12/12",
                horarioDoInicioDoJogo = "17:00",
                horarioDoFimDoJogo = "18:00",
                valorDoJogo = BigDecimal("500"),
            )
        )
        adapter.atualiza(jogosDao.buscaTodos())

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
//        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        binding.activityListaJogosFab.setOnClickListener {
            vaiParaFormularioJogos()
        }
    }

    private fun vaiParaFormularioJogos() {
        val intent = Intent(this, FormularioJogosActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.activityListaJogosRecyclerview
        recyclerView.adapter = adapter

        adapter.quandoClicaNoItem = {
            val intent = Intent(
                this,
                DetalhesDoJogoActivity::class.java
            ).apply {
                putExtra(CHAVE_JOGOS, it)
            }
            startActivity(intent)
        }
    }
}