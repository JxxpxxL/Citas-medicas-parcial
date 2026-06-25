package com.example.parcialfirebase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcialfirebase.screens.AddSongScreen
import com.example.parcialfirebase.screens.AlbumsScreen
import com.example.parcialfirebase.screens.HomeScreen
import com.example.parcialfirebase.screens.LocationScreen
import com.example.parcialfirebase.screens.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login")    { LoginScreen(navController) }
        composable("home")     { HomeScreen(navController) }
        composable("addSong")  { AddSongScreen(navController) }
        composable("albums")   { AlbumsScreen(navController) }
        composable("location") { LocationScreen(navController) }
    }
}