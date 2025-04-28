package pe.edu.upeu.ctproyecto.data.model

data class UpdateStatusRequest(
    val is_active: Boolean,
    val motivo_inactivo: String? = null
)