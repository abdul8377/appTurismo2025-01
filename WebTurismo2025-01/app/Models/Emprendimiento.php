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

    public function usuarios()
    {
        return $this->belongsToMany(User::class, 'emprendimiento_usuarios', 'emprendimientos_id', 'users_id')
                    ->withPivot('rol_emprendimiento', 'fecha_asignacion')
                    ->withTimestamps();
    }

    // Relación inversa con los usuarios
    public function users()
    {
        return $this->belongsToMany(User::class, 'emprendimiento_usuarios', 'emprendimientos_id', 'users_id');
    }
}
