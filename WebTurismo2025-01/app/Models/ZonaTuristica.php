<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class ZonaTuristica extends Model
{
    protected $table = 'zonas_turisticas';
    protected $primaryKey = 'zonas_turisticas_id';
    public $timestamps = false;

    protected $fillable = [
        'nombre',
        'descripcion',
        'ubicacion',
        'imagen_url',
        'estado',
        'created_at'
    ];
}
