<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\TipoNegocio;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class TipoNegocioController extends Controller
{
     // Obtener todos los tipos de negocio
     public function index()
     {
         $tipos_negocio = TipoNegocio::all();
         return response()->json($tipos_negocio, Response::HTTP_OK);
     }

     // Insertar un nuevo tipo de negocio
     public function store(Request $request)
     {
         $tipo_negocio = TipoNegocio::create($request->only('nombre'));

         return response()->json([
             'message' => "Registro creado satisfactoriamente",
             'tipo_negocio' => $tipo_negocio
         ], Response::HTTP_CREATED);
     }

     // Actualizar un tipo de negocio
     public function update(Request $request, $id)
     {
         $tipo_negocio = TipoNegocio::findOrFail($id);

         $tipo_negocio->update($request->only('nombre'));

         return response()->json([
             'message' => "Registro actualizado satisfactoriamente",
             'tipo_negocio' => $tipo_negocio
         ], Response::HTTP_OK);
     }

     // Eliminar un tipo de negocio
     public function destroy($id)
     {
         $tipo_negocio = TipoNegocio::findOrFail($id);

         $tipo_negocio->delete();

         return response()->json([
             'message' => "Registro eliminado satisfactoriamente"
         ], Response::HTTP_OK);
     }

     public function show($id)
    {
        // Buscar el tipo de negocio por su ID
        $tipo_negocio = TipoNegocio::find($id);

        // Si no se encuentra, devolver error
        if (!$tipo_negocio) {
            return response()->json(['message' => 'Tipo de negocio no encontrado'], Response::HTTP_NOT_FOUND);
        }

        // Si se encuentra, devolverlo
        return response()->json($tipo_negocio, Response::HTTP_OK);
    }
}
