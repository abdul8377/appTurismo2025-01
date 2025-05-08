<?php

use App\Http\Controllers\EmprendedorController;
use App\Http\Controllers\TipoDeNegocioController;
use App\Http\Controllers\TuristaController;
use App\Livewire\Categoria\CategoriaList;
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



                // Listar emprendedores
            Route::get('emprendedores', [EmprendedorController::class, 'index'])->name('emprendedores.index');

            // Crear nuevo emprendedor (usuario + perfil)
            Route::get('emprendedores/create', [EmprendedorController::class, 'create'])->name('emprendedores.create');
            Route::post('emprendedores', [EmprendedorController::class, 'store'])->name('emprendedores.store');

            // Ver detalles de un emprendedor
            Route::get('emprendedores/{emprendedor}', [EmprendedorController::class, 'show'])->name('emprendedores.show');

            // Editar perfil de emprendedor
            Route::get('emprendedores/{emprendedor}/edit', [EmprendedorController::class, 'edit'])->name('emprendedores.edit');
            Route::put('emprendedores/{emprendedor}', [EmprendedorController::class, 'update'])->name('emprendedores.update');
            // Actualizar el estado de validación de un emprendedor
            Route::put('emprendedores/{emprendedor}/estado-validacion', [EmprendedorController::class, 'updateStatus'])->name('emprendedores.updateStatus');


            // Listar turistas
            Route::get('turistas', [TuristaController::class, 'index'])->name('turistas.index');

            // Mostrar los detalles de un turista
            Route::get('turistas/{turista}', [TuristaController::class, 'show'])->name('turistas.show');

            // Editar contraseña de un turista
            Route::get('turistas/{turista}/edit', [TuristaController::class, 'edit'])->name('turistas.edit');
            Route::put('turistas/{turista}', [TuristaController::class, 'update'])->name('turistas.update');




        });

require __DIR__.'/auth.php';
