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
        Schema::create('servicios', function (Blueprint $table) {
            $table->id('id_servicio');
            $table->foreignId('id_emprendimiento')->constrained('emprendimiento');
            $table->string('nombre_servicio', 150);
            $table->text('descripcion')->nullable();
            $table->decimal('precio', 10, 2);
            $table->string('ubicacion', 255)->nullable();
            $table->date('fecha_inicio')->nullable();
            $table->date('fecha_fin')->nullable();
            $table->enum('estado', ['activo', 'inactivo'])->default('activo')->nullable();
            $table->timestamp('fecha_publicacion')->useCurrent();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('servicios');
    }
};
