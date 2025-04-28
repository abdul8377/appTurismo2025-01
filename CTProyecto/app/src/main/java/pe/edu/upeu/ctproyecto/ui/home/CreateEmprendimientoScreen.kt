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
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.CreateEmprendimientoViewModel

@Composable
fun CreateEmprendimientoScreen(
    navController: NavController,
    viewModel: CreateEmprendimientoViewModel = viewModel()
) {
    val context = LocalContext.current
    val success by viewModel.success.collectAsState()
    val error by viewModel.error.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val tiposNegocio by viewModel.tiposNegocio.collectAsState()

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("activo") }
    var selectedTipoNegocio by remember { mutableStateOf<Pair<Int, String>?>(null) }
    var expandedTipoNegocio by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.fetchTiposNegocio()
    }

    if (success) {
        Toast.makeText(context, "Emprendimiento creado exitosamente", Toast.LENGTH_SHORT).show()
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
        Text("Crear Emprendimiento", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
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

            // ComboBox para Tipo de Negocio
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = selectedTipoNegocio?.second ?: "",
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Tipo de Negocio") },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        IconButton(onClick = { expandedTipoNegocio = !expandedTipoNegocio }) {
                            Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                        }
                    }
                )

                DropdownMenu(
                    expanded = expandedTipoNegocio,
                    onDismissRequest = { expandedTipoNegocio = false }
                ) {
                    tiposNegocio.forEach { tipo ->
                        DropdownMenuItem(
                            text = { Text(tipo.second) },
                            onClick = {
                                selectedTipoNegocio = tipo
                                expandedTipoNegocio = false
                            }
                        )
                    }
                }
            }

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

            // Estado Switch
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Activo")
                Switch(
                    checked = estado == "activo",
                    onCheckedChange = { isChecked ->
                        estado = if (isChecked) "activo" else "inactivo"
                    }
                )
                Text("Inactivo")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    if (selectedTipoNegocio != null) {
                        viewModel.createEmprendimiento(
                            nombre,
                            descripcion,
                            selectedTipoNegocio!!.first,
                            direccion,
                            telefono,
                            estado
                        )
                    } else {
                        Toast.makeText(context, "Selecciona un tipo de negocio", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Crear Emprendimiento")
            }

        }
    }
}