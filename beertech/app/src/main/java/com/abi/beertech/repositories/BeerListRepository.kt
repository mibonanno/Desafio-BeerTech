package com.abi.beertech.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abi.beertech.entities.BeerItem

class BeerListRepository {

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abi.beertech.entities.BeerItem
import com.abi.beertech.InternetReturn.BeersAPIService
import kotlinx.coroutines.*
import java.lang.Exception

class BeerListRepository {


    private val productsListResponse = MutableLiveData<List<BeerItem>>()
    val productsResponse: LiveData<List<BeerItem>>
        get() = productsListResponse

    init {
        getProducts()
    }


    private fun getProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = BeersAPI.retrofitService.getBeers().body()
                productsListResponse.postValue(response)

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    productsListResponse.postValue(null)
                }

            }
        }
    }

