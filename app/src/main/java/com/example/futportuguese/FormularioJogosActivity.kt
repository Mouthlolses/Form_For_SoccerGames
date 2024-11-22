package com.example.futportuguese

import android.os.Bundle
import android.util.Log
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
        val botaoSalvar = findViewById<Button>(R.id.botaoSalvar)
        botaoSalvar.setOnClickListener {
            val campoNomeDoOrganizador = findViewById<EditText>(R.id.nomeDoOrganizador)
            val nomeDoOrganizador = campoNomeDoOrganizador.text.toString()
            val campoNumeroParaContato = findViewById<EditText>(R.id.numeroParaContato)
            val numeroParaContato = campoNumeroParaContato.text.toString()
            val campoDataDoJogo = findViewById<EditText>(R.id.diaDojogo)
            val dataDoJogo = campoDataDoJogo.text.toString()
            val campoHorarioDeInicioDoJogo = findViewById<EditText>(R.id.horarioDoInicioDoJogo)
            val horarioDeInicioDoJogo = campoHorarioDeInicioDoJogo.text.toString()
            val campoHorarioDeTerminoDoJogo = findViewById<EditText>(R.id.horarioDeFimDoJogo)
            val horarioDoFimDoJogo = campoHorarioDeTerminoDoJogo.text.toString()
            val campoValor = findViewById<EditText>(R.id.valorAPagar)
            val valorAPagarEmTexto = campoValor.text.toString()
            val valorAPagar = if (valorAPagarEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorAPagarEmTexto)
            }


            val jogoCriado = Jogos(
                nomeDoOrganizador = nomeDoOrganizador,
                numeroParaContato = numeroParaContato,
                diaDaSemana = dataDoJogo,
                horarioDoInicioDoJogo = horarioDeInicioDoJogo,
                horarioDoFimDoJogo = horarioDoFimDoJogo,
                valorDoJogo = valorAPagar
            )
            Log.i("Formulario", "onCreate: $jogoCriado")
            val dao = JogosDao()
            dao.adiciona(jogoCriado)
            Log.i("Formulario", "onCreate: ${dao.buscaTodos()}")
            finish()
        }
    }
}