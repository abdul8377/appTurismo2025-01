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
        Schema::create('pagos', function (Blueprint $table) {
            $table->id('id_pago');
            $table->unsignedBigInteger('id_orden');
            $table->foreign('id_orden')->references('id_orden')->on('ordenes');
            $table->enum('metodo_pago', ['tarjeta', 'paypal', 'transferencia']);
            $table->decimal('monto_pagado', 10, 2);
            $table->timestamp('fecha_pago')->useCurrent();
            $table->enum('estado_pago', ['pendiente', 'completado', 'fallido'])->default('pendiente')->nullable();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pagos');
    }
};
