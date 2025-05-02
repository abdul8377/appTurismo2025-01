package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.CreateEmprendimientoUsuarioRequest
import pe.edu.upeu.ctproyecto.data.model.Emprendimiento
import pe.edu.upeu.ctproyecto.data.model.User
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class CreateEmprendimientoUsuarioViewModel : ViewModel() {

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _emprendimientos = MutableStateFlow<List<Emprendimiento>>(emptyList())
    val emprendimientos: StateFlow<List<Emprendimiento>> = _emprendimientos

    private val _productores = MutableStateFlow<List<User>>(emptyList())
    val productores: StateFlow<List<User>> = _productores

    // Función para obtener los emprendimientos y productores
    fun fetchEmprendimientosYUsuarios() {
        viewModelScope.launch {
            try {
                // Obtener los emprendimientos
                val responseEmprendimientos = RetrofitClient.apiService.getEmprendimientos()
                if (responseEmprendimientos.isSuccessful && responseEmprendimientos.body() != null) {
                    _emprendimientos.value = responseEmprendimientos.body()!!
                } else {
                    _error.value = "Error al obtener los emprendimientos: ${responseEmprendimientos.code()}"
                }

                // Obtener los productores
                val responseProductores = RetrofitClient.apiService.getUsuariosProductoresLibres()
                if (responseProductores.isSuccessful && responseProductores.body() != null) {
                    _productores.value = responseProductores.body()!!
                } else {
                    _error.value = "Error al obtener los productores: ${responseProductores.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

    // Función para crear el emprendimiento-usuario
    fun createEmprendimientoUsuario(
        idEmprendimiento: Int,
        idUsuario: Int,
        rolEmprendimiento: String
    ) {
        viewModelScope.launch {
            try {
                val request = CreateEmprendimientoUsuarioRequest(
                    id_emprendimiento = idEmprendimiento,
                    id_usuario = idUsuario,
                    rol_emprendimiento = rolEmprendimiento
                )
                val response = RetrofitClient.apiService.createEmprendimientoUsuario(request)
                if (response.isSuccessful && response.code() == 201) {
                    _success.value = true
                } else {
                    _error.value = "Error al crear usuario asignado: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}
