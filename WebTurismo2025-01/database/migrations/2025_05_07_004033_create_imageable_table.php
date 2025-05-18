<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    // /**
    //  * Run the migrations.
    //  */
    // public function up(): void
    // {
    //     Schema::create('imageable', function (Blueprint $table) {
    //         $table->bigIncrements('imageable_registro_id');
    //         $table->unsignedBigInteger('images_id');
    //         $table->string('imageable_type');
    //         $table->unsignedBigInteger('imageable_id');
    //         $table->timestamp('created_at')->useCurrent();
    //         $table->timestamp('updated_at')->useCurrent()->useCurrentOnUpdate();

    //         $table->foreign('images_id')->references('images_id')->on('images');

    //     });
    // }

    // /**
    //  * Reverse the migrations.
    //  */
    // public function down(): void
    // {
    //     Schema::dropIfExists('imageable');
    // }
};
