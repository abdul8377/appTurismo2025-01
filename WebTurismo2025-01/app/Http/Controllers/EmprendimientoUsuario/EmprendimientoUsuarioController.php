<?php

namespace App\Http\Controllers\EmprendimientoUsuario;

use App\Http\Controllers\Controller;
use App\Models\Emprendimiento;
use App\Models\EmprendimientoUsuario;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Str;  // Importar Str

class EmprendimientoUsuarioController extends Controller
{
    /**
     * Mostrar el formulario para crear el emprendimiento y asignar un usuario.
     */
    public function create($emprendedor_id)
    {
        // Obtener el usuario emprendedor por su ID
        $emprendedor = User::findOrFail($emprendedor_id);

        // Obtener la lista de todos los emprendimientos
        $emprendimientos = Emprendimiento::all();

        // Retornar la vista con el usuario y los emprendimientos
        return view('EmprendimientoUsuario.create', compact('emprendedor', 'emprendimientos'));
    }


    /**
     * Almacenar el emprendimiento y asignar un usuario y rol.
     */
public function store(Request $request)
{
    // Validar los datos del formulario
    $request->validate([
        'nombre' => 'required|string|max:255',
        'descripcion' => 'nullable|string',
        'direccion' => 'nullable|string|max:255',
        'telefono' => 'nullable|string|max:20',
        'imagen_destacada' => 'nullable|image|mimes:jpeg,png,jpg,gif|max:2048',
        'rol_emprendimiento' => 'required|in:propietario,colaborador',
    ]);

    // Asignar el estado como "activo"
    $estado = 'activo';

    // Verificar si la carpeta de "Emprendimiento" existe, si no, crearla
    $folder = 'public/Emprendimiento';
    if (!Storage::exists($folder)) {
        Storage::makeDirectory($folder);
    }

    // Subir imagen si existe
    if ($request->hasFile('imagen_destacada')) {
        // Obtener la extensión de la imagen
        $ext = $request->file('imagen_destacada')->getClientOriginalExtension();

        // Guardar la imagen con el nombre del emprendimiento y su extensión
        $imagen_nombre = Str::slug($request->nombre) . '.' . $ext;
        $imagen_destacada = $request->file('imagen_destacada')->storeAs($folder, $imagen_nombre);

        // Guardar solo el URL de la imagen en la base de datos
        $imagen_url = Storage::url($imagen_destacada);
    } else {
        $imagen_url = null;
    }

    // Crear el emprendimiento
    $emprendimiento = Emprendimiento::create([
        'nombre' => $request->nombre,
        'descripcion' => $request->descripcion,
        'direccion' => $request->direccion,
        'telefono' => $request->telefono,
        'estado' => $estado,
        'imagen_destacada' => $imagen_url,
    ]);

    // Asignar el usuario y el rol al emprendimiento
    EmprendimientoUsuario::create([
        'emprendimientos_id' => $emprendimiento->emprendimientos_id,
        'users_id' => $request->usuario_id ?? $emprendimiento->emprendedor_id,  // Usa el usuario_id desde el formulario o toma el que viene de la URL
        'rol_emprendimiento' => $request->rol_emprendimiento,
    ]);

    // Redirigir a la vista de emprendedores con un mensaje de éxito
    return redirect()->route('emprendedores.index')->with('success', 'Emprendimiento creado y usuario asignado correctamente.');
}

}
