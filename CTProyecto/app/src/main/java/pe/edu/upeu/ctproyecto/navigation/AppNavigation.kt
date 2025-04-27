package pe.edu.upeu.ctproyecto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pe.edu.upeu.ctproyecto.ui.welcome.WelcomeScreen
import pe.edu.upeu.ctproyecto.ui.login.LoginScreen
import pe.edu.upeu.ctproyecto.ui.register.RegisterScreen
import pe.edu.upeu.ctproyecto.ui.home.HomeScreen
import pe.edu.upeu.ctproyecto.ui.splash.SplashScreen // Importa el SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash" // <-- Ahora arrancamos en Splash
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("register") {
            RegisterScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
    }
}
