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
        Schema::create('resenas', function (Blueprint $table) {
            $table->id('id_resena');
            $table->unsignedBigInteger('id_usuario');
            $table->foreign('id_usuario')->references('id')->on('users');
            $table->unsignedBigInteger('id_producto')->nullable();
            $table->foreign('id_producto')->references('id_producto')->on('productos');
            $table->unsignedBigInteger('id_servicio')->nullable();
            $table->foreign('id_servicio')->references('id_servicio')->on('servicios');
            $table->integer('puntuacion');
            $table->text('comentario')->nullable();
            $table->timestamp('fecha_resena')->useCurrent();
            $table->enum('estado', ['activo', 'inactivo'])->default('activo')->nullable();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('resenas');
    }
};
