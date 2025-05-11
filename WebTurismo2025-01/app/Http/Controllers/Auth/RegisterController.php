<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Auth\Events\Registered;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use Illuminate\Validation\Rules;
use Lwwcas\LaravelCountries\Models\Country;

class RegisterController extends Controller
{
   public function show()
    {
        app()->setLocale('es');

        $countries = Country::whereNotNull('iso_alpha_2')
            ->orderBy('official_name') // opcional, para orden alfabético
            ->pluck('official_name', 'iso_alpha_2') // ← Aquí también
            ->toArray();

        return view('auth.register', compact('countries'));
    }


    public function register(Request $request)
    {
        $validated = $request->validate([
            'name' => 'required|string|max:255',
            'last_name' => 'required|string|max:255',
            'user' => 'required|string|max:100|unique:users,user',
            'email' => 'required|string|email|max:255|unique:users,email',
            'country' => 'required|string|in:' . implode(',', Country::pluck('iso_alpha_2')->toArray()), // ← Aquí el fix
            'zip_code' => 'nullable|string|max:20',
            'password' => ['required', 'confirmed', Rules\Password::defaults()],
        ]);

        $validated['password'] = Hash::make($validated['password']);

        $user = User::create($validated);

        event(new Registered($user));
        Auth::login($user);

        return redirect()->route('dashboard');
    }
}
