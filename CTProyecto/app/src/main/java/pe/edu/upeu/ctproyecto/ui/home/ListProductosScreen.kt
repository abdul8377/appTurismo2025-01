package pe.edu.upeu.ctproyecto.ui.productos

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
import pe.edu.upeu.ctproyecto.ui.productos.viewmodel.ListProductosViewModel

@Composable
fun ListProductosScreen(
    navController: NavController,
    viewModel: ListProductosViewModel = viewModel()
) {
    val context = LocalContext.current
    val productos by viewModel.productos.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchProductos()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Lista de Productos", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        if (error != null) {
            Text(text = error ?: "", color = MaterialTheme.colorScheme.error)
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(productos) { producto ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), elevation = CardDefaults.cardElevation()) {
                    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                        Text("Nombre: ${producto.nombre_producto}")
                        Text("Estado: ${producto.estado}")
                        Text("Precio: ${producto.precio}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Button(onClick = { navController.navigate("editProducto/${producto.id}") }) {
                                Text("Editar")
                            }

                            Button(onClick = { navController.navigate("deleteProducto/${producto.id}") }) {
                                Text("Eliminar")
                            }
                        }
                    }
                }
            }
        }
    }
}
