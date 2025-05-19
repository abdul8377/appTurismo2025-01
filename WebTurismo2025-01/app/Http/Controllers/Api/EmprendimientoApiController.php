<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Emprendimiento;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use Symfony\Component\HttpFoundation\Response;

class EmprendimientoApiController extends Controller
{
    // Obtener todos los emprendimientos
    public function index()
    {
        $emprendimientos = Emprendimiento::with(['categoriaServicio'])->get();
        return response()->json($emprendimientos, Response::HTTP_OK);
    }

    // Crear nuevo emprendimiento
    public function store(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'nombre' => 'required|string|max:255',
            'descripcion' => 'nullable|string',
            'categorias_servicios_id' => 'required|exists:categorias_servicios,categorias_servicios_id',
            'direccion' => 'nullable|string|max:255',
            'telefono' => 'nullable|string|max:20',
            'estado' => 'in:activo,inactivo,pendiente',
            'imagen_destacada' => 'nullable|string|max:255'
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        $emprendimiento = Emprendimiento::create($request->all());

        return response()->json([
            'message' => 'Emprendimiento creado correctamente',
            'emprendimiento' => $emprendimiento
        ], Response::HTTP_CREATED);
    }

    // Mostrar un emprendimiento específico
    public function show($id)
    {
        $emprendimiento = Emprendimiento::with(['categoriaServicio'])->findOrFail($id);
        return response()->json($emprendimiento, Response::HTTP_OK);
    }

    // Actualizar un emprendimiento
    public function update(Request $request, $id)
    {
        $emprendimiento = Emprendimiento::findOrFail($id);

        $validator = Validator::make($request->all(), [
            'nombre' => 'required|string|max:255',
            'descripcion' => 'nullable|string',
            'categorias_servicios_id' => 'required|exists:categorias_servicios,categorias_servicios_id',
            'direccion' => 'nullable|string|max:255',
            'telefono' => 'nullable|string|max:20',
            'estado' => 'in:activo,inactivo,pendiente',
            'imagen_destacada' => 'nullable|string|max:255'
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        $emprendimiento->update($request->all());

        return response()->json([
            'message' => 'Emprendimiento actualizado correctamente',
            'emprendimiento' => $emprendimiento
        ], Response::HTTP_OK);
    }

    // Eliminar un emprendimiento
    public function destroy($id)
    {
        Emprendimiento::findOrFail($id)->delete();
        return response()->json(['message' => 'Emprendimiento eliminado correctamente'], Response::HTTP_OK);
    }
}
