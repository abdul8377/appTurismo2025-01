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

    //public $timestamps = true;

    // Campos que pueden ser asignados masivamente
    protected $fillable = [
        'nombre',
        'descripcion',
        'imagen',
        'icono'
    ];



    // Genera URL completa al recurso en public/storage
    public function getImagenUrlAttribute(): ?string
    {
        if (! $this->imagen) {
            return null;
        }
        // Asegúrate de que 'imagen' sea algo como "images/cultura.jpg"
        return URL::to("storage/{$this->imagen}");
    }

    public function getIconoUrlAttribute(): ?string
    {
        if (! $this->icono) {
            return null;
        }
        return URL::to("storage/{$this->icono}");
    }

    protected $appends = ['imagen_url', 'icono_url'];
    protected $hidden  = ['imagen', 'icono'];

    public function servicios()
    {
        // Relación de uno a muchos con el modelo Servicio
        return $this->hasMany(Servicio::class, 'categorias_servicios_id');
    }


}
