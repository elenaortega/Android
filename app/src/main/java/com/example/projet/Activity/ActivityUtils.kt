package com.example.projet.Activity

import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.projet.data.AppDatabase
import com.example.projet.data.MetroDao
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory



/**
 * Retourne le DAO
 *
 */
fun AppCompatActivity.dao() : MetroDao {
    val database =
        Room.databaseBuilder(this, AppDatabase::class.java, "gestionmetro")
            .build()
    return database.getMetroDao()
}

/**
 * Retourne l'accès à L'API Rest
 *
 */
fun AppCompatActivity.retrofit() : Retrofit {

    val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val stations = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .addNetworkInterceptor(StethoInterceptor())
        .build()

    return Retrofit.Builder()
        .baseUrl("https://api-ratp.pierre-grimaud.fr/v4/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(stations)
        .build()
}

