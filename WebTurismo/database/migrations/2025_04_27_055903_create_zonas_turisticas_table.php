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
        Schema::create('zonas_turisticas', function (Blueprint $table) {
            $table->id('id_zona');
            $table->string('nombre', 150);
            $table->text('descripcion')->nullable();
            $table->string('ubicacion', 255)->nullable();
            $table->string('imagen_url', 255)->nullable();
            $table->enum('estado', ['activo', 'inactivo'])->default('activo')->nullable();
            $table->timestamp('fecha_creacion')->useCurrent();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('zonas_turisticas');
    }
};
