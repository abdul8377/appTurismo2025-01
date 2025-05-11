<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('images', function (Blueprint $table) {
            $table->id();

            // Ruta o nombre del archivo
            $table->string('url');

            // Relación polimórfica
            $table->unsignedBigInteger('imageable_id');
            $table->string('imageable_type');

            // Nuevo campo: tipo de imagen (logo, portada, perfil, galeria)
            $table->string('tipo')->nullable(); // <--- Este campo es necesario

            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('images');
    }
};
