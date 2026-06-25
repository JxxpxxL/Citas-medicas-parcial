# 📱 Parcial de Programación Móvil I
### Implementación Básica de Firebase y Funcionalidades de Navegación

**Estudiante:** Jean Paul Cala Villegas  
**Curso:** Electiva de Profundización IV - 8B  
**Fecha:** 24 de Junio de 2026  

---

## 🎯 Descripción

Aplicación Android desarrollada en **Kotlin** con **Jetpack Compose** que integra Firebase Authentication, Cloud Firestore, consumo de API REST y ubicación GPS.

---

## ✨ Funcionalidades

| Pantalla | Descripción |
|----------|-------------|
| 🔐 **LoginScreen** | Inicio de sesión y registro con Firebase Authentication |
| 🏠 **HomeScreen** | Pantalla principal con navegación a todas las funciones |
| 🎵 **AddSongScreen** | Agregar canciones a Cloud Firestore |
| 💿 **AlbumsScreen** | Lista de álbumes desde API REST |
| 📍 **LocationScreen** | Coordenadas GPS del dispositivo |

---

## 🛠️ Tecnologías

- **Kotlin** — Lenguaje principal
- **Jetpack Compose** — UI declarativa
- **Firebase Authentication** — Autenticación email/contraseña
- **Cloud Firestore** — Base de datos en la nube
- **Retrofit 2** — Consumo de API REST
- **Google Play Services Location** — GPS
- **Navigation Compose** — Navegación entre pantallas
- **Accompanist Permissions** — Permisos en tiempo de ejecución

---

## 🚀 Cómo ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/JxxpxxL/Citas-medicas-parcial.git
   ```
2. Abre el proyecto en **Android Studio**
3. Agrega tu propio archivo `google-services.json` en la carpeta `app/`
4. Activa **Authentication (Email/Contraseña)** y **Firestore** en tu consola de Firebase
5. Ejecuta la app en un emulador o dispositivo físico

---

## 📁 Estructura del Proyecto

```
app/src/main/java/com/example/parcialfirebase/
├── MainActivity.kt
├── navigation/
│   └── AppNavigation.kt
├── network/
│   └── AlbumApi.kt
└── screens/
    ├── LoginScreen.kt
    ├── HomeScreen.kt
    ├── AddSongScreen.kt
    ├── AlbumsScreen.kt
    └── LocationScreen.kt
```

---

## 🌐 API utilizada

- **JSONPlaceholder:** `https://jsonplaceholder.typicode.com/albums`

---

## 📄 Licencia

Proyecto académico — Electiva de Profundización IV
