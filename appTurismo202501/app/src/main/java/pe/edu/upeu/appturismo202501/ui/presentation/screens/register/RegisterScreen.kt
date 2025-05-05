package pe.edu.upeu.appturismo202501.ui.presentation.screens.register


import android.os.Build
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.k0shk0sh.compose.easyforms.BuildEasyForms
import com.github.k0shk0sh.compose.easyforms.EasyFormsErrorState
import com.github.k0shk0sh.compose.easyforms.EasyFormsResult
import com.github.k0shk0sh.compose.easyforms.EmailValidationType
import com.github.k0shk0sh.compose.easyforms.NameValidationType
import com.github.k0shk0sh.compose.easyforms.PasswordValidationType
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pe.edu.upeu.appturismo202501.modelo.RegisterDto
import pe.edu.upeu.sysventasjpc.ui.presentation.components.ProgressBarLoading
import pe.edu.upeu.sysventasjpc.ui.presentation.components.form.EmailTextField
import pe.edu.upeu.sysventasjpc.ui.presentation.components.form.LoginButton
import pe.edu.upeu.sysventasjpc.ui.presentation.components.form.MyFormKeys
import pe.edu.upeu.sysventasjpc.ui.presentation.components.form.NameTextField
import pe.edu.upeu.sysventasjpc.ui.presentation.components.form.PasswordConfirmation
import pe.edu.upeu.sysventasjpc.ui.presentation.components.form.PasswordTextField
import pe.edu.upeu.sysventasjpc.ui.presentation.components.form.RegisterButton

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel(),
    onNavigateToLogin: () -> Unit
) {
    val isLoading by viewModel.isLoading.collectAsState()
    val registerSuccess by viewModel.registerSuccess.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    LaunchedEffect(registerSuccess) {
        registerSuccess?.let {
            Toast.makeText(context, "Registro exitoso", Toast.LENGTH_LONG).show()
            onNavigateToLogin()
        }
    }

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            scope.launch {
                snackbarHostState.showSnackbar(it)
                viewModel.clearError()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Registrarse", style = MaterialTheme.typography.headlineMedium)

        BuildEasyForms { easyForms ->
            Column(modifier = Modifier.fillMaxWidth()) {
                // Campos del formulario

                NameTextField(easyForms, "", "Nombre de usuario", key = MyFormKeys.NAME)
                EmailTextField(easyForms, "", "Correo") // Puedes cambiar "N" si usas otro
                PasswordTextField(easyForms, "", "Contraseña")
                PasswordConfirmation(easyForms, "", "Confirmar Contraseña")


                Spacer(modifier = Modifier.height(20.dp))

                // Botón Registrar
                RegisterButton(easyForms = easyForms, onClick = {
                    val dataForm = easyForms.formData()

                    if (dataForm.size < 4) {
                        Toast.makeText(context, "Por favor completa todos los campos", Toast.LENGTH_LONG).show()
                        return@RegisterButton
                    }

                    val name = (dataForm[0] as EasyFormsResult.StringResult).value.trim()
                    val email = (dataForm[1] as EasyFormsResult.StringResult).value.trim()

                    val password = (dataForm[2] as EasyFormsResult.StringResult).value.trim()
                    val confirmPassword = (dataForm[3] as EasyFormsResult.StringResult).value.trim()

                    Log.i("REGISTRO_DATA", "Email: $email, Name: $name, Pass: $password, Confirm: $confirmPassword")

                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        Toast.makeText(context, "Correo inválido", Toast.LENGTH_SHORT).show()
                        return@RegisterButton
                    }


                    if (password != confirmPassword) {
                        Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show()
                        return@RegisterButton
                    }

                    val user = RegisterDto(name, email, password, confirmPassword)

                    Log.i("REG_DTO", "Json Enviado: $user")
                    viewModel.registerUser(user)

                    scope.launch {
                        delay(3600)
                        if (registerSuccess != null) {
                            Log.i("REGISTER", "Registro exitoso: ${registerSuccess!!.name}")
                            onNavigateToLogin()
                        } else {
                            Toast.makeText(context, "Error al registrar", Toast.LENGTH_LONG).show()
                        }
                    }
                }, label = "Registrarse")

        }

        Spacer(modifier = Modifier.height(8.dp))

        // Ir a login
        TextButton (onClick = onNavigateToLogin) {
            Text("¿Ya tienes cuenta? Inicia sesión")
        }
    }

    SnackbarHost(
        hostState = snackbarHostState,
        modifier = Modifier.wrapContentHeight(Alignment.Bottom).padding(16.dp),
    )

    ProgressBarLoading(isLoading = isLoading)
}}