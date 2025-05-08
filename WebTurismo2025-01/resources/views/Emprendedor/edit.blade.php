<x-layouts.app :title="__('Editar Emprendedor')">
    <div class="max-w-2xl mx-auto mt-8 bg-white dark:bg-neutral-900 p-6 rounded-lg shadow">

        <!-- Título -->
        <h2 class="text-2xl font-semibold text-gray-800 dark:text-white mb-6">Editar Emprendedor: {{ $emprendedor->name }}</h2>

        <!-- Formulario para Editar Usuario (Solo Contraseña) -->
        <form action="{{ route('emprendedores.update', $emprendedor) }}" method="POST" class="space-y-5">
            @csrf
            @method('PUT')

            <!-- Nombre de Usuario (solo lectura) -->
            <div>
                <label for="name" class="block text-sm font-medium text-gray-700 dark:text-gray-300">Nombre de Usuario</label>
                <input type="text" name="name" id="name" value="{{ old('name', $emprendedor->name) }}"
                    class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:ring-blue-500 focus:border-blue-500 dark:bg-neutral-800 dark:border-neutral-700 dark:text-white"
                    readonly>
            </div>

            <!-- Correo Electrónico (solo lectura) -->
            <div>
                <label for="email" class="block text-sm font-medium text-gray-700 dark:text-gray-300">Correo Electrónico</label>
                <input type="email" name="email" id="email" value="{{ old('email', $emprendedor->email) }}"
                    class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:ring-blue-500 focus:border-blue-500 dark:bg-neutral-800 dark:border-neutral-700 dark:text-white"
                    readonly>
            </div>

            <!-- Contraseña -->
            <div>
                <label for="password" class="block text-sm font-medium text-gray-700 dark:text-gray-300">Contraseña (Opcional)</label>
                <input type="password" name="password" id="password" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:ring-blue-500 focus:border-blue-500 dark:bg-neutral-800 dark:border-neutral-700 dark:text-white">
                @error('password')
                    <p class="text-sm text-red-600 mt-1">{{ $message }}</p>
                @enderror
            </div>

            <!-- Confirmar Contraseña -->
            <div>
                <label for="password_confirmation" class="block text-sm font-medium text-gray-700 dark:text-gray-300">Confirmar Contraseña (Opcional)</label>
                <input type="password" name="password_confirmation" id="password_confirmation"
                    class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:ring-blue-500 focus:border-blue-500 dark:bg-neutral-800 dark:border-neutral-700 dark:text-white">
            </div>

            <hr class="my-6 border-gray-300 dark:border-neutral-700">

            <!-- Perfil del Emprendedor -->
            <h3 class="text-lg font-semibold text-gray-800 dark:text-white mb-4">Perfil del Emprendedor</h3>

            <!-- DNI -->
            <div>
                <label for="dni" class="block text-sm font-medium text-gray-700 dark:text-gray-300">DNI</label>
                <input type="text" name="dni" id="dni" value="{{ old('dni', $emprendedor->perfilEmprendedor->dni) }}"
                    class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:ring-blue-500 focus:border-blue-500 dark:bg-neutral-800 dark:border-neutral-700 dark:text-white"
                    readonly>
            </div>

            <!-- Teléfono de Contacto -->
            <div>
                <label for="telefono_contacto" class="block text-sm font-medium text-gray-700 dark:text-gray-300">Teléfono de Contacto</label>
                <input type="text" name="telefono_contacto" id="telefono_contacto" value="{{ old('telefono_contacto', $emprendedor->perfilEmprendedor->telefono_contacto) }}"
                    class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:ring-blue-500 focus:border-blue-500 dark:bg-neutral-800 dark:border-neutral-700 dark:text-white" readonly>
            </div>

            <!-- Gmail de Contacto -->
            <div>
                <label for="gmail_contacto" class="block text-sm font-medium text-gray-700 dark:text-gray-300">Correo Gmail de Contacto</label>
                <input type="email" name="gmail_contacto" id="gmail_contacto" value="{{ old('gmail_contacto', $emprendedor->perfilEmprendedor->gmail_contacto) }}"
                    class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:ring-blue-500 focus:border-blue-500 dark:bg-neutral-800 dark:border-neutral-700 dark:text-white" readonly>
            </div>

            <!-- Experiencia -->
            <div>
                <label for="experiencia" class="block text-sm font-medium text-gray-700 dark:text-gray-300">Experiencia</label>
                <textarea name="experiencia" id="experiencia" rows="3"
                    class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:ring-blue-500 focus:border-blue-500 dark:bg-neutral-800 dark:border-neutral-700 dark:text-white" readonly>{{ old('experiencia', $emprendedor->perfilEmprendedor->experiencia) }}</textarea>
            </div>

            <!-- Botones -->
            <div class="flex justify-between">
                <a href="{{ route('emprendedores.index') }}"
                   class="inline-flex items-center px-4 py-2 bg-gray-200 dark:bg-neutral-700 text-gray-800 dark:text-white text-sm font-medium rounded-md hover:bg-gray-300">
                    Cancelar
                </a>
                <button type="submit"
                        class="inline-flex items-center px-4 py-2 bg-blue-600 text-white text-sm font-medium rounded-md hover:bg-blue-700">
                    Guardar Cambios
                </button>
            </div>
        </form>
    </div>
</x-layouts.app>
