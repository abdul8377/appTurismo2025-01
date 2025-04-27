<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;
use Spatie\Permission\Models\Role;
use Illuminate\Support\Facades\Validator;

class AdminController extends Controller
{
    /**
     * Listar todos los usuarios.
     */
    public function listUsers()
    {
        $users = User::with('roles')->get();

        $usersFormatted = $users->map(function ($user) {
            return [
                'id' => $user->id,
                'name' => $user->name,
                'email' => $user->email,
                'roles' => $user->roles->pluck('name'),
                'created_at' => $user->created_at,
                'updated_at' => $user->updated_at,
                'is_active' => $user->is_active,
                'motivo_inactivo' => $user->motivo_inactivo
            ];
        });

        return response()->json($usersFormatted, 200);
    }

    /**
     * Crear un nuevo usuario (solo para administradores).
     */
    public function createUser(Request $request)
    {
        // Validación de entrada
        $validator = Validator::make($request->all(), [
            'name' => 'required|string|max:255',
            'email' => 'required|string|email|max:255|unique:users',
            'password' => 'required|string|min:6|confirmed',
            'role' => 'required|string|exists:roles,name', // Validación de rol
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        try {
            // Crear usuario
            $user = User::create([
                'name' => $request->name,
                'email' => $request->email,
                'password' => bcrypt($request->password), // Contraseña cifrada
                'is_active' => true, // Por defecto activo
            ]);

            // Asignar el rol
            $user->assignRole($request->role);

            return response()->json([
                'message' => 'Usuario creado con éxito',
                'user' => $user
            ], 201);

        } catch (\Exception $e) {
            return response()->json(['error' => 'Hubo un error al crear el usuario: ' . $e->getMessage()], 500);
        }
    }

    /**
     * Cambiar el estado de un usuario (activo/inactivo).
     */
    public function updateStatus(Request $request, $id)
    {
        // Validación de entrada
        $validator = Validator::make($request->all(), [
            'is_active' => 'required|boolean',
            'motivo_inactivo' => 'nullable|string|max:255',
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        try {
            $user = User::findOrFail($id);
            $user->is_active = $request->is_active;
            $user->motivo_inactivo = $request->is_active ? null : $request->motivo_inactivo;
            $user->save();

            return response()->json(['message' => 'Estado de usuario actualizado', 'user' => $user], 200);
        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al actualizar el estado del usuario: ' . $e->getMessage()], 500);
        }
    }

    /**
     * Actualizar los detalles de un usuario.
     */
    public function updateUser(Request $request, $id)
    {
        // Validación de entrada
        $validator = Validator::make($request->all(), [
            'name' => 'required|string|max:255',
            'email' => 'required|string|email|max:255|unique:users,email,' . $id,
            'role' => 'required|string|exists:roles,name', // Validación de rol
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        try {
            $user = User::findOrFail($id);
            $user->update([
                'name' => $request->name,
                'email' => $request->email,
            ]);

            // Actualizar rol
            if ($user->roles()->exists()) {
                $user->syncRoles([$request->role]);
            } else {
                $user->assignRole($request->role);
            }

            return response()->json(['message' => 'Usuario actualizado correctamente', 'user' => $user], 200);
        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al actualizar el usuario: ' . $e->getMessage()], 500);
        }
    }

    /**
     * Eliminar un usuario.
     */
    public function deleteUser($id)
    {
        try {
            $user = User::findOrFail($id);
            $user->delete();

            return response()->json(['message' => 'Usuario eliminado correctamente'], 200);
        } catch (\Exception $e) {
            return response()->json(['error' => 'Error al eliminar el usuario: ' . $e->getMessage()], 500);
        }
    }
}
