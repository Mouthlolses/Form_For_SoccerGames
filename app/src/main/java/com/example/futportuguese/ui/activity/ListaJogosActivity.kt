package com.example.futportuguese.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.futportuguese.FormularioJogosActivity
import com.example.futportuguese.R
import com.example.futportuguese.dao.JogosDao
import com.example.futportuguese.ui.recyclerview.adapter.ListaDeJogosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaJogosActivity : AppCompatActivity() {
    private val dao = JogosDao()
    private val adapter = ListaDeJogosAdapter(context = this, jogos = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_de_jogos)
        configuraRecyclerView()
        configuraFab()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_lista_jogos_fab)
        fab.setOnClickListener {
            vaiParaFormularioJogos()
        }
    }

    private fun vaiParaFormularioJogos() {
        val intent = Intent(this, FormularioJogosActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_jogos_recyclerview)
        recyclerView.adapter = adapter
    }
}