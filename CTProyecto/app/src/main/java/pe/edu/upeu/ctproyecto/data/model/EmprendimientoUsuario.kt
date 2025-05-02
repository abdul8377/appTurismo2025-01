package pe.edu.upeu.ctproyecto.data.model

import com.google.gson.annotations.SerializedName

data class EmprendimientoUsuario(
    @SerializedName("id_emprendimiento") val idEmprendimiento: Int,
    @SerializedName("id_usuario") val idUsuario: Int,
    @SerializedName("rol_emprendimiento") val rolEmprendimiento: String,
    val fechaAsignacion: String
)
