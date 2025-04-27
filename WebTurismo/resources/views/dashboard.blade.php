<x-layouts.app :title="__('Dashboard')">
    <div class="py-6 px-4 sm:px-8">
        <h1 class="text-3xl font-bold mb-2 text-center text-gray-800 dark:text-white">
            <i class="fas fa-mountain-sun mr-2 text-blue-600"></i> Mejores tours en Capachica
        </h1>
        <p class="text-center text-gray-500 dark:text-gray-300 mb-10">
            Conoce nuestra mejor selección de paquetes turísticos en Capachica.
        </p>

        <div class="grid gap-6 grid-cols-1 sm:grid-cols-2 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 justify-center">
            <!-- CARD -->
            @foreach (range(1, 19) as $i)
                @php
                    $titles = ['Promoción: City + Valle + Humantay', 'Inti Raymi Cusco Full Day', 'Montaña de 7 colores', 'Laguna Humantay Full Day'];
                    $descriptions = [
                        'Recorre los mejores destinos de Cusco: Valle Sagrado, Montaña de 7 colores y Laguna Humantay.',
                        'Vive la fiesta más importante del imperio Inca con un recorrido completo por el centro histórico.',
                        'Un paisaje multicolor que parece de otro mundo. Incluye transporte, guía y desayuno.',
                        'Un trekking épico hacia una de las lagunas más hermosas del Perú, con vistas impresionantes.',
                    ];
                    $prices = [119, 437, 45, 45];
                    $index = ($i - 1) % count($titles);
                @endphp

            <div class="bg-white dark:bg-zinc-800 rounded-2xl shadow-sm border border-gray-200 dark:border-zinc-700 overflow-hidden hover:shadow-md transition">
                <img src="https://www.machupicchuperutours.com/wp-content/uploads/elementor/thumbs/montana-7-colores-2-qa7mjn56elv1ltpyp010swf33syl4xbsah7507b2c4.jpg"
                    alt="Tour {{ $i }}"
                    class="w-full h-48 object-cover rounded-t-2xl" />

                <div class="p-4 flex flex-col justify-between min-h-[180px]">
                    <h2 class="text-lg font-semibold text-gray-900 dark:text-white mb-2">
                        {{ $titles[$index] }}
                    </h2>
                    <p class="text-sm text-gray-600 dark:text-gray-300 mb-4">
                        {{ $descriptions[$index] }}
                    </p>
                    <div class="flex items-center justify-between mt-auto">
                        <span class="text-blue-600 font-bold text-lg">
                            ${{ $prices[$index] }}.00
                        </span>
                        <a href="#" class="bg-blue-600 text-white px-4 py-1.5 text-sm rounded hover:bg-blue-700 transition">
                            <i class="fas fa-calendar-check mr-1"></i> Reservar
                        </a>
                    </div>
                </div>
            </div>
            @endforeach

        </div>
    </div>
</x-layouts.app>
