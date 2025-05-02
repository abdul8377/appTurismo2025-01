PASO 1:
clonar el repositorio
-git clone https://github.com/abdul8377/appTurismo2025-01.git
PASO 2:
Nos ubicamos el la ruta clonada
ejm: D:\appTurismo2025-01\WebTurismo
Paso 3:
verificamos si tiene el archivo ".env"
si no tiene el archivo se debe crear ".env"
el archivo ".env" debe contener:
        APP_NAME=Laravel
        APP_ENV=local
        APP_KEY=base64:/XvTBoeUnb0zM4NAZue+UA7uU0BrEruJAOJ2zuhQchk=
        APP_DEBUG=true
        APP_URL=http://localhost

        APP_LOCALE=en
        APP_FALLBACK_LOCALE=en
        APP_FAKER_LOCALE=en_US

        APP_MAINTENANCE_DRIVER=file
        # APP_MAINTENANCE_STORE=database

        PHP_CLI_SERVER_WORKERS=4

        BCRYPT_ROUNDS=12

        LOG_CHANNEL=stack
        LOG_STACK=single
        LOG_DEPRECATIONS_CHANNEL=null
        LOG_LEVEL=debug

        DB_CONNECTION=mysql
        DB_HOST=127.0.0.1
        DB_PORT=3306
        DB_DATABASE=turismo
        DB_USERNAME=root
        DB_PASSWORD=

        SESSION_DRIVER=database
        SESSION_LIFETIME=120
        SESSION_ENCRYPT=false
        SESSION_PATH=/
        SESSION_DOMAIN=null

        BROADCAST_CONNECTION=log
        FILESYSTEM_DISK=local
        QUEUE_CONNECTION=database

        CACHE_STORE=database
        # CACHE_PREFIX=

        MEMCACHED_HOST=127.0.0.1

        REDIS_CLIENT=phpredis
        REDIS_HOST=127.0.0.1
        REDIS_PASSWORD=null
        REDIS_PORT=6379

        MAIL_MAILER=log
        MAIL_SCHEME=null
        MAIL_HOST=127.0.0.1
        MAIL_PORT=2525
        MAIL_USERNAME=null
        MAIL_PASSWORD=null
        MAIL_FROM_ADDRESS="hello@example.com"
        MAIL_FROM_NAME="${APP_NAME}"

        AWS_ACCESS_KEY_ID=
        AWS_SECRET_ACCESS_KEY=
        AWS_DEFAULT_REGION=us-east-1
        AWS_BUCKET=
        AWS_USE_PATH_STYLE_ENDPOINT=false

        VITE_APP_NAME="${APP_NAME}"

        GOOGLE_CLIENT_ID=1067324627109-2i6lo4fcjvvljiued1f3nq61s7el70hr.apps.googleusercontent.com
        GOOGLE_CLIENT_SECRET=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
        GOOGLE_REDIRECT_URI=http://localhost:8000/auth/google/callback


        FACEBOOK_CLIENT_ID=528537510309364
        FACEBOOK_CLIENT_SECRET=3a5eecccf21c97f09fac2af5c6894a12
        FACEBOOK_REDIRECT_URI=http://localhost:8000/auth/facebook/callback
Paso 4:
verificamos que tengamos los recursos necesesarios:
-composer
    para intalar
        composer install
-laravel
    para intalar
        composer global require laravel/installer
ejecutar los comandos en la terminal
Paso 5:
Iniciamos la base de datos:
    "laragon" "xaamp", etc.
Paso 6:
En la terminal nos ubicamos en nuestro proyecto
    D:\appTurismo2025-01\WebTurismo
Paso 7:
luego ejecutamos los siguientes codigos:
    php artisan migrate
    php artisan migrate:fresh --seed
esto nos dara el usuario y contraseña para administrador
    user: Franck Coaquira
    pasword: 12345678
esto nos ayudara a entrar en el sistema en rol administrador
Paso 8:
iniciamos el backend: ejecutar en la terminal
    php artisan serve --host=0.0.0.0 --port=8000
con esto ya levantamos el backend
Paso 9:
abrimos el proyecto con android studio
    D:\appTurismo2025-01\CTProyecto
Paso 10:
obtenemos nuestro ip por la terminal:
    ipconfig
esto nos dara la direccion de nuestra ip
    ejem:
    Dirección IPv4. . . . . . . . . . . . . . : 192.168.0.198
Paso 11:
copiamos nuestra ip y reemplasamos en las sig rutas:
    appTurismo2025-01\CTProyecto\app\src\main\java\pe\
    edu\upeu\ctproyecto\data\remote\Retrofitclient
        pegar la ip en:
            private const val BASE_URL = "http://"pegar la ip":8000/api/" 
------------------------------------------------------------------------------- 
se debe cambiar en la sig ruta
    CTProyecto\app\src\main\res\xml\network_security_config
     pegar la ip en:
             <domain includeSubdomains="true">"pegar la ip"</domain>
Paso 12:
correr la app movil
si decea puede registrase
o iniciar sesion con rol adminitrador
    user: Franck Coaquira
    pasword: 12345678
se recomienda entrar como adminitrador ya que
en otro rol algunas funciones estan restringidas
--------------------------------------------------------------------------------
OBSERVACIONES:
    si en la pantalla de carga indica no hay conexion
    puede que se deba a que no se a iniciado el backend

    si no es el caso verificar bien la ip

--------------------------------------------------------------------------------

INTREGRANTES:
JULMER QUISPE APAZA(G2)
ABDUL QUISPE CONDORI(G1)
FRANK A. COAQUIRA JUSTO(G2)
PRETEL RAMOS ARISAPANA(G2)
GLENEN W. CHOQUECHAMBI LUQUE(G2)
YAMIL ZUÑIGA(G1)







