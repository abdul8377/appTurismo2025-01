<div class="flex items-center gap-3 w-full max-w-[220px]">
    <!-- LOGO -->
    <div class="flex h-10 w-10 items-center justify-center overflow-hidden rounded-full border border-zinc-200 dark:border-zinc-700 shadow-sm bg-white shrink-0">
        <img src="https://png.pngtree.com/png-clipart/20211115/ourmid/pngtree-world-tourism-day-simple-design-png-image_4032587.png"
             alt="Capachica Logo"
             class="object-cover w-full h-full" />
    </div>

    <!-- TEXTO -->
    <div class="flex flex-col overflow-hidden">
        <span class="text-base font-semibold leading-tight text-gray-800 dark:text-white whitespace-nowrap">
            Capachica Travel
            <div>
            {{ ucfirst(auth()->user()->roles->first()?->name ?? 'Usuario') }} 
            </div>
        </span>
        <span class="text-xs text-gray-500 dark:text-gray-400 leading-none">Panel</span>
    </div>
</div>
