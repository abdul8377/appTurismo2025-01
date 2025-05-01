package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.Servicio
import pe.edu.upeu.ctproyecto.data.model.ServicioRequest
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class EditServicioViewModel : ViewModel() {

    private val _servicio = MutableStateFlow<Servicio?>(null)
    val servicio: StateFlow<Servicio?> = _servicio

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchServicio(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getServicioById(id)
                if (response.isSuccessful) {
                    _servicio.value = response.body()
                } else {
                    _error.value = "Error al cargar: ${response.code()}" // 👈 Aquí verás el 404
                }
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
            }
        }
    }

    fun updateServicio(
        id: Int,
        nombre_servicio: String,
        descripcion: String?,
        precio: Double,
        ubicacion: String?,
        fecha_inicio: String?,
        fecha_fin: String?,
        estado: String
    ) {
        viewModelScope.launch {
            try {
                val request = ServicioRequest(
                    id_emprendimiento = _servicio.value?.id_emprendimiento ?: 1,
                    nombre_servicio = nombre_servicio,
                    descripcion = descripcion,
                    precio = precio,
                    ubicacion = ubicacion,
                    fecha_inicio = fecha_inicio,
                    fecha_fin = fecha_fin,
                    estado = estado
                )

                val response = RetrofitClient.apiService.updateServicio(id, request)
                if (response.isSuccessful) {
                    _success.value = true
                } else {
                    _error.value = "Error al actualizar: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de red: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}