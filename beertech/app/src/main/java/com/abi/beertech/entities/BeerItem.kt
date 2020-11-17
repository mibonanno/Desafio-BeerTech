package com.abi.beertech.entities

import com.squareup.moshi.Json

class BeerItem {
    @Json(name = "Beer")
val product: String,

    @Json(name = "descricao")
    val quantity: String,

    @Json(name = "preco")
    val price: Float,

    @Json(name = "desconto")
    val discount: Boolean,

    @Json(name = "imagem")
    val imageUrl: String
    )

}