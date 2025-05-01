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
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.EditEventoViewModel
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.EditServicioViewModel


@Composable
fun EditEventoScreen(
    navController: NavController,
    id: Int,
    viewModel: EditEventoViewModel = viewModel()
) {
    val context = LocalContext.current
    val evento by viewModel.evento.collectAsState()
    val success by viewModel.success.collectAsState()
    val error by viewModel.error.collectAsState()

    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var fechaInicio by remember { mutableStateOf("") }
    var fechaFin by remember { mutableStateOf("") }
    var lugar by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("activo") }
    var expanded by remember { mutableStateOf(false) }

    LaunchedEffect(id) {
        viewModel.fetchEvento(id)
        println("🔍 ID recibido en pantalla de edición: $id")
    }

    LaunchedEffect(evento) {
        evento?.let {
            println("📦 Evento cargado: ${evento?.titulo}")
            titulo = it.titulo
            descripcion = it.descripcion ?: ""
            fechaInicio = it.fecha_inicio
            fechaFin = it.fecha_fin
            lugar = it.lugar ?: ""
            estado = it.estado
        }
    }

    if (success) {
        Toast.makeText(context, "Evento actualizado correctamente", Toast.LENGTH_SHORT).show()
        navController.popBackStack()
    }

    error?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {
        Text("Editar Evento", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = titulo, onValueChange = { titulo = it }, label = { Text("Título") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = fechaInicio, onValueChange = { fechaInicio = it }, label = { Text("Fecha Inicio") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = fechaFin, onValueChange = { fechaFin = it }, label = { Text("Fecha Fin") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = lugar, onValueChange = { lugar = it }, label = { Text("Lugar") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))

        Box {
            OutlinedTextField(
                value = estado,
                onValueChange = {},
                readOnly = true,
                label = { Text("Estado") },
                trailingIcon = {
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                    }
                },
                modifier = Modifier.fillMaxWidth()
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
                viewModel.updateEvento(
                    id,
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
            Text("Actualizar")
        }
    }
}