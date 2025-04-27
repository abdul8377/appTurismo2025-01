package pe.edu.upeu.ctproyecto.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.RegisterRequest
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException

class RegisterViewModel : ViewModel() {

    fun register(
        name: String,
        email: String,
        password: String,
        passwordConfirmation: String,
        onSuccess: (String, String) -> Unit,  // ✅ Dos parámetros ahora: message y token
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.register(
                    RegisterRequest(
                        name = name,
                        email = email,
                        password = password,
                        password_confirmation = passwordConfirmation
                    )
                )

                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        // Aquí mandamos message y token al success
                        onSuccess(body.message, body.token)
                    } else {
                        onError("Respuesta vacía del servidor")
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    onError("Error en el registro: ${errorBody ?: response.message()}")
                }

            } catch (e: HttpException) {
                onError("Error de servidor: ${e.localizedMessage}")
            } catch (e: Exception) {
                onError("Error: ${e.localizedMessage ?: "Error desconocido"}")
            }
        }
    }
}
