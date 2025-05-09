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
            $table->bigIncrements('servicios_id');
            $table->unsignedBigInteger('emprendimientos_id');
            $table->string('nombre', 150);
            $table->text('descripcion')->nullable();
            $table->decimal('precio', 10, 2);
            $table->integer('capacidad_maxima');
            $table->integer('duracion_servicio')->nullable();
            $table->string('imagen_destacada', 255)->nullable();
            $table->unsignedBigInteger('categorias_servicios_id');  // Agregar la columna de clave foránea para categorías de servicio
            $table->timestamp('created_at')->useCurrent();
            $table->timestamp('updated_at')->useCurrent()->useCurrentOnUpdate();

            // Definir las claves foráneas
            $table->foreign('emprendimientos_id')->references('emprendimientos_id')->on('emprendimientos');
            $table->foreign('categorias_servicios_id')->references('categorias_servicios_id')->on('categorias_servicios'); // Relación con categorías de servicio
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
