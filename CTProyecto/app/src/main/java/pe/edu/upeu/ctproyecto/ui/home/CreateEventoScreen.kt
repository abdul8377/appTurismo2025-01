package pe.edu.upeu.ctproyecto.ui.home


import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.data.model.EventoRequest
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.CreateEventoViewModel
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.CreateServicioViewModel


@Composable
fun CreateEventoScreen(
    navController: NavController,
    viewModel: CreateEventoViewModel = viewModel()
) {
    val context = LocalContext.current
    val success by viewModel.success.collectAsState()
    val error by viewModel.error.collectAsState()

    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var fechaInicio by remember { mutableStateOf("") }
    var fechaFin by remember { mutableStateOf("") }
    var lugar by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("activo") }
    var expanded by remember { mutableStateOf(false) }

    if (success) {
        Toast.makeText(context, "Evento creado con éxito", Toast.LENGTH_SHORT).show()
        navController.popBackStack()
    }

    error?.let {
        Toast.makeText(context, it, Toast.LENGTH_LONG).show()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
    ) {
        Text("Registrar Evento", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = titulo, onValueChange = { titulo = it }, label = { Text("Título") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = fechaInicio, onValueChange = { fechaInicio = it }, label = { Text("Fecha Inicio (yyyy-mm-dd)") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = fechaFin, onValueChange = { fechaFin = it }, label = { Text("Fecha Fin (yyyy-mm-dd)") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = lugar, onValueChange = { lugar = it }, label = { Text("Lugar") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))

        Box {
            OutlinedTextField(
                value = estado,
                onValueChange = {},
                readOnly = true,
                label = { Text("Estado") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                    }
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listOf("activo", "inactivo", "cancelado").forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            estado = option
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.createEvento(
                    EventoRequest(
                        titulo = titulo,
                        descripcion = descripcion,
                        fecha_inicio = fechaInicio,
                        fecha_fin = fechaFin,
                        lugar = lugar,
                        estado = estado
                    )
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar")
        }
    }
}