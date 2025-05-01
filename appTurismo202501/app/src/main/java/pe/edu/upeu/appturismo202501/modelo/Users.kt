package pe.edu.upeu.appturismo202501.modelo

data class UsersDto(
    val id: Long,
    val name: String,
    val email: String,
    val roles: Long,
    val is_active: Boolean,
    val motivo_inactivo: String?,
    val created_at: String,
    val updated_at: String,
)



data class UserResp(
    val id: Long,
    val name: String,
    val email: String,
    val roles: Roles,
    val is_active: Boolean,
    val motivo_inactivo: String?,
    val created_at: String,
    val updated_at: String,
)

fun UserResp.toDto(): UsersDto {
    return UsersDto(
        id = this.id,
        name = this.name,
        email = this.email,
        roles = this.roles.id,
        is_active = this.is_active,
        motivo_inactivo = this.motivo_inactivo,
        created_at = this.created_at,
        updated_at = this.updated_at
    )
}