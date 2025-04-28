package pe.edu.upeu.ctproyecto.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.ListEmprendimientosViewModel

@Composable
fun ListEmprendimientosScreen(
    navController: NavController,
    viewModel: ListEmprendimientosViewModel = viewModel()
) {
    val context = LocalContext.current
    val emprendimientos by viewModel.emprendimientos.collectAsState()
    val error by viewModel.error.collectAsState()

    var showDialog by remember { mutableStateOf(false) }
    var selectedEmprendimientoId by remember { mutableStateOf<Int?>(null) }
    var selectedEmprendimientoName by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        viewModel.fetchEmprendimientos()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Lista de Emprendimientos", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        if (error != null) {
            Text(text = error ?: "", color = MaterialTheme.colorScheme.error)
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(emprendimientos) { emprendimiento ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Text("Nombre: ${emprendimiento.nombre}")
                        Text("Estado: ${emprendimiento.estado}")
                        Text("Dirección: ${emprendimiento.direccion ?: "Sin dirección"}")
                        Text("Teléfono: ${emprendimiento.telefono ?: "Sin teléfono"}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(onClick = {
                                emprendimiento.id?.let { id ->
                                    navController.navigate("editEmprendimiento/$id")
                                } ?: run {
                                    Toast.makeText(context, "Error: ID de emprendimiento inválido", Toast.LENGTH_SHORT).show()
                                }
                            }) {
                                Text("Editar")
                            }

                            Button(onClick = {
                                selectedEmprendimientoId = emprendimiento.id
                                selectedEmprendimientoName = emprendimiento.nombre
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
            text = { Text("¿Estás seguro de eliminar el emprendimiento '${selectedEmprendimientoName}'?") },
            confirmButton = {
                Button(onClick = {
                    selectedEmprendimientoId?.let {
                        viewModel.deleteEmprendimiento(it)
                    }
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