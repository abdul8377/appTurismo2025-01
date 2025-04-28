package pe.edu.upeu.ctproyecto.data.remote

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import pe.edu.upeu.ctproyecto.data.local.DataStoreManager

object RetrofitClient {
    private const val BASE_URL = "http://192.168.1.2:8000/api/"

    private lateinit var getToken: suspend () -> String?

    fun init(getTokenFunction: suspend () -> String?) {
        getToken = getTokenFunction
    }

    private val authInterceptor = Interceptor { chain ->
        val originalRequest: Request = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("Accept", "application/json") // Muy importante

        val token = runBlocking { getToken() }
        if (!token.isNullOrEmpty()) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }
        chain.proceed(requestBuilder.build())
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client) // Usa nuestro cliente personalizado
        .build()

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}