<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Slider extends Model
{
    protected $table = 'slider';
    protected $primaryKey = 'slider_id';
    public $timestamps = false;

    protected $fillable = [
        'url_imagen',
        'titulo',
        'descripcion'
    ];
}
