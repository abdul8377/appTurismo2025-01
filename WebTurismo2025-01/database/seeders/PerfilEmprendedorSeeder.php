<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\PerfilEmprendedor;
use App\Models\User;
use Spatie\Permission\Models\Role; // Asegúrate de usar Spatie para los roles

class PerfilEmprendedorSeeder extends Seeder
{
    public function run()
    {
        // Obtener el rol "Emprendedor"
        $role = Role::where('name', 'Emprendedor')->first();

        // Verificar si el rol "Emprendedor" existe, si no, crear el rol
        if (!$role) {
            $role = Role::create(['name' => 'Emprendedor']);
        }

        // Crear 5 usuarios con el rol "Emprendedor"
        $users = User::factory(5)->create(); // Usamos Factory para crear 5 usuarios

        // Asignar el rol "Emprendedor" a los usuarios creados
        foreach ($users as $user) {
            $user->assignRole('Emprendedor'); // Asigna el rol "Emprendedor" a cada usuario
        }

        // Crear perfiles de emprendedores para cada uno de los usuarios con el rol "Emprendedor"
        foreach ($users as $user) {
            PerfilEmprendedor::create([
                'users_id' => $user->id,
                'dni' => '12345678' . $user->id, // Asignar un DNI diferente para cada usuario
                'telefono_contacto' => '98765432' . $user->id,
                'experiencia' => 'Experiencia en emprendimiento número ' . $user->id,
                'estado_validacion' => 'pendiente', // Puedes ponerlo en pendiente para todos o cambiarlo
                'descripcion_emprendimiento' => 'Descripción del emprendimiento para el usuario ' . $user->id,
                'gmail_contacto' => 'emprendedor' . $user->id . '@gmail.com',
                'gmail_confirmado' => true,
                'codigo' => 'EM' . $user->id . 'CODE', // Un código único por usuario
            ]);
        }
    }
}
