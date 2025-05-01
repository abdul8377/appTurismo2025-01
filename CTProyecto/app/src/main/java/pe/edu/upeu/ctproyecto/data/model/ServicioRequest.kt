package pe.edu.upeu.ctproyecto.data.model

data class ServicioRequest(
    val id_emprendimiento: Int,
    val nombre_servicio: String,
    val descripcion: String?,
    val precio: Double,
    val ubicacion: String?,
    val fecha_inicio: String?,
    val fecha_fin: String?,
    val estado: String?
)