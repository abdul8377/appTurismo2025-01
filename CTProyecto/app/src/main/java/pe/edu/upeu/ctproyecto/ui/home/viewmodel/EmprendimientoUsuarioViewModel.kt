package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.EmprendimientoUsuario
import pe.edu.upeu.ctproyecto.data.model.User
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class EmprendimientoUsuarioViewModel : ViewModel() {

    private val _emprendimientoUsuarios = MutableStateFlow<List<EmprendimientoUsuario>>(emptyList())
    val emprendimientoUsuarios: StateFlow<List<EmprendimientoUsuario>> = _emprendimientoUsuarios

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    // Suponiendo que tienes un servicio para obtener usuarios
    private val _usuarios = MutableStateFlow<List<User>>(emptyList())
    val usuarios: StateFlow<List<User>> = _usuarios

    // Función para obtener todos los usuarios asignados a emprendimientos
    fun fetchEmprendimientoUsuarios() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.listEmprendimientoUsuarios()
                if (response.isSuccessful && response.body() != null) {
                    _emprendimientoUsuarios.value = response.body()!!
                    fetchUsuarios() // Obtener usuarios para asociar con los emprendimientos
                } else {
                    _error.value = "Error al obtener los usuarios asignados: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

    // Función para obtener los usuarios
    fun fetchUsuarios() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.listUsers()
                if (response.isSuccessful && response.body() != null) {
                    _usuarios.value = response.body()!!
                } else {
                    _error.value = "Error al obtener los usuarios: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

    // Función para eliminar un usuario asignado a un emprendimiento
    fun deleteEmprendimientoUsuario(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.deleteEmprendimientoUsuario(id)
                if (response.isSuccessful) {
                    fetchEmprendimientoUsuarios() // Refrescar la lista
                } else {
                    _error.value = "Error al eliminar la relación: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}
