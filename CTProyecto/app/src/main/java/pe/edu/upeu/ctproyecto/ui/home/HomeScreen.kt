package pe.edu.upeu.ctproyecto.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.local.DataStoreManager

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val dataStoreManager = remember { DataStoreManager(context) }

    // Variables para almacenar nombre y rol
    var userName by remember { mutableStateOf<String?>(null) }
    var userRole by remember { mutableStateOf<String?>(null) }

    // Cargar datos de DataStore
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            dataStoreManager.getName().collectLatest { name ->
                userName = name
            }
        }
        coroutineScope.launch {
            dataStoreManager.getRole().collectLatest { role ->
                userRole = role
            }
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
            text = "¡Bienvenido ${userName ?: "Invitado"}!",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Rol: ${userRole ?: "Desconocido"}",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                    dataStoreManager.clearUserData()
                    Toast.makeText(context, "Sesión cerrada", Toast.LENGTH_SHORT).show()
                    navController.navigate("welcome") {
                        popUpTo(0) { inclusive = true }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text("Cerrar Sesión", fontSize = 18.sp)
        }



        Button(
            onClick = { navController.navigate("listUsers") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Listar Usuarios", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { navController.navigate("updateStatus") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Actualizar Estado de Usuario", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { navController.navigate("createUser") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Crear Usuario")
        }

        Button(
            onClick = { navController.navigate("listEmprendimientos") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Listar Emprendimientos")
        }

        Button(
            onClick = { navController.navigate("createEmprendimiento") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear Nuevo Emprendimiento")
        }
    }
}
