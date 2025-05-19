<?php

namespace Database\Seeders;

use App\Models\CategoriaServicio;
use Illuminate\Database\Seeder;

class CategoriaServicioSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        CategoriaServicio::create([
            'nombre' => 'Cultura',
            'descripcion' => 'Experiencias culturales',
            'imagen' => 'images/cultura.jpg',
            'icono' => 'iconos/cultura.png'
        ]);

        CategoriaServicio::create([
            'nombre' => 'Gastronomía',
            'descripcion' => 'Experiencias culinarias',
            'imagen' => 'images/gastronomia.webp',
            'icono' => 'iconos/gastronomia.png'
        ]);

        CategoriaServicio::create([
            'nombre' => 'Experiencias',
            'descripcion' => 'Experiencias inolvidables',
            'imagen' => 'images/experiencias.jpg',
            'icono' => 'iconos/experiencias.png'
        ]);

        CategoriaServicio::create([
            'nombre' => 'Alojamiento',
            'descripcion' => 'Alojamientos para todos los gustos',
            'imagen' => 'images/alojamiento.jpeg',
            'icono' => 'iconos/alojamiento.png'
        ]);

        CategoriaServicio::create([
            'nombre' => 'Guías',
            'descripcion' => 'Los mejores guías turísticos',
            'imagen' => 'images/guia.jpg',
            'icono' => 'iconos/guia.png'
        ]);
    }
}
