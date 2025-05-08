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
        Schema::create('emprendimientos', function (Blueprint $table) {
            $table->bigIncrements('emprendimientos_id');
            $table->string('nombre', 255);
            $table->text('descripcion')->nullable();
            $table->unsignedBigInteger('tipo_negocio_id')->nullable(); // CAMBIO AQUÍ
            $table->string('direccion', 255)->nullable();
            $table->string('telefono', 20)->nullable();
            $table->enum('estado', ['activo', 'inactivo', 'pendiente'])->default('pendiente');
            $table->timestamp('fecha_registro')->useCurrent();
            $table->string('imagen_destacada', 255)->nullable();

            // Nueva relación
            $table->foreign('tipo_negocio_id')->references('id')->on('tipos_de_negocio'); // CAMBIO AQUÍ
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('emprendimientos');
    }
};
