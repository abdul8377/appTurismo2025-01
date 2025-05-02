# Sistema de Turismo

## PASO 1: Clonar el Repositorio
Abre la terminal y clona el repositorio en tu máquina local:

```bash
git clone https://github.com/abdul8377/appTurismo2025-01.git
```

## PASO 2: Ubicarse en la Ruta Clonada
Navega a la carpeta del proyecto clonado:

```bash
D:\appTurismo2025-01\WebTurismo
```

## PASO 3: Verificar el Archivo `.env`
Verifica si el archivo `.env` está presente en la raíz del proyecto. Si no lo está, crea el archivo `.env` y copia el siguiente contenido dentro de él:

```dotenv
APP_NAME=Laravel
APP_ENV=local
APP_KEY=base64:/XvTBoeUnb0zM4NAZue+UA7uU0BrEruJAOJ2zuhQchk=
APP_DEBUG=true
APP_URL=http://localhost

APP_LOCALE=en
APP_FALLBACK_LOCALE=en
APP_FAKER_LOCALE=en_US

APP_MAINTENANCE_DRIVER=file

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
```

## PASO 4: Instalar las dependencias:

1. **Composer**:
   ```bash
   composer install
   ```

3. **Laravel**: Si aún no tienes Laravel instalado globalmente, instálalo con:
   ```bash
   composer global require laravel/installer
   ```

## PASO 5: Iniciar el Servidor de Base de Datos
Asegúrate de que el servidor de base de datos esté funcionando. Puedes usar **Laragon**, **XAMPP**, o cualquier otro servidor de bases de datos que prefieras.

## PASO 6: Navegar al Proyecto
Navega nuevamente a la ruta donde clonaste el proyecto:

```bash
cd D:\appTurismo2025-01\WebTurismo
```

## PASO 7: Ejecutar las Migraciones de Base de Datos
Ejecuta los siguientes comandos para migrar y poblar la base de datos:

```bash
php artisan migrate
php artisan migrate:fresh --seed
```

Esto generará los datos de usuario, con el siguiente acceso de administrador:
- **Usuario**: Franck Coaquira
- **Contraseña**: 12345678

## PASO 8: Iniciar el Backend de Laravel
Inicia el servidor de Laravel para que el backend esté disponible:

```bash
php artisan serve --host=0.0.0.0 --port=8000
```

Esto levantará el backend en la URL: `http://localhost:8000`.

## PASO 9: Abrir el Proyecto en Android Studio
Abre el proyecto de la aplicación móvil con Android Studio:

```bash
D:\appTurismo2025-01\CTProyecto
```

## PASO 10: Obtener la Dirección IP de la Máquina
Ejecuta el siguiente comando en la terminal de tu computadora para obtener tu dirección IPv4:

```bash
ipconfig
```

Ejemplo de salida:

```
Dirección IPv4: 192.168.0.198
```

## PASO 11: Actualizar la IP en el Proyecto de Android

1. **Editar RetrofitClient**: Copia tu IP y reemplázala en la siguiente ruta:

   ```bash
   D:\appTurismo2025-01\CTProyecto\app\src\main\java\pe\edu\upeu\ctproyecto\data\remote\Retrofitclient
   ```
   Reemplaza la IP en la constante `BASE_URL`:
   ```kotlin
   private const val BASE_URL = "http://192.168.0.198:8000/api/"
   ```

2. **Editar Configuración de Seguridad de Red**: También debes actualizar la IP en el archivo de configuración de seguridad:
   ```bash
   D:\appTurismo2025-01\CTProyecto\app\src\main\res\xml\network_security_config
   ```
   Reemplaza la IP en el archivo XML:
   ```xml
   <domain includeSubdomains="true">192.168.0.198</domain>
   ```

## PASO 12: Ejecutar la App Móvil

Ahora puedes ejecutar la app en Android Studio.

- Si deseas, puedes registrarte o iniciar sesión como **Administrador** con las siguientes credenciales:
  - **Usuario**: Franck Coaquira
  - **Contraseña**: 12345678

Es recomendable ingresar como **Administrador** ya que algunas funciones están restringidas en otros roles.

---

### **OBSERVACIONES:**

- Si al iniciar la app ves un mensaje de "No hay conexión", asegúrate de que el **Backend** de Laravel esté corriendo.
- Si el problema persiste, verifica que la **IP** esté correctamente configurada tanto en el backend como en la app móvil.

---

### **INTEGRANTES:**
- **Julmer Quispe Apaza** (G2)
- **Abdul Quispe Condori** (G1)
- **Franck A. Coaquira Justo** (G2)
- **Pretil Ramos Arisapana** (G2)
- **Glenen W. Choquechambi Luque** (G2)
- **Yamil Zúñiga** (G1)
