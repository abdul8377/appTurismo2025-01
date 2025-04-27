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
        Schema::create('detalle_orden', function (Blueprint $table) {
            $table->id('id_detalle');
            $table->unsignedBigInteger('id_orden');
            $table->foreign('id_orden')->references('id_orden')->on('ordenes');
            $table->unsignedBigInteger('id_producto')->nullable();
            $table->foreign('id_producto')->references('id_producto')->on('productos');
            $table->unsignedBigInteger('id_servicio')->nullable();
            $table->foreign('id_servicio')->references('id_servicio')->on('servicios');
            $table->integer('cantidad');
            $table->decimal('precio_unitario', 10, 2);
            $table->decimal('subtotal', 10, 2);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('detalle_orden');
    }
};
