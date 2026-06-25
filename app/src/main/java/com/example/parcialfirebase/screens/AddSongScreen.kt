package com.example.parcialfirebase.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AddSongScreen(navController: NavController) {
    val db = FirebaseFirestore.getInstance()
    var autor by remember { mutableStateOf("") }
    var nombreCancion by remember { mutableStateOf("") }
    var nombreAlbum by remember { mutableStateOf("") }
    var anioAlbum by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }
    var esError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Agregar Canción", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = autor, onValueChange = { autor = it },
            label = { Text("Autor") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = nombreCancion, onValueChange = { nombreCancion = it },
            label = { Text("Nombre de la canción") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = nombreAlbum, onValueChange = { nombreAlbum = it },
            label = { Text("Nombre del álbum") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = anioAlbum, onValueChange = { anioAlbum = it },
            label = { Text("Año del álbum") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))

        if (mensaje.isNotEmpty()) {
            Text(mensaje, color = if (esError) MaterialTheme.colorScheme.error
            else MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Button(
            onClick = {
                if (autor.isEmpty() || nombreCancion.isEmpty() || nombreAlbum.isEmpty() || anioAlbum.isEmpty()) {
                    esError = true; mensaje = "Completa todos los campos"
                    return@Button
                }
                val cancion = hashMapOf(
                    "autor" to autor,
                    "nombreCancion" to nombreCancion,
                    "nombreAlbum" to nombreAlbum,
                    "anioAlbum" to anioAlbum
                )
                db.collection("canciones").add(cancion)
                    .addOnSuccessListener {
                        esError = false
                        mensaje = "✅ Canción guardada exitosamente"
                        autor = ""; nombreCancion = ""; nombreAlbum = ""; anioAlbum = ""
                    }
                    .addOnFailureListener {
                        esError = true; mensaje = "❌ No se pudo guardar la canción"
                    }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Guardar Canción") }

        Spacer(modifier = Modifier.height(12.dp))
        TextButton(onClick = { navController.popBackStack() }) { Text("← Volver") }
    }
}
