package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.CreateCategoriaRequest
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class CreateCategoriaViewModel : ViewModel() {

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun createCategoria(
        nombreCategoria: String,
        descripcion: String?,

    ) {
        viewModelScope.launch {
            try {
                val request = CreateCategoriaRequest(
                    nombre_categoria = nombreCategoria,
                    descripcion = descripcion,

                )
                val response = RetrofitClient.apiService.createCategoria(request)
                if (response.isSuccessful) {
                    _success.value = true
                } else {
                    _error.value = "Error al crear categoría: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}
