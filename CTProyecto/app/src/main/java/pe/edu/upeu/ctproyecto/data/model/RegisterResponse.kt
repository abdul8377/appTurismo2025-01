package pe.edu.upeu.ctproyecto.data.model

data class RegisterResponse(
    val message: String,
    val token: String,
    val name: String,
    val role: String
)
