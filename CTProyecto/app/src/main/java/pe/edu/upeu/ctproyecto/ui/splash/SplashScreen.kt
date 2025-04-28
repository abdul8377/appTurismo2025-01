package pe.edu.upeu.ctproyecto.ui.splash

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import pe.edu.upeu.ctproyecto.R
import pe.edu.upeu.ctproyecto.data.local.DataStoreManager
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current

    // Controlar animación fade-in
    val alphaAnim = remember { Animatable(0f) }

    var loading by remember { mutableStateOf(true) }
    var errorConnection by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        alphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1500)
        )

        delay(1500) // Delay para mostrar animación

        // Verificar conexión a internet
        if (isNetworkAvailable(context)) {
            try {
                // Probar conexión al backend haciendo un ping sencillo
                RetrofitClient.apiService.listEmprendimientos()
                val dataStoreManager = DataStoreManager(context)
                val token = dataStoreManager.getToken().first()

                if (token.isNullOrEmpty()) {
                    navController.navigate("welcome") {
                        popUpTo(0) { inclusive = true }
                    }
                } else {
                    navController.navigate("home") {
                        popUpTo(0) { inclusive = true }
                    }
                }
            } catch (e: IOException) {
                errorConnection = true
            } catch (e: HttpException) {
                errorConnection = true
            }
        } else {
            errorConnection = true
        }

        loading = false
    }

    // Diseño del Splash
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo WebTurismo",
                modifier = Modifier
                    .size(180.dp)
                    .alpha(alphaAnim.value)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "WebTurismo",
                fontSize = 30.sp,
                modifier = Modifier.alpha(alphaAnim.value)
            )
            Spacer(modifier = Modifier.height(30.dp))

            if (loading) {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(10.dp))
                Text("Conectando...", fontSize = 18.sp)
            } else if (errorConnection) {
                Text(
                    "Sin conexión. Reintentando...",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.error
                )
                CircularProgressIndicator()
            }
        }
    }
}

// Función para verificar si hay conexión a Internet
fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}