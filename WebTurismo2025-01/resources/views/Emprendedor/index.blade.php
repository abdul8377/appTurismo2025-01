<x-layouts.app :title="__('Lista de Emprendedores')">
    <div class="max-w-6xl mx-auto mt-8 bg-white dark:bg-neutral-900 p-6 rounded-lg shadow">

        <!-- Título -->
        <h2 class="text-2xl font-semibold text-gray-800 dark:text-white mb-6">Emprendedores</h2>

        <!-- Botón de Crear Nuevo Emprendedor -->
        <a href="{{ route('emprendedores.create') }}" class="inline-flex items-center px-4 py-2 bg-blue-600 text-white rounded-md hover:bg-blue-700 mb-4">
            Crear Nuevo Emprendedor
        </a>

        <!-- Tabla de Emprendedores -->
        <div class="overflow-x-auto rounded-lg border border-gray-200 dark:border-neutral-700">
            <table class="min-w-full divide-y divide-gray-200 dark:divide-neutral-700">
                <thead class="bg-gray-50 dark:bg-neutral-800">
                    <tr>
                        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">ID</th>
                        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Nombre</th>
                        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Teléfono</th>
                        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Correo de Contacto</th>
                        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Estado</th>
                        <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Opciones</th>
                    </tr>
                </thead>
                <tbody class="bg-white dark:bg-neutral-900 divide-y divide-gray-200 dark:divide-neutral-700">
                    @foreach($emprendedores as $emprendedor)
                        <tr>
                            <td class="px-6 py-4 text-sm text-gray-800 dark:text-gray-200">{{ $emprendedor->perfilEmprendedor->perfil_emprendedor_id ?? 'N/A' }}</td>
                            <td class="px-6 py-4 text-sm text-gray-800 dark:text-gray-200">{{ $emprendedor->name }}</td>
                            <td class="px-6 py-4 text-sm text-gray-800 dark:text-gray-200">{{ $emprendedor->perfilEmprendedor->telefono_contacto ?? 'N/A' }}</td>
                            <td class="px-6 py-4 text-sm text-gray-800 dark:text-gray-200">{{ $emprendedor->perfilEmprendedor->gmail_contacto ?? 'N/A' }}</td>
                            <td class="px-6 py-4 text-sm text-gray-800 dark:text-gray-200">{{ $emprendedor->perfilEmprendedor->estado_validacion ?? 'N/A' }}</td>
                            <td class="px-6 py-4 text-sm text-gray-800 dark:text-gray-200">
                                <!-- Opciones de acción -->
                                <a href="{{ route('emprendedores.show', $emprendedor) }}" class="inline-block px-3 py-1 bg-indigo-600 text-white rounded-md hover:bg-indigo-700">
                                    Ver Detalles
                                </a>
                                <a href="{{ route('emprendedores.edit', $emprendedor) }}" class="inline-block px-3 py-1 bg-yellow-400 text-white rounded-md hover:bg-yellow-500 ml-2">
                                    Editar
                                </a>
                                <a href="{{ route('emprendimiento-usuarios.create', $emprendedor->id) }}" class="inline-block px-3 py-1 bg-green-600 text-white rounded-md hover:bg-green-700 ml-2">
                                    Crear Emprendimiento
                                </a>


                            </td>
                        </tr>
                    @endforeach
                </tbody>
            </table>
        </div>
    </div>
</x-layouts.app>
