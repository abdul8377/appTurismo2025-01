package pe.edu.upeu.ctproyecto.ui.home.navbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object Home : BottomNavItem("home", Icons.Filled.Home, "Inicio")
    object Usuarios : BottomNavItem("mainusers", Icons.Filled.Person, "Usuarios")
    object Emprendimientos : BottomNavItem("listEmprendimientos", Icons.Filled.List, "Emprendimientos")
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    // Lista de ítems de la barra de navegación
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Usuarios,
        BottomNavItem.Emprendimientos
    )

    // Obtén la ruta actual del back stack
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry.value?.destination?.route

    NavigationBar {
        items.forEach { item ->
            val selected = currentRoute == item.route
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = selected, // Marca el ítem si está seleccionado
                onClick = {
                    // Navegar solo si no estamos en la misma pantalla
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}