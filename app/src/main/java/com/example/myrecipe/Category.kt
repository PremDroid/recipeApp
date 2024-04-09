package com.example.myrecipe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val idCategory : String,
    val strCategory : String,
    val strCategoryThumb : String,
    val strCategoryDescription : String
):Parcelable

data class CategoryResponse( val categories : List<Category>)