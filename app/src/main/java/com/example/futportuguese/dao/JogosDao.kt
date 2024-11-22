package com.example.futportuguese.dao

import com.example.futportuguese.model.Jogos

class JogosDao {

    fun adiciona(jogo: Jogos){
        jogos.add(jogo)
    }


    fun buscaTodos(): List<Jogos>{
        return jogos.toList()
    }

    companion object {
        private val jogos = mutableListOf<Jogos>()
    }
}

