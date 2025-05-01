package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.CreateEmprendimientoRequest
import pe.edu.upeu.ctproyecto.data.model.Emprendimiento
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class CreateEmprendimientoViewModel : ViewModel() {

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _tiposNegocio = MutableStateFlow<List<Pair<Int, String>>>(emptyList())
    val tiposNegocio: StateFlow<List<Pair<Int, String>>> = _tiposNegocio

    fun createEmprendimiento(
        nombre: String,
        descripcion: String?,
        idTipoNegocio: Int,
        direccion: String?,
        telefono: String?,
        estado: String
    ) {
        viewModelScope.launch {
            try {
                _isLoading.value = true

                // Crear un objeto Emprendimiento
                val emprendimiento = Emprendimiento(
                    id = 0, // Aquí asumes que el id se genera en el servidor
                    nombre = nombre,
                    descripcion = descripcion,
                    id_tipo_negocio = idTipoNegocio,
                    direccion = direccion,
                    telefono = telefono,
                    estado = estado
                )

                // Crear un CreateEmprendimientoRequest a partir del objeto Emprendimiento
                val request = CreateEmprendimientoRequest(
                    nombre = emprendimiento.nombre,
                    descripcion = emprendimiento.descripcion,
                    id_tipo_negocio = emprendimiento.id_tipo_negocio,
                    direccion = emprendimiento.direccion,
                    telefono = emprendimiento.telefono,
                    estado = emprendimiento.estado
                )

                // Enviar la solicitud a la API
                val response = RetrofitClient.apiService.createEmprendimiento(request)

                if (response.isSuccessful) {
                    _success.value = true
                } else {
                    _error.value = "Error al crear emprendimiento: ${response.code()}"
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

    fun fetchTiposNegocio() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getTiposNegocio()
                if (response.isSuccessful && response.body() != null) {
                    _tiposNegocio.value = response.body()!!.map { it.id_tipo_negocio to it.nombre }
                } else {
                    _error.value = "Error al cargar tipos de negocio: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}
