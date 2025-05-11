<?php

namespace App\Http\Controllers\Municipalidad;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\MunicipalidadDescripcion;
use App\Models\Image;
use Illuminate\Support\Facades\Storage;

class MunicipalidadDescripcionController extends Controller
{
    public function index()
    {
        $municipalidad = MunicipalidadDescripcion::with('images')->first();
        return view('Municipalidad.index', compact('municipalidad'));
    }

    public function store(Request $request)
    {
        if (MunicipalidadDescripcion::exists()) {
            return redirect()->route('municipalidad.index')->with('error', 'Ya existe un registro de la municipalidad.');
        }

        $data = $request->validate([
            'direccion'        => 'nullable|string|max:255',
            'descripcion'      => 'nullable|string',
            'ruc'              => 'nullable|string|max:20',
            'correo'           => 'nullable|email|max:100',
            'telefono'         => 'nullable|string|max:20',
            'nombre_alcalde'   => 'nullable|string|max:100',
            'facebook_url'     => 'nullable|url|max:255',
            'anio_gestion'     => 'nullable|string|max:10',
            'nombre'           => 'nullable|string|max:100',
            'color_primario'   => 'nullable|string|max:10',
            'color_secundario' => 'nullable|string|max:10',
            'mantenimiento'    => 'nullable|boolean',
        ]);

        MunicipalidadDescripcion::create($data);

        return redirect()->route('municipalidad.index')->with('success', 'Municipalidad registrada correctamente.');
    }

    public function update(Request $request, $id)
    {
        $municipalidad = MunicipalidadDescripcion::findOrFail($id);
        $municipalidad->update($request->except(['_token', '_method']));
        return redirect()->route('municipalidad.index')->with('success', 'Dato actualizado.');
    }

    public function uploadImage(Request $request, $id)
    {
        $request->validate([
            'image' => 'required|image|max:2048',
            'tipo'  => 'required|in:logo,portada,perfil,galeria',
        ]);

        $municipalidad = MunicipalidadDescripcion::findOrFail($id);
        $path = $request->file('image')->store('municipalidad', 'public');

        $municipalidad->images()->create([
            'url'  => $path,
            'tipo' => $request->tipo,
        ]);

        return redirect()->route('municipalidad.index')->with('success', 'Imagen agregada correctamente.');
    }

    public function galeria()
    {
        $municipalidad = MunicipalidadDescripcion::with('images')->first();
        return view('Municipalidad.galeria', compact('municipalidad'));
    }

    public function destroyImagen($id)
    {
        $imagen = Image::findOrFail($id);

        if (Storage::disk('public')->exists($imagen->url)) {
            Storage::disk('public')->delete($imagen->url);
        }

        $imagen->delete();
        return redirect()->back()->with('success', 'Imagen eliminada correctamente.');
    }

    public function toggleMantenimiento($id)
    {
        $municipalidad = MunicipalidadDescripcion::findOrFail($id);
        $municipalidad->update(['mantenimiento' => !$municipalidad->mantenimiento]);
        return redirect()->back()->with('success', 'Modo de mantenimiento actualizado.');
    }
}
