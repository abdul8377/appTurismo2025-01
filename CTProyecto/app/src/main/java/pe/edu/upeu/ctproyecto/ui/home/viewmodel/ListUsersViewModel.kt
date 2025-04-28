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

class ListUsersViewModel : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

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
    fun deleteUser(userId: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.deleteUser(userId)
                if (response.isSuccessful) {
                    fetchUsers() // Recargar usuarios después de eliminar
                } else {
                    _error.value = "Error al eliminar usuario: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}