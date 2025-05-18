<?php


namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class CategoriaServicio extends Model
{


    use HasFactory;
    protected $table = 'categorias_servicios';
    protected $primaryKey = 'categorias_servicios_id';

    //public $timestamps = true;

    // Campos que pueden ser asignados masivamente
    protected $fillable = [
        'nombre',
        'descripcion',
        'imagen',
        'icono'
    ];


    public function servicios()
    {
        // Relación de uno a muchos con el modelo Servicio
        return $this->hasMany(Servicio::class, 'categorias_servicios_id');
    }


}
