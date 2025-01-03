package com.example.futportuguese.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.futportuguese.database.converter.Converter
import com.example.futportuguese.database.dao.JogosDao
import com.example.futportuguese.model.Jogos

@Database(entities = [Jogos::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun jogosDao(): JogosDao


    //Utilizei um companion object pois ele é estatico e não seria possível instanciar ele na class AppDatabase como uma função comum.
    companion object {
        fun instancia(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "futPortuguese.db"
            ).allowMainThreadQueries()
                .build()
        }
    }
}