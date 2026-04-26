package com.aaronmg.fakestoreapi.services

import com.aaronmg.fakestoreapi.models.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsService {

    @GET("products")
    suspend fun getAllProducts() : List<Product>

    //Path, Query String y Body
    // /1 --> Path
    // ?name=Juan&lastName=Frausto --> Query String
    // {"name":"Juan" } ---> BodyPOST, PUT, PATCH
    @GET("products/{id}")
    suspend fun getProductById( @Path("id") id: Int) : Product
}