package pe.edu.upeu.ctproyecto.data.local

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import androidx.datastore.preferences.core.emptyPreferences

class DataStoreManager(private val context: Context) {

    companion object {
        private val Context.dataStore by preferencesDataStore("user_prefs")
        val TOKEN_KEY = stringPreferencesKey("user_token")
        val NAME_KEY = stringPreferencesKey("user_name")
        val ROLE_KEY = stringPreferencesKey("user_role")
    }

    // Guarda los datos del usuario en DataStore
    suspend fun saveUserData(token: String, name: String, role: String) {
        context.dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = token
            preferences[NAME_KEY] = name
            preferences[ROLE_KEY] = role
        }
    }

    // Obtiene el token guardado
    fun getToken(): Flow<String?> {
        return context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences()) // Emitir preferencias vacías si hay error
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[TOKEN_KEY]
            }
    }

    // Obtiene el nombre guardado
    fun getName(): Flow<String?> {
        return context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[NAME_KEY]
            }
    }

    // Obtiene el rol guardado
    fun getRole(): Flow<String?> {
        return context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[ROLE_KEY]
            }
    }

    // Limpia todos los datos del usuario (para logout)
    suspend fun clearUserData() {
        context.dataStore.edit { preferences ->
            preferences.remove(TOKEN_KEY)
            preferences.remove(NAME_KEY)
            preferences.remove(ROLE_KEY)
        }
    }
}
