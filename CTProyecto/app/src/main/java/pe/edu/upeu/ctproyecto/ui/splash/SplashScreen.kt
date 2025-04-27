package pe.edu.upeu.ctproyecto.ui.splash

import android.annotation.SuppressLint
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
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import pe.edu.upeu.ctproyecto.R
import pe.edu.upeu.ctproyecto.data.local.DataStoreManager
import androidx.compose.ui.unit.sp


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    // Controlar la animación
    val alphaAnim = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        alphaAnim.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1500)
        )

        delay(2000) // Muestra el splash 2 segundos

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
    }

    // Diseño del Splash con imagen y animación de fade-in
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo WebTurismo",
                modifier = Modifier
                    .size(180.dp)
                    .alpha(alphaAnim.value) // Aplica animación de desvanecimiento
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "WebTurismo",
                fontSize = 30.sp,
                modifier = Modifier.alpha(alphaAnim.value)
            )
        }
    }
}
