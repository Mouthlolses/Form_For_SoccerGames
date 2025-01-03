package com.example.futportuguese.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.futportuguese.database.converter.Converter
import com.example.futportuguese.database.dao.JogosDao
import com.example.futportuguese.model.Jogos

@Database(entities = [Jogos::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun jogosDao(): JogosDao
}