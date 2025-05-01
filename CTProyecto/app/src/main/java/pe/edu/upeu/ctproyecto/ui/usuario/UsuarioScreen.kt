package pe.edu.upeu.ctproyecto.ui.usuario

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.local.DataStoreManager

@Composable
fun UsuarioScreen(navController: NavController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    // Obtener el nombre del usuario desde DataStore
    val dataStoreManager = DataStoreManager(context)
    var userName by remember { mutableStateOf("") }
    LaunchedEffect(true) {
        dataStoreManager.getName().collect { name ->
            userName = name ?: "Usuario"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenido, $userName!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                // Realizar el logout
                coroutineScope.launch {
                    dataStoreManager.clearUserData()
                    navController.navigate("login") {
                        popUpTo(0) { inclusive = true }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text("Cerrar sesión", fontSize = 18.sp)
        }
    }
}
