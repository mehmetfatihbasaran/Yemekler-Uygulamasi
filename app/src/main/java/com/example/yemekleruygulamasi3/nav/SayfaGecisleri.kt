package com.example.yemekleruygulamasi3.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.yemekleruygulamasi3.data.model.Yemekler
import com.example.yemekleruygulamasi3.ui.screens.AnaSayfa
import com.example.yemekleruygulamasi3.ui.screens.DetaySayfa
import com.google.gson.Gson

@Composable
fun SayfaGecisleri() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anaSayfa") {
        composable("anaSayfa") {
            AnaSayfa(navController = navController)
        }
        composable("detaySayfa/{yemek}",
            arguments = listOf(
                navArgument("yemek") {
                    type = NavType.StringType
                }
            )
        ) {
            val json = it.arguments?.getString("yemek")
            val yemek = Gson().fromJson(json, Yemekler::class.java)
            DetaySayfa(yemek = yemek!!)
        }
    }
}