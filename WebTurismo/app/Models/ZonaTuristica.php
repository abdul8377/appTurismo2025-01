<?php

namespace App\Models;



use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;


class ZonaTuristica extends Model
{
    use HasFactory;
    protected $table = 'zonas_turisticas';
    protected $primaryKey = 'id_zona';
    public $timestamps = false;

    protected $fillable = [
        'nombre',
        'descripcion',
        'ubicacion',
        'imagen_url',
        'estado',
        'fecha_creacion'
    ];
}
