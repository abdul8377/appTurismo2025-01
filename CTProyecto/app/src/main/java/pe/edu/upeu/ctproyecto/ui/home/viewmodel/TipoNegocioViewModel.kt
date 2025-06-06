package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.TipoNegocio
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class TipoNegocioViewModel : ViewModel() {

    private val _tiposNegocio = MutableStateFlow<List<TipoNegocio>>(emptyList())
    val tiposNegocio: StateFlow<List<TipoNegocio>> = _tiposNegocio

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchTiposNegocio() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getTiposNegocio()
                if (response.isSuccessful && response.body() != null) {
                    _tiposNegocio.value = response.body()!!
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
    fun deleteTipoNegocio(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.deleteTipoNegocio(id)
                if (response.isSuccessful) {
                    // Actualizar la lista de tipos de negocio después de la eliminación
                    fetchTiposNegocio() // Refresca la lista
                } else {
                    _error.value = "Error al eliminar tipo de negocio: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}
