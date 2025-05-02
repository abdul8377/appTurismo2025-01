<?php

namespace App\Http\Controllers;

use App\Models\EmprendimientoUsuario;
use App\Models\User;
use App\Models\Emprendimiento;
use Illuminate\Http\Request;

class EmprendimientoUsuarioController extends Controller
{
    /**
     * Mostrar la lista de usuarios asignados a un emprendimiento.
     */
    public function index()
    {
        $emprendimientoUsuarios = EmprendimientoUsuario::with(['usuario', 'emprendimiento'])->get();
        return response()->json($emprendimientoUsuarios);
    }

    /**
     * Crear un nuevo usuario para un emprendimiento.
     */
    public function store(Request $request)
        {
            // Validación de los datos recibidos
            $request->validate([
                'id_emprendimiento' => 'required|exists:emprendimiento,id_emprendimiento',
                'id_usuario' => 'required|exists:users,id',
                'rol_emprendimiento' => 'required|in:propietario,colaborador',
            ]);

            // Verificar si el usuario ya está vinculado a otro emprendimiento
            $userAlreadyLinked = EmprendimientoUsuario::where('id_usuario', $request->id_usuario)->exists();
            if ($userAlreadyLinked) {
                return response()->json(['message' => 'El usuario ya está vinculado a otro emprendimiento.'], 400);
            }

            // Obtener el usuario
            $user = User::find($request->id_usuario);

            // Verificar si el usuario tiene el rol "Productor"
            if (!$user->hasRole('Productor')) {
                return response()->json(['message' => 'Solo los usuarios con rol de "Productor" pueden ser vinculados a un emprendimiento.'], 400);
            }

            // Crear la relación entre el usuario y el emprendimiento
            $emprendimientoUsuario = EmprendimientoUsuario::create([
                'id_emprendimiento' => $request->id_emprendimiento,
                'id_usuario' => $request->id_usuario,
                'rol_emprendimiento' => $request->rol_emprendimiento,
                'fecha_asignacion' => now(),
            ]);

            return response()->json($emprendimientoUsuario, 201);
        }



    /**
     * Mostrar un usuario asignado a un emprendimiento.
     */
    public function show($id)
    {
        $emprendimientoUsuario = EmprendimientoUsuario::with(['usuario', 'emprendimiento'])->find($id);

        if (!$emprendimientoUsuario) {
            return response()->json(['message' => 'Usuario no encontrado'], 404);
        }

        return response()->json($emprendimientoUsuario);
    }

    /**
     * Actualizar un usuario asignado a un emprendimiento.
     */
    public function update(Request $request, $id)
    {
        $emprendimientoUsuario = EmprendimientoUsuario::find($id);

        if (!$emprendimientoUsuario) {
            return response()->json(['message' => 'Usuario no encontrado'], 404);
        }

        // Validación para actualizar solo el rol
        $request->validate([
            'rol_emprendimiento' => 'required|in:propietario,colaborador',
        ]);

        $emprendimientoUsuario->update([
            'rol_emprendimiento' => $request->rol_emprendimiento,
            'fecha_asignacion' => now(),
        ]);

        return response()->json($emprendimientoUsuario);
    }

    /**
     * Eliminar un usuario asignado a un emprendimiento.
     */
    public function destroy($id)
    {
        $emprendimientoUsuario = EmprendimientoUsuario::find($id);

        if (!$emprendimientoUsuario) {
            return response()->json(['message' => 'Usuario no encontrado'], 404);
        }

        $emprendimientoUsuario->delete();

        return response()->json(['message' => 'Usuario eliminado correctamente']);
    }
}
