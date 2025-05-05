package pe.edu.upeu.appturismo202501.ui.presentation.screens

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.k0shk0sh.compose.easyforms.BuildEasyForms
import com.github.k0shk0sh.compose.easyforms.EasyFormsResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pe.edu.upeu.appturismo202501.modelo.LoginDto
import pe.edu.upeu.appturismo202501.ui.theme.AppTurismo202501Theme
import pe.edu.upeu.appturismo202501.ui.theme.LightRedColors
import pe.edu.upeu.sysventasjpc.ui.presentation.components.ErrorImageAuth
import pe.edu.upeu.sysventasjpc.ui.presentation.components.ImageLogin
import pe.edu.upeu.sysventasjpc.ui.presentation.components.ProgressBarLoading
import pe.edu.upeu.sysventasjpc.ui.presentation.components.form.EmailTextField
import pe.edu.upeu.sysventasjpc.ui.presentation.components.form.LoginButton
import pe.edu.upeu.sysventasjpc.ui.presentation.components.form.PasswordTextField
import pe.edu.upeu.sysventasjpc.utils.ComposeReal
import pe.edu.upeu.sysventasjpc.utils.TokenUtils



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import pe.edu.upeu.appturismo202501.ui.navigation.Destinations
import pe.edu.upeu.appturismo202501.ui.theme.LightColorScheme
import pe.edu.upeu.appturismo202501.ui.theme.LightGreenColors


@Composable
fun LoginScreen(
    navigateToHome: () -> Unit,
    onGoogleLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),


) {

    val isLoading by viewModel.isLoading.observeAsState(false)
    val isLogin by viewModel.islogin.observeAsState(false)
    val isError by viewModel.isError.observeAsState(false)
    val loginResul by viewModel.listUser.observeAsState()
    val errorMessage by viewModel.errorMessage.observeAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        // Título
        Text(
            text = "Iniciar sesión",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        BuildEasyForms { easyForm ->
            //email
            EmailTextField(
                easyForms = easyForm,
                text = "",
                label = "E-Mail:",
            )
            Spacer(modifier = Modifier.height(16.dp))
            //password
            PasswordTextField(
                easyForms = easyForm,
                text = "",
                label = "password: ",
            )
            Spacer(modifier = Modifier.height(24.dp))
            LoginButton(easyForms=easyForm, onClick = {
                val dataForm=easyForm.formData()
                val login=LoginDto(
                    (dataForm.get(0) as EasyFormsResult.StringResult).value,
                    (dataForm.get(1) as EasyFormsResult.StringResult).value)
                viewModel.loginSys(login)
                scope.launch {
                    delay(3600)
                    if(isLogin && loginResul!=null){
                        Log.i("TOKENV", TokenUtils.TOKEN_CONTENT)
                        Log.i("DATA", loginResul!!.name)
                        navigateToHome.invoke()
                    }else{
                        Log.v("ERRORX", "Error logeo")
                        Toast.makeText(context,"Error al conectar",Toast.LENGTH_LONG)
                    }
                }
            },
                label = "Iniciar sesion"
            )
            /*Button(onClick = {
                navigateToHome.invoke()
            }) {
                Text("Ir a Detalle")
            }*/
            ComposeReal.COMPOSE_TOP.invoke()
        }
        ProgressBarLoading(isLoading = isLoading)

        Spacer(modifier = Modifier.height(16.dp))


        // Botón Google
        OutlinedButton(
            onClick = onGoogleLoginClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Google",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Iniciar sesión con Google")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Texto: ¿Aún no tienes una cuenta?
        Row {
            Text("¿Aún no tienes una cuenta? ")
            Text(
                text = "Registrarte",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable (onClick = onRegisterClick)
            )
        }
    }
    // Mostrar Snackbar manualmente
    SnackbarHost(
        hostState = snackbarHostState,
        modifier = Modifier.wrapContentHeight(Alignment.Bottom).padding(16.dp),

        )
    // Mostrar el snackbar cuando haya mensaje de error
    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearErrorMessage()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    val colors = LightGreenColors
    // Puedes usar el tema de tu app si lo tienes
    AppTurismo202501Theme(colorScheme = colors) {
        LoginScreen(
            navigateToHome={},
            onGoogleLoginClick = {},
            onRegisterClick = {},

        )
    }
}
