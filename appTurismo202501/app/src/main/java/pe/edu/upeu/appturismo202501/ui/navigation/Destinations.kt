package pe.edu.upeu.appturismo202501.ui.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check

import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector) {

    object Login : Destinations("login", "Login", Icons.Filled.Settings)
    object Register : Destinations("register", "register", Icons.Filled.Check)
    object Pantalla1 : Destinations("pantalla1", "Pantalla1", Icons.Filled.Home)

}

