package pe.edu.upeu.ctproyecto.data.model

import com.google.gson.annotations.SerializedName

data class Emprendimiento(
    @SerializedName("id_emprendimiento") val id: Int, // <- Así mapeas correctamente
    val nombre: String,
    val descripcion: String?,
    val id_tipo_negocio: Int,
    val direccion: String?,
    val telefono: String?,
    val estado: String
)