package pe.edu.upeu.ctproyecto.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.EmprendimientoUsuarioViewModel

@Composable
fun ListEmprendimientoUsuariosScreen(
    navController: NavController,
    viewModel: EmprendimientoUsuarioViewModel = viewModel()
) {
    val context = LocalContext.current
    val emprendimientoUsuarios by viewModel.emprendimientoUsuarios.collectAsState()
    val usuarios by viewModel.usuarios.collectAsState()
    val emprendimientos by viewModel.emprendimientos.collectAsState()
    val error by viewModel.error.collectAsState()

    var showDialog by remember { mutableStateOf(false) }
    var selectedUserId by remember { mutableStateOf<Int?>(null) }
    var selectedUserName by remember { mutableStateOf<String?>(null) }
    var selectedEmprendimientoName by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        viewModel.fetchEmprendimientoUsuarios()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Usuarios Asignados a Emprendimiento",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (error != null) {
            Text(text = error ?: "", color = MaterialTheme.colorScheme.error)
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(emprendimientoUsuarios) { usuario ->
                // Buscar el nombre del usuario utilizando el idUsuario
                val user = usuarios.find { it.id == usuario.idUsuario }
                val userName = user?.name ?: "Desconocido"  // Si no se encuentra, mostramos "Desconocido"

                // Buscar el nombre del emprendimiento usando id_emprendimiento
                val emprendimiento = emprendimientos.find { it.id == usuario.idEmprendimiento }
                val emprendimientoName = emprendimiento?.nombre ?: "Desconocido"
                val fechaAsignacion = usuario.fechaAsignacion

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .shadow(8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        // Muestra la información del usuario y el emprendimiento
                        Text(
                            "Nombre del Usuario: $userName",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text("ID Usuario: ${usuario.idUsuario}", style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Nombre del Emprendimiento: $emprendimientoName",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text("ID Emprendimiento: ${usuario.idEmprendimiento}", style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Fecha de Asignación: $fechaAsignacion", style = MaterialTheme.typography.bodyMedium)

                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(
                                onClick = {
                                    selectedUserId = usuario.idUsuario
                                    selectedUserName = userName
                                    selectedEmprendimientoName = emprendimientoName
                                    showDialog = true
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                            ) {
                                Text("Eliminar", color = Color.White)
                            }
                        }
                    }
                }
            }
        }
    }

    // Confirmación de eliminación de usuario
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Confirmar eliminación") },
            text = {
                Text("¿Estás seguro de eliminar al usuario $selectedUserName del emprendimiento $selectedEmprendimientoName?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        selectedUserId?.let {
                            viewModel.deleteEmprendimientoUsuario(it)
                        }
                        showDialog = false
                    }
                ) {
                    Text("Eliminar")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}
