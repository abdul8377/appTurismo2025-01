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
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.EditTipoNegocioViewModel

@Composable
fun EditTipoNegocioScreen(
    navController: NavController,
    id: Int,
    viewModel: EditTipoNegocioViewModel = viewModel()
) {
    val context = LocalContext.current
    val tipoNegocio by viewModel.tipoNegocio.collectAsState()
    val error by viewModel.error.collectAsState()
    val success by viewModel.success.collectAsState()

    var nombre by remember { mutableStateOf("") }

    // Cargar los datos del tipo de negocio
    LaunchedEffect(id) {
        viewModel.fetchTipoNegocio(id)
    }

    LaunchedEffect(tipoNegocio) {
        tipoNegocio?.let {
            nombre = it.nombre
        }
    }

    if (success) {
        Toast.makeText(context, "Tipo de negocio actualizado exitosamente", Toast.LENGTH_SHORT).show()
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
        Text("Editar Tipo de Negocio", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))

        if (tipoNegocio == null) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    if (nombre.isNotBlank()) {
                        viewModel.updateTipoNegocio(id, nombre)
                    } else {
                        Toast.makeText(context, "Por favor ingresa un nombre", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Actualizar")
            }

            Spacer(modifier = Modifier.height(20.dp))


        }
    }
}
