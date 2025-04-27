{{-- aqui va el diseño de lo que va dentro 1.2 del login --}}

<?php

use Illuminate\Auth\Events\Lockout;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\RateLimiter;
use Illuminate\Support\Facades\Session;
use Illuminate\Support\Str;
use Illuminate\Validation\ValidationException;
use Livewire\Attributes\Layout;
use Livewire\Attributes\Validate;
use Livewire\Volt\Component;

return new #[Layout('components.layouts.auth')] class extends Component {
    #[Validate('required|string|email')]
    public string $email = '';

    #[Validate('required|string')]
    public string $password = '';

    public bool $remember = false;

    public function login(): void
    {
        $this->validate();

        $this->ensureIsNotRateLimited();

        if (! Auth::attempt(['email' => $this->email, 'password' => $this->password], $this->remember)) {
            RateLimiter::hit($this->throttleKey());

            throw ValidationException::withMessages([
                'email' => __('auth.failed'),
            ]);
        }

        RateLimiter::clear($this->throttleKey());
        Session::regenerate();

        $this->redirectIntended(route('dashboard'));
    }

    protected function ensureIsNotRateLimited(): void
    {
        if (! RateLimiter::tooManyAttempts($this->throttleKey(), 5)) {
            return;
        }

        event(new Lockout(request()));

        $seconds = RateLimiter::availableIn($this->throttleKey());

        throw ValidationException::withMessages([
            'email' => __('auth.throttle', [
                'seconds' => $seconds,
                'minutes' => ceil($seconds / 60),
            ]),
        ]);
    }

    protected function throttleKey(): string
    {
        return Str::transliterate(Str::lower($this->email) . '|' . request()->ip());
    }
};
?>

<!-- Contenedor general: ocupa el alto justo sin forzar scroll -->
<div class="w-full min-h-[100dvh] grid grid-cols-1 lg:grid-cols-2 overflow-hidden">

    <!-- 📸 Imagen izquierda en escritorio -->
    <div class="hidden lg:block h-full">
        <img
            src="https://www.inti.tv/wp-content/uploads/2015/02/Diez-cosas-que-un-turista-responsable-debe-saber-antes-de-emprender-su-viaje-1.jpg"
            alt="Login"
            class="object-cover w-full h-full"
        />
    </div>

    <!-- 🔐 Formulario -->
    <div class="flex items-center justify-center p-6 bg-white dark:bg-stone-900 overflow-hidden">
        <div class="w-full max-w-md sm:max-w-lg bg-white dark:bg-stone-950 rounded-xl shadow-md p-6 sm:p-8 space-y-6">

            <h2 class="text-2xl sm:text-3xl font-bold text-center text-gray-900 dark:text-white">Sign In</h2>

            <!-- ✅ ALERTA si hay sesión de bienvenida -->
            @if(session('google_welcome'))
                <div class="p-3 text-sm text-green-800 bg-green-100 border border-green-200 rounded">
                    {{ session('google_welcome') }}
                </div>
            @endif

            <!-- 🌐 Botón de Google -->
            <div class="flex justify-center">
                <a href="{{ url('/auth/google') }}"
                   class="flex items-center gap-3 border border-gray-300 dark:border-stone-700 rounded-md px-4 py-2 w-full justify-center hover:bg-gray-50 dark:hover:bg-stone-800 transition text-sm font-medium text-gray-800 dark:text-white">
                    <img src="https://www.svgrepo.com/show/475656/google-color.svg" alt="Google" class="w-5 h-5">
                    Sign in with Google
                </a>
            </div>

            <<!-- Botón de Facebook -->
<a href="{{ route('facebook.redirect') }}"
   class="flex items-center gap-3 border border-blue-600 text-blue-600 hover:bg-blue-50 dark:border-blue-500 dark:text-blue-400 dark:hover:bg-stone-800 rounded-md px-4 py-2 w-full justify-center transition text-sm font-medium">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/facebook/facebook-original.svg" alt="Facebook" class="w-5 h-5">
    Sign in with Facebook
</a>


            <!-- 🧾 Divider -->
            <div class="flex items-center gap-2 my-4">
                <hr class="flex-grow border-t border-gray-300 dark:border-stone-700">
                <span class="text-xs text-gray-500 dark:text-gray-400">OR</span>
                <hr class="flex-grow border-t border-gray-300 dark:border-stone-700">
            </div>

            <!-- Formulario -->
            <form wire:submit.prevent="login" class="space-y-5">
                <div>
                    <label for="email" class="block text-sm font-medium text-gray-700 dark:text-gray-300 uppercase">
                        Username
                    </label>
                    <input wire:model="email" type="email" id="email" placeholder="Enter your email"
                           class="w-full mt-2 p-3 rounded-md border border-gray-300 focus:ring-2 focus:ring-yellow-500 dark:bg-stone-900 dark:text-white" />
                    @error('email')
                        <p class="text-sm text-red-600 mt-1">{{ $message }}</p>
                    @enderror
                </div>

                <div>
                    <label for="password" class="block text-sm font-medium text-gray-700 dark:text-gray-300 uppercase">
                        Password
                    </label>
                    <input wire:model="password" type="password" id="password" placeholder="••••••••"
                           class="w-full mt-2 p-3 rounded-md border border-gray-300 focus:ring-2 focus:ring-yellow-500 dark:bg-stone-900 dark:text-white" />
                    @error('password')
                        <p class="text-sm text-red-600 mt-1">{{ $message }}</p>
                    @enderror
                </div>

                <div class="flex items-center justify-between text-sm">
                    <label class="flex items-center">
                        <input wire:model="remember" type="checkbox" class="form-checkbox text-yellow-500 w-4 h-4" />
                        <span class="ml-2 text-yellow-600 dark:text-yellow-400 font-medium">Remember Me</span>
                    </label>
                    @if (Route::has('password.request'))
                        <a href="{{ route('password.request') }}" class="text-gray-500 hover:underline dark:text-gray-300">
                            Forgot Password?
                        </a>
                    @endif
                </div>

                <button type="submit"
                        class="w-full bg-yellow-500 hover:bg-yellow-600 text-white font-bold py-3 rounded-md transition">
                    Sign In
                </button>
            </form>

            @if (Route::has('register'))
                <div class="text-center text-sm text-gray-600 dark:text-gray-400">
                    Not a member?
                    <a href="{{ route('register') }}" class="text-yellow-600 font-semibold hover:underline dark:text-yellow-400">
                        Sign Up
                    </a>
                </div>
            @endif

        </div>
    </div>
</div>


