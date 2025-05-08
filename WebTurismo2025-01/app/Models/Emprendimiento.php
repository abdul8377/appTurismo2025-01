<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Emprendimiento extends Model
{
    protected $table = 'emprendimientos';
    protected $primaryKey = 'emprendimientos_id';
    public $timestamps = false;

    protected $fillable = [
        'nombre',
        'descripcion',
        'categorias_id',
        'direccion',
        'telefono',
        'estado',
        'fecha_registro',
        'imagen_destacada'
    ];

    // Relaciones
    public function emprendimientos()
{
    return $this->hasMany(Emprendimiento::class, 'tipo_negocio_id');
}

    public function blogs()
    {
        return $this->hasMany(Blog::class, 'emprendimientos_id', 'emprendimientos_id');
    }
}
