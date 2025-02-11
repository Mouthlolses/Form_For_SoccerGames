package com.example.futportuguese.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.futportuguese.model.Jogos


@Dao
interface JogosDao {

    @Query("SELECT * FROM Jogos")
    fun buscaTodos(): List<Jogos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun salva(vararg jogos: Jogos)

    @Delete
    fun remove(vararg jogos: Jogos)

/*
    @Update
    fun atualiza(vararg jogos: Jogos)
*/

    //Função no app que Busca a lista em questão pelo Id para assim poder editar
    @Query("SELECT * FROM Jogos WHERE id = :id")
    fun buscaPorId(id: Long) : Jogos?
}


//DAO por sua vez vai utilizar a Entity, para falar que a partir do "Jogos" eu quero salvar/buscar/alterar ou remover.