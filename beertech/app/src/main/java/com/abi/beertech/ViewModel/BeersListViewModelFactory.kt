package com.abi.beertech.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abi.beertech.repositories.BeerListRepository

class BeersListViewModelFactory (private val repository: BeerListRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BeersListViewModel::class.java)) {
            return BeersListViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}