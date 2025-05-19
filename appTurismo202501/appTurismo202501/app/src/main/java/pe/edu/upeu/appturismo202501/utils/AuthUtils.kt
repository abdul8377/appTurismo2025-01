package pe.edu.upeu.appturismo202501.utils

import pe.edu.upeu.sysventasjpc.utils.TokenUtils

object AuthUtils {
    fun isAuthenticated(): Boolean {
        return TokenUtils.TOKEN_CONTENT.isNotEmpty()
    }
}