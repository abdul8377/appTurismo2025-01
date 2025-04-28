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
import androidx.navigation.NavController
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.ListUsersViewModel

@Composable
fun ListUsersScreen(navController: NavController, viewModel: ListUsersViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val context = LocalContext.current
    val users by viewModel.users.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchUsers()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Lista de Usuarios", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        if (error != null) {
            Text(text = error ?: "", color = MaterialTheme.colorScheme.error)
        }

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
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = "Nombre: ${user.name}")
                        Text(text = "Correo: ${user.email}")
                        Text(text = "Rol: ${user.roles.joinToString(", ")}")
                        Text(text = "Activo: ${if (user.is_active) "Sí" else "No"}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(onClick = {
                                navController.navigate("editUser/${user.id}")
                            }) {
                                Text("Editar")
                            }

                            Button(onClick = {
                                viewModel.deleteUser(user.id)
                                Toast.makeText(context, "Usuario eliminado", Toast.LENGTH_SHORT).show()
                            }) {
                                Text("Eliminar")
                            }
                        }
                    }
                }
            }
        }
    }
}