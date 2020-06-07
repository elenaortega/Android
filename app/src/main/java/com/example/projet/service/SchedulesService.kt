package com.example.projet.service

import retrofit2.http.GET
import retrofit2.http.Path

interface SchedulesService {
    /**
     * Génère une requete HTTP du  type : /lines?results=<size>
     *
     */
    @GET("/schedules/{type}/{code}/{station}/{way}")
    suspend fun getSchedules(@Path("result") size: Int, @Path("type") type: String?, @Path("code") code: String?, @Path("station") station: String?, @Path("way") way: String?) : GetSchedulesResults
}

data class GetSchedulesResults(val results: List<Lines> = emptyList())

data class Schedules(val code: String = "", val station: String = "", val way: String = "", val message: String = "", val destination: String = "" )
