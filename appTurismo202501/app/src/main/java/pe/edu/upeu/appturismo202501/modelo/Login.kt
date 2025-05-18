package pe.edu.upeu.appturismo202501.modelo

data class LoginDto(
    val email_or_gmail: String,
    val password: String
)

data class LoginResp(
    val token: String,
    val name: String,
    val email: String,
    val role: String,
    val is_active: Boolean,
    val motivo_inactivo: String?,
    val email_or_gmail: String,
    val password: String
)