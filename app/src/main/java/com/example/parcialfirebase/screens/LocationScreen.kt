package com.example.parcialfirebase.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices

@OptIn(ExperimentalPermissionsApi::class)
@SuppressLint("MissingPermission")
@Composable
fun LocationScreen(navController: NavController) {
    val context = LocalContext.current
    val fusedClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    var latitud by remember { mutableStateOf("Obteniendo...") }
    var longitud by remember { mutableStateOf("") }

    val permiso = rememberPermissionState(android.Manifest.permission.ACCESS_FINE_LOCATION)

    LaunchedEffect(permiso.status.isGranted) {
        if (permiso.status.isGranted) {
            fusedClient.lastLocation.addOnSuccessListener { loc ->
                if (loc != null) {
                    latitud = "%.6f".format(loc.latitude)
                    longitud = "%.6f".format(loc.longitude)
                } else {
                    latitud = "No se pudo obtener"
                    longitud = "Activa el GPS del dispositivo"
                }
            }
        } else {
            permiso.launchPermissionRequest()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("📍 Ubicación GPS", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        if (permiso.status.isGranted) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text("Latitud:", style = MaterialTheme.typography.labelLarge)
                    Text(latitud, style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Longitud:", style = MaterialTheme.typography.labelLarge)
                    Text(longitud, style = MaterialTheme.typography.bodyLarge)
                }
            }
        } else {
            Text("Se necesita permiso de ubicación")
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { permiso.launchPermissionRequest() }) {
                Text("Conceder permiso")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        TextButton(onClick = { navController.popBackStack() }) { Text("← Volver") }
    }
}