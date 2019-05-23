package com.fges.rizomm.m1.ecommercemobile.ui.Adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.fges.rizomm.m1.ecommercemobile.R
import com.fges.rizomm.m1.ecommercemobile.ui.Adapter.ProductsAdapter.ViewHolder
import com.fges.rizomm.m1.ecommercemobile.model.Product
import com.fges.rizomm.m1.ecommercemobile.model.ProductDetails
import com.squareup.picasso.Picasso

class ProductsAdapter(private val products: List<Product>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        Picasso.get().load(product.photo).into(holder.image)
        holder.title.text = product.designation
        holder.prix.text = product.prix.toString()
        //holder.image = product
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        val holder = ViewHolder(view)

        view.setOnClickListener{
            val intent = Intent(parent.context, ProductDetails::class.java)
            intent.putExtra("designation", products[holder.adapterPosition].designation)
            intent.putExtra("photo", products[holder.adapterPosition].photo)
            parent.context.startActivity(intent)
        }
        return holder
    }

    override fun getItemCount() = products.size


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView= itemView.findViewById(R.id.title)
        val prix: TextView= itemView.findViewById(R.id.prix)

    }
}