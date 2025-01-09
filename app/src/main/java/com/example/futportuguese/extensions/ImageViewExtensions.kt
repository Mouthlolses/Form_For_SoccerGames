package com.example.futportuguese.extensions

import android.widget.ImageView
import coil3.load
import coil3.request.error
import coil3.request.fallback
import coil3.request.placeholder
import com.example.futportuguese.R

//Imagens para funções de load(carregamento)
fun ImageView.tentaCarregarImagem(
    url: String? = null,

    fallback: Int = R.drawable.logomarca_para_um_aplicativo_que_marca_hor_rios_para_jogos_de_futebol_em_portgu_s
) {
    load(url) {
        fallback(fallback)
        error(R.drawable.logomarca_para_um_aplicativo_que_marca_hor_rios_para_jogos_de_futebol_em_portgu_s)
        placeholder(R.drawable.placeholder)
    }
}