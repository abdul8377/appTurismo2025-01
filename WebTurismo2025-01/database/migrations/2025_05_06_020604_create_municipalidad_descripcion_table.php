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
        Schema::create('municipalidad_descripcion', function (Blueprint $table) {
            $table->bigIncrements('municipalidad_descripcion_id');
            $table->string('logo_url', 255)->nullable();
            $table->string('direccion', 255)->nullable();
            $table->text('descripcion')->nullable();
            $table->string('ruc', 20)->nullable();
            $table->string('correo', 100)->nullable();
            $table->string('telefono', 20)->nullable();
            $table->string('nombre_alcalde', 100)->nullable();
            $table->string('facebook_url', 255)->nullable();
            $table->string('anio_gestion', 10)->nullable();
            $table->string('imagen_url', 255)->nullable();
            $table->timestamp('created_at')->useCurrent();
            $table->timestamp('updated_at')->useCurrent()->useCurrentOnUpdate();

        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('municipalidad_descripcion');
    }
};
