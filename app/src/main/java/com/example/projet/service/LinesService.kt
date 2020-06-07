package com.example.projet.service

import com.facebook.stetho.json.annotation.JsonProperty
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LinesService {
    /**
     * Génère une requete HTTP du  type : /lines?results=<size>
     *
     */
    @GET("/lines/{type}")
    suspend fun getLines(@Path("result") size: Int, @Path("type") type: String?) : GetLinesResult
}

data class GetLinesResult(val results: List<Lines> = emptyList())

data class Lines(val code: String = "", val name: String = "", val directions: String = "", val num: Num = Num ())

data class Num(val id: Int = 0)
