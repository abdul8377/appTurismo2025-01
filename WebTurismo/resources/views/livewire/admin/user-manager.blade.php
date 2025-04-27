
<div class="max-w-5xl mx-auto py-6 px-4 sm:px-6 lg:px-8">
    <h2 class="text-2xl font-semibold text-gray-800 dark:text-white mb-6 flex items-center gap-2">
        <i class="fas fa-users text-indigo-500"></i> Gestión de Usuarios
    </h2>

    @if (session()->has('success'))
        <div class="bg-green-100 text-green-800 px-4 py-2 rounded mb-4">
            {{ session('success') }}
        </div>
    @endif

    <!-- Formulario -->
    <form wire:submit.prevent="{{ $isEdit ? 'update' : 'store' }}" class="bg-white dark:bg-zinc-800 shadow-md rounded px-6 py-4 mb-8">
        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <div>
                <label class="block text-sm font-medium text-gray-700 dark:text-white">Nombre</label>
                <input wire:model="name" class="mt-1 w-full rounded border-gray-300 shadow-sm focus:ring-indigo-500 focus:border-indigo-500 dark:bg-zinc-700 dark:text-white" placeholder="Nombre" />
                @error('name') <span class="text-red-500 text-xs">{{ $message }}</span> @enderror
            </div>

            <div>
                <label class="block text-sm font-medium text-gray-700 dark:text-white">Email</label>
                <input wire:model="email" class="mt-1 w-full rounded border-gray-300 shadow-sm focus:ring-indigo-500 focus:border-indigo-500 dark:bg-zinc-700 dark:text-white" placeholder="Email" />
                @error('email') <span class="text-red-500 text-xs">{{ $message }}</span> @enderror
            </div>

            <div>
                <label class="block text-sm font-medium text-gray-700 dark:text-white">Contraseña</label>
                <input wire:model="password" type="password" class="mt-1 w-full rounded border-gray-300 shadow-sm focus:ring-indigo-500 focus:border-indigo-500 dark:bg-zinc-700 dark:text-white" placeholder="{{ $isEdit ? 'Nueva contraseña (opcional)' : 'Contraseña' }}" />
                @error('password') <span class="text-red-500 text-xs">{{ $message }}</span> @enderror
            </div>

            <div>
                <label class="block text-sm font-medium text-gray-700 dark:text-white">Rol</label>
                <select wire:model="role" class="mt-1 w-full rounded border-gray-300 shadow-sm focus:ring-indigo-500 focus:border-indigo-500 dark:bg-zinc-700 dark:text-white">
                    <option value="">Selecciona un rol</option>
                    @foreach($roles as $r)
                        <option value="{{ $r->name }}">{{ $r->name }}</option>
                    @endforeach
                </select>
                @error('role') <span class="text-red-500 text-xs">{{ $message }}</span> @enderror
            </div>
        </div>

        <div class="mt-6 flex items-center gap-3">
            <button type="submit" class="inline-flex items-center px-4 py-2 bg-indigo-600 text-white rounded hover:bg-indigo-700">
                <i class="fas fa-save mr-2"></i>
                {{ $isEdit ? 'Actualizar' : 'Crear' }}
            </button>
            @if($isEdit)
                <button type="button" wire:click="resetForm" class="inline-flex items-center px-4 py-2 bg-gray-300 text-gray-800 rounded hover:bg-gray-400">
                    <i class="fas fa-times mr-2"></i> Cancelar
                </button>
            @endif
        </div>
    </form>

    <!-- Tabla -->
    <div class="bg-white dark:bg-zinc-800 shadow-md rounded overflow-x-auto">
        <table class="min-w-full divide-y divide-gray-200 dark:divide-zinc-600">
            <thead class="bg-gray-50 dark:bg-zinc-700">
                <tr>
                    <th class="px-6 py-3 text-left text-sm font-medium text-gray-600 dark:text-gray-300">Nombre</th>
                    <th class="px-6 py-3 text-left text-sm font-medium text-gray-600 dark:text-gray-300">Email</th>
                    <th class="px-6 py-3 text-left text-sm font-medium text-gray-600 dark:text-gray-300">Rol</th>
                    <th class="px-6 py-3 text-right text-sm font-medium text-gray-600 dark:text-gray-300">Acciones</th>
                </tr>
            </thead>
            <tbody class="bg-white dark:bg-zinc-800 divide-y divide-gray-100 dark:divide-zinc-700">
                @foreach($users as $u)
                    <tr>
                        <td class="px-6 py-4 whitespace-nowrap">{{ $u->name }}</td>
                        <td class="px-6 py-4 whitespace-nowrap">{{ $u->email }}</td>
                        <td class="px-6 py-4 whitespace-nowrap">{{ $u->roles->pluck('name')->join(', ') }}</td>
                        <td class="px-6 py-4 whitespace-nowrap text-right flex gap-2 justify-end">
                            <button wire:click="edit({{ $u->id }})" class="inline-flex items-center px-3 py-1 bg-yellow-400 text-white text-sm rounded hover:bg-yellow-500">
                                <i class="fas fa-edit mr-1"></i> Editar
                            </button>
                            <button wire:click="delete({{ $u->id }})" onclick="return confirm('¿Eliminar este usuario?')" class="inline-flex items-center px-3 py-1 bg-red-600 text-white text-sm rounded hover:bg-red-700">
                                <i class="fas fa-trash-alt mr-1"></i> Eliminar
                            </button>
                        </td>
                    </tr>
                @endforeach
            </tbody>
        </table>
    </div>

    <div class="mt-4">
        {{ $users->links() }}
    </div>
</div>
