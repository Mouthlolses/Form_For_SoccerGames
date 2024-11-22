package com.example.futportuguese.model

import java.math.BigDecimal

data class Jogos(
    val nomeDoOrganizador: String,
    val numeroParaContato: String,
    val diaDaSemana: String,
    val horarioDoInicioDoJogo: String,
    val horarioDoFimDoJogo: String,
    val valorDoJogo: BigDecimal
)
