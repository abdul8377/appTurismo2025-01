<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Producto;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;

class ProductoController extends Controller
{

    //listar productos
    public function index(){
        $productos = Producto::all();
        return response()->json($productos, 200);
    }



    //crear nuevo producto

    public function store(Request $request){
        //validacion de entradaas
        $validator = Validator::make($request->all(), [
            'id_emprendimiento' => 'required|exists:emprendimiento,id_emprendimiento',
            'id_categoria' => 'required|exists:categorias_productos,id_categoria',
            'nombre_producto' => 'required|string|max:150',
            'descripcion' => 'nullable|string',
            'precio' => 'required|numeric|min:0',
            'stock' => 'required|integer|min:0',
            'imagen_url' => 'nullable|url|max:255',
            'estado' => 'required|in:activo,inactivo',
        ]);
        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        try {
            $producto = Producto::create($request->all());

            return response()->json([
                'message' => 'Producto creado exitosamente',
                'producto' => $producto
            ], 201);

        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al crear el producto: ' . $e->getMessage()], 500);
        }
    }


    //moistrar un producto especifico
    public function show($id){
        try {
            $producto = Producto::findOrFail($id);
            return response()->json($producto, 200);

        } catch (\Exception $e) {
            return response()->json(['error' => 'Producto no encontrado'], 404);
        }
    }


    /**
     * Actualizar un producto existente.
     */
    public function update(Request $request, $id)
    {
        // Validación de entrada
        $validator = Validator::make($request->all(), [
            'nombre_producto' => 'required|string|max:150',
            'descripcion' => 'nullable|string',
            'precio' => 'required|numeric|min:0',
            'stock' => 'required|integer|min:0',
            'imagen_url' => 'nullable|url|max:255',
            'estado' => 'required|in:activo,inactivo',
            'id_categoria' => 'required|exists:categorias_productos,id_categoria',
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        try {
            $producto = Producto::findOrFail($id);
            $producto->update($request->all());

            return response()->json([
                'message' => 'Producto actualizado correctamente',
                'producto' => $producto
            ], 200);

        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al actualizar el producto: ' . $e->getMessage()], 500);
        }
    }

    /**
     * Eliminar un producto.
     */
    public function destroy($id)
    {
        try {
            $producto = Producto::findOrFail($id);
            $producto->delete();

            return response()->json(['message' => 'Producto eliminado correctamente'], 200);

        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al eliminar el producto: ' . $e->getMessage()], 500);
        }
    }





}
