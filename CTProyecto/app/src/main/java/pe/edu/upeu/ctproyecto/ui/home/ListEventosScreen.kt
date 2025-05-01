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
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.EventoViewModel

@Composable
fun ListEventosScreen(
    navController: NavController,
    viewModel: EventoViewModel = viewModel()
) {
    val eventos by viewModel.eventos.collectAsState()
    val error by viewModel.error.collectAsState()
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var eventoIdToDelete by remember { mutableStateOf<Int?>(null) }

    LaunchedEffect(Unit) {
        viewModel.fetchEventos()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("createEvento") }) {
                Icon(Icons.Default.Add, contentDescription = "Nuevo Evento")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Lista de Eventos", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            if (error != null) {
                Text(text = error ?: "", color = MaterialTheme.colorScheme.error)
            }

            LazyColumn {
                items(eventos) { evento ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Título: ${evento.titulo}")
                            Text("Estado: ${evento.estado}")
                            Text("Lugar: ${evento.lugar ?: "No especificado"}")

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                Button(onClick = {
                                    println("🟢 CLIC en Editar evento con ID: ${evento.id}")
                                    evento.id?.let { id ->
                                        navController.navigate("editEvento/$id")
                                    }
                                }) {
                                    Text("Editar")
                                }
                                Button(onClick = {
                                    eventoIdToDelete = evento.id
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
                text = { Text("¿Deseas eliminar este evento?") },
                confirmButton = {
                    Button(onClick = {
                        eventoIdToDelete?.let { viewModel.deleteEvento(it) }
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