package pe.edu.upeu.ctproyecto.data.model

data class EventoRequest(
    val titulo: String,
    val descripcion: String?,
    val fecha_inicio: String,
    val fecha_fin: String,
    val lugar: String?,
    val estado: String
)