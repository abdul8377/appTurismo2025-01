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
       Schema::create('images', function (Blueprint $table) {
            $table->id();
            $table->string('url');
            $table->unsignedBigInteger('imageable_id');
            $table->string('imageable_type');
            $table->string('tipo')->nullable(); // ejemplo: 'portada', 'galeria', etc.
            $table->timestamps();

            $table->index(['imageable_id', 'imageable_type']); // Mejora las consultas
        });

    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('images');
    }
};
