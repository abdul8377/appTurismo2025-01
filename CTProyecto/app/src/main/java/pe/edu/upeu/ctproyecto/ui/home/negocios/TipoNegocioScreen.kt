package pe.edu.upeu.ctproyecto.ui.home.negocios

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.TipoNegocioViewModel
import pe.edu.upeu.ctproyecto.data.model.TipoNegocio

@Composable
fun TipoNegocioScreen(
    navController: NavController,
    viewModel: TipoNegocioViewModel = viewModel() // Inyectamos el ViewModel
) {
    val context = LocalContext.current

    // Especificando el tipo explícitamente para cada variable
    val tiposNegocio: List<TipoNegocio> by viewModel.tiposNegocio.collectAsState(initial = emptyList()) // Especificamos el tipo
    val error: String? by viewModel.error.collectAsState(initial = null) // Especificamos el tipo

    var showDialog by remember { mutableStateOf(false) }
    var selectedTipoNegocioId by remember { mutableStateOf<Int?>(null) }
    var selectedTipoNegocioName by remember { mutableStateOf<String?>(null) }

    // Cargar tipos de negocio cuando la pantalla es construida
    LaunchedEffect(Unit) {
        viewModel.fetchTiposNegocio()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Lista de Tipos de Negocio", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar error si existe
        error?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }

        // Mostrar lista de tipos de negocio
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(tiposNegocio) { tipoNegocio ->
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
                        Text("Nombre: ${tipoNegocio.nombre}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(onClick = {
                                tipoNegocio.id_tipo_negocio?.let { id -> // Cambiar a id_tipo_negocio
                                    navController.navigate("editTipoNegocio/$id")
                                } ?: run {
                                    Toast.makeText(context, "Error: ID de tipo de negocio inválido", Toast.LENGTH_SHORT).show()
                                }
                            }) {
                                Text("Editar")
                            }

                            Button(onClick = {
                                selectedTipoNegocioId = tipoNegocio.id_tipo_negocio // Cambiar a id_tipo_negocio
                                selectedTipoNegocioName = tipoNegocio.nombre
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

    // Diálogo de confirmación para eliminar
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Confirmar eliminación") },
            text = { Text("¿Estás seguro de eliminar el tipo de negocio '${selectedTipoNegocioName}'?") },
            confirmButton = {
                Button(onClick = {
                    selectedTipoNegocioId?.let {
                        viewModel.deleteTipoNegocio(it)
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
