package pe.edu.upeu.ctproyecto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pe.edu.upeu.ctproyecto.ui.home.CreateEmprendimientoScreen
import pe.edu.upeu.ctproyecto.ui.home.CreateUserScreen
import pe.edu.upeu.ctproyecto.ui.home.EditEmprendimientoScreen
import pe.edu.upeu.ctproyecto.ui.home.EditUserScreen
import pe.edu.upeu.ctproyecto.ui.welcome.WelcomeScreen
import pe.edu.upeu.ctproyecto.ui.login.LoginScreen
import pe.edu.upeu.ctproyecto.ui.register.RegisterScreen
import pe.edu.upeu.ctproyecto.ui.home.HomeScreen
import pe.edu.upeu.ctproyecto.ui.home.ListEmprendimientosScreen
import pe.edu.upeu.ctproyecto.ui.home.ListUsersScreen
import pe.edu.upeu.ctproyecto.ui.home.UpdateStatusScreen
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



        composable("listUsers") {
            ListUsersScreen(navController)
        }

        composable(
            "editUser/{userId}"
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toIntOrNull()
            if (userId != null) {
                EditUserScreen(navController, userId)
            }
        }

        composable("updateStatus") {
            UpdateStatusScreen(navController)
        }

        //crear usuario
        composable("createUser") {
            CreateUserScreen(navController)
        }


        //navegacion emprendimientos

        composable("listEmprendimientos") {
            ListEmprendimientosScreen(navController)
        }

        composable("createEmprendimiento") {
            CreateEmprendimientoScreen(navController)
        }

// O para editar podría ser dinámico:
        composable("editEmprendimiento/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            if (id != null) {
                // EditEmprendimientoScreen(navController, id)
            }
        }

        composable("editEmprendimiento/{id}") { backStackEntry ->
            val idParam = backStackEntry.arguments?.getString("id")
            val id = idParam?.toIntOrNull()

            if (id != null && id > 0) {
                EditEmprendimientoScreen(navController, id)
            } else {
                // Puedes navegar a una pantalla de error o simplemente no hacer nada
            }
        }


    }
}
