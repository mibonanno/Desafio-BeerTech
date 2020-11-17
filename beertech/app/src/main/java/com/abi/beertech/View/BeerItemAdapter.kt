package com.abi.beertech.View

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abi.beertech.R
import com.abi.beertech.entities.BeerItem
import com.bumptech.glide.Glide
import java.text.DecimalFormat

class BeerItemAdapter {

class BeerItemsAdapter: RecyclerView.Adapter<BeerItemAdapter.BeersListViewHolder>() {
    var data = listOf<BeerItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BeerItemAdapter.BeersListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.beer_item, parent, false) as View
        return ProductsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeersListViewHolder,
                                  position: Int
    ) {
        val item = data[position]
        holder.bind(item.product, item.quantity, item.price, item.discount, item.imageUrl)
    }

    override fun getItemCount(): Int = data.size


    inner class ProductsListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val itemTitle = itemView.findViewById<TextView>(R.id.tv_beerName)
        private val itemQuantity = itemView.findViewById<TextView>(R.id.tv_beerQuantity)
        private val itemPrice = itemView.findViewById<TextView>(R.id.tv_beerPrice)
        private val itemImage = itemView.findViewById<ImageView>(R.id.iv_beerImage)

        fun bind(product: String, quantity: String, price: Float, discount: Boolean, imageUrl: String) {
            itemTitle.text = product
            itemQuantity.text = quantity


            itemPrice.text = "R$ ${DecimalFormat("#.00").format(price)}"

            if(discount) {
                val color = Color.parseColor("#0FB816")
                itemPrice.setTextColor(color)
            }

            if(imageUrl.isNotEmpty()) {
                Glide.with(itemView.context)
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_beer_pint)
                    .error(R.drawable.ic_beer_pint)
                    .into(itemImage)
            } else {
                Glide.with(itemView.context).clear(itemView)
                itemImage.setImageResource(R.drawable.ic_beer_pint)
            }

        }
    }

