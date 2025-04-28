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

class EditEmprendimientoViewModel : ViewModel() {

    private val _emprendimiento = MutableStateFlow<Emprendimiento?>(null)
    val emprendimiento: StateFlow<Emprendimiento?> = _emprendimiento

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    fun fetchEmprendimiento(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getEmprendimientoById(id)
                if (response.isSuccessful && response.body() != null) {
                    _emprendimiento.value = response.body()
                } else {
                    _error.value = "Emprendimiento no encontrado (Error ${response.code()})"
                }
            } catch (e: IOException) {
                _error.value = "Error de conexión: ${e.message}"
            } catch (e: HttpException) {
                _error.value = "Error HTTP: ${e.message}"
            }
        }
    }

    fun updateEmprendimiento(
        id: Int,
        nombre: String,
        descripcion: String?,
        idTipoNegocio: Int,
        direccion: String?,
        telefono: String?,
        estado: String
    ) {
        viewModelScope.launch {
            try {
                val body = mapOf<String, Any>(
                    "nombre" to nombre,
                    "descripcion" to (descripcion ?: ""),
                    "id_tipo_negocio" to idTipoNegocio,
                    "direccion" to (direccion ?: ""),
                    "telefono" to (telefono ?: ""),
                    "estado" to estado
                )
                val response = RetrofitClient.apiService.updateEmprendimiento(id, body)
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