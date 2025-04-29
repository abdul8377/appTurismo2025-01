package pe.edu.upeu.ctproyecto.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
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
import pe.edu.upeu.ctproyecto.ui.home.navbar.BottomNavigationBar

@Composable
@OptIn(ExperimentalMaterial3Api::class)
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
            dataStoreManager.getName().collectLatest { name -> userName = name }
        }
        coroutineScope.launch {
            dataStoreManager.getRole().collectLatest { role -> userRole = role }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bienvenido") },
                actions = {
                    // Botón de perfil
                    IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(Icons.Filled.AccountCircle, contentDescription = "Perfil")
                    }
                    // Botón de cerrar sesión
                    IconButton(onClick = {
                        coroutineScope.launch {
                            dataStoreManager.clearUserData()
                            Toast.makeText(context, "Sesión cerrada", Toast.LENGTH_SHORT).show()
                            navController.navigate("welcome") {
                                popUpTo(0) { inclusive = true }
                            }
                        }
                    }) {
                        Icon(Icons.Filled.ExitToApp, contentDescription = "Cerrar sesión")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Bienvenida al usuario
            Text(
                text = "¡Bienvenido ${userName ?: "Invitado"}!",
                fontSize = 28.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Muestra el rol del usuario
            Text(
                text = "Rol: ${userRole ?: "Desconocido"}",
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Si el rol del usuario es "admin", mostrar opciones de administración
            if (userRole == "Administrador") {
                Text(
                    text = "Panel de Administrador",
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.titleMedium
                )

                // Opciones del administrador
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { navController.navigate("listUsers") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
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
                    Text("Crear Usuario", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Emprendimientos",
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.titleMedium
                )

                // Opciones de emprendimientos
                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { navController.navigate("listEmprendimientos") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Listar Emprendimientos", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { navController.navigate("createEmprendimiento") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Crear Nuevo Emprendimiento", fontSize = 18.sp)
                }
            } else {
                // Si no es admin, mostrar un mensaje simple
                Text(
                    text = "¡Disfruta de la aplicación!",
                    fontSize = 20.sp
                )
            }
        }
    }
}
