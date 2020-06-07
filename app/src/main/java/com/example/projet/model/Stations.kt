package com.example.projet.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "stations")
data class Stations (@PrimaryKey(autoGenerate = true) val id: Int,
                     val code: String,
                     val way: String,
                     val name: String,
                     val like: String,
                     val active: Boolean) : Parcelable {
    companion object {
        val all = (1..20)
            .map {
                Stations(it,"code$it", "way$it", "name$it", "false", true)
            }.toMutableList()
    }
}
