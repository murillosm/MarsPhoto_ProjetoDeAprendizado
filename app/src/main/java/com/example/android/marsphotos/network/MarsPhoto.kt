package com.example.android.marsphotos.network

import com.squareup.moshi.Json

//Esta classe de dados define uma foto de Marte que inclui um ID e o URL da imagem.
// Os nomes de propriedade desta classe de dados são usados polo Moshi para corresponder aos nomes de valores em JSON.
data class MarsPhoto(
    val id: String,
    //usado para mapear img_src do JSON para imgSrcUrl em nossa classe
    @Json(name = "img_src") val imgSrcUrl: String
)