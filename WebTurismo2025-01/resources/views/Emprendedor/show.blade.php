<x-layouts.app :title="__('Detalles del Emprendedor')">
    <div class="max-w-4xl mx-auto mt-8 bg-white dark:bg-neutral-900 p-6 rounded-lg shadow">

        <!-- Título -->
        <h2 class="text-2xl font-semibold text-gray-800 dark:text-white mb-6">Detalles de: {{ $emprendedor->name }}</h2>

        <!-- Detalles del Usuario -->
        <div class="mb-6">
            <h3 class="text-lg font-semibold text-gray-800 dark:text-white mb-2">Información del Usuario</h3>
            <p class="text-sm text-gray-600 dark:text-gray-300"><strong>Email:</strong> {{ $emprendedor->email }}</p>
            <p class="text-sm text-gray-600 dark:text-gray-300"><strong>Rol:</strong> {{ $emprendedor->getRoleNames()->first() }}</p>
        </div>

        <!-- Detalles del Perfil de Emprendedor -->
        <div>
            <h3 class="text-lg font-semibold text-gray-800 dark:text-white mb-2">Perfil del Emprendedor</h3>
            <p class="text-sm text-gray-600 dark:text-gray-300"><strong>DNI:</strong> {{ $emprendedor->perfilEmprendedor->dni }}</p>
            <p class="text-sm text-gray-600 dark:text-gray-300"><strong>Teléfono de Contacto:</strong> {{ $emprendedor->perfilEmprendedor->telefono_contacto ?? 'No disponible' }}</p>
            <p class="text-sm text-gray-600 dark:text-gray-300"><strong>Correo Gmail:</strong> {{ $emprendedor->perfilEmprendedor->gmail_contacto ?? 'No disponible' }}</p>
            <p class="text-sm text-gray-600 dark:text-gray-300"><strong>Experiencia:</strong> {{ $emprendedor->perfilEmprendedor->experiencia ?? 'No disponible' }}</p>
        </div>

        <!-- Estado de Validación -->
        <div class="mb-6">
            <h3 class="text-lg font-semibold text-gray-800 dark:text-white mb-2">Estado de Validación</h3>
            <form action="{{ route('emprendedores.updateStatus', $emprendedor) }}" method="POST" class="space-y-4">
                @csrf
                @method('PUT')
                <div class="flex items-center space-x-4">
                    <select name="estado_validacion" id="estado_validacion" class="mt-1 block w-full max-w-xs rounded-md border-gray-300 shadow-sm focus:ring-blue-500 focus:border-blue-500 dark:bg-neutral-800 dark:border-neutral-700 dark:text-white">
                        <option value="pendiente" {{ $emprendedor->perfilEmprendedor->estado_validacion == 'pendiente' ? 'selected' : '' }}>Pendiente</option>
                        <option value="aprobado" {{ $emprendedor->perfilEmprendedor->estado_validacion == 'aprobado' ? 'selected' : '' }}>Aprobado</option>
                        <option value="rechazado" {{ $emprendedor->perfilEmprendedor->estado_validacion == 'rechazado' ? 'selected' : '' }}>Rechazado</option>
                    </select>
                </div>

                <button type="submit" class="mt-4 inline-flex items-center px-4 py-2 bg-blue-600 text-white rounded-md hover:bg-blue-700">
                    Actualizar Estado
                </button>
            </form>
        </div>

        <!-- Botón de Volver -->
        <div class="mt-6">
            <a href="{{ route('emprendedores.index') }}" class="inline-flex items-center px-4 py-2 bg-gray-200 dark:bg-neutral-700 text-gray-800 dark:text-white text-sm font-medium rounded-md hover:bg-gray-300">
                Volver a la lista de emprendedores
            </a>
        </div>
    </div>
</x-layouts.app>
