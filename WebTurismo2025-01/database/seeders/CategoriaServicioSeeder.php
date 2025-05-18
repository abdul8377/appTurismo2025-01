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
            'imagen'=>'images/gastronomia',
            'icono'=>'iconos/gastronomia'
        ]);
        $categoryService=CategoriaServicio::create([
            'nombre'=>'experiencias',
            'descripcion'=>'Experiencias inolvidables',
            'imagen'=>'images/experiencias',
            'icono'=>'iconos/experiencias'
        ]);
        $categoryService=CategoriaServicio::create([
            'nombre'=>'Alojamiento',
            'descripcion'=>'Alojamientos para todos los gustos',
            'imagen'=>'images/alojamiento',
            'icono'=>'iconos/alojamiento'
        ]);
        $categoryService=CategoriaServicio::create([
            'nombre'=>'Guias',
            'descripcion'=>'Los mejores guias turisticos',
            'imagen'=>'images/guia',
            'icono'=>'iconos/guia'
        ]);
    }
}
