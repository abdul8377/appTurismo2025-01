package pe.edu.upeu.ctproyecto.data.remote

import pe.edu.upeu.ctproyecto.data.model.LoginRequest
import pe.edu.upeu.ctproyecto.data.model.LoginResponse
import pe.edu.upeu.ctproyecto.data.model.RegisterRequest
import pe.edu.upeu.ctproyecto.data.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>
}
