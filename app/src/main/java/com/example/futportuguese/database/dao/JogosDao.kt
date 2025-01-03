package com.example.futportuguese.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.futportuguese.model.Jogos


@Dao
interface JogosDao {

    @Query("SELECT * FROM Jogos")
    fun buscaTodos() : List<Jogos>

    @Insert
    fun salva(vararg jogos: Jogos)
}


//DAO por sua vez vai utilizar a Entity, para falar que a partir do "Jogos" eu quero salvar/buscar/alterar ou remover.