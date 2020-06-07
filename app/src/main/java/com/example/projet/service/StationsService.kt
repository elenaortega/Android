package com.example.projet.service

import retrofit2.http.GET
import retrofit2.http.Path


interface StationsService {
    /**
     * Génère une requete HTTP du  type : /lines?results=<size>
     *
     */
    @GET("stations/{type}/{code}")
    suspend fun getSchedules(@Path("result") size: Int, @Path("type") type: String?, @Path("code") code: String?): GetStationsResults
}

data class GetStationsResults(val results: List<Lines> = emptyList())

data class Stations(val code: String = "", val station: String = "", val way: String = "", val message: String = "", val destination: String = "" )
