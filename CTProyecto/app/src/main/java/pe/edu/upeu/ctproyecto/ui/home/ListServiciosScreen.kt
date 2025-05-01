package pe.edu.upeu.ctproyecto.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.ServicioViewModel

@Composable
fun ListServiciosScreen(
    navController: NavController,
    viewModel: ServicioViewModel = viewModel()
) {
    val context = LocalContext.current
    val servicios by viewModel.servicios.collectAsState()
    val error by viewModel.error.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var idEliminar by remember { mutableStateOf<Int?>(null) }

    LaunchedEffect(Unit) {
        viewModel.fetchServicios()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("createServicio") }) {
                Icon(Icons.Default.Add, contentDescription = "Nuevo Servicio")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(padding)
        ) {
            Text("Servicios", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            if (error != null) {
                Text(text = error ?: "", color = MaterialTheme.colorScheme.error)
            }

            LazyColumn {
                items(servicios) { servicio ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Nombre: ${servicio.nombre_servicio}")
                            Text("Precio: S/. ${servicio.precio}")
                            Text("Estado: ${servicio.estado}")
                            Text("Ubicación: ${servicio.ubicacion ?: "No especificada"}")

                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Button(onClick = {
                                    servicio.id?.let { id ->
                                        navController.navigate("editServicio/$id")
                                    }
                                }) {
                                    Text("Editar")
                                    println("🟢 Editar servicio con ID: ${servicio.id}")
                                }

                                Button(onClick = {
                                    idEliminar = servicio.id
                                    showDialog = true
                                }) {
                                    Text("Eliminar")
                                }
                            }
                        }
                    }
                }
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Confirmar eliminación") },
                text = { Text("¿Estás seguro de eliminar este servicio?") },
                confirmButton = {
                    Button(onClick = {
                        idEliminar?.let { viewModel.deleteServicio(it) }
                        showDialog = false
                    }) {
                        Text("Eliminar")
                    }
                },
                dismissButton = {
                    OutlinedButton(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}