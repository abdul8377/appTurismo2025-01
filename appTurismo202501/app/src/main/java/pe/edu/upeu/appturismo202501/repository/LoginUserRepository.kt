package pe.edu.upeu.appturismo202501.repository

import pe.edu.upeu.appturismo202501.data.remote.RestLoginUsuario
import pe.edu.upeu.appturismo202501.modelo.LoginDto
import pe.edu.upeu.appturismo202501.modelo.LoginResp
import pe.edu.upeu.appturismo202501.modelo.UsersDto
import retrofit2.Response
import javax.inject.Inject


interface LoginUserRepository{
    suspend fun loginUsuario(userLogin:LoginDto):
            Response<LoginResp>
}

class LoginUserRespositoryImp @Inject constructor(private val restLoginUsuario: RestLoginUsuario) :LoginUserRepository{
    override suspend fun loginUsuario(userLogin: LoginDto):
            Response<LoginResp>{
        return restLoginUsuario.login(userLogin)
    }
}