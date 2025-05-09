<?php

namespace Database\Seeders;

use App\Models\User;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $user=User::create([
            'name'=>'Franck Coaquira',
            'email'=>'franck@gmail.com',
            'password'=>bcrypt('12345678')
        ]);
        $user->assignRole('Administrador');

        $user=User::create([
            'name'=>'Emprendedor1',
            'email'=>'emprendedor@gmail.com',
            'password'=>bcrypt('12345678')
        ]);
        $user->assignRole('Emprendedor');

        $user=User::create([
            'name'=>'Emprendedor2',
            'email'=>'emprendedor2@gmail.com',
            'password'=>bcrypt('12345678')
        ]);
        $user->assignRole('Emprendedor');

        $user=User::create([
            'name'=>'Emprendedor3',
            'email'=>'emprendedor3@gmail.com',
            'password'=>bcrypt('12345678')
        ]);
        $user->assignRole('Emprendedor');

        $user=User::create([
            'name'=>'Emprendedor4',
            'email'=>'emprendedor4@gmail.com',
            'password'=>bcrypt('12345678')
        ]);
        $user->assignRole('Emprendedor');

        $user=User::create([
            'name'=>'Emprendedor5',
            'email'=>'emprendedor5@gmail.com',
            'password'=>bcrypt('12345678')
        ]);
        $user->assignRole('Emprendedor');

        //Usuarios

        $user=User::create([
            'name'=>'Usuario1',
            'email'=>'usuario1@gmail.com',
            'password'=>bcrypt('12345678')
        ]);
        $user->assignRole('Usuario');


        $user=User::create([
            'name'=>'Usuario2',
            'email'=>'usuario2@gmail.com',
            'password'=>bcrypt('12345678')
        ]);
        $user->assignRole('Usuario');


        $user=User::create([
            'name'=>'Usuario3',
            'email'=>'usuario3@gmail.com',
            'password'=>bcrypt('12345678')
        ]);
        $user->assignRole('Usuario');


        $user=User::create([
            'name'=>'Usuario4',
            'email'=>'usuario4@gmail.com',
            'password'=>bcrypt('12345678')
        ]);
        $user->assignRole('Usuario');


        $user=User::create([
            'name'=>'Usuario5',
            'email'=>'usuario5@gmail.com',
            'password'=>bcrypt('12345678')
        ]);
        $user->assignRole('Usuario');






    }
}
