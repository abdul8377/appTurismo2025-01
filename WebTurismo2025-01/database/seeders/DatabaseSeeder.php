<?php

namespace Database\Seeders;

use App\Models\Categoria;
use App\Models\CategoriaServicio;
use App\Models\PerfilEmprendedor;
use App\Models\TipoDeNegocio;
use App\Models\User;

// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
       //Primero permisos y roles
       $this->call(PermissionSeeder::class);
       $this->call(RoleSeeder::class);
       //Usuario administrador
       $this->call(UserSeeder::class);

       //categoria servicio
       $this->call(CategoriaServicioSeeder::class);

       TipoDeNegocio::factory()->count(10)->create();
       $this->call(PerfilEmprendedorSeeder::class); // Llamar al seeder de PerfilEmprendedor



    }

}
