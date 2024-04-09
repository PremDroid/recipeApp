package com.example.myrecipe



sealed class Screen(val route: String) {
    object recipeScreen : Screen("RecipeScreen")
    object discription : Screen("Description")
}