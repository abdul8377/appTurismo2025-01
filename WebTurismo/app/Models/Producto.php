<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Producto extends Model
{
    use HasFactory;
    protected $table = 'productos';

    protected $primaryKey = 'id_producto';
    protected $fillable = [
        'id_emprendimiento',
        'id_categoria',
        'nombre_producto',
        'descripcion',
        'precio',
        'stock',
        'imagen_url',
        'estado',
    ];

    //relacion de muchos a uno con categorias
    public function category(){
        return $this->belongsTo(Categoria::class);
    }


}
