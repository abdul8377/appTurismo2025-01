<?php

namespace Database\Factories;

use App\Models\Categoria;
use Illuminate\Database\Eloquent\Factories\Factory;

class CategoriaFactory extends Factory
{
    protected $model = Categoria::class;

    public function definition()
    {
        return [
            'nombre' => $this->faker->word,
            'tipo' => $this->faker->randomElement(['Producto', 'Servicio']),
            'descripcion' => $this->faker->paragraph,
        ];
    }
}
