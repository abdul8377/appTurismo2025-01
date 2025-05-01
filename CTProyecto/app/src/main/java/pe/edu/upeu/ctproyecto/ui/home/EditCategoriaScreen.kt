package pe.edu.upeu.ctproyecto.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.EditCategoriaViewModel

@Composable
fun EditCategoriaScreen(
    navController: NavController,
    id: Int,
    viewModel: EditCategoriaViewModel = viewModel()
) {
    val context = LocalContext.current
    val categoria by viewModel.categoria.collectAsState()
    val error by viewModel.error.collectAsState()
    val success by viewModel.success.collectAsState()

    var nombreCategoria by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }


    LaunchedEffect(id) {
        viewModel.fetchCategoria(id)
    }

    LaunchedEffect(categoria) {
        categoria?.let {
            nombreCategoria = it.nombre_categoria
            descripcion = it.descripcion ?: ""

        }
    }

    if (success) {
        Toast.makeText(context, "Categoría actualizada exitosamente", Toast.LENGTH_SHORT).show()
        navController.popBackStack()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        when {
            error != null -> {
                Text(text = error ?: "Error desconocido", color = MaterialTheme.colorScheme.error)
            }
            categoria == null -> {
                CircularProgressIndicator()
            }
            else -> {
                // FORMULARIO de Edición
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text("Editar Categoría", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = nombreCategoria,
                        onValueChange = { nombreCategoria = it },
                        label = { Text("Nombre Categoría") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = descripcion,
                        onValueChange = { descripcion = it },
                        label = { Text("Descripción") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))



                    Button(
                        onClick = {
                            viewModel.updateCategoria(
                                id = id,
                                nombreCategoria = nombreCategoria,
                                descripcion = descripcion,
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Actualizar Categoría")
                    }
                }
            }
        }
    }
}
