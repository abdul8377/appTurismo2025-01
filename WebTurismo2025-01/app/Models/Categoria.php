<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Categoria extends Model
{
    use HasFactory;

    // Indicar qué campos pueden ser asignados masivamente
    protected $fillable = ['nombre', 'tipo', 'descripcion'];

    // Definir las relaciones, si las hay, entre tablas
    // Ejemplo: Si tienes una relación con otro modelo llamado Producto
    // public function productos()
    // {
    //     return $this->hasMany(Producto::class);
    // }
}
