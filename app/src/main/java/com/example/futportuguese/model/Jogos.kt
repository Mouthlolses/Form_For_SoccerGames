package com.example.futportuguese.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal


@Entity
@Parcelize
data class Jogos(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nomeDoOrganizador: String,
    val numeroParaContato: String,
    val diaDaSemana: String,
    val horarioDoInicioDoJogo: String,
    val horarioDoFimDoJogo: String,
    val valorDoJogo: BigDecimal,
    val imagem: String? = null
) : Parcelable


//Entities são responsáveis em determinar quais informações queremos salvar no Banco de Dados.

//DAO por sua vez vai utilizar a Entity, para falar que a partir do "Jogos" eu quero salvar/buscar/alterar ou remover.

//Room Database por sua vez é o componente responsável em fazer a configuração geral do Banco de Dados.