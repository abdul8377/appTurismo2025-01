package pe.edu.upeu.ctproyecto.data.model

import com.google.gson.annotations.SerializedName

data class Servicio(
    @SerializedName("id_servicio") val id: Int,
    val id_emprendimiento: Int,
    val nombre_servicio: String,
    val descripcion: String?,
    val precio: Double,
    val ubicacion: String?,
    val fecha_inicio: String?,
    val fecha_fin: String?,
    val estado: String
)