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
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.ListCategoriasViewModel

@Composable
fun ListCategoriasScreen(
    navController: NavController,
    viewModel: ListCategoriasViewModel = viewModel()
) {
    val context = LocalContext.current
    val categorias by viewModel.categorias.collectAsState()
    val error by viewModel.error.collectAsState()

    var showDialog by remember { mutableStateOf(false) }
    var selectedCategoriaId by remember { mutableStateOf<Int?>(null) }
    var selectedCategoriaName by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        viewModel.fetchCategorias()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Lista de Categorías", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        if (error != null) {
            Text(text = error ?: "", color = MaterialTheme.colorScheme.error)
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(categorias) { categoria ->
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
                        Text("Nombre: ${categoria.nombre_categoria}")
                        Text("Estado: ${categoria.descripcion}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(onClick = {
                                categoria.id?.let { id ->
                                    navController.navigate("editCategoria/$id")
                                } ?: run {
                                    Toast.makeText(context, "Error: ID de categoría inválido", Toast.LENGTH_SHORT).show()
                                }
                            }) {
                                Text("Editar")
                            }

                            Button(onClick = {
                                selectedCategoriaId = categoria.id
                                selectedCategoriaName = categoria.nombre_categoria
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
            text = { Text("¿Estás seguro de eliminar la categoría '${selectedCategoriaName}'?") },
            confirmButton = {
                Button(onClick = {
                    selectedCategoriaId?.let {
                        viewModel.deleteCategoria(it)
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
