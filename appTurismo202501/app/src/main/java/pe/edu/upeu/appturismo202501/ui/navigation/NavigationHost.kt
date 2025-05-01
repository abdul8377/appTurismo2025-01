package pe.edu.upeu.appturismo202501.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import pe.edu.upeu.appturismo202501.ui.presentation.Pantalla1
import pe.edu.upeu.appturismo202501.ui.presentation.screens.LoginScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    darkMode: MutableState<Boolean>,
    modif: PaddingValues
) {
    NavHost(
        navController = navController, startDestination =
            Destinations.Login.route
    ) {
        composable (Destinations.Login.route){
            LoginScreen(navigateToHome = {
                navController.navigate(Destinations.Pantalla1.route)})
        }

        composable(Destinations.Pantalla1.route) {
            Pantalla1  (navegarPantalla2 = { newText ->navController.navigate(Destinations.Pantalla2.createRoute(newText)) }
            )
        }


    }
}