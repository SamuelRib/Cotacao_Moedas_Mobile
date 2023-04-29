package com.sam.cotacao_moedas.api

import com.sam.cotacao_moedas.model.Moeda
import com.sam.cotacao_moedas.model.ParMoeda
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCotacao {
    @GET("{moeda}")
    fun setMoeda(@Path("moeda") moeda: String): Call<ParMoeda>
}