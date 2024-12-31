package com.example.futportuguese.dao

import com.example.futportuguese.model.Jogos
import java.math.BigDecimal

class JogosDao {

    fun adiciona(jogo: Jogos) {
        jogos.add(jogo)
    }


    fun buscaTodos(): List<Jogos> {
        return jogos.filter { it.imagem != "Invalida" }.toList()
    }

    companion object {
        private val jogos = mutableListOf<Jogos>(
        )
    }
}


/*
 * Esse é o  Data Access Object,ele é um padrão de design usado para
separar a lógica de acesso a dados da lógica de negócios de uma aplicação.

 * O DAO é um componente essencial ao criar apps Android que interagem com bancos de dados.
Ele simplifica o acesso a dados, promove a organização do código e
permite que a interface do usuário reaja automaticamente às mudanças nos dados.


 * O DAO serve como uma interface que define métodos para interagir com o banco de dados.
Ele atua como uma ponte entre a aplicação e o banco de dados,com:

* Inserção de dados: Permite adicionar novos registros ao banco de dados.
Exemplo:
@Insert
fun insertUser(user: User)

* Atualização de dados: Permite modificar registros existentes.
Exemplo:
@Update
fun updateUser(user: User)

* Exclusão de dados: Remove registros do banco de dados.
Exemplo:

@Delete
fun deleteUser(user: User)

* Consulta de dados: Define métodos para buscar registros, podendo incluir filtros e ordenação.
Exemplo:

@Query("SELECT * FROM User WHERE id = :userId")
fun getUserById(userId: Int): User
*/


/*
 * Como o DAO funciona em um app Android?
 * Em uma aplicação Android que usa o Room, o DAO:

* Define operações no banco de dados: Ele abstrai consultas SQL para que você não precise escrevê-las diretamente,
mas ainda pode usar @Query para consultas personalizadas.

* Evita duplicação de código: Centraliza toda a lógica de acesso a dados, tornando o código mais limpo e reutilizável.

* Integra com Kotlin coroutines e LiveData: Pode retornar tipos reativos como Flow ou LiveData,
permitindo que a UI reaja automaticamente às mudanças nos dados.


 * Exemplo de DAO com Room:

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM User WHERE id = :id")
    fun getUserById(id: Int): Flow<User>

    @Delete
    suspend fun deleteUser(user: User)
}



 * Por que usar um DAO em Android?

* Organização: Mantém a lógica de acesso a dados separada da lógica de apresentação e negócios.

* Facilidade de manutenção: Torna o código mais fácil de entender e modificar.

* Desempenho: Otimiza as interações com o banco de dados ao gerar código eficiente durante a compilação.

* Confiabilidade: Garante que as consultas ao banco de dados sejam verificadas em tempo de compilação, reduzindo erros.
*/