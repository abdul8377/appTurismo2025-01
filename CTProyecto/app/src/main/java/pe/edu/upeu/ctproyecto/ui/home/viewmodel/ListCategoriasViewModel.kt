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

class ListCategoriasViewModel : ViewModel() {

    private val _categorias = MutableStateFlow<List<Categoria>>(emptyList())
    val categorias: StateFlow<List<Categoria>> = _categorias

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchCategorias() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.listCategorias()
                if (response.isSuccessful && response.body() != null) {
                    _categorias.value = response.body()!!
                } else {
                    _error.value = "Error al cargar categorías: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

    fun deleteCategoria(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.deleteCategoria(id)
                if (response.isSuccessful) {
                    fetchCategorias() // Refrescar la lista
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
