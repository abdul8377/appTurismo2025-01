package pe.edu.upeu.ctproyecto.data.model

data class CreateEmprendimientoUsuarioRequest(
    val id_emprendimiento: Int,
    val id_usuario: Int,
    val rol_emprendimiento: String,
)
