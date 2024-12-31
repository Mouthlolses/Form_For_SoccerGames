package com.example.futportuguese.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Jogos(
    val nomeDoOrganizador: String,
    val numeroParaContato: String,
    val diaDaSemana: String,
    val horarioDoInicioDoJogo: String,
    val horarioDoFimDoJogo: String,
    val valorDoJogo: BigDecimal,
    val imagem: String? = null
) : Parcelable
