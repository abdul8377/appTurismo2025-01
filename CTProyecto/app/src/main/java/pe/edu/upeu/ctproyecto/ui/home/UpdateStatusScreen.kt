package pe.edu.upeu.ctproyecto.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.UpdateStatusViewModel

@Composable
fun UpdateStatusScreen(
    navController: NavController,
    viewModel: UpdateStatusViewModel = viewModel()
) {
    val context = LocalContext.current
    val users by viewModel.users.collectAsState()
    val error by viewModel.error.collectAsState()
    val success by viewModel.success.collectAsState()

    var showDialog by remember { mutableStateOf(false) }
    var motivoInactivo by remember { mutableStateOf("") }
    var userIdToUpdate by remember { mutableStateOf<Int?>(null) }
    var newStatus by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        viewModel.fetchUsers()
    }

    success?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }

    error?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Actualizar Estado de Usuarios", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(users) { user ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Nombre: ${user.name}")
                            Text("Estado: ${if (user.is_active) "Activo" else "Inactivo"}")
                        }

                        Switch(
                            checked = user.is_active,
                            onCheckedChange = { checked ->
                                if (user.id != null) { // <- 🔥 PROTEGER PRIMERO
                                    if (!checked) {
                                        // Si va a inactivar, pedir motivo
                                        userIdToUpdate = user.id
                                        newStatus = checked
                                        showDialog = true
                                    } else {
                                        // Si va a activar directamente
                                        viewModel.updateStatus(user.id, true, null)
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }

    // AlertDialog para ingresar motivo
    if (showDialog && userIdToUpdate != null) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
                userIdToUpdate = null
                motivoInactivo = ""
            },
            title = { Text("Motivo de Inactivación") },
            text = {
                OutlinedTextField(
                    value = motivoInactivo,
                    onValueChange = { motivoInactivo = it },
                    label = { Text("Motivo") },
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        userIdToUpdate?.let { id ->
                            viewModel.updateStatus(id, false, motivoInactivo)
                        }
                        showDialog = false
                        userIdToUpdate = null
                        motivoInactivo = ""
                    }
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showDialog = false
                        userIdToUpdate = null
                        motivoInactivo = ""
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}