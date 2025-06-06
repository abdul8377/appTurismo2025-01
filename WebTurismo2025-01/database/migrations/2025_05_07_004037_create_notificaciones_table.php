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
        Schema::create('notificaciones', function (Blueprint $table) {
            $table->bigIncrements('notificaciones_id');
            $table->unsignedBigInteger('users_id');
            $table->enum('tipo', ['reserva', 'mensaje', 'sancion', 'aprobacion', 'promocion']);
            $table->text('contenido');
            $table->boolean('leido')->default(false);
            $table->timestamp('creado_en')->useCurrent();
            $table->timestamp('updated_at')->useCurrent()->useCurrentOnUpdate();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('notificaciones');
    }
};
