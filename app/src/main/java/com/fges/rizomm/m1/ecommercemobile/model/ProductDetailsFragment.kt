package com.fges.rizomm.m1.ecommercemobile.model

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.fges.rizomm.m1.ecommercemobile.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_product_details.*


class ProductDetailsFragment : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_product_details)

        val title = intent.getStringExtra("designation")
        val photoUrl = intent.getStringExtra("photo")

        product_name.text = title
        Picasso.get().load(photoUrl).into(photo)

        //val photo = intent.getStringExtra("photo")
        //photo.

        availability.setOnClickListener{
            AlertDialog.Builder(this)
                .setMessage("$title is in Stock!")
                .setPositiveButton("OK"){
                        p0, p1 ->
                }
                .create()
                .show()
        }
    }
}