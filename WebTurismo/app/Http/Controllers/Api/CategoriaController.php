<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Categoria;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;

class CategoriaController extends Controller
{
    //listar productos
    public function index(){
        $categorias = Categoria::all();
        return response()->json($categorias, 200);
    }



    //crear nuevo categoria

    public function store(Request $request){
        //validacion de entradaas
        $validator = Validator::make($request->all(), [
            'nombre_categoria' => 'required|string|max:100|unique:categorias_productos,nombre_categoria',
            'descripcion' => 'nullable|string'

        ]);
        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        try {
            $categoria = Categoria::create($request->all());

            return response()->json([
                'message' => 'categoria creado exitosamente',
                'categoria' => $categoria
            ], 201);

        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al crear el categoria: ' . $e->getMessage()], 500);
        }
    }


    //moistrar un categoria especifico
    public function show($id){
        try {
            $categoria = Categoria::findOrFail($id);
            return response()->json($categoria, 200);

        } catch (\Exception $e) {
            return response()->json(['error' => 'categoria no encontrado'], 404);
        }
    }


    /**
     * Actualizar un producto existente.
     */
    public function update(Request $request, $id)
    {
        // Validación de entrada
        $validator = Validator::make($request->all(), [
            'nombre_categoria' => 'required|string|max:100|unique:categorias_productos,nombre_categoria,' . $id . ',id_categoria',
            'descripcion' => 'nullable|string'
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        try {
            $categoria = Categoria::findOrFail($id);
            $categoria->update($request->only('nombre_categoria', 'descripcion'));

            return response()->json([
                'message' => 'Categoría actualizada correctamente',
                'categoria' => $categoria
            ], 200);

        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al actualizar la categoría: ' . $e->getMessage()], 500);
        }
    }

    /**
     * Eliminar un producto.
     */
    public function destroy($id)
    {
        try {
            $categoria = Categoria::findOrFail($id);
            $categoria->delete();

            return response()->json(['message' => 'categoria eliminado correctamente'], 200);

        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al eliminar el categoria: ' . $e->getMessage()], 500);
        }
    }
}
