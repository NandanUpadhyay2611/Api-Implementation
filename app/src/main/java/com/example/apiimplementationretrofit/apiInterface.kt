package com.example.apiimplementationretrofit

import retrofit2.Call
import retrofit2.http.GET

interface apiInterface {
    @GET("products")  //copy and paste the end name of the json
    fun getproductdata(): Call<myData>
}