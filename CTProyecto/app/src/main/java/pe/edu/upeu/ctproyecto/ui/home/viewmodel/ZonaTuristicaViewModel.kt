package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.ZonaTuristica
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class ZonaTuristicaViewModel : ViewModel() {
    private val _zonas = MutableStateFlow<List<ZonaTuristica>>(emptyList())
    val zonas: StateFlow<List<ZonaTuristica>> = _zonas

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchZonas() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getZonasTuristicas()
                if (response.isSuccessful && response.body() != null) {
                    _zonas.value = response.body()!!
                } else {
                    _error.value = "Error al cargar zonas: ${response.code()}"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

    fun deleteZona(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.deleteZonaTuristica(id)
                if (response.isSuccessful) {
                    fetchZonas()
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
