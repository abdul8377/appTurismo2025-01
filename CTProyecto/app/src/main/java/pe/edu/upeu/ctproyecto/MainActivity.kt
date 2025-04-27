package pe.edu.upeu.ctproyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import pe.edu.upeu.ctproyecto.navigation.AppNavigation
import pe.edu.upeu.ctproyecto.ui.theme.CTProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CTProyectoTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
