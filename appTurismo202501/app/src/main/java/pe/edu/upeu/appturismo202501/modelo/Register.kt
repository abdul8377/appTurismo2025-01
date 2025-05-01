package pe.edu.upeu.appturismo202501.modelo

data class RegisterDto (
    val name: String,
    val email: String,
    val password:String,
    val password_confirmation: String
)


data class RegisterResp (
    val name: String,
    val email: String,
    val password:String,
    val password_confirmation: String
)