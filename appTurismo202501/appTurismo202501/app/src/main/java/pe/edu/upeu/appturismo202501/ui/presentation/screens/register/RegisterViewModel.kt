package pe.edu.upeu.appturismo202501.ui.presentation.screens.register

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upeu.appturismo202501.modelo.RegisterDto
import pe.edu.upeu.appturismo202501.modelo.RegisterResp
import pe.edu.upeu.appturismo202501.repository.RegisterRepository
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: RegisterRepository
): ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _registerSuccess = MutableStateFlow<RegisterResp?>(null)
    val registerSuccess: StateFlow<RegisterResp?> = _registerSuccess

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun registerUser(data: RegisterDto) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = repository.register(data)
                if (response.isSuccessful && response.body() != null) {
                    _registerSuccess.value = response.body()
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("REG_ERROR", "Código: ${response.code()} - Body: $errorBody")
                    _errorMessage.value = "Error: ${response.code()} - $errorBody"
                }
            } catch (e: IOException) {
                _errorMessage.value = "Error de red: ${e.message}"
            } catch (e: HttpException) {
                _errorMessage.value = "Error del servidor: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun clearError() {
        _errorMessage.value = null
    }
}