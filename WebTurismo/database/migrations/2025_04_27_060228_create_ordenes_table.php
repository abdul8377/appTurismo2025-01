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
        Schema::create('ordenes', function (Blueprint $table) {
            $table->id('id_orden');
            $table->foreignId('id_usuario')->constrained('users');
            $table->timestamp('fecha_orden')->useCurrent();
            $table->enum('estado_orden', ['pendiente', 'pagado', 'cancelado'])->default('pendiente')->nullable();
            $table->decimal('total', 10, 2);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('ordenes');
    }
};
