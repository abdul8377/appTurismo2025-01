<?php

namespace App\Http\Controllers;

use App\Models\User;
use App\Models\PerfilEmprendedor;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Spatie\Permission\Models\Role;

class EmprendedorController extends Controller
{
    // Mostrar la lista de emprendedores
    public function index()
    {
        // Listar todos los emprendedores con el perfil asociado
        $emprendedores = User::whereHas('perfilEmprendedor')->get();

        return view('Emprendedor.index', compact('emprendedores'));
    }

    // Mostrar el formulario para crear un nuevo usuario y perfil
    public function create()
    {
        return view('Emprendedor.create');
    }

    // Guardar el usuario y su perfil
    public function store(Request $request)
    {
        // Validar datos del usuario
        $validatedUser = $request->validate([
            'name' => 'required|string|max:255',
            'email' => 'required|email|unique:users,email',
            'password' => 'required|string|min:8|confirmed',
        ]);

        // Crear el usuario
        $user = User::create([
            'name' => $validatedUser['name'],
            'email' => $validatedUser['email'],
            'password' => Hash::make($validatedUser['password']),
        ]);

        // Asignar el rol de 'Emprendedor' automáticamente
        $user->assignRole('Emprendedor');

        // Validar y guardar el perfil de emprendedor
        $validatedProfile = $request->validate([
            'dni' => 'required|string|max:20',
            'telefono_contacto' => 'nullable|string|max:20',
            'gmail_contacto' => 'nullable|string|max:255',
            'experiencia' => 'nullable|string',
        ]);

        // Crear el perfil de emprendedor
        $user->perfilEmprendedor()->create($validatedProfile);

        return redirect()->route('emprendedores.index')->with('success', 'Emprendedor creado correctamente');
    }

    // Mostrar los detalles completos de un emprendedor
    public function show(User $emprendedor)
    {
        // Cargar el perfil de emprendedor relacionado
        $emprendedor->load('perfilEmprendedor');
        return view('Emprendedor.show', compact('emprendedor'));
    }

    // Mostrar el formulario para editar el perfil de un emprendedor
    public function edit(User $emprendedor)
    {
        // Cargar el perfil de emprendedor
        $emprendedor->load('perfilEmprendedor');
        return view('Emprendedor.edit', compact('emprendedor'));
    }

    // Actualizar el perfil de un emprendedor
    public function update(Request $request, User $emprendedor)
{
    // Validar los datos del perfil del emprendedor
    $validatedProfile = $request->validate([
        'dni' => 'required|string|max:20',
        'telefono_contacto' => 'nullable|string|max:20',
        'gmail_contacto' => 'nullable|string|max:255',
        'experiencia' => 'nullable|string',
    ]);

    // Actualizar el perfil del emprendedor
    $emprendedor->perfilEmprendedor->update($validatedProfile);

    // Verificar si se proporcionó una nueva contraseña
    if ($request->filled('password')) {
        // Validar la nueva contraseña
        $request->validate([
            'password' => 'required|string|min:8|confirmed',
        ]);

        // Actualizar la contraseña del usuario
        $emprendedor->update([
            'password' => Hash::make($request->password),
        ]);
    }

    return redirect()->route('emprendedores.index')->with('success', 'Perfil actualizado correctamente');
}


    public function updateStatus(Request $request, User $emprendedor)
        {
            // Validar el estado de validación
            $validated = $request->validate([
                'estado_validacion' => 'required|in:pendiente,aprobado,rechazado',
            ]);

            // Actualizar el estado de validación
            $emprendedor->perfilEmprendedor->update([
                'estado_validacion' => $validated['estado_validacion'],
            ]);

            return redirect()->route('emprendedores.show', $emprendedor)
                            ->with('success', 'Estado de validación actualizado correctamente.');
        }

}
