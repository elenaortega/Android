package com.example.projet.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "lignes")
data class Lignes (@PrimaryKey(autoGenerate = true) val id_lignes: Int,
                   val code: String,
                   val name: String,
                   val directions: String,
                   val id: Int,
                   val active: Boolean) : Parcelable {
    companion object {
        val all = (1..20)
            .map {
                Lignes(it, "code$it" , "name$it","directions$it", 0+it,true)
            }.toMutableList()
    }
}
