package pe.edu.upeu.ctproyecto.ui.home.usuarios.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.UpdateStatusRequest
import pe.edu.upeu.ctproyecto.data.model.User
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class UpdateStatusViewModel : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _success = MutableStateFlow<String?>(null)
    val success: StateFlow<String?> = _success

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.listUsers()
                if (response.isSuccessful && response.body() != null) {
                    _users.value = response.body()!!
                } else {
                    _error.value = "Error al cargar usuarios: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

    fun updateStatus(userId: Int, isActive: Boolean, motivo: String?) {
        viewModelScope.launch {
            try {
                val body = UpdateStatusRequest(
                    is_active = isActive,
                    motivo_inactivo = motivo
                )
                val response = RetrofitClient.apiService.updateStatus(userId, body)
                if (response.isSuccessful) {
                    _success.value = "Estado actualizado"
                    fetchUsers() // Recargar lista
                } else {
                    _error.value = "Error al actualizar estado: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}