<?php
namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class EmprendimientoUsuario extends Model
{
    use HasFactory;

    // Definir la tabla asociada
    protected $table = 'emprendimiento_usuarios';

    // Especificar la clave primaria
    protected $primaryKey = 'id_emprendimiento_usuarios';

    // Especificar los campos asignables masivamente
    protected $fillable = [
        'id_emprendimiento',
        'id_usuario',
        'rol_emprendimiento',
        'fecha_asignacion',
    ];

    // Relaciones
    public function emprendimiento()
    {
        return $this->belongsTo(Emprendimiento::class, 'id_emprendimiento', 'id_emprendimiento');
    }

    public function usuario()
    {
        return $this->belongsTo(User::class, 'id_usuario', 'id');
    }
}
