package pe.edu.upeu.ctproyecto.data.model

import com.google.gson.annotations.SerializedName

data class Evento(
    @SerializedName("id") val id: Int,
    val titulo: String,
    val descripcion: String? = null,
    val fecha_inicio: String,
    val fecha_fin: String,
    val lugar: String? = null,
    val estado: String
)