<?php

namespace Database\Seeders;

use App\Models\CategoriaServicio;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class CategoriaServicioSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $categoryService=CategoriaServicio::create([
            'nombre'=>'Cutura',
            'descripcion'=>'Experiencias culturales',
            'imagen'=>'images/cultura.jpg',
            'icono'=>'iconos/cultura.png'
        ]);
        $categoryService=CategoriaServicio::create([
            'nombre'=>'Gastronomia',
            'descripcion'=>'Experiencias culinarias',
            'imagen'=>'images/gastronomia.webp',
            'icono'=>'iconos/gastronomia.png'
        ]);
        $categoryService=CategoriaServicio::create([
            'nombre'=>'experiencias',
            'descripcion'=>'Experiencias inolvidables',
            'imagen'=>'images/experiencias.jpg',
            'icono'=>'iconos/experiencias.png'
        ]);
        $categoryService=CategoriaServicio::create([
            'nombre'=>'Alojamiento',
            'descripcion'=>'Alojamientos para todos los gustos',
            'imagen'=>'images/alojamiento.jpeg',
            'icono'=>'iconos/alojamiento.png'
        ]);
        $categoryService=CategoriaServicio::create([
            'nombre'=>'Guias',
            'descripcion'=>'Los mejores guias turisticos',
            'imagen'=>'images/guia.jpg',
            'icono'=>'iconos/guia.png'
        ]);
    }
}
