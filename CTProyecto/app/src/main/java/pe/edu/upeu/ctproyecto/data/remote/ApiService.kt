package pe.edu.upeu.ctproyecto.data.remote

import pe.edu.upeu.ctproyecto.data.model.Categoria
import pe.edu.upeu.ctproyecto.data.model.CreateCategoriaRequest
import pe.edu.upeu.ctproyecto.data.model.CreateEmprendimientoRequest
import pe.edu.upeu.ctproyecto.data.model.CreateTipoNegocioRequest
import pe.edu.upeu.ctproyecto.data.model.Emprendimiento
import pe.edu.upeu.ctproyecto.data.model.LoginRequest
import pe.edu.upeu.ctproyecto.data.model.LoginResponse
import pe.edu.upeu.ctproyecto.data.model.RegisterRequest
import pe.edu.upeu.ctproyecto.data.model.RegisterResponse
import pe.edu.upeu.ctproyecto.data.model.TipoNegocio
import pe.edu.upeu.ctproyecto.data.model.UpdateStatusRequest
import pe.edu.upeu.ctproyecto.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>



    @GET("users")
    suspend fun listUsers(): Response<List<User>>

    @POST("users")
    suspend fun createUser(@Body user: Map<String, String>): Response<User>

    @PUT("users/{id}/status")
    suspend fun updateStatus(
        @Path("id") id: Int,
        @Body status: UpdateStatusRequest
    ): Response<Map<String, Any>>

    @PUT("users/{id}")
    suspend fun updateUser(
        @Path("id") id: Int,
        @Body user: Map<String, String>
    ): Response<User>

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") id: Int): Response<Unit>


    // Obtener un usuario por ID (para prellenar EditUserScreen)
    @GET("users/{id}")
    suspend fun getUserById(
        @Path("id") id: Int
    ): Response<User>

    // Listar todos los roles disponibles (para el ComboBox)
    @GET("roles")
    suspend fun getRoles(): Response<List<String>>



    //emprendimientos

    @GET("emprendimientos")
    suspend fun listEmprendimientos(): Response<List<Emprendimiento>>

    @POST("emprendimientos")
    suspend fun createEmprendimiento(
        @Body emprendimiento: CreateEmprendimientoRequest
    ): Response<Emprendimiento>

    @GET("emprendimientos/{id}")
    suspend fun getEmprendimientoById(
        @Path("id") id: Int
    ): Response<Emprendimiento>

    @PUT("emprendimientos/{id}")
    suspend fun updateEmprendimiento(
        @Path("id") id: Int,
        @Body body: Map<String, @JvmSuppressWildcards Any> // <- ESTA ES LA CORRECCIÓN
    ): Response<Any>

    @DELETE("emprendimientos/{id}")
    suspend fun deleteEmprendimiento(
        @Path("id") id: Int
    ): Response<Unit>


    //tipo-negocio


    @POST("tipos-negocio")
    suspend fun createTipoNegocio(@Body request: CreateTipoNegocioRequest): Response<TipoNegocio>

    @GET("tipos-negocio/{id}")
    suspend fun getTipoNegocioById(@Path("id") id: Int): Response<TipoNegocio>

    @PUT("tipos-negocio/{id}")
    suspend fun updateTipoNegocio(
        @Path("id") id: Int,
        @Body request: CreateTipoNegocioRequest  // Enviar el request con el nuevo nombre
    ): Response<TipoNegocio>

    @DELETE("tipos-negocio/{id}")
    suspend fun deleteTipoNegocio(@Path("id") id: Int): Response<Unit>

    @GET("tipos-negocio")
    suspend fun getTiposNegocio(): Response<List<TipoNegocio>>

    // Categorias
    @GET("categorias")
    suspend fun listCategorias(): Response<List<Categoria>>

    @POST("categorias")
    suspend fun createCategoria(
        @Body categoria: CreateCategoriaRequest
    ): Response<Categoria>

    @GET("categorias/{id}")
    suspend fun getCategoriaById(
        @Path("id") id: Int
    ): Response<Categoria>

    @PUT("categorias/{id}")
    suspend fun updateCategoria(
        @Path("id") id: Int,
        @Body body: Map<String, @JvmSuppressWildcards Any>
    ): Response<Any>


    @DELETE("categorias/{id}")
    suspend fun deleteCategoria(
        @Path("id") id: Int
    ): Response<Unit>


}
