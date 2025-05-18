package pe.edu.upeu.appturismo202501.modelo

data class CategoryDto(
    val id: Long,
    val nombre: String,
    val descripcion: String?,
    val imagen: String?,
    val icono: String?
)

data class CategoryResp(
    val id: Long,
    val nombre: String,
    val descripcion: String?,
    val imagen: String?,
    val icono: String?
)