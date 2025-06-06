<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration {
    public function up(): void
    {
        Schema::create('tipos_de_negocio', function (Blueprint $table) {
            $table->id();
            $table->string('nombre'); // o el campo que necesites
            $table->text('descripcion')->nullable(); // opcional
            $table->timestamps(); // created_at y updated_at
        });
    }

    public function down(): void
    {
        Schema::dropIfExists('tipos_de_negocio');
    }
};
