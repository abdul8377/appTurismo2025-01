package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.Categoria
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class EditCategoriaViewModel : ViewModel() {

    private val _categoria = MutableStateFlow<Categoria?>(null)
    val categoria: StateFlow<Categoria?> = _categoria

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    // Cargar la categoría desde el servidor
    fun fetchCategoria(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getCategoriaById(id)
                if (response.isSuccessful && response.body() != null) {
                    _categoria.value = response.body()
                } else {
                    _error.value = "Categoría no encontrada (Error ${response.code()})"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

    // Actualizar la categoría
    fun updateCategoria(
        id: Int,
        nombreCategoria: String,
        descripcion: String?,

    ) {
        viewModelScope.launch {
            try {
                val body = mapOf<String, Any>(
                    "nombre_categoria" to nombreCategoria,
                    "descripcion" to (descripcion ?: ""),

                )
                val response = RetrofitClient.apiService.updateCategoria(id, body)
                if (response.isSuccessful) {
                    _success.value = true
                } else {
                    _error.value = "Error al actualizar: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}
