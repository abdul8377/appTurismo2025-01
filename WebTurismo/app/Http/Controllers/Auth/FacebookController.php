<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Support\Facades\Auth;
use Laravel\Socialite\Facades\Socialite;
use Illuminate\Support\Str;

class FacebookController extends Controller
{
    public function redirect()
    {
        return Socialite::driver('facebook')->redirect();
    }

    public function callback()
    {
        try {
            $fbUser = Socialite::driver('facebook')->user();

            $user = User::updateOrCreate(
                ['email' => $fbUser->getEmail()],
                [
                    'name' => $fbUser->getName(),
                    'password' => bcrypt(Str::random(24)),
                ]
            );

            Auth::login($user);
            session()->flash('google_welcome', '¡Bienvenido, ' . $user->name . '!');
            return redirect()->intended(route('dashboard'));

        } catch (\Exception $e) {
            return redirect()->route('login')->withErrors(['facebook_error' => $e->getMessage()]);
        }
    }
}
