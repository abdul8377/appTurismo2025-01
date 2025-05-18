package pe.edu.upeu.appturismo202501.modelo

import com.google.gson.annotations.SerializedName

data class RegisterDto(
    val name: String,
    val email: String,
    val password: String,
    @SerializedName("password_confirmation")
    val password_confirmation: String
)

data class RegisterResp(
    val message: String,
    val token: String,
    val name: String,
    val role: String
)