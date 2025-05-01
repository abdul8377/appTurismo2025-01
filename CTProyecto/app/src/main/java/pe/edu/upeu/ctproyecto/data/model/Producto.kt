package pe.edu.upeu.ctproyecto.data.model

import com.google.gson.annotations.SerializedName

data class Producto(
    @SerializedName("id_producto") val id: Int,
    val nombre_producto: String,
    val descripcion: String?,
    val precio: Double,
    val stock: Int,
    val estado: String,
    val imagen_url: String?,
    val id_categoria: Int,
    val id_emprendimiento: Int
)
