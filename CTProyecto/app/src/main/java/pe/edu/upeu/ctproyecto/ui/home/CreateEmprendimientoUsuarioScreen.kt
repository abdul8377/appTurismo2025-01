package pe.edu.upeu.ctproyecto.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.data.model.Emprendimiento
import pe.edu.upeu.ctproyecto.data.model.User
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.CreateEmprendimientoUsuarioViewModel

@Composable
fun CreateEmprendimientoUsuarioScreen(
    navController: NavController,
    viewModel: CreateEmprendimientoUsuarioViewModel = viewModel()
) {
    val context = LocalContext.current
    val success by viewModel.success.collectAsState()
    val error by viewModel.error.collectAsState()

    val emprendimientos by viewModel.emprendimientos.collectAsState()
    val productores by viewModel.productores.collectAsState()

    var selectedEmprendimiento by remember { mutableStateOf<Emprendimiento?>(null) }
    var selectedUsuario by remember { mutableStateOf<User?>(null) }
    var selectedRol by remember { mutableStateOf("") }

    // Fetch data on screen load
    LaunchedEffect(Unit) {
        viewModel.fetchEmprendimientosYUsuarios()
    }

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

        // Emprendimientos
        Text("Seleccionar Emprendimiento", style = MaterialTheme.typography.titleMedium)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                emprendimientos.forEach { emprendimiento ->
                    Row(
                        modifier = Modifier
                            .selectableGroup()
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        RadioButton(
                            selected = selectedEmprendimiento == emprendimiento,
                            onClick = { selectedEmprendimiento = emprendimiento }
                        )
                        Text(emprendimiento.nombre, modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Productores
        Text("Seleccionar Productor", style = MaterialTheme.typography.titleMedium)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                productores.forEach { productor ->
                    Row(
                        modifier = Modifier
                            .selectableGroup()
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        RadioButton(
                            selected = selectedUsuario == productor,
                            onClick = { selectedUsuario = productor }
                        )
                        Text(productor.name, modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Roles
        Text("Seleccionar Rol", style = MaterialTheme.typography.titleMedium)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    RadioButton(
                        selected = selectedRol == "propietario",
                        onClick = { selectedRol = "propietario" }
                    )
                    Text("Propietario", modifier = Modifier.padding(start = 8.dp))
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    RadioButton(
                        selected = selectedRol == "colaborador",
                        onClick = { selectedRol = "colaborador" }
                    )
                    Text("Colaborador", modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Button to create
        Button(
            onClick = {
                selectedEmprendimiento?.let { emprendimiento ->
                    selectedUsuario?.let { usuario ->
                        viewModel.createEmprendimientoUsuario(
                            emprendimiento.id,
                            usuario.id,
                            selectedRol
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("Asignar Usuario", color = Color.White)
        }
    }
}
