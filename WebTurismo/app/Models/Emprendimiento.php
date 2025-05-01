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
     * Relación: Un emprendimiento puede tener muchos usuarios a través de EmprendimientoUsuario.
     */
    public function emprendimientoUsuarios()
    {
        return $this->hasMany(EmprendimientoUsuario::class, 'id_emprendimiento');
    }

    /**
     * Relación: Emprendimiento pertenece a un tipo de negocio.
     */
    public function tipoNegocio()
    {
        return $this->belongsTo(TipoNegocio::class);
    }

    // Modelo Emprendimiento
    public function usuarios()
        {
            return $this->belongsToMany(User::class, 'emprendimiento_usuarios', 'id_emprendimiento', 'id_usuario');
        }



}
