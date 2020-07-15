package com.inchko.toatoa.Data

import java.net.URL

data class Stores(
    val title: String,
    val Categoria: String,
    val City: String,
    val Description: String,
    val Rating: Float,
    val photos: ArrayList<String>?
)