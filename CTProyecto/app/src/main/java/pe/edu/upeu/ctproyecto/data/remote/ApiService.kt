package pe.edu.upeu.ctproyecto.data.remote

import pe.edu.upeu.ctproyecto.data.model.Categoria
import pe.edu.upeu.ctproyecto.data.model.CreateCategoriaRequest
import pe.edu.upeu.ctproyecto.data.model.CreateEmprendimientoRequest
import pe.edu.upeu.ctproyecto.data.model.CreateEmprendimientoUsuarioRequest
import pe.edu.upeu.ctproyecto.data.model.CreateTipoNegocioRequest
import pe.edu.upeu.ctproyecto.data.model.Emprendimiento
import pe.edu.upeu.ctproyecto.data.model.EmprendimientoUsuario
import pe.edu.upeu.ctproyecto.data.model.Evento
import pe.edu.upeu.ctproyecto.data.model.EventoRequest
import pe.edu.upeu.ctproyecto.data.model.LoginRequest
import pe.edu.upeu.ctproyecto.data.model.LoginResponse
import pe.edu.upeu.ctproyecto.data.model.RegisterRequest
import pe.edu.upeu.ctproyecto.data.model.RegisterResponse
import pe.edu.upeu.ctproyecto.data.model.Servicio
import pe.edu.upeu.ctproyecto.data.model.ServicioRequest
import pe.edu.upeu.ctproyecto.data.model.TipoNegocio
import pe.edu.upeu.ctproyecto.data.model.UpdateStatusRequest
import pe.edu.upeu.ctproyecto.data.model.User
import pe.edu.upeu.ctproyecto.data.model.ZonaTuristica
import pe.edu.upeu.ctproyecto.data.model.ZonaTuristicaRequest
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



    //zonas turisticas

    @GET("zonas-turisticas")
    suspend fun getZonasTuristicas(): Response<List<ZonaTuristica>>

    @GET("zonas-turisticas/{id}")
    suspend fun getZonaTuristicaById(@Path("id") id: Int): Response<ZonaTuristica>

    @POST("zonas-turisticas")
    suspend fun createZonaTuristica(@Body request: ZonaTuristicaRequest): Response<ZonaTuristica>

    @PUT("zonas-turisticas/{id}")
    suspend fun updateZonaTuristica(
        @Path("id") id: Int,
        @Body request: ZonaTuristicaRequest
    ): Response<ZonaTuristica>

    @DELETE("zonas-turisticas/{id}")
    suspend fun deleteZonaTuristica(@Path("id") id: Int): Response<Unit>


    @GET("servicios")
    suspend fun getServicios(): Response<List<Servicio>>

    @GET("servicios/{id}")
    suspend fun getServicioById(@Path("id") id: Int): Response<Servicio>

    @POST("servicios")
    suspend fun createServicio(@Body request: ServicioRequest): Response<Servicio>

    @PUT("servicios/{id}")
    suspend fun updateServicio(@Path("id") id: Int, @Body request: ServicioRequest): Response<Servicio>

    @DELETE("servicios/{id}")
    suspend fun deleteServicio(@Path("id") id: Int): Response<Unit>


    @GET("eventos")
    suspend fun getEventos(): Response<List<Evento>>

    @GET("eventos/{id}")
    suspend fun getEventoById(@Path("id") id: Int): Response<Evento>

    @POST("eventos")
    suspend fun createEvento(@Body request: EventoRequest): Response<Evento>

    @PUT("eventos/{id}")
    suspend fun updateEvento(@Path("id") id: Int, @Body request: EventoRequest): Response<Evento>

    @DELETE("eventos/{id}")
    suspend fun deleteEvento(@Path("id") id: Int): Response<Unit>


    @GET("emprendimiento-usuario")
    suspend fun listEmprendimientoUsuarios(): Response<List<EmprendimientoUsuario>>

    @POST("emprendimiento-usuario")
    suspend fun createEmprendimientoUsuario(
        @Body request: CreateEmprendimientoUsuarioRequest // Asegúrate de usar el modelo correcto aquí
    ): Response<Unit> // Cambia el tipo de respuesta según lo que espera tu API

    @GET("emprendimiento-usuario/{id}")
    suspend fun getEmprendimientoUsuarioById(
        @Path("id") id: Int
    ): Response<EmprendimientoUsuario>

    @PUT("emprendimiento-usuario/{id}")
    suspend fun updateEmprendimientoUsuario(
        @Path("id") id: Int,
        @Body emprendimientoUsuario: EmprendimientoUsuario
    ): Response<EmprendimientoUsuario>

    @DELETE("emprendimiento-usuario/{id}")
    suspend fun deleteEmprendimientoUsuario(
        @Path("id") id: Int
    ): Response<Unit>

    @GET("productores-libres")
    suspend fun getUsuariosProductoresLibres(): Response<List<User>>

    @GET("emprendimientos-libres")
    suspend fun getEmprendimientosLibres(): Response<List<Emprendimiento>>


}
