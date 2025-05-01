package pe.edu.upeu.ctproyecto.data.model

import com.google.gson.annotations.SerializedName

data class ZonaTuristica(
    @SerializedName("id_zona") val id: Int,
    val nombre: String,
    val descripcion: String?,
    val ubicacion: String?,
    val imagen_url: String?,
    val estado: String
)