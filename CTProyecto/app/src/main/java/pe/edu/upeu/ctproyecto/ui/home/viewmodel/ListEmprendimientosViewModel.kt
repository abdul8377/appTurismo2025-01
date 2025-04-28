package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.Emprendimiento
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class ListEmprendimientosViewModel : ViewModel() {

    private val _emprendimientos = MutableStateFlow<List<Emprendimiento>>(emptyList())
    val emprendimientos: StateFlow<List<Emprendimiento>> = _emprendimientos

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchEmprendimientos() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.listEmprendimientos()
                if (response.isSuccessful && response.body() != null) {
                    _emprendimientos.value = response.body()!!
                } else {
                    _error.value = "Error al cargar emprendimientos: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

    fun deleteEmprendimiento(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.deleteEmprendimiento(id)
                if (response.isSuccessful) {
                    fetchEmprendimientos() // Refrescar la lista
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