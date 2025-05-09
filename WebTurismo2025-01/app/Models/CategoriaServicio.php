<?php


namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class CategoriaServicio extends Model
{


    use HasFactory;
    // Definir la tabla si no sigue la convención
    protected $table = 'categorias_servicios';

    // Clave primaria
    protected $primaryKey = 'categorias_servicios_id';

    // Deshabilitar los timestamps si no se quieren usar (si ya tienes los campos created_at y updated_at)
    public $timestamps = true;

    // Campos que pueden ser asignados masivamente
    protected $fillable = [
        'nombre',
        'descripcion',
    ];

    /**
     * Relación con los servicios
     */
    public function servicios()
    {
        // Relación de uno a muchos con el modelo Servicio
        return $this->hasMany(Servicio::class, 'categorias_servicios_id');
    }


}
