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
        // Tabla de usuarios
        Schema::create('users', function (Blueprint $table) {
            $table->id();
            $table->string('name');                      // Nombre
            $table->string('last_name');                 // Apellido
            $table->string('user')->unique();            // Nombre de usuario único
            $table->string('email')->unique();           // Correo electrónico único
            $table->timestamp('email_verified_at')->nullable();
            $table->string('password');                  // Contraseña hasheada
            $table->string('country')->nullable();       // País (opcional)
            $table->string('zip_code')->nullable();      // Código postal (opcional)
            $table->rememberToken();                     // Token de sesión
            $table->timestamps();                        // created_at y updated_at
        });

        // Tabla de recuperación de contraseñas
        Schema::create('password_reset_tokens', function (Blueprint $table) {
            $table->string('email')->primary();          // Email único (clave primaria)
            $table->string('token');                     // Token de recuperación
            $table->timestamp('created_at')->nullable(); // Fecha de creación
        });

        // Tabla de sesiones (Laravel > 10)
        Schema::create('sessions', function (Blueprint $table) {
            $table->string('id')->primary();             // ID de sesión
            $table->foreignId('user_id')->nullable()->index();
            $table->string('ip_address', 45)->nullable();
            $table->text('user_agent')->nullable();      // Info del navegador
            $table->longText('payload');                 // Datos de sesión
            $table->integer('last_activity')->index();   // Timestamp de última actividad
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('sessions');
        Schema::dropIfExists('password_reset_tokens');
        Schema::dropIfExists('users');
    }
};
