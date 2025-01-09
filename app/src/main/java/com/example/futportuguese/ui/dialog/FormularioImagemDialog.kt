package com.example.futportuguese.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.futportuguese.databinding.FormularioImagemBinding
import com.example.futportuguese.extensions.tentaCarregarImagem


class FormularioImagemDialog(private val context: Context) {

    //Função que cria e configura o Dialog da Imagem, para mostrar e carregar imagem
    fun mostra(urlPadrao: String? = null, quandoImagemCarregada: (imagem: String) -> Unit) {
        FormularioImagemBinding
            .inflate(LayoutInflater.from(context)).apply {

                urlPadrao?.let {
                    formularioImagemImageview.tentaCarregarImagem(it)
                    formularioImagemUrl.setText(it)
                }
                formularioImagemBotaoCarregar.setOnClickListener {
                    val url = formularioImagemUrl.text.toString()
                    formularioImagemImageview.tentaCarregarImagem(url)
                }

                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Confirmar") { _, _ ->
                        val url = formularioImagemUrl.text.toString()
                        quandoImagemCarregada(url)
                    }
                    .setNegativeButton("Cancelar") { _, _ ->

                    }
                    .show()
            }
    }

}