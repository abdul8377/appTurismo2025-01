<?php

use App\Http\Controllers\CategoriaServicioController;
use App\Http\Controllers\EmprendedorController;
use App\Http\Controllers\EmprendimientoUsuario\EmprendimientoUsuarioController;
use App\Http\Controllers\TipoDeNegocioController;
use App\Http\Controllers\TuristaController;
use App\Livewire\Categoria\CategoriaList;
use App\Providers\VoltServiceProvider;
use Illuminate\Support\Facades\Route;
use Livewire\Volt\Volt;


Route::get('/', function () {
    return view('welcome');
})->name('home');

Route::view('dashboard', 'dashboard')
    ->middleware(['auth', 'verified'])
    ->name('dashboard');

Route::middleware(['auth'])->group(function () {
    Route::redirect('settings', 'settings/profile');

    Volt::route('settings/profile', 'settings.profile')->name('settings.profile');
    Volt::route('settings/password', 'settings.password')->name('settings.password');
    Volt::route('settings/appearance', 'settings.appearance')->name('settings.appearance');

    Route::get('/categorias-p-s', CategoriaList::class)->name('categorias-p');

    Route::resource('tipos-de-negocio', TipoDeNegocioController::class)->parameters([
        'tipos-de-negocio' => 'tipoDeNegocio'
    ]);

    Route::prefix('emprendedores')->name('emprendedores.')->group(function() {
        // Mostrar lista de emprendedores
        Route::get('/', [EmprendedorController::class, 'index'])->name('index');

        // Mostrar el formulario para crear un nuevo emprendedor
        Route::get('/create', [EmprendedorController::class, 'create'])->name('create');

        // Guardar un nuevo emprendedor
        Route::post('/', [EmprendedorController::class, 'store'])->name('store');

        // Mostrar los detalles de un emprendedor
        Route::get('/{emprendedor}', [EmprendedorController::class, 'show'])->name('show');

        // Mostrar el formulario para editar un emprendedor
        Route::get('/{emprendedor}/edit', [EmprendedorController::class, 'edit'])->name('edit');

        // Actualizar un emprendedor
        Route::put('/{emprendedor}', [EmprendedorController::class, 'update'])->name('update');

        // Actualizar el estado de validación de un emprendedor
        Route::put('/{emprendedor}/status', [EmprendedorController::class, 'updateStatus'])->name('updateStatus');
    });

    // Ruta para mostrar el formulario de creación del emprendimiento y asignación de usuario
    Route::get('/emprendimiento-usuario/create/{emprendedor_id}', [EmprendimientoUsuarioController::class, 'create'])->name('emprendimiento-usuarios.create');

    // Ruta para almacenar el emprendimiento y asignar un usuario y rol
    Route::post('/emprendimiento-usuario', [EmprendimientoUsuarioController::class, 'store'])->name('emprendimiento-usuarios.store');



    // Listar turistas
    Route::get('turistas', [TuristaController::class, 'index'])->name('turistas.index');

    // Mostrar los detalles de un turista
    Route::get('turistas/{turista}', [TuristaController::class, 'show'])->name('turistas.show');

    // Editar contraseña de un turista
    Route::get('turistas/{turista}/edit', [TuristaController::class, 'edit'])->name('turistas.edit');
    Route::put('turistas/{turista}', [TuristaController::class, 'update'])->name('turistas.update');

    Route::resource('categorias-servicios', CategoriaServicioController::class)->parameters([
        'categorias-servicios' => 'categoriaDeServicio'
    ]);
});

require __DIR__.'/auth.php';
