package com.example.projet.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projet.model.Lignes
import com.example.projet.model.Schedules
import com.example.projet.model.Stations


@Database(entities = arrayOf(Lignes::class, Schedules::class, Stations::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMetroDao() : MetroDao
}

