package pe.edu.upeu.ctproyecto.data.model

data class LoginResponse(
    val token: String,
    val name: String,
    val email: String,
    val role: String,
    val is_active: Boolean,
    val motivo_inactivo: String?
)
