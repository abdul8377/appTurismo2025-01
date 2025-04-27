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
        Schema::create('emprendimiento_usuarios', function (Blueprint $table) {
            $table->id('id_emprendimiento_usuarios');
            $table->unsignedBigInteger('id_emprendimiento');
            $table->unsignedBigInteger('id_usuario');
            $table->foreign('id_usuario')->references('id')->on('users');
            $table->enum('rol_emprendimiento', ['propietario', 'colaborador'])->default('propietario')->nullable();
            $table->timestamp('fecha_asignacion')->useCurrent();

            $table->foreign('id_emprendimiento')->references('id_emprendimiento')->on('emprendimiento');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('emprendimiento_usuarios');
    }
};
