package com.abi.beertech.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.abi.beertech.databinding.ActivityBeersListBinding
import com.abi.beertech.repositories.BeerListRepository
import com.abi.beertech.viewmodel.BeersListViewModel
import com.abi.beertech.viewmodel.BeersListViewModelFactory

class ProductsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBeersListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = BeerListRepository()
        val viewModelFactory = BeersListViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(BeersListViewModel::class.java)
        val list = viewModel.productsList

        val recyclerView = binding.recyclerViewProducts
        val adapter = BeerItemsAdapter()
        recyclerView.adapter = adapter

        list.observe(this, Observer {
            adapter.data = it
            recyclerView.visibility = View.VISIBLE
            binding.loadingProductsIndicator.visibility = View.GONE
        })
    }
}