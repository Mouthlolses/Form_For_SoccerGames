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
            Jogos(
                imagem = "https://upload.wikimedia.org/wikipedia/commons/3/3f/Foto_oficial_de_Luiz_In%C3%A1cio_Lula_da_Silva_%28rosto%29.jpg",
                nomeDoOrganizador = "Luiz Inacio Lula da Silva",
                numeroParaContato = "88996278654",
                diaDaSemana = "15/06/2020",
                horarioDoInicioDoJogo = "15:00",
                horarioDoFimDoJogo = "15:00",
                valorDoJogo = BigDecimal("100")
            ),
            Jogos(
                imagem = "https://s2-g1.glbimg.com/v852h9EH9JTPOAp4PJGxY1mJscs=/0x0:427x640/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2019/F/7/qkFYZGRuuqBkBNsSng3w/3.jpg",
                nomeDoOrganizador = "Bolsonaro",
                numeroParaContato = "88996278654",
                diaDaSemana = "15/06/2020",
                horarioDoInicioDoJogo = "15:00",
                horarioDoFimDoJogo = "17:00",
                valorDoJogo = BigDecimal("100")
            ),
            Jogos(
                imagem = "https://i.pinimg.com/originals/14/d4/ff/14d4ff19f84c0cb768c21e473a875f88.jpg",
                nomeDoOrganizador = "Justin Bieber",
                numeroParaContato = "88996278654",
                diaDaSemana = "15/06/2020",
                horarioDoInicioDoJogo = "11:00",
                horarioDoFimDoJogo = "17:00",
                valorDoJogo = BigDecimal("600")
            ),
            Jogos(
                imagem = "https://s2-techtudo.glbimg.com/3zDRyac6Lja3dr33NiWF13lNXsE=/0x8:640x507/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2019/I/X/zUjzvvRZirgzcuyVA93w/43984903-290100898498205-95480952794328461-n.jpg",
                nomeDoOrganizador = "Neymar Jr",
                numeroParaContato = "88996278654",
                diaDaSemana = "15/06/2020",
                horarioDoInicioDoJogo = "11:00",
                horarioDoFimDoJogo = "17:00",
                valorDoJogo = BigDecimal("1000")
            ),
            Jogos(
                imagem = "https://upload.wikimedia.org/wikipedia/commons/e/e0/07.09.2024_-_Desfile_de_7_de_Setembro_%2853978379274%29_Alexandre_de_Moraes_3x4_portrait_crop.jpg",
                nomeDoOrganizador = "Alexandre de Moraes",
                numeroParaContato = "88996278654",
                diaDaSemana = "15/06/2020",
                horarioDoInicioDoJogo = "11:00",
                horarioDoFimDoJogo = "17:00",
                valorDoJogo = BigDecimal("5000")
            ),
            Jogos(
                imagem = "https://s2.glbimg.com/96P5iqE9v1ZnbHjczxDfKykB-2Y=/143x0:804x707/661x707/middle/i.s3.glbimg.com/v1/AUTH_da025474c0c44edd99332dddb09cabe8/internal_photos/bs/2024/M/w/KC40aUTQ6W9e66beoBXQ/elon-musk-etienne-laurent-afp-13-de-abril-de-2024.jpg",
                nomeDoOrganizador = "Elon Musk",
                numeroParaContato = "88996278654",
                diaDaSemana = "15/06/2020",
                horarioDoInicioDoJogo = "11:00",
                horarioDoFimDoJogo = "17:00",
                valorDoJogo = BigDecimal("10000")
            )
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