package pe.edu.upeu.ctproyecto.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.LoginRequest
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException

class LoginViewModel : ViewModel() {

    fun login(
        emailOrGmail: String,
        password: String,
        onSuccess: (String, String, String) -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.login(
                    LoginRequest(email_or_gmail = emailOrGmail, password = password)
                )

                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        onSuccess(body.token, body.name, body.role)
                    } else {
                        onError("Respuesta vacía del servidor")
                    }
                } else {
                    if (response.code() == 403) {
                        val errorBody = response.errorBody()?.string()
                        onError("Tu cuenta está inactiva. Motivo: ${errorBody ?: "Sin especificar"}")
                    } else {
                        onError("Error: ${response.message()}")
                    }
                }

            } catch (e: HttpException) {
                onError("Error de servidor: ${e.localizedMessage}")
            } catch (e: Exception) {
                onError("Error: ${e.localizedMessage ?: "Error desconocido"}")
            }
        }
    }
}
