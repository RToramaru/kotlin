package com.example.lanchoneteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.applicationworkapi.model.Product
import com.example.lanchoneteapp.fragments.HomeFragment


class ProductAdapter(private val context: HomeFragment, private val productList:List<Product>)
    :RecyclerView.Adapter<ProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
            ProductViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.product_list, parent, false))

    override fun getItemCount(): Int  = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        holder.productName.text = item.prName
        holder.productPrice.text = item.prPrice
        Glide.with(context).load(item.prImage).into(holder.productImage)
    }

}

class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val productImage:ImageView = itemView.findViewById(R.id.product_list_image)
    val productName:TextView = itemView.findViewById(R.id.product_list_name)
    val productPrice:TextView = itemView.findViewById(R.id.product_list_description)
}