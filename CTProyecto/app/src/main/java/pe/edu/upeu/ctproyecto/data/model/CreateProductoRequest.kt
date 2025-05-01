package pe.edu.upeu.ctproyecto.data.model

data class CreateProductoRequest(
    val nombre_producto: String,
    val descripcion: String?,
    val precio: Double,
    val stock: Int,
    val estado: String,
    val imagen_url: String?,
    val id_categoria: Int,
    val id_emprendimiento: Int
)
