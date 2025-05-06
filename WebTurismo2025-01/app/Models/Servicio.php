<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Servicio extends Model
{
    protected $table = 'servicios';
    protected $primaryKey = 'servicios_id';
    public $timestamps = true; // Porque tiene created_at y updated_at

    protected $fillable = [
        'emprendimientos_id',
        'nombre',
        'descripcion',
        'precio',
        'capacidad_maxima',
        'duracion_servicio',
        'imagen_destacada'
    ];

    // Relaciones
    public function emprendimiento()
    {
        return $this->belongsTo(Emprendimiento::class, 'emprendimientos_id', 'emprendimientos_id');
    }

}
