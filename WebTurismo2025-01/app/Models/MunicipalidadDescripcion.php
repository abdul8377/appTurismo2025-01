<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class MunicipalidadDescripcion extends Model
{
    protected $table = 'municipalidad_descripcion';
    protected $primaryKey = 'municipalidad_descripcion_id';
    public $timestamps = true;

    protected $fillable = [
        'logo_url',
        'direccion',
        'descripcion',
        'ruc',
        'correo',
        'telefono',
        'nombre_alcalde',
        'facebook_url',
        'anio_gestion',
        'imagen_url'
    ];
}
