package pe.edu.upeu.ctproyecto.ui.home.usuarios.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.ui.home.navbar.BottomNavigationBar
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.TipoNegocioViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainAdminScreen(navController: NavController) {
    val context = LocalContext.current
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Panel de Control") }
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
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = { selectedTabIndex = 0 },
                    text = { Text("Usuarios") }
                )
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = { selectedTabIndex = 1 },
                    text = { Text("Emprendimientos") }
                )
                Tab(
                    selected = selectedTabIndex == 2,
                    onClick = { selectedTabIndex = 2 },
                    text = { Text("Productos ") }
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

                        // Aquí agregamos el botón para crear un nuevo tipo de negocio
                        item {
                            Button(
                                onClick = { navController.navigate("createTipoNegocio") }, // Navegar a la pantalla de creación de tipo de negocio
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Crear Nuevo Tipo de Negocio", fontSize = 18.sp)
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

                        item {
                            Button(
                                onClick = { navController.navigate("listUsuariosEmprendimiento") },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Listar User EMopre", fontSize = 18.sp)
                            }
                        }

                        item {
                            Button(
                                onClick = { navController.navigate("AsignarUsuarioaEmprendimiento") },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("crear User EMopre", fontSize = 18.sp)
                            }
                        }
                    }
                }
                2 -> {
                    // Contenido de "Productos" - Agregar botones para categorías
                    Text(
                        text = "Productos y Categorías",
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
                                onClick = { navController.navigate("listCategorias") }, // Navegar a la lista de categorías
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Listar Categorías", fontSize = 18.sp)
                            }
                        }

                        item {
                            Button(
                                onClick = { navController.navigate("createCategoria") }, // Navegar a la pantalla de creación de categorías
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Crear Nueva Categoría", fontSize = 18.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}
