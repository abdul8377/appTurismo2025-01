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
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.ZonaTuristicaViewModel

@Composable
fun ListZonaTuristicaScreen(
    navController: NavController,
    viewModel: ZonaTuristicaViewModel = viewModel()
) {
    val context = LocalContext.current
    val zonas by viewModel.zonas.collectAsState()
    val error by viewModel.error.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var zonaIdToDelete by remember { mutableStateOf<Int?>(null) }

    LaunchedEffect(Unit) {
        viewModel.fetchZonas()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("createZona") }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Crear Zona")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(padding) // esto respeta el espacio del FAB
        ) {
            Text("Zonas Turísticas", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            if (error != null) {
                Text(text = error ?: "", color = MaterialTheme.colorScheme.error)
            }

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(zonas) { zona ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Nombre: ${zona.nombre}")
                            Text("Estado: ${zona.estado}")
                            Text("Ubicación: ${zona.ubicacion ?: "No especificada"}")

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Button(onClick = {
                                    println("🟢 CLIC EN EDITAR zona con id: ${zona.id}")
                                    zona.id?.let { id ->
                                        navController.navigate("editZona/$id")
                                    }
                                }) {
                                    Text("Editar")
                                }
                                Button(onClick = {
                                    zonaIdToDelete = zona.id
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
                text = { Text("¿Deseas eliminar esta zona turística?") },
                confirmButton = {
                    Button(onClick = {
                        zonaIdToDelete?.let { viewModel.deleteZona(it) }
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
