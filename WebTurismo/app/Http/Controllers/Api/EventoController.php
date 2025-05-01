<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Evento;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Validator;

class EventoController extends Controller
{
    public function index()
    {
        return response()->json(Evento::all(), Response::HTTP_OK);
    }

    public function store(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'titulo' => 'required|string|max:255',
            'descripcion' => 'nullable|string',
            'fecha_inicio' => 'required|date',
            'fecha_fin' => 'required|date|after_or_equal:fecha_inicio',
            'lugar' => 'nullable|string|max:255',
            'estado' => 'in:activo,inactivo,cancelado'
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        $evento = Evento::create($request->all());

        return response()->json([
            'message' => 'Evento creado correctamente',
            'evento' => $evento
        ], Response::HTTP_CREATED);
    }

    public function show($id)
    {
        return response()->json(Evento::findOrFail($id), Response::HTTP_OK);
    }

    public function update(Request $request, $id)
    {
        $evento = Evento::findOrFail($id);

        $validator = Validator::make($request->all(), [
            'titulo' => 'required|string|max:255',
            'descripcion' => 'nullable|string',
            'fecha_inicio' => 'required|date',
            'fecha_fin' => 'required|date|after_or_equal:fecha_inicio',
            'lugar' => 'nullable|string|max:255',
            'estado' => 'in:activo,inactivo,cancelado'
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        $evento->update($request->all());

        return response()->json([
            'message' => 'Evento actualizado correctamente',
            'evento' => $evento
        ], Response::HTTP_OK);
    }

    public function destroy($id)
    {
        Evento::findOrFail($id)->delete();
        return response()->json(['message' => 'Evento eliminado correctamente'], Response::HTTP_OK);
    }
}
