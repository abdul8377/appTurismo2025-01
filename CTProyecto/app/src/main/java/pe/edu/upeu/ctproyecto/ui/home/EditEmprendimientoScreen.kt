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
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.EditEmprendimientoViewModel

@Composable

fun EditEmprendimientoScreen(
    navController: NavController,
    id: Int,
    viewModel: EditEmprendimientoViewModel = viewModel()
) {
    val context = LocalContext.current
    val emprendimiento by viewModel.emprendimiento.collectAsState()
    val error by viewModel.error.collectAsState()
    val success by viewModel.success.collectAsState()

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("activo") }
    var idTipoNegocio by remember { mutableStateOf(1) }

    var expandedEstado by remember { mutableStateOf(false) }

    LaunchedEffect(id) {
        viewModel.fetchEmprendimiento(id)
    }

    LaunchedEffect(emprendimiento) {
        emprendimiento?.let {
            nombre = it.nombre
            descripcion = it.descripcion ?: ""
            direccion = it.direccion ?: ""
            telefono = it.telefono ?: ""
            estado = it.estado
            idTipoNegocio = it.id_tipo_negocio
        }
    }

    if (success) {
        Toast.makeText(context, "Emprendimiento actualizado exitosamente", Toast.LENGTH_SHORT).show()
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
            emprendimiento == null -> {
                CircularProgressIndicator()
            }
            else -> {
                // FORMULARIO de Edición
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text("Editar Emprendimiento", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.height(20.dp))

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
                        value = direccion,
                        onValueChange = { direccion = it },
                        label = { Text("Dirección") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = telefono,
                        onValueChange = { telefono = it },
                        label = { Text("Teléfono") },
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

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            viewModel.updateEmprendimiento(
                                id = id,
                                nombre = nombre,
                                descripcion = descripcion,
                                idTipoNegocio = idTipoNegocio,
                                direccion = direccion,
                                telefono = telefono,
                                estado = estado
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Actualizar")
                    }
                }
            }
        }
    }
}
