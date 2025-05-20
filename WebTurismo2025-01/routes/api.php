<?php

use App\Http\Controllers\Administrador\AuthController;
use App\Http\Controllers\Api\CategoriaServicioApiController;
use App\Http\Controllers\Api\EmprendimientoApiController;
use App\Http\Controllers\Api\ServicioApiController;
use App\Http\Controllers\Api\ZonaTuristicaApiController;
use App\Http\Controllers\EmprendimientoUsuario\EmprendimientoUsuarioController;
use App\Http\Controllers\ImageableController;
use App\Http\Controllers\TipoDeNegocioController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

// Rutas de autenticación
Route::post('register', [AuthController::class, 'register']);
Route::post('login', [AuthController::class, 'login']);
Route::post('logout', [AuthController::class, 'logout'])->middleware('auth:sanctum');


Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');


// Rutas de autenticación
Route::post('register', [AuthController::class, 'register']);
Route::post('login', [AuthController::class, 'login']);
Route::post('logout', [AuthController::class, 'logout'])->middleware('auth:sanctum');

// Rutas de administración (requiere autenticación y permiso de 'Ver Rutas')



//rutas emprendimientos
Route::get('/emprendimientos', [EmprendimientoUsuarioController::class, 'index']);
Route::post('/emprendimientos', [EmprendimientoUsuarioController::class, 'store']);
Route::get('/emprendimientos/{id}', [EmprendimientoUsuarioController::class, 'show']);
Route::put('/emprendimientos/{id}', [EmprendimientoUsuarioController::class, 'update']);
Route::delete('/emprendimientos/{id}', [EmprendimientoUsuarioController::class, 'destroy']);




//rutas tipos negocio
Route::get('/tipos-negocio', [TipoDeNegocioController::class, 'index']);
Route::post('/tipos-negocio', [TipoDeNegocioController::class, 'store']);
Route::get('/tipos-negocio/{id}', [TipoDeNegocioController::class, 'show']);
Route::put('/tipos-negocio/{id}', [TipoDeNegocioController::class, 'update']);
Route::delete('/tipos-negocio/{id}', [TipoDeNegocioController::class, 'destroy']);


//categoria servicios
Route::apiResource('categorias-servicios', CategoriaServicioApiController::class);


// emprendimientos
Route::get('/emprendimientos', [EmprendimientoApiController::class, 'index']);
Route::post('/emprendimientos', [EmprendimientoApiController::class, 'store']);
Route::get('/emprendimientos/{id}', [EmprendimientoApiController::class, 'show']);
Route::put('/emprendimientos/{id}', [EmprendimientoApiController::class, 'update']);
Route::delete('/emprendimientos/{id}', [EmprendimientoApiController::class, 'destroy']);

//servicios
Route::get('/servicios', [ServicioApiController::class, 'index']);
Route::post('/servicios', [ServicioApiController::class, 'store']);
Route::get('/servicios/{id}', [ServicioApiController::class, 'show']);
Route::put('/servicios/{id}', [ServicioApiController::class, 'update']);
Route::delete('/servicios/{id}', [ServicioApiController::class, 'destroy']);

//ZoNAs turisiticas

Route::get('/zonas-turisticas', [ZonaTuristicaApiController::class, 'index']);
Route::post('/zonas-turisticas', [ZonaTuristicaApiController::class, 'store']);
Route::get('/zonas-turisticas/{id}', [ZonaTuristicaApiController::class, 'show']);
Route::put('/zonas-turisticas/{id}', [ZonaTuristicaApiController::class, 'update']);
Route::delete('/zonas-turisticas/{id}', [ZonaTuristicaApiController::class, 'destroy']);


//imagenenes

Route::post('/imagenes', [ImageableController::class, 'store']);
Route::get('/imagenes/{type}/{id}', [ImageableController::class, 'index']);
