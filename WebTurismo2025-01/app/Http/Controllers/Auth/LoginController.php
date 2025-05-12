<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Auth\Events\Lockout;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\RateLimiter;
use Illuminate\Support\Facades\Session;
use Illuminate\Support\Str;
use Illuminate\Validation\ValidationException;

class LoginController extends Controller
{
    /**
     * Paso 1: Mostrar el formulario para ingresar el nombre de usuario.
     */
    public function showUserForm()
    {
        return view('auth.login-step1'); // Debes crear esta vista
    }

    /**
     * Paso 1: Validar que el usuario existe y redirigir al paso 2.
     */
    public function validateUser(Request $request)
    {
        $request->validate([
            'user' => 'required|string',
        ]);

        $user = User::where('user', $request->input('user'))->first();

        if (!$user) {
            return back()->withErrors(['user' => 'El usuario no fue encontrado.'])->withInput();
        }

        return redirect()->route('login.password', ['user' => $user->user]);
    }

    /**
     * Paso 2: Mostrar formulario de bienvenida y contraseña.
     */
    public function showPasswordForm($user)
    {
        $userRecord = User::where('user', $user)->firstOrFail();
        return view('auth.login-step2', compact('userRecord'));
    }

    /**
     * Paso 2: Autenticar usando nombre de usuario y contraseña.
     */
    public function authenticate(Request $request, $user)
    {
        $request->validate([
            'password' => 'required|string',
        ]);

        $request->merge(['user' => $user]);

        $this->ensureIsNotRateLimited($request);

        if (!Auth::attempt(['user' => $user, 'password' => $request->input('password')], $request->filled('remember'))) {
            RateLimiter::hit($this->throttleKey($request));

            return back()->withErrors(['password' => 'Contraseña incorrecta.']);
        }

        RateLimiter::clear($this->throttleKey($request));
        $request->session()->regenerate();

        return redirect()->intended(route('dashboard'));
    }

    /**
     * Logout.
     */
    public function logout(Request $request)
    {
        Auth::logout();
        $request->session()->invalidate();
        $request->session()->regenerateToken();
        return redirect()->route('login');
    }

    /**
     * Control de intentos fallidos (rate limiting).
     */
    protected function ensureIsNotRateLimited(Request $request): void
    {
        if (!RateLimiter::tooManyAttempts($this->throttleKey($request), 5)) {
            return;
        }

        event(new Lockout($request));

        $seconds = RateLimiter::availableIn($this->throttleKey($request));

        throw ValidationException::withMessages([
            'user' => __('auth.throttle', [
                'seconds' => $seconds,
                'minutes' => ceil($seconds / 60),
            ]),
        ]);
    }

    /**
     * Clave única de intento por usuario/IP.
     */
    protected function throttleKey(Request $request): string
    {
        return Str::lower($request->input('user')) . '|' . $request->ip();
    }
}
