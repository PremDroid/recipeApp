package com.example.myrecipe


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel : MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoryState

    NavHost(navController = navController , startDestination = Screen.recipeScreen.route){
        composable(route = Screen.recipeScreen.route ){
            RecipeScreen(viewState = viewstate, Navigatetodetail = {
                //This part is responsible for passing data from the current screen to the detail screen.
                // It utilizes the savedStateHandle, which is a component of the Compose navigation framework.

                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(Screen.discription.route)
            })
        }
        composable(route = Screen.discription.route){
            val category  = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat") ?: Category("","","","")
            Discription(category = category)
        }
    }
}