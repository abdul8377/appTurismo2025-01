<?php

namespace Database\Factories;

use App\Models\CategoriaServicio;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\CategoriaServicio>
 */
class CategoriaServicioFactory extends Factory
{
    /**
     * El nombre del modelo correspondiente a la factoría.
     *
     * @var string
     */
    protected $model = CategoriaServicio::class;

    /**
     * Definir los datos predeterminados de la factoría.
     *
     * @return array
     */
    public function definition(): array
    {
        return [
            'nombre' => $this->faker->word, // Genera una palabra aleatoria para el nombre
            'descripcion' => $this->faker->paragraph, // Genera un párrafo aleatorio para la descripción
            'created_at' => now(),
            'updated_at' => now(),
        ];
    }
}
