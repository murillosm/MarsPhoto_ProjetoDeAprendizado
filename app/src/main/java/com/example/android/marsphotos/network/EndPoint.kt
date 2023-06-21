package com.example.android.marsphotos.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPoint {
    @GET("/gh/fawazahmed0/currency-api@1/latest/currencies.json")
    fun getMoedas() : Call<JsonObject>

    @GET("gh/fawazahmed0/currency-api@1/latest/currencies/{from}/{to}.json")
    fun getTaxasDeCambio(@Path(value = "from", encoded = true) from : String, @Path(value = "to", encoded = true) to : String) : Call<JsonObject>
}