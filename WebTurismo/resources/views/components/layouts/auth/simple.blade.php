
{{-- en esta parde se ve el login modificaciones aqui 1.1 --}}


{{-- auth.blade.php --}}

<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}" class="dark h-full">
    <head>
        @include('partials.head')
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            html, body {
                margin: 0;
                padding: 0;
                height: 100%;
                overflow: hidden;
            }
        </style>
    </head>
    <body class="h-full bg-white antialiased dark:bg-gradient-to-b dark:from-neutral-950 dark:to-neutral-900">

        <div class="w-full h-full flex flex-col items-center justify-center px-4 py-8">
            <div class="w-full max-w-md sm:max-w-lg md:max-w-xl lg:max-w-2xl xl:max-w-3xl flex flex-col gap-6">

                {{-- Accesibilidad: Nombre oculto --}}
                <a href="{{ route('home') }}" class="sr-only" wire:navigate>
                    {{ config('app.name', 'Laravel') }}
                </a>

                {{-- Contenido dinámico --}}
                <div class="w-full bg-white dark:bg-stone-950 shadow-md rounded-lg p-6 sm:p-8">
                    {{ $slot }}
                </div>

            </div>
        </div>

        @fluxScripts
    </body>
</html>
