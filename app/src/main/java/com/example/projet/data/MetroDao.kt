package com.example.projet.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.projet.model.Lignes
import com.example.projet.model.Schedules
import com.example.projet.model.Stations



@Dao
interface MetroDao {

    @Query("select * from lignes")
    suspend fun getLines() : List<Lignes>

    @Insert
    suspend fun addLignes(lignes: Lignes)

    @Query("select * from schedules")
    suspend fun getSchedules() : List<Schedules>

    @Query("select * from stations")
    suspend fun getStations() : List<Stations>

}