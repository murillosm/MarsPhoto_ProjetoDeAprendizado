package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.http.GET
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


//Definimos a constante BASE_URL com o URL base do serviço da Web.
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


// Criação do objeto Retrofit com o conversor de scalars
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi)) // Converter para String
    .baseUrl(BASE_URL)  // Definir a URL base
    .build()    //criar o objeto Retrofit


// Interface que define como a Retrofit se comunica com o servidor da Web
interface MarsApiService{
    @GET("photos")
    suspend fun getPhotos() : List<MarsPhoto>// Função para obter as fotos
}


// Objeto Singleton que inicializa o serviço Retrofit
object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}