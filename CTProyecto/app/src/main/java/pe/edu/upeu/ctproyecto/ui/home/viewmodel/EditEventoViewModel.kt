package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.Emprendimiento
import pe.edu.upeu.ctproyecto.data.model.Evento
import pe.edu.upeu.ctproyecto.data.model.EventoRequest
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class EditEventoViewModel : ViewModel() {
    private val _evento = MutableStateFlow<Evento?>(null)
    val evento: StateFlow<Evento?> = _evento

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchEvento(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getEventoById(id)
                if (response.isSuccessful) {
                    _evento.value = response.body()
                } else {
                    _error.value = "❌ Error al cargar evento: ${response.code()}"
                }
            } catch (e: Exception) {
                _error.value = "❌ Error: ${e.message}"
            }
        }

    }

    fun updateEvento(id: Int, request: EventoRequest) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.updateEvento(id, request)
                _success.value = response.isSuccessful
                if (!response.isSuccessful) {
                    _error.value = "Error al actualizar: ${response.code()}"
                }
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
            }
        }
    }
}