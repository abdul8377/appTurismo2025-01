package pe.edu.upeu.ctproyecto.ui.home.usuarios.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun MainAdminScreen(navController: NavController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val dataStoreManager = remember { DataStoreManager(context) }

    // Variables para almacenar el nombre y el rol del usuario
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

    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Panel de Control") },
                actions = {
                    // Agregar íconos aquí si lo deseas
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController) // Barra de navegación en la parte inferior
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Barra de pestañas
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.fillMaxWidth(),
                divider = { Divider(thickness = 1.dp) }
            ) {
                // Pestaña "Usuarios"
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = { selectedTabIndex = 0 },
                    text = { Text("Usuarios") }
                )
                // Pestaña "Emprendimientos"
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = { selectedTabIndex = 1 },
                    text = { Text("Emprendimientos") }
                )
                // Pestaña "Configuraciones" (vacía por ahora)
                Tab(
                    selected = selectedTabIndex == 2,
                    onClick = { selectedTabIndex = 2 },
                    text = { Text("Configuraciones") }
                )
            }

            // Contenido de acuerdo con la pestaña seleccionada
            when (selectedTabIndex) {
                0 -> {
                    // Contenido de "Usuarios"
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        item {
                            Button(
                                onClick = { navController.navigate("listUsers") },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Listar Usuarios", fontSize = 18.sp)
                            }
                        }

                        item {
                            Button(
                                onClick = { navController.navigate("updateStatus") },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Actualizar Estado de Usuario", fontSize = 18.sp)
                            }
                        }

                        item {
                            Button(
                                onClick = { navController.navigate("createUser") },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Crear Usuario", fontSize = 18.sp)
                            }
                        }

                        // Si el usuario es admin, mostrar el botón de editar usuario
                        if (userRole == "admin") {
                            item {
                                Button(
                                    onClick = {
                                        // Aquí deberías pasar un userId dinámicamente desde una lista de usuarios
                                        val userId = 1 // Este valor debe ser dinámico
                                        navController.navigate("editUser/$userId") // RUTA PARA EDITAR USUARIO
                                    },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Editar Usuario", fontSize = 18.sp)
                                }
                            }
                        }
                    }
                }
                1 -> {
                    // Contenido de "Emprendimientos"
                    Text(
                        text = "Emprendimientos",
                        fontSize = 24.sp,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        item {
                            Button(
                                onClick = { navController.navigate("listEmprendimientos") },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Listar Emprendimientos", fontSize = 18.sp)
                            }
                        }

                        item {
                            Button(
                                onClick = { navController.navigate("createEmprendimiento") },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Crear Nuevo Emprendimiento", fontSize = 18.sp)
                            }
                        }



                        item {
                            Button(
                                onClick = { navController.navigate("tiposNegociosList") },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Listar Tipo de Negocio", fontSize = 18.sp)
                            }
                        }
                    }
                }
                2 -> {
                    // Contenido de "Configuraciones" (vacío por ahora)
                    Text(
                        text = "Configuraciones (vacío)",
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}
