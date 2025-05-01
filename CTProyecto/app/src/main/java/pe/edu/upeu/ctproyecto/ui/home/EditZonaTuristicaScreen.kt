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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.EditZonaTuristicaViewModel

@Composable
fun EditZonaTuristicaScreen(
    navController: NavController,
    id: Int,
    viewModel: EditZonaTuristicaViewModel = viewModel()
) {
    val context = LocalContext.current
    val zona by viewModel.zona.collectAsState()
    val error by viewModel.error.collectAsState()
    val success by viewModel.success.collectAsState()

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var ubicacion by remember { mutableStateOf("") }
    var imagenUrl by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("activo") }
    var expanded by remember { mutableStateOf(false) }

    // Cargar datos de zona
    LaunchedEffect(id) {
        viewModel.fetchZona(id)
    }

    // Rellenar los campos cuando llega la data
    LaunchedEffect(zona) {
        zona?.let {
            nombre = it.nombre
            descripcion = it.descripcion ?: ""
            ubicacion = it.ubicacion ?: ""
            imagenUrl = it.imagen_url ?: ""
            estado = it.estado
        }
    }
    LaunchedEffect(Unit) {
        println("✅ Entrando a EditZonaTuristicaScreen con id = $id")
    }

    if (success) {
        Toast.makeText(context, "Zona actualizada exitosamente", Toast.LENGTH_SHORT).show()
        navController.popBackStack()
    }

    error?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Editar Zona Turística", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
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

        OutlinedTextField(
            value = ubicacion,
            onValueChange = { ubicacion = it },
            label = { Text("Ubicación") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = imagenUrl,
            onValueChange = { imagenUrl = it },
            label = { Text("URL de Imagen") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
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
                DropdownMenuItem(
                    text = { Text("activo") },
                    onClick = {
                        estado = "activo"
                        expanded = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("inactivo") },
                    onClick = {
                        estado = "inactivo"
                        expanded = false
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                viewModel.updateZona(
                    id = id,
                    nombre = nombre,
                    descripcion = descripcion,
                    ubicacion = ubicacion,
                    imagenUrl = imagenUrl,
                    estado = estado
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Actualizar Zona")
        }
    }
}