<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Producto extends Model
{
    protected $table = 'productos';
    protected $primaryKey = 'productos_id';
    public $timestamps = false;

    protected $fillable = [
        'emprendimientos_id',
        'nombre',
        'descripcion',
        'precio',
        'unidad',
        'categorias_id',
        'imagen_destacada',
        'stock',
        'capacidad_total'
    ];

    // Relaciones
    public function emprendimiento()
    {
        return $this->belongsTo(Emprendimiento::class, 'emprendimientos_id', 'emprendimientos_id');
    }

    public function categoria()
    {
        return $this->belongsTo(Categoria::class, 'categorias_id', 'categorias_id');
    }
}
