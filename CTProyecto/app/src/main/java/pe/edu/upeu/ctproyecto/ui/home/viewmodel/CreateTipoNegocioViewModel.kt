package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.CreateTipoNegocioRequest
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class CreateTipoNegocioViewModel : ViewModel() {

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun createTipoNegocio(nombre: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true

                val request = CreateTipoNegocioRequest(nombre)

                val response = RetrofitClient.apiService.createTipoNegocio(request)

                if (response.isSuccessful) {
                    _success.value = true
                } else {
                    _error.value = "Error al crear tipo de negocio: ${response.code()}"
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
}
