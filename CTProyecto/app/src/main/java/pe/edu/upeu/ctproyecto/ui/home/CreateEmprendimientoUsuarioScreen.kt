package pe.edu.upeu.ctproyecto.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.CreateEmprendimientoUsuarioViewModel

@Composable
fun CreateEmprendimientoUsuarioScreen(
    navController: NavController,
    viewModel: CreateEmprendimientoUsuarioViewModel = viewModel()
) {
    val context = LocalContext.current
    val success by viewModel.success.collectAsState()
    val error by viewModel.error.collectAsState()

    var idEmprendimiento by remember { mutableStateOf(0) }
    var idUsuario by remember { mutableStateOf(0) }
    var rolEmprendimiento by remember { mutableStateOf("") }

    if (success) {
        Toast.makeText(context, "Usuario asignado exitosamente", Toast.LENGTH_SHORT).show()
        navController.popBackStack() // Vuelve a la pantalla anterior
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
        Text("Asignar Usuario a Emprendimiento", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = idEmprendimiento.toString(),
            onValueChange = { idEmprendimiento = it.toIntOrNull() ?: 0 },
            label = { Text("ID del Emprendimiento") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = idUsuario.toString(),
            onValueChange = { idUsuario = it.toIntOrNull() ?: 0 },
            label = { Text("ID del Usuario") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = rolEmprendimiento,
            onValueChange = { rolEmprendimiento = it },
            label = { Text("Rol en el Emprendimiento") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                viewModel.createEmprendimientoUsuario(
                    idEmprendimiento,
                    idUsuario,
                    rolEmprendimiento
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Asignar Usuario")
        }
    }
}
