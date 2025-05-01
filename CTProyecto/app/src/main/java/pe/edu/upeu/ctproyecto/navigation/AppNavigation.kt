package pe.edu.upeu.ctproyecto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pe.edu.upeu.ctproyecto.ui.home.CreateEmprendimientoScreen
import pe.edu.upeu.ctproyecto.ui.home.usuarios.screem.CreateUserScreen
import pe.edu.upeu.ctproyecto.ui.home.EditEmprendimientoScreen
import pe.edu.upeu.ctproyecto.ui.home.usuarios.screem.EditUserScreen
import pe.edu.upeu.ctproyecto.ui.welcome.WelcomeScreen
import pe.edu.upeu.ctproyecto.ui.login.LoginScreen
import pe.edu.upeu.ctproyecto.ui.register.RegisterScreen
import pe.edu.upeu.ctproyecto.ui.home.HomeScreen
import pe.edu.upeu.ctproyecto.ui.home.ListEmprendimientosScreen
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.TipoNegocioViewModel
import pe.edu.upeu.ctproyecto.ui.home.usuarios.main.MainAdminScreen
import pe.edu.upeu.ctproyecto.ui.home.usuarios.screem.ListUsersScreen
import pe.edu.upeu.ctproyecto.ui.home.usuarios.screem.UpdateStatusScreen
import pe.edu.upeu.ctproyecto.ui.splash.SplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import pe.edu.upeu.ctproyecto.ui.home.CreateCategoriaScreen
import pe.edu.upeu.ctproyecto.ui.home.CreateEventoScreen
import pe.edu.upeu.ctproyecto.ui.home.CreateServicioScreen
import pe.edu.upeu.ctproyecto.ui.home.CreateTipoNegocioScreen
import pe.edu.upeu.ctproyecto.ui.home.CreateZonaTuristicaScreen
import pe.edu.upeu.ctproyecto.ui.home.EditCategoriaScreen
import pe.edu.upeu.ctproyecto.ui.home.EditEventoScreen
import pe.edu.upeu.ctproyecto.ui.home.EditServicioScreen
import pe.edu.upeu.ctproyecto.ui.home.EditTipoNegocioScreen
import pe.edu.upeu.ctproyecto.ui.home.EditZonaTuristicaScreen
import pe.edu.upeu.ctproyecto.ui.home.ListCategoriasScreen
import pe.edu.upeu.ctproyecto.ui.home.ListEventosScreen
import pe.edu.upeu.ctproyecto.ui.home.ListServiciosScreen
import pe.edu.upeu.ctproyecto.ui.home.ListZonaTuristicaScreen
import pe.edu.upeu.ctproyecto.ui.home.TipoNegocioScreen


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

        composable("mainusers") {
            MainAdminScreen(navController)
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

        // Editar emprendimiento
        composable("editEmprendimiento/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()

            if (id != null) {
                EditEmprendimientoScreen(navController, id)
            } else {
                // Manejar error si el ID es inválido o nulo
            }
        }

        //Tipo de Negocios

        // Ruta para la lista de tipos de negocio
        composable("tiposNegociosList") {
            // Usamos el ViewModel de TipoNegocio con ViewModelProvider para garantizar la persistencia
            val tipoNegocioViewModel: TipoNegocioViewModel = viewModel() // Obtiene el ViewModel
            TipoNegocioScreen(viewModel = tipoNegocioViewModel, navController = navController)
        }


        composable("createTipoNegocio") {
            // Pantalla para crear un nuevo tipo de negocio
            CreateTipoNegocioScreen(navController = navController)
        }


        // Editar Tipo de Negocio

        composable("editTipoNegocio/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            if (id != null) {
                EditTipoNegocioScreen(navController = navController, id = id)
            } else {
                // Manejar error si el ID es inválido o nulo
            }
        }

        composable("listCategorias") {
            ListCategoriasScreen(navController)
        }

        composable("createCategoria") {
            CreateCategoriaScreen(navController)
        }

        composable("editCategoria/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()

            if (id != null) {
                EditCategoriaScreen(navController = navController, id = id)
            } else {
                // Manejar error si el ID es inválido o nulo
            }
        }
        //zonas
        composable("listZonas") {
            ListZonaTuristicaScreen(navController)
        }
        composable("editZona/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            id?.let {
                EditZonaTuristicaScreen(navController, id = it)
            }
        }
        composable("createZona") {
            CreateZonaTuristicaScreen(navController)
        }


        //servicios

        composable("listServicios") {
            ListServiciosScreen(navController)
        }

        composable("createServicio") {
            CreateServicioScreen(navController)
        }

        composable("editServicio/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            if (id != null) {
                EditServicioScreen(navController = navController, id = id)
            }
        }
        composable("listEventos") {
            ListEventosScreen(navController) }

        composable("createEvento") {
            CreateEventoScreen(navController) }

        composable("editEvento/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            if (id != null) {
                EditEventoScreen(navController = navController, id = id)
            }
        }
    }
}
