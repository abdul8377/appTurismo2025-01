package pe.edu.upeu.appturismo202501.ui.presentation.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okio.IOException
import pe.edu.upeu.appturismo202501.modelo.LoginDto
import pe.edu.upeu.appturismo202501.modelo.LoginResp
import pe.edu.upeu.appturismo202501.repository.LoginUserRepository
import pe.edu.upeu.sysventasjpc.utils.TokenUtils
import java.net.SocketTimeoutException
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepo: LoginUserRepository
) : ViewModel(){
    private val _isLoading: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>(false) }
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _islogin: MutableLiveData<Boolean> by lazy {MutableLiveData<Boolean>(false)}
    val islogin: LiveData<Boolean> get() = _islogin

    val isError=MutableLiveData<Boolean>(false)
    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage


    val listUser = MutableLiveData<LoginResp>()

    fun loginSys(toData: LoginDto) {
        Log.i("LOGIN", toData.email_or_gmail)
        viewModelScope.launch(Dispatchers.IO){
            _isLoading.postValue(true)
        try {
            _isLoading.postValue(false)
            val totek = loginRepo.loginUsuario(toData).body()
            delay(1500L)
            TokenUtils.TOKEN_CONTENT = "Bearer" + totek?.token
            Log.i("DATAXLOGIN", "Pruebalogin")
            listUser.postValue(totek!!)
            Log.i("DATAXLOGIN", TokenUtils.TOKEN_CONTENT)
            if (TokenUtils.TOKEN_CONTENT != "Bearer null") {
                TokenUtils.USER_LOGIN = toData.email_or_gmail
                _islogin.postValue(true)
            } else {
                isError.postValue(true)
                _errorMessage.postValue("Error de login: verifique sus credenciales")
            }
            _isLoading.postValue(false)

        } catch (e:SocketTimeoutException){
            isError.postValue(true)
            _errorMessage.postValue("no se pudo conectar al servidor.")
        }catch (e:IOException) {
            isError.postValue(true)
            _errorMessage.postValue("Error de red: ${e.localizedMessage}")
        } catch (e:Exception) {
            isError.postValue(true)
            _errorMessage.postValue("ocurrio un error inesperado")
        }
        }
    }
    fun clearErrorMessage() {
        _errorMessage.postValue(null)
        isError.postValue(false)
        _isLoading.postValue(false)
    }
}
