package com.example.futportuguese.extensions

import android.widget.ImageView
import coil3.load
import coil3.request.error
import coil3.request.fallback
import coil3.request.placeholder

fun ImageView.tentaCarregarImagem(url: String? = null) {
    load(url) {
        fallback(com.example.futportuguese.R.drawable.logomarca_para_um_aplicativo_que_marca_hor_rios_para_jogos_de_futebol_em_portgu_s)
        error(com.example.futportuguese.R.drawable.logomarca_para_um_aplicativo_que_marca_hor_rios_para_jogos_de_futebol_em_portgu_s)
        placeholder(com.example.futportuguese.R.drawable.placeholder)
    }
}