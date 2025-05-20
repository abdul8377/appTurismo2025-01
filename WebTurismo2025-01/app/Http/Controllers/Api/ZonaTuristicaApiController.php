<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\ZonaTuristica;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use Symfony\Component\HttpFoundation\Response;

class ZonaTuristicaApiController extends Controller
{
    // Obtener todas las zonas turísticas
    public function index()
    {
        return response()->json(ZonaTuristica::all(), Response::HTTP_OK);
    }

    // Crear una nueva zona turística
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

        $zona = ZonaTuristica::create($request->all());

        return response()->json([
            'message' => 'Zona turística creada correctamente',
            'zona' => $zona
        ], Response::HTTP_CREATED);
    }

    // Mostrar una zona turística específica
    public function show($id)
    {
        $zona = ZonaTuristica::findOrFail($id);
        return response()->json($zona, Response::HTTP_OK);
    }

    // Actualizar una zona turística
    public function update(Request $request, $id)
    {
        $zona = ZonaTuristica::findOrFail($id);

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

        $zona->update($request->all());

        return response()->json([
            'message' => 'Zona turística actualizada correctamente',
            'zona' => $zona
        ], Response::HTTP_OK);
    }

    // Eliminar una zona turística
    public function destroy($id)
    {
        ZonaTuristica::findOrFail($id)->delete();
        return response()->json(['message' => 'Zona turística eliminada correctamente'], Response::HTTP_OK);
    }
}
