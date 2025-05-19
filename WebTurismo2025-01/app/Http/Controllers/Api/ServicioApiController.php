<?php

namespace App\Http\Controllers\Api;


use App\Http\Controllers\Controller;
use App\Models\Servicio;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use Symfony\Component\HttpFoundation\Response;

class ServicioApiController extends Controller
{
    // Obtener todos los servicios
    public function index()
    {
        $servicios = Servicio::with(['emprendimiento', 'categoriaServicio'])->get();
        return response()->json($servicios, Response::HTTP_OK);
    }

    // Crear nuevo servicio
    public function store(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'emprendimientos_id' => 'required|exists:emprendimientos,emprendimientos_id',
            'nombre' => 'required|string|max:150',
            'descripcion' => 'nullable|string',
            'precio' => 'required|numeric|min:0',
            'capacidad_maxima' => 'required|integer|min:1',
            'duracion_servicio' => 'nullable|integer|min:1',
            'imagen_destacada' => 'nullable|string|max:255',
            'categorias_servicios_id' => 'required|exists:categorias_servicios,categorias_servicios_id',
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        $servicio = Servicio::create($request->all());

        return response()->json([
            'message' => 'Servicio creado correctamente',
            'servicio' => $servicio
        ], Response::HTTP_CREATED);
    }

    // Mostrar un servicio específico
    public function show($id)
    {
        $servicio = Servicio::with(['emprendimiento', 'categoriaServicio'])->findOrFail($id);
        return response()->json($servicio, Response::HTTP_OK);
    }

    // Actualizar un servicio
    public function update(Request $request, $id)
    {
        $servicio = Servicio::findOrFail($id);

        $validator = Validator::make($request->all(), [
            'nombre' => 'required|string|max:150',
            'descripcion' => 'nullable|string',
            'precio' => 'required|numeric|min:0',
            'capacidad_maxima' => 'required|integer|min:1',
            'duracion_servicio' => 'nullable|integer|min:1',
            'imagen_destacada' => 'nullable|string|max:255',
            'categorias_servicios_id' => 'required|exists:categorias_servicios,categorias_servicios_id',
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        $servicio->update($request->all());

        return response()->json([
            'message' => 'Servicio actualizado correctamente',
            'servicio' => $servicio
        ], Response::HTTP_OK);
    }

    // Eliminar un servicio
    public function destroy($id)
    {
        Servicio::findOrFail($id)->delete();
        return response()->json(['message' => 'Servicio eliminado correctamente'], Response::HTTP_OK);
    }
}
