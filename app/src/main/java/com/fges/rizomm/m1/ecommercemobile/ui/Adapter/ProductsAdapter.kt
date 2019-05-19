package com.fges.rizomm.m1.ecommercemobile.ui.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.fges.rizomm.m1.ecommercemobile.R
import com.fges.rizomm.m1.ecommercemobile.ui.Adapter.ProductsAdapter.ViewHolder
import com.fges.rizomm.m1.ecommercemobile.model.Product
import com.squareup.picasso.Picasso

class ProductsAdapter(private val products: List<Product>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(products[position].photo).into(holder.image)
        holder.title.text = products[position].designation
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView= itemView.findViewById(R.id.title)

    }
}