package com.example.futportuguese.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

//Extensio para formatar BigDeciaml em MoedaBrasileira
fun BigDecimal.formataParaMoedaBrasileira(): String {
    val formatador: NumberFormat = NumberFormat
        .getCurrencyInstance(Locale("pt", "br"))
    return formatador.format(this)
}