<?php

namespace App\Http\Controllers\Api;

use App\Models\Emprendimiento;
use App\Models\Tipo_Negocio;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use App\Http\Controllers\Controller;

class EmprendimientoController extends Controller
{
    //listar productos
    public function index(){
        $emprendimiento = Emprendimiento::all();
        return response()->json($emprendimiento, 200);
    }



    //crear nuevo producto

    public function store(Request $request)
    {
        try {
            $emprendimiento = Emprendimiento::create($request->only([
                'nombre',
                'descripcion',
                'id_tipo_negocio',
                'direccion',
                'telefono',
                'estado'
            ]));

            return response()->json([
                'message' => 'Emprendimiento creado exitosamente',
                'emprendimiento' => $emprendimiento
            ], 201);

        } catch (\Exception $e) {
            return response()->json([
                'error' => 'Error al crear el emprendimiento: ' . $e->getMessage()
            ], 500);
        }
    }


    //mostrar un emprendimineto especifico
    public function show($id){
        try {
            $emprendimiento = Emprendimiento::findOrFail($id);
            return response()->json($emprendimiento, 200);

        } catch (\Exception $e) {
            return response()->json(['error' => 'emprendimiento no encontrado'], 404);
        }
    }


    /**
     * Actualizar un producto existente.
     */
    public function update(Request $request, $id)
    {
        // Validación de entrada
        $validator = Validator::make($request->all(), [
            'nombre' => 'required|string|max:255',
            'descripcion' => 'nullable|string',
            'id_tipo_negocio' => 'nullable|exists:tipos_negocio,id_tipo_negocio',
            'direccion' => 'nullable|string|max:255',
            'telefono' => 'nullable|string|max:20',
            'estado' => 'required|in:activo,inactivo'
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        try {
            $emprendimiento = Emprendimiento::findOrFail($id);
            $emprendimiento->update($request->all());

            return response()->json([
                'message' => 'emprendimiento actualizado correctamente',
                'emprendimiento' => $emprendimiento
            ], 200);

        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al actualizar el producto: ' . $e->getMessage()], 500);
        }
    }

    /**
     * Eliminar un emprendimeinto.
     */
    public function destroy($id)
    {
        try {
            $emprendimiento = Emprendimiento::findOrFail($id);
            $emprendimiento->delete();

            return response()->json(['message' => 'emprenndimiento eliminado correctamente'], 200);

        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al eliminar el emprendimirnto: ' . $e->getMessage()], 500);
        }
    }
}
