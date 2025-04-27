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
        Schema::create('reservas', function (Blueprint $table) {
            $table->id('id_reserva');
            $table->unsignedBigInteger('id_usuario');
            $table->foreign('id_usuario')->references('id')->on('users');
            $table->unsignedBigInteger('id_servicio');
            $table->foreign('id_servicio')->references('id_servicio')->on('servicios');
            $table->dateTime('fecha_reserva');
            $table->integer('cantidad')->default(1);
            $table->enum('estado', ['pendiente', 'confirmada', 'cancelada'])->default('pendiente')->nullable();
            $table->timestamp('fecha_creacion')->useCurrent();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('reservas');
    }
};
