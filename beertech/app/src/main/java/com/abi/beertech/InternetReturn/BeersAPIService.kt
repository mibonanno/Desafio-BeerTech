package com.abi.beertech.InternetReturn

import com.abi.beertech.entities.BeerItem

package com.abi.beertech.InternetReturn

import com.abi.beertech.entities.BeerItem
import com.abi.squareup.moshi.Moshi
import com.abi.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET


private const val BASE_URL = "https://private-8f4dda-testeabi.apiary-mock.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit : Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BeersAPIService {
    @GET("/beers")
    suspend fun getBeers(): Response<List<BeerItem>>

}

object ProductsAPI {
    val retrofitService: BeersAPIService by lazy {
        retrofit.create(BeersAPIService::class.java)
    }
}