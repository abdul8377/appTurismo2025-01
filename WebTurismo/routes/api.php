<?php

use App\Http\Controllers\AuthController;
use App\Http\Controllers\AdminController;
use App\Http\Controllers\Api\CategoriaController;
use App\Http\Controllers\Api\ProductoController;
use App\Http\Controllers\Api\TipoNegocioController;
use App\Http\Controllers\Api\EmprendimientoController;
use App\Http\Controllers\Api\EventoController;
use App\Http\Controllers\Api\ServicioController;
use App\Http\Controllers\Api\ZonaTuristicaController;
use App\Http\Controllers\EmprendimientoUsuarioController;
use App\Http\Controllers\ProductorController;
use Illuminate\Support\Facades\Route;

// Rutas de autenticación
Route::post('register', [AuthController::class, 'register']);
Route::post('login', [AuthController::class, 'login']);
Route::post('logout', [AuthController::class, 'logout'])->middleware('auth:sanctum');

// Rutas de administración (requiere autenticación y permiso de 'Ver Rutas')
Route::middleware(['auth:sanctum', 'role:Administrador'])->group(function () {
    Route::get('/users', [AdminController::class, 'listUsers']);
    Route::post('/users', [AdminController::class, 'createUser']);
    Route::put('/users/{id}/status', [AdminController::class, 'updateStatus']);
    Route::put('/users/{id}', [AdminController::class, 'updateUser']);
    Route::delete('/users/{id}', [AdminController::class, 'deleteUser']);


    Route::get('/users/{id}', [AdminController::class, 'getUser']);
    Route::get('/roles', [AdminController::class, 'listRoles']);
});


//rutas crud sin autenticacion prueba

Route::get('/productos', [ProductoController::class, 'index']);
Route::post('/productos', [ProductoController::class, 'store']);
Route::get('/productos/{id}', [ProductoController::class, 'show']);
Route::put('/productos/{id}', [ProductoController::class, 'update']);
Route::delete('/productos/{id}', [ProductoController::class, 'destroy']);


//rutas emprendimientos
Route::get('/emprendimientos', [EmprendimientoController::class, 'index']);
Route::post('/emprendimientos', [EmprendimientoController::class, 'store']);
Route::get('/emprendimientos/{id}', [EmprendimientoController::class, 'show']);
Route::put('/emprendimientos/{id}', [EmprendimientoController::class, 'update']);
Route::delete('/emprendimientos/{id}', [EmprendimientoController::class, 'destroy']);


//categorias productos

Route::get('/categorias', [CategoriaController::class, 'index']);
Route::post('/categorias', [CategoriaController::class, 'store']);
Route::get('/categorias/{id}', [CategoriaController::class, 'show']);
Route::put('/categorias/{id}', [CategoriaController::class, 'update']);
Route::delete('/categorias/{id}', [CategoriaController::class, 'destroy']);

//rutas tipos negocio
Route::get('/tipos-negocio', [TipoNegocioController::class, 'index']);
Route::post('/tipos-negocio', [TipoNegocioController::class, 'store']);
Route::get('/tipos-negocio/{id}', [TipoNegocioController::class, 'show']);
Route::put('/tipos-negocio/{id}', [TipoNegocioController::class, 'update']);
Route::delete('/tipos-negocio/{id}', [TipoNegocioController::class, 'destroy']);
Route::get('/tipos-negocio/{id}', [TipoNegocioController::class, 'show']);


//rutas para zonas turisticas
Route::get('/zonas-turisticas', [ZonaTuristicaController::class, 'index']);
Route::post('/zonas-turisticas', [ZonaTuristicaController::class, 'store']);
Route::get('/zonas-turisticas/{id}', [ZonaTuristicaController::class, 'show']);
Route::put('/zonas-turisticas/{id}', [ZonaTuristicaController::class, 'update']);
Route::delete('/zonas-turisticas/{id}', [ZonaTuristicaController::class, 'destroy']);


//rutas para servicios

Route::get('/servicios', [ServicioController::class, 'index']);
Route::post('/servicios', [ServicioController::class, 'store']);
Route::get('/servicios/{id}', [ServicioController::class, 'show']);
Route::put('/servicios/{id}', [ServicioController::class, 'update']);
Route::delete('/servicios/{id}', [ServicioController::class, 'destroy']);

//rutas para evento

Route::get('/eventos', [EventoController::class, 'index']);
Route::post('/eventos', [EventoController::class, 'store']);
Route::get('/eventos/{id}', [EventoController::class, 'show']);
Route::put('/eventos/{id}', [EventoController::class, 'update']);
Route::delete('/eventos/{id}', [EventoController::class, 'destroy']);

//USURARIO EMPRENDIMIENTO
Route::get('/emprendimiento-usuario', [EmprendimientoUsuarioController::class, 'index']);  // Obtener lista de usuarios asignados a un emprendimiento
Route::post('/emprendimiento-usuario', [EmprendimientoUsuarioController::class, 'store']);  // Crear un nuevo usuario para un emprendimiento
Route::get('/emprendimiento-usuario/{id}', [EmprendimientoUsuarioController::class, 'show']);  // Obtener un usuario asignado a un emprendimiento
Route::put('/emprendimiento-usuario/{id}', [EmprendimientoUsuarioController::class, 'update']);  // Actualizar un usuario asignado a un emprendimiento
Route::delete('/emprendimiento-usuario/{id}', [EmprendimientoUsuarioController::class, 'destroy']);  // Eliminar un usuario asignado a un emprendimiento
// Ruta para obtener los productores libres
Route::get('/productores-libres', [ProductorController::class, 'getUsuariosProductoresLibres']);
Route::get('/emprendimientos-libres', [ProductorController::class, 'getEmprendimientos']);

