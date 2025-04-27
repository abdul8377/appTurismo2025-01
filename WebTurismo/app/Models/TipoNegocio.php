<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class TipoNegocio extends Model
{
    //
    use HasFactory;

    protected $table = 'tipos_negocio';
    protected $primaryKey = 'id_tipo_negocio';

    protected $fillable = [
        'nombre',
    ];
    /**
     * Relación: Un tipo de negocio tiene muchos emprendimientos
     */
    public function emprendimientos()
    {
        return $this->hasMany(Emprendimiento::class, 'id_tipo_negocio', 'id_tipo_negocio');
    }
}
