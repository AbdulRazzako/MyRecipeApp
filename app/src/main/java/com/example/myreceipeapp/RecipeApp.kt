package com.example.myreceipeapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import eu.tutorials.myrecipeapp.RecipeScreen


@Composable
fun RecipeApp(navController: NavHostController,modifier: Modifier = Modifier) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewstate = recipeViewModel.categoriesState

    NavHost(
        navController = navController, startDestination  = Screen.RecipeScreen.route,
    ){
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(viewstate = viewstate, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)

                navController.navigate(Screen.DetailScreen.route)
            },
                modifier = modifier
                )
        }
        composable(route = Screen.DetailScreen.route) {
            val cat = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")

            if (cat != null) {
                CategoryDetailScreen(category = cat, modifier = modifier)
            } else {
                // Optionally show an error or navigate back
                Text("No category selected")
            }

        }

    }

}