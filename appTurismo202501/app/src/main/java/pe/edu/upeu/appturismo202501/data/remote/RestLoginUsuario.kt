package pe.edu.upeu.appturismo202501.data.remote

import pe.edu.upeu.appturismo202501.modelo.LoginDto
import pe.edu.upeu.appturismo202501.modelo.LoginResp
import pe.edu.upeu.appturismo202501.modelo.UserResp
import pe.edu.upeu.appturismo202501.modelo.UsersDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RestLoginUsuario {
    @POST("login")
    suspend fun login(@Body userLogin:LoginDto):
            Response<LoginResp>
}