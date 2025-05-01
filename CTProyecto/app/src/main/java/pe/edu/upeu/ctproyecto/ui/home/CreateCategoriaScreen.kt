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
import pe.edu.upeu.ctproyecto.ui.home.viewmodel.CreateCategoriaViewModel

@Composable
fun CreateCategoriaScreen(
    navController: NavController,
    viewModel: CreateCategoriaViewModel = viewModel()
) {
    val context = LocalContext.current
    val success by viewModel.success.collectAsState()
    val error by viewModel.error.collectAsState()

    var nombreCategoria by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("activo") }

    if (success) {
        Toast.makeText(context, "Categoría creada exitosamente", Toast.LENGTH_SHORT).show()
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
        Text("Crear Categoría", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = nombreCategoria,
            onValueChange = { nombreCategoria = it },
            label = { Text("Nombre Categoría") },
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


        Button(
            onClick = {
                viewModel.createCategoria(
                    nombreCategoria,
                    descripcion,

                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear Categoría")
        }
    }
}
