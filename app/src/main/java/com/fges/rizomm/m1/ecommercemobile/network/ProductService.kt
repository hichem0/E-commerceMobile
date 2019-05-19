package com.fges.rizomm.m1.ecommercemobile.network

import com.fges.rizomm.m1.ecommercemobile.model.Product
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("/produits")
    fun listProduits(): Deferred<List<Product>>
}