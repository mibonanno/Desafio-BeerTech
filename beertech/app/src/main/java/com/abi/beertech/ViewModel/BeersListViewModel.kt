package com.abi.beertech.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.abi.beertech.entities.BeerItem
import com.abi.beertech.repositories.BeerListRepository

class BeersListViewModel (private val repository: BeerListRepository): ViewModel() {

    val productsList: LiveData<List<BeerItem>>
        get() = repository.beerResponse
}