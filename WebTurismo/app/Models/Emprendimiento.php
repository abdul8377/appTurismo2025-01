<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Emprendimiento extends Model
{
    use HasFactory;



    protected $table = 'emprendimiento';

    protected $primaryKey = 'id_emprendimiento';

    protected $fillable = [
        'nombre',
        'descripcion',
        'id_tipo_negocio',
        'direccion',
        'telefono',
        'estado',
        'fecha_registro',
    ];


    /**
     * Relación: Emprendimiento pertenece a un tipo de negocio
     */
    public function tipoNegocio()
    {
        return $this->belongsTo(TipoNegocio::class);
    }
}
