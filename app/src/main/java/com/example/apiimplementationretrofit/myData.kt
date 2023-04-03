package com.example.apiimplementationretrofit

data class myData(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)