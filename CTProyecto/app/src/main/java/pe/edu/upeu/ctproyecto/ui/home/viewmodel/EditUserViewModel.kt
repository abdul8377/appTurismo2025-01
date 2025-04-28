package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.User
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class EditUserViewModel : ViewModel() {

    // Estados
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _roles = MutableStateFlow<List<String>>(emptyList())
    val roles: StateFlow<List<String>> = _roles

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    // Función para actualizar usuario
    fun updateUser(userId: Int, name: String, email: String, role: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val body = mapOf(
                    "name" to name,
                    "email" to email,
                    "role" to role
                )
                val response = RetrofitClient.apiService.updateUser(userId, body)
                if (response.isSuccessful) {
                    _success.value = true
                } else {
                    _error.value = "Error al actualizar usuario: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Función para obtener usuario por ID
    fun fetchUser(userId: Int) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = RetrofitClient.apiService.getUserById(userId)
                if (response.isSuccessful && response.body() != null) {
                    _user.value = response.body()
                } else {
                    _error.value = "Error al obtener usuario: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Función para obtener roles
    fun fetchRoles() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getRoles()
                if (response.isSuccessful && response.body() != null) {
                    _roles.value = response.body()!!
                } else {
                    _error.value = "Error al obtener roles: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}