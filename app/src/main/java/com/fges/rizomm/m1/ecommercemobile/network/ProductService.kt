package com.fges.rizomm.m1.ecommercemobile.network

import com.fges.rizomm.m1.ecommercemobile.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("/produits")
    fun listProduits(): Call<List<Product>>
}