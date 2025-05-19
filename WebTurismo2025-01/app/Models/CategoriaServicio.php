<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Support\Facades\URL;

class CategoriaServicio extends Model
{
    use HasFactory;

    protected $table = 'categorias_servicios';
    protected $primaryKey = 'categorias_servicios_id';

    // Campos que pueden ser asignados masivamente
    protected $fillable = [
        'nombre',
        'descripcion',
        'imagen',
        'icono',
    ];

    // Agrega automáticamente estos atributos calculados al JSON
    protected $appends = ['imagen_url', 'icono_url'];

    // Oculta los atributos 'imagen' e 'icono' en la respuesta JSON
    protected $hidden = ['imagen', 'icono'];

    /**
     * Accesor para la URL completa de la imagen.
     */
    public function getImagenUrlAttribute(): ?string
    {
        return $this->imagen ? URL::to("storage/{$this->imagen}") : null;
    }

    /**
     * Accesor para la URL completa del icono.
     */
    public function getIconoUrlAttribute(): ?string
    {
        return $this->icono ? URL::to("storage/{$this->icono}") : null;
    }

    /**
     * Relación con el modelo Servicio.
     */
    public function servicios()
    {
        return $this->hasMany(Servicio::class, 'categorias_servicios_id');
    }
}
