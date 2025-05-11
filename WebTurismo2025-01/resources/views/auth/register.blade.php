<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Crear una cuenta - {{ config('app.name') }}</title>

    <link rel="icon" href="/favicon.ico" sizes="any">
    <link rel="icon" href="/favicon.svg" type="image/svg+xml">
    <link rel="apple-touch-icon" href="/apple-touch-icon.png">

    <link rel="preconnect" href="https://fonts.bunny.net">
    <link href="https://fonts.bunny.net/css?family=instrument-sans:400,500,600" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" crossorigin="anonymous" referrerpolicy="no-referrer" />

    @vite(['resources/css/app.css', 'resources/js/app.js'])
    @livewireStyles
</head>
<body class="bg-gray-100 dark:bg-zinc-900 min-h-screen flex items-center justify-center">
<div class="max-w-md mx-auto mt-10 space-y-6 bg-white dark:bg-zinc-800 p-8 rounded shadow">
    <h2 class="text-2xl font-bold text-center text-gray-800 dark:text-white">Crear una cuenta</h2>

    @if ($errors->any())
        <div class="bg-red-100 border border-red-400 text-red-700 p-3 rounded">
            <ul class="list-disc list-inside text-sm">
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif

    <form method="POST" action="{{ route('register') }}" class="space-y-4">
        @csrf

        <div>
            <label for="name" class="block font-medium text-gray-700 dark:text-gray-200">Nombre</label>
            <input id="name" type="text" name="name" value="{{ old('name') }}" required autofocus
                class="w-full px-4 py-2 border rounded focus:outline-none focus:ring focus:ring-blue-300">
        </div>

        <div>
            <label for="last_name" class="block font-medium text-gray-700 dark:text-gray-200">Apellido</label>
            <input id="last_name" type="text" name="last_name" value="{{ old('last_name') }}" required
                class="w-full px-4 py-2 border rounded focus:outline-none focus:ring focus:ring-blue-300">
        </div>

        <div>
            <label for="user" class="block font-medium text-gray-700 dark:text-gray-200">Nombre de usuario</label>
            <input id="user" type="text" name="user" value="{{ old('user') }}" required
                class="w-full px-4 py-2 border rounded focus:outline-none focus:ring focus:ring-blue-300">
        </div>

        <div>
            <label for="email" class="block font-medium text-gray-700 dark:text-gray-200">Correo electrónico</label>
            <input id="email" type="email" name="email" value="{{ old('email') }}" required
                class="w-full px-4 py-2 border rounded focus:outline-none focus:ring focus:ring-blue-300">
        </div>

        <div>
            <label for="zip_code" class="block font-medium text-gray-700 dark:text-gray-200">Código Postal</label>
            <input id="zip_code" type="text" name="zip_code" value="{{ old('zip_code') }}"
                class="w-full px-4 py-2 border rounded focus:outline-none focus:ring focus:ring-blue-300">
        </div>

        <div>
            <label for="country" class="block font-medium text-gray-700 dark:text-gray-200">País</label>
            <select name="country" id="country" required
                class="w-full px-4 py-2 border rounded focus:outline-none focus:ring focus:ring-blue-300">
                <option value="">Seleccione un país</option>
                @foreach ($countries as $code => $name)
                    <option value="{{ $code }}" {{ old('country') == $code ? 'selected' : '' }}>
                        {{ $name }}
                    </option>
                @endforeach
            </select>
        </div>

        <div>
            <label for="password" class="block font-medium text-gray-700 dark:text-gray-200">Contraseña</label>
            <input id="password" type="password" name="password" required
                class="w-full px-4 py-2 border rounded focus:outline-none focus:ring focus:ring-blue-300">
        </div>

        <div>
            <label for="password_confirmation" class="block font-medium text-gray-700 dark:text-gray-200">Confirmar contraseña</label>
            <input id="password_confirmation" type="password" name="password_confirmation" required
                class="w-full px-4 py-2 border rounded focus:outline-none focus:ring focus:ring-blue-300">
        </div>

        <button type="submit"
            class="w-full bg-blue-600 hover:bg-blue-700 text-white font-medium py-2 px-4 rounded transition duration-200">
            Crear cuenta
        </button>
    </form>

    <div class="text-center text-sm text-gray-600 dark:text-gray-400">
        ¿Ya tienes una cuenta?
        <a href="{{ route('login') }}" class="text-blue-600 hover:underline">Iniciar sesión</a>
    </div>
</div>

@livewireScripts
</body>
</html>
