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
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.EditServicioViewModel

@Composable
fun EditServicioScreen(
    navController: NavController,
    id: Int,
    viewModel: EditServicioViewModel = viewModel()
) {
    val context = LocalContext.current
    val servicio by viewModel.servicio.collectAsState()
    val success by viewModel.success.collectAsState()
    val error by viewModel.error.collectAsState()

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var ubicacion by remember { mutableStateOf("") }
    var fechaInicio by remember { mutableStateOf("") }
    var fechaFin by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("activo") }

    LaunchedEffect(id) {
        viewModel.fetchServicio(id)
    }

    LaunchedEffect(servicio) {
        servicio?.let {
            nombre = it.nombre_servicio
            descripcion = it.descripcion ?: ""
            precio = it.precio.toString()
            ubicacion = it.ubicacion ?: ""
            fechaInicio = it.fecha_inicio ?: ""
            fechaFin = it.fecha_fin ?: ""
            estado = it.estado
        }
    }

    if (success) {
        Toast.makeText(context, "Servicio actualizado", Toast.LENGTH_SHORT).show()
        navController.popBackStack()
    }

    error?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Editar Servicio", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = precio, onValueChange = { precio = it }, label = { Text("Precio") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = ubicacion, onValueChange = { ubicacion = it }, label = { Text("Ubicación") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = fechaInicio, onValueChange = { fechaInicio = it }, label = { Text("Fecha Inicio") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = fechaFin, onValueChange = { fechaFin = it }, label = { Text("Fecha Fin") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.updateServicio(
                id = id,
                nombre_servicio = nombre,
                descripcion = descripcion,
                precio = precio.toDoubleOrNull() ?: 0.0,
                ubicacion = ubicacion,
                fecha_inicio = fechaInicio,
                fecha_fin = fechaFin,
                estado = estado
            )
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Actualizar")
        }
    }
}