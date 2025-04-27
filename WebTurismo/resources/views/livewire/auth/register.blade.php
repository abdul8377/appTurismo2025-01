<?php

use App\Models\User;
use Illuminate\Auth\Events\Registered;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use Illuminate\Validation\Rules;
use Livewire\Attributes\Layout;
use Livewire\Volt\Component;

new #[Layout('components.layouts.auth')] class extends Component {
    public string $name = '';
    public string $email = '';
    public string $password = '';
    public string $password_confirmation = '';

    /**
     * Handle an incoming registration request.
     */
    public function register(): void
    {
        $validated = $this->validate([
            'name' => ['required', 'string', 'max:255'],
            'email' => ['required', 'string', 'email', 'max:255', 'unique:' . User::class],
            'password' => ['required', 'string', 'confirmed', Rules\Password::defaults()],
        ]);

        // Normaliza el correo a minúsculas
        $validated['email'] = strtolower($validated['email']);

        // Hashea la contraseña
        $validated['password'] = Hash::make($validated['password']);

        // Crea el usuario y dispara el evento
        $user = User::create($validated);
        event(new Registered($user));

        // Inicia sesión
        Auth::login($user);

        // Redirige al dashboard
        $this->redirectIntended(route('dashboard', absolute: false), navigate: true);
    }
}; ?>

<div class="min-h-[100dvh] flex items-center justify-center bg-[url('https://i.pinimg.com/236x/74/61/08/7461085637cc106c5465711c31241f8f.jpg')] bg-cover bg-center bg-no-repeat px-4 py-12">
    <div class="w-full max-w-md sm:max-w-lg bg-white/90 dark:bg-stone-950/90 backdrop-blur-md rounded-xl shadow-lg p-6 sm:p-8 space-y-6">

        {{-- Título --}}
        <x-auth-header :title="__('Create an account')" :description="__('Enter your details below to create your account')" />

        {{-- Estado de sesión --}}
        <x-auth-session-status class="text-center" :status="session('status')" />

        {{-- Formulario --}}
        <form wire:submit="register" class="flex flex-col gap-6 text-base">

            <flux:input
                wire:model="name"
                :label="__('Name')"
                type="text"
                required
                autofocus
                autocomplete="name"
                :placeholder="__('Full name')"
            />

            <flux:input
                wire:model="email"
                :label="__('Email address')"
                type="email"
                required
                autocomplete="email"
                placeholder="email@example.com"
            />

            <flux:input
                wire:model="password"
                :label="__('Password')"
                type="password"
                name="password"
                required
                autocomplete="new-password"
                :placeholder="__('Password')"
            >
                <template #append>
                    <button type="button" class="text-sm text-gray-500 dark:text-gray-400" onclick="toggleVisibility('password')">👁️</button>
                </template>
            </flux:input>

            <flux:input
                wire:model="password_confirmation"
                :label="__('Confirm password')"
                type="password"
                name="password_confirmation"
                required
                autocomplete="new-password"
                :placeholder="__('Confirm password')"
            >
                <template #append>
                    <button type="button" class="text-sm text-gray-500 dark:text-gray-400" onclick="toggleVisibility('password_confirmation')">👁️</button>
                </template>
            </flux:input>

            <div class="flex items-center justify-end">
                <flux:button type="submit" variant="primary" class="w-full">
                    {{ __('Create account') }}
                </flux:button>
            </div>
        </form>

        <div class="text-center text-sm text-zinc-600 dark:text-zinc-400">
            {{ __('Already have an account?') }}
            <flux:link :href="route('login')" wire:navigate class="text-yellow-600 font-semibold hover:underline dark:text-yellow-400">
                {{ __('Log in') }}
            </flux:link>
        </div>

        {{-- Divider --}}
        <div class="flex items-center gap-2 my-4">
            <hr class="flex-grow border-t border-gray-300 dark:border-stone-700">
            <span class="text-xs text-gray-500 dark:text-gray-400">OR</span>
            <hr class="flex-grow border-t border-gray-300 dark:border-stone-700">
        </div>

        {{-- Botón de Google --}}
        <a href="{{ route('google.redirect') }}"
            class="w-full flex items-center justify-center gap-2 bg-white border border-gray-300 hover:bg-gray-50 dark:bg-stone-800 dark:border-stone-700 dark:hover:bg-stone-700 text-sm text-gray-700 dark:text-gray-100 font-medium py-2 px-4 rounded-md transition">
            <img src="https://www.svgrepo.com/show/475656/google-color.svg" alt="Google" class="w-5 h-5">
            Continue with Google
        </a>

        {{-- Botón de Facebook --}}
<a href="{{ route('facebook.redirect') }}"
    class="w-full flex items-center justify-center gap-2 bg-blue-600 hover:bg-blue-700 text-sm text-white font-medium py-2 px-4 rounded-md transition">
    <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 24 24">
        <path
            d="M22.676 0H1.324C.593 0 0 .593 0 1.324v21.352C0 23.407.593 24 1.324 24h11.49v-9.294H9.692v-3.622h3.122V8.413c0-3.1 1.894-4.788 4.659-4.788 1.325 0 2.464.099 2.796.143v3.24l-1.918.001c-1.504 0-1.796.715-1.796 1.763v2.31h3.587l-.467 3.622h-3.12V24h6.116C23.407 24 24 23.407 24 22.676V1.324C24 .593 23.407 0 22.676 0"
        />
    </svg>
    Continue with Facebook
</a>


    </div>
</div>

<script>
    function toggleVisibility(id) {
        const input = document.querySelector(`input[name='${id}']`);
        if (input) {
            input.type = input.type === 'password' ? 'text' : 'password';
        }
    }
</script>
