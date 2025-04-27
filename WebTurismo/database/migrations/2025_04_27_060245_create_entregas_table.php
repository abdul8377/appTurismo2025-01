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
        Schema::create('entregas', function (Blueprint $table) {
            $table->id('id_entrega');
            $table->unsignedBigInteger('id_orden');
            $table->foreign('id_orden')->references('id_orden')->on('ordenes');
            $table->timestamp('fecha_entrega')->nullable();
            $table->enum('estado_entrega', ['pendiente', 'recogido', 'enviado'])->default('pendiente')->nullable();
            $table->text('observaciones')->nullable();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('entregas');
    }
};
