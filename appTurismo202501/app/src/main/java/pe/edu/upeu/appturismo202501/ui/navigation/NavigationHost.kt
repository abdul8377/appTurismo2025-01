package pe.edu.upeu.appturismo202501.ui.navigation

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import pe.edu.upeu.appturismo202501.ui.presentation.Pantalla1
import pe.edu.upeu.appturismo202501.ui.presentation.screens.LoginScreen
import pe.edu.upeu.appturismo202501.ui.presentation.screens.register.RegisterScreen
import pe.edu.upeu.appturismo202501.ui.presentation.screens.welcome.PerfilScreen
import pe.edu.upeu.appturismo202501.ui.presentation.screens.welcome.SearchScreen
import pe.edu.upeu.appturismo202501.ui.presentation.screens.welcome.WelcomeScreen
import pe.edu.upeu.appturismo202501.ui.theme.AppTurismo202501Theme
import pe.edu.upeu.appturismo202501.ui.theme.LightRedColors

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NavigationHost(
    navController: NavHostController,
    darkMode: MutableState<Boolean>,
    innerPadding: PaddingValues,


) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Welcome.route,   // usa tu enum/objeto
        modifier = Modifier.padding(innerPadding)

    ) {

        // ---------- PANTALLAS PRINCIPALES ----------
        composable(Destinations.Welcome.route) {
            WelcomeScreen(navController)
        }

        composable(Destinations.Search.route) {
            SearchScreen(
                navController = navController,
                suggestions = listOf(
                    "Isla Taquile", "Isla Amantaní",
                    "Lago Titicaca", "Puno", "Cusco"
                )
            )
        }
        composable(Destinations.PerfilWelcome.route) {
            PerfilScreen(
                onNavigateToLogin = {
                    navController.navigate(Destinations.Login.route) {
                        popUpTo(Destinations.PerfilWelcome.route) { inclusive = true }
                    }
                }
            )
        }

        // ---------- AUTENTICACIÓN ----------
        composable(Destinations.Login.route) {
            LoginScreen(
                navigateToHome = {
                    navController.navigate(Destinations.Pantalla1.route) {
                        popUpTo(Destinations.Login.route) { inclusive = true }
                    }
                },
                onGoogleLoginClick = { /* TODO */ },
                onRegisterClick = {
                    navController.navigate(Destinations.Register.route)
                }
            )
        }

        composable(Destinations.Register.route) {
            RegisterScreen(
                onNavigateToLogin = { navController.popBackStack() }
            )
        }


    }
}





