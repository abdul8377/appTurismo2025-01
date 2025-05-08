<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;

class TuristaController extends Controller
{
    // Mostrar la lista de turistas
    public function index()
    {
        // Obtener todos los usuarios con perfil de turista
        $turistas = User::whereHas('perfilTurista')->get();

        return view('Turista.index', compact('turistas'));
    }

    // Mostrar los detalles completos de un turista
    public function show(User $turista)
    {
        // Cargar el perfil del turista
        $turista->load('perfilTurista');
        return view('Turista.show', compact('turista'));
    }

    // Mostrar el formulario para editar la contraseña de un turista
    public function edit(User $turista)
    {
        return view('Turista.edit', compact('turista'));
    }

    // Actualizar la contraseña de un turista
    public function update(Request $request, User $turista)
    {
        // Validar la nueva contraseña
        $validated = $request->validate([
            'password' => 'required|string|min:8|confirmed',
        ]);

        // Actualizar la contraseña
        $turista->update([
            'password' => Hash::make($validated['password']),
        ]);

        return redirect()->route('turistas.index')->with('success', 'Contraseña actualizada correctamente');
    }
}
