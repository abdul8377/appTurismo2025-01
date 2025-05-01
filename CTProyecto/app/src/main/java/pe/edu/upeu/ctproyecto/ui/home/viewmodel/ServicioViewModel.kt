package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.Servicio
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class ServicioViewModel : ViewModel() {

    private val _servicios = MutableStateFlow<List<Servicio>>(emptyList())
    val servicios: StateFlow<List<Servicio>> = _servicios

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchServicios() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getServicios()
                if (response.isSuccessful && response.body() != null) {
                    _servicios.value = response.body()!!
                } else {
                    _error.value = "Error al cargar servicios: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

    fun deleteServicio(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.deleteServicio(id)
                if (response.isSuccessful) {
                    fetchServicios() // Recargar lista tras eliminar
                } else {
                    _error.value = "Error al eliminar: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}