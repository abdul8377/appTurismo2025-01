package pe.edu.upeu.ctproyecto.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.ctproyecto.data.model.ZonaTuristicaRequest
import pe.edu.upeu.ctproyecto.data.remote.RetrofitClient
import retrofit2.HttpException
import java.io.IOException

class CreateZonaTuristicaViewModel : ViewModel() {

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun createZona(
        nombre: String,
        descripcion: String?,
        ubicacion: String?,
        imagenUrl: String?,
        estado: String
    ) {
        viewModelScope.launch {
            try {
                val request = ZonaTuristicaRequest(
                    nombre = nombre,
                    descripcion = descripcion,
                    ubicacion = ubicacion,
                    imagen_url = imagenUrl,
                    estado = estado
                )

                val response = RetrofitClient.apiService.createZonaTuristica(request)

                if (response.isSuccessful) {
                    _success.value = true
                } else {
                    _error.value = "Error: ${response.code()}"
                }

            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }
}
