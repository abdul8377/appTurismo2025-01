package pe.edu.upeu.appturismo202501.ui.navigation

import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector) {
    object Login : Destinations("login", "Login", Icons.Filled.Settings)
    object Pantalla1 : Destinations("pantalla1", "Pantalla1", Icons.Filled.Home)
    object Pantalla2 :
        Destinations("pantalla2/?newText={newText}", "Pantalla 2", Icons.Filled.Settings) {
        fun createRoute(newText: String) = "pantalla2/?newText=$newText"
    }
}

