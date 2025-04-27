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
        Schema::create('emprendimiento', function (Blueprint $table) {
            $table->id('id_emprendimiento');
            $table->string('nombre', 255);
            $table->text('descripcion')->nullable();
            $table->unsignedBigInteger('id_tipo_negocio')->nullable();
            $table->foreign('id_tipo_negocio')->references('id_tipo_negocio')->on('tipos_negocio');
            $table->string('direccion', 255)->nullable();
            $table->string('telefono', 20)->nullable();
            $table->enum('estado', ['activo', 'inactivo'])->default('activo');
            $table->timestamp('fecha_registro')->useCurrent();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('emprendimiento');
    }
};
