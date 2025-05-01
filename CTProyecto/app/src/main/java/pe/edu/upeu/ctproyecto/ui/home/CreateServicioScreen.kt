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
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.CreateServicioViewModel

@Composable
fun CreateServicioScreen(
    navController: NavController,
    viewModel: CreateServicioViewModel = viewModel()
) {
    val context = LocalContext.current
    val success by viewModel.success.collectAsState()
    val error by viewModel.error.collectAsState()

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var ubicacion by remember { mutableStateOf("") }
    var fechaInicio by remember { mutableStateOf("") }
    var fechaFin by remember { mutableStateOf("") }

    var idEmprendimiento by remember { mutableStateOf("1") } // ← Cambia por ComboBox si deseas
    var estado by remember { mutableStateOf("activo") } // valor por defecto
    var expandedEstado by remember { mutableStateOf(false) }


    if (success) {
        Toast.makeText(context, "Servicio creado con éxito", Toast.LENGTH_SHORT).show()
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
        Text("Registrar Servicio", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = precio, onValueChange = { precio = it }, label = { Text("Precio") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = ubicacion, onValueChange = { ubicacion = it }, label = { Text("Ubicación") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = fechaInicio, onValueChange = { fechaInicio = it }, label = { Text("Fecha Inicio (yyyy-mm-dd)") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = fechaFin, onValueChange = { fechaFin = it }, label = { Text("Fecha Fin (yyyy-mm-dd)") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = idEmprendimiento, onValueChange = { idEmprendimiento = it }, label = { Text("ID Emprendimiento") }, modifier = Modifier.fillMaxWidth())


        Text("Estado:")
        Box {
            OutlinedTextField(
                value = estado,
                onValueChange = {},
                readOnly = true,
                label = { Text("Estado") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = { expandedEstado = !expandedEstado }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                    }
                }
            )

            DropdownMenu(
                expanded = expandedEstado,
                onDismissRequest = { expandedEstado = false }
            ) {
                DropdownMenuItem(
                    text = { Text("activo") },
                    onClick = {
                        estado = "activo"
                        expandedEstado = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("inactivo") },
                    onClick = {
                        estado = "inactivo"
                        expandedEstado = false
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

// 👇 luego el botón
        Button(onClick = {
            viewModel.createServicio(
                id_emprendimiento = idEmprendimiento.toIntOrNull() ?: 1,
                nombre_servicio = nombre,
                descripcion = descripcion,
                precio = precio.toDoubleOrNull() ?: 0.0,
                ubicacion = ubicacion,
                fecha_inicio = fechaInicio,
                fecha_fin = fechaFin,
                estado = estado // ✅ ya actualizado aquí
            )
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Guardar")
        }



    }
}