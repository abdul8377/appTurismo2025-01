<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\ZonaTuristica;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Validator;

class ZonaTuristicaController extends Controller
{
    // Obtener todas las zonas
    public function index()
    {
        $zonas = ZonaTuristica::all();
        return response()->json($zonas, Response::HTTP_OK);
    }

    // Insertar nueva zona
    public function store(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'nombre' => 'required|string|max:150',
            'descripcion' => 'nullable|string',
            'ubicacion' => 'nullable|string|max:255',
            'imagen_url' => 'nullable|string|max:255',
            'estado' => 'in:activo,inactivo'
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        try {
            $zona = ZonaTuristica::create($request->all());

            return response()->json([
                'message' => 'Zona turística creada exitosamente',
                'zona' => $zona
            ], 201);
        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al crear zona turística: ' . $e->getMessage()], 500);
        }
    }

    // Mostrar una zona específica
    public function show($id)
    {
        try {
            $zona = ZonaTuristica::findOrFail($id);
            return response()->json($zona, Response::HTTP_OK);
        } catch (\Exception $e) {
            return response()->json(['error' => 'Zona no encontrada'], 404);
        }
    }

    // Actualizar una zona
    public function update(Request $request, $id)
    {
        $validator = Validator::make($request->all(), [
            'nombre' => 'required|string|max:150',
            'descripcion' => 'nullable|string',
            'ubicacion' => 'nullable|string|max:255',
            'imagen_url' => 'nullable|string|max:255',
            'estado' => 'in:activo,inactivo'
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        try {
            $zona = ZonaTuristica::findOrFail($id);
            $zona->update($request->all());

            return response()->json([
                'message' => 'Zona turística actualizada correctamente',
                'zona' => $zona
            ], Response::HTTP_OK);
        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al actualizar la zona: ' . $e->getMessage()], 500);
        }
    }

    // Eliminar una zona
    public function destroy($id)
    {
        try {
            $zona = ZonaTuristica::findOrFail($id);
            $zona->delete();

            return response()->json(['message' => 'Zona turística eliminada correctamente'], Response::HTTP_OK);
        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al eliminar la zona: ' . $e->getMessage()], 500);
        }
    }
}
