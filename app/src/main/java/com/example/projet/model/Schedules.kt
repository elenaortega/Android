package com.example.projet.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "schedules")
data class Schedules (@PrimaryKey(autoGenerate = true) val id_horaires: Int,
                      val code: String,
                      val station: String,
                      val way: String,
                      val message: String,
                      val destination: String,
                      val active: Boolean) : Parcelable {
    companion object {
        val all = (1..20)
            .map {
                Schedules(it, "code$it", "station$it", "way$it", "message$it", "destination$it", true)
            }.toMutableList()
    }
}
