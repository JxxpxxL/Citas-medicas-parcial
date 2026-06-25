package com.example.parcialfirebase.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(navController: NavController) {
    val user = FirebaseAuth.getInstance().currentUser

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido", style = MaterialTheme.typography.headlineMedium)
        Text(user?.email ?: "", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate("addSong") },
            modifier = Modifier.fillMaxWidth()) { Text("🎵 Agregar Canción") }
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { navController.navigate("albums") },
            modifier = Modifier.fillMaxWidth()) { Text("💿 Ver Álbumes") }
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { navController.navigate("location") },
            modifier = Modifier.fillMaxWidth()) { Text("📍 Ver Ubicación GPS") }
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedButton(onClick = {
            FirebaseAuth.getInstance().signOut()
            navController.navigate("login") { popUpTo("home") { inclusive = true } }
        }, modifier = Modifier.fillMaxWidth()) { Text("Cerrar Sesión") }
    }
}