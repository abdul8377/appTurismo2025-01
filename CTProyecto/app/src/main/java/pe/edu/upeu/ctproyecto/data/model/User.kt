package pe.edu.upeu.ctproyecto.data.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val roles: List<String>,
    val created_at: String,
    val updated_at: String,
    val is_active: Boolean,
    val motivo_inactivo: String?
)