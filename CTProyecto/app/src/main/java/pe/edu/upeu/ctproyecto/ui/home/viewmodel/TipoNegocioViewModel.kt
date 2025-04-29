package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.TipoNegocio
import pe.edu.upeu.ctproyecto.data.remote.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.Response

class TipoNegocioViewModel : ViewModel() {

    private val _tiposNegocio = MutableStateFlow<List<TipoNegocio>>(emptyList())
    val tiposNegocio: StateFlow<List<TipoNegocio>> get() = _tiposNegocio

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    // Función para cargar los tipos de negocio
    fun fetchTiposNegocio() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getTiposNegocio()
                if (response.isSuccessful) {
                    _tiposNegocio.value = response.body() ?: emptyList()
                } else {
                    _error.value = "Error al cargar los tipos de negocio"
                }
            } catch (e: Exception) {
                _error.value = "Error al cargar los tipos de negocio: ${e.message}"
            }
        }
    }

    // Función para eliminar un tipo de negocio
    fun deleteTipoNegocio(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.deleteTipoNegocio(id)
                if (response.isSuccessful) {
                    fetchTiposNegocio() // Recargar la lista
                } else {
                    _error.value = "Error al eliminar el tipo de negocio"
                }
            } catch (e: Exception) {
                _error.value = "Error al eliminar el tipo de negocio: ${e.message}"
            }
        }
    }
}
