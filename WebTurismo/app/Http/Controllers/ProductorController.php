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
    // Método para obtener los emprendimientos que no están vinculados a ningún usuario
        public function getEmprendimientos()
            {
                // Obtener los emprendimientos que no están vinculados a ningún usuario
                $emprendimientosLibres = Emprendimiento::doesntHave('usuarios')  // Asegura que no estén vinculados a ningún usuario
                    ->get();

                // Si no se encuentran emprendimientos libres
                if ($emprendimientosLibres->isEmpty()) {
                    return response()->json(['message' => 'No hay emprendimientos libres.'], 404);
                }

                return response()->json($emprendimientosLibres);
            }


}

