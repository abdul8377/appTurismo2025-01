package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.CreateTipoNegocioRequest
import pe.edu.upeu.ctproyecto.data.model.TipoNegocio
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class EditTipoNegocioViewModel : ViewModel() {

    private val _tipoNegocio = MutableStateFlow<TipoNegocio?>(null)
    val tipoNegocio: StateFlow<TipoNegocio?> = _tipoNegocio

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    fun fetchTipoNegocio(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getTipoNegocioById(id)
                if (response.isSuccessful && response.body() != null) {
                    _tipoNegocio.value = response.body()
                } else {
                    _error.value = "Tipo de negocio no encontrado (Error ${response.code()})"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

    // UpdateTipoNegocioViewModel
    fun updateTipoNegocio(id: Int, nombre: String) {
        viewModelScope.launch {
            try {
                // Crear un objeto de tipo CreateTipoNegocioRequest
                val request = CreateTipoNegocioRequest(nombre)

                // Enviar el objeto request al endpoint para actualizar el tipo de negocio
                val response = RetrofitClient.apiService.updateTipoNegocio(id, request)
                if (response.isSuccessful) {
                    _success.value = true
                } else {
                    // Log el error recibido
                    _error.value = "Error al actualizar: ${response.code()}"
                    // Aquí podrías ver más detalles del error de la respuesta
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

}
