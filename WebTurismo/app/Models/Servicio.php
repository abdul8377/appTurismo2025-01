<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Servicio extends Model
{
    use HasFactory;

    protected $table = 'servicios';
    protected $primaryKey = 'id_servicio';
    public $timestamps = false;

    protected $fillable = [
        'id_emprendimiento',
        'nombre_servicio',
        'descripcion',
        'precio',
        'ubicacion',
        'fecha_inicio',
        'fecha_fin',
        'estado',
        'fecha_publicacion'
    ];

    // Relación con emprendimiento
    public function emprendimiento()
    {
        return $this->belongsTo(Emprendimiento::class);
    }
}
