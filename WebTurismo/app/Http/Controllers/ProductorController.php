<?php
namespace App\Http\Controllers;

use App\Models\Emprendimiento;
use App\Models\User;
use Illuminate\Http\Request;

class ProductorController extends Controller
{
    /**
     * Obtener los usuarios con rol "Productor" que no están vinculados a ningún emprendimiento.
     */
    public function getUsuariosProductoresLibres()
    {
        // Obtener los usuarios con rol "Productor" que no están vinculados a un emprendimiento
        $productoresLibres = User::role('Productor')
            ->whereDoesntHave('emprendimientoUsuarios')  // Asegura que no estén vinculados a ningún emprendimiento
            ->get();

        // Si no se encuentran usuarios libres
        if ($productoresLibres->isEmpty()) {
            return response()->json(['message' => 'No hay usuarios con rol "Productor" libres.'], 404);
        }

        return response()->json($productoresLibres);
    }

    /**
     * Obtener todos los emprendimientos disponibles.
     */
    public function getEmprendimientos()
    {
        // Obtener todos los emprendimientos sin ningún filtro
        $emprendimientos = Emprendimiento::all();

        // Si no se encuentran emprendimientos
        if ($emprendimientos->isEmpty()) {
            return response()->json(['message' => 'No hay emprendimientos disponibles.'], 404);
        }

        return response()->json($emprendimientos);
    }


}

