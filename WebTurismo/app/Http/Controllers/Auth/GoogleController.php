<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Support\Facades\Auth;
use Laravel\Socialite\Facades\Socialite;

class GoogleController extends Controller
{
    /**
     * Redirecciona al usuario a Google para autenticarse.
     */
    public function redirect()
    {
        return Socialite::driver('google')->redirect();
    }

    /**
     * Maneja la respuesta de Google después de autenticarse.
     */
    public function callback()
    {
        try {
            $googleUser = Socialite::driver('google')->user();

            // Crear o actualizar usuario por email
            $user = User::updateOrCreate(
                ['email' => $googleUser->getEmail()],
                [
                    'name' => $googleUser->getName() ?? $googleUser->getNickname(),
                    'password' => bcrypt(uniqid()) // Genera una contraseña aleatoria segura
                ]
            );

            // Asigna el rol "Usuario" si no lo tiene aún
            if (!$user->hasRole('Usuario')) {
                $user->assignRole('Usuario');
            }

            // Inicia sesión con el usuario
            Auth::login($user);

            return redirect()->intended(route('dashboard'));

       } catch (\Exception $e) {
            return redirect()->route('login')->withErrors([
                'google_error' => 'Error al iniciar sesión con Google: ' . $e->getMessage()
            ]);
        }
    }

}
