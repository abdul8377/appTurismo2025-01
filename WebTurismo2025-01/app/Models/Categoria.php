<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Categoria extends Model
{
    protected $table = 'categorias';
    protected $primaryKey = 'id';
    public $timestamps = true;

    protected $fillable = [
        'nombre',
        'tipo',
        'descripcion',
    ];

    public function scopeProductos($query)
    {
        return $query->where('tipo', 'Producto');
    }

    public function scopeServicios($query)
    {
        return $query->where('tipo', 'Servicio');
    }
}
