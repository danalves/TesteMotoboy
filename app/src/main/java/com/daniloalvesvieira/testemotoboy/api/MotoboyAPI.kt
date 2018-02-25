package com.daniloalvesvieira.testemotoboy.api

import com.daniloalvesvieira.testemotoboy.model.RetornoAutent
import com.daniloalvesvieira.testemotoboy.model.RetornoOrcamento
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MotoboyAPI {

    @GET("login")
    fun autenticar(@Query("username") username: String, @Query("apiKey") key: String): Call<RetornoAutent>

    @GET("orcamento")
    fun solicitarOrcamento(@Query("cidade") cidade: String, @Query("endereco1_cep") cepColeta: String,
                           @Query("endereco2_cep") cepEntrega: String): Call<RetornoOrcamento>

}