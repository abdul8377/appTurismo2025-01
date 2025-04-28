package pe.edu.upeu.ctproyecto.data.model

data class CreateEmprendimientoRequest(
    val nombre: String,
    val descripcion: String?,
    val id_tipo_negocio: Int,
    val direccion: String?,
    val telefono: String?,
    val estado: String
)