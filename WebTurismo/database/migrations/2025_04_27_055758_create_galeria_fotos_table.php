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
        Schema::create('galeria_fotos', function (Blueprint $table) {
            $table->id('id_foto');
            $table->string('titulo', 150)->nullable();
            $table->text('descripcion')->nullable();
            $table->string('imagen_url', 255);
            $table->enum('estado', ['activo', 'inactivo'])->default('activo');
            $table->timestamp('fecha_subida')->useCurrent();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('galeria_fotos');
    }
};
