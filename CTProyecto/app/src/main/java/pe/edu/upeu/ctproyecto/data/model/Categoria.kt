package pe.edu.upeu.ctproyecto.data.model

import com.google.gson.annotations.SerializedName

data class Categoria(
    @SerializedName("id_categoria") val id: Int,
    val nombre_categoria: String,
    val descripcion: String?,

)
