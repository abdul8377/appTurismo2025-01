<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Turismo Comunitario Capachica</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  <style>
    body {
      background-color: #161616;
    }
    h1, h2, h3, .lead {
      color: #fff;
    }
    .navbar {
      background: linear-gradient(90deg, #0077b6, #00b4d8);
    }
    .navbar .nav-link {
      color: #fff !important;
      font-weight: 500;
      margin: 0 10px;
    }
    .navbar .nav-link:hover {
      text-decoration: underline;
    }
    .carousel {
      z-index: 0;
    }
    .carousel-item img {
      height: 500px;
      object-fit: cover;
      object-position: center;
    }
    .carousel-caption {
      background: rgba(0, 0, 0, 0.6);
      padding: 20px;
      border-radius: 10px;
    }
    .wrapper {
      margin-top: 5rem;
      margin-bottom: 5rem;
    }
    .card {
      border: none;
      overflow: hidden;
      border-radius: 20px;
      min-height: 450px;
      box-shadow: 0 0 12px 0 rgba(0, 0, 0, 0.2);
      background-size: cover;
      background-position: center;
      transition: all 0.5s ease-in-out;
      position: relative;
      z-index: 1;
    }
    .card:hover {
      transform: scale(1.02);
      box-shadow: 0 0 15px rgba(255, 186, 33, 0.6);
    }
    .card-img-overlay {
      background: linear-gradient(0deg, rgba(255,186,33,0.4) 0%, rgba(255,186,33,1) 100%);
      transition: all 0.5s ease-in-out;
    }
  </style>
</head>
<body>

<!-- Navbar mejorada con íconos y botón -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
      <a class="navbar-brand text-white fw-bold" href="#">
        <i class="fas fa-mountain-sun me-2"></i>Capachica
      </a>
  
      <!-- Botón hamburguesa para móviles -->
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
  
      <!-- Menú de navegación -->
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto align-items-center">
          <li class="nav-item">
            <a class="nav-link" href="index.html"><i class="fas fa-home me-1"></i>Inicio</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="descubre.html"><i class="fas fa-compass me-1"></i>Descubre</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="actividades.html"><i class="fas fa-hiking me-1"></i>Actividades</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contactanos.html"><i class="fas fa-envelope me-1"></i>Contacto</a>
          </li>
          <!-- Botón de Iniciar sesión con estilo similar a Blade -->
                <li class="nav-item ms-3">
                <a
                    href="{{ route('login') }}"
                    class="btn btn-outline-light btn-sm border border-light rounded-sm px-4 py-1"
                    style="font-weight: 500;"
                >
                    <i class="fas fa-sign-in-alt me-1"></i>Log in
                </a>
                </li>
        </ul>
      </div>
    </div>
  </nav>
  
  

<!-- Carrusel separado -->
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://static.esmartcity.es/media/2020/09/cuenca-avanza-estrategia-destino-turistico-inteligente-nueva-plataforma-web.png" class="d-block w-100" alt="Mirador Escallani">
      <div class="carousel-caption d-none d-md-block">
        <h5>Mirador Escallani</h5>
        <p>Vista panorámica del Titicaca y los Andes.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="https://antuanetvalle.com/wp-content/uploads/2024/08/Turismo-Cultural-Descubre-las-Tradiciones-y-el-Patrimonio-www.antuanetvalle.vom_-1024x576.jpg" class="d-block w-100" alt="Turismo Comunitario">
      <div class="carousel-caption d-none d-md-block">
        <h5>Turismo Comunitario</h5>
        <p>Vive la cultura con familias locales.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="https://www.ceupe.com/images/easyblog_articles/4419/b2ap3_large_turismo-vista-panormica.jpg" class="d-block w-100" alt="Paisaje Capachica">
      <div class="carousel-caption d-none d-md-block">
        <h5>Paisaje Andino</h5>
        <p>Descubre la serenidad de Capachica.</p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>

<!-- Cards independientes -->
<section class="wrapper" id="actividades">
  <div class="container">
    <div class="row text-center mb-5">
      <div class="col">
        <h2 class="display-5">¿Qué hacer en Capachica?</h2>
        <p class="lead">Explora cultura, naturaleza y experiencias únicas</p>
      </div>
    </div>
    <div class="row g-4">
      <div class="col-md-4">
        <div class="card text-white card-has-bg" style="background-image:url('https://losviajesdeali.com/wp-content/uploads/2015/01/pen%C3%ADnsula-de-capachica-1-18.jpg.webp');">
          <div class="card-img-overlay d-flex flex-column justify-content-end">
            <div>
              <h4 class="card-title">Ruta de Miradores</h4>
              <p class="card-text">Contempla el lago desde los puntos más altos.</p>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card text-white card-has-bg" style="background-image:url('https://losviajesdeali.com/wp-content/uploads/2015/01/pen%C3%ADnsula-de-capachica-1-18.jpg.webp');">
          <div class="card-img-overlay d-flex flex-column justify-content-end">
            <div>
              <h4 class="card-title">Gastronomía Andina</h4>
              <p class="card-text">Degusta platos tradicionales con insumos locales.</p>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card text-white card-has-bg" style="background-image:url('https://losviajesdeali.com/wp-content/uploads/2015/01/pen%C3%ADnsula-de-capachica-1-18.jpg.webp');">
          <div class="card-img-overlay d-flex flex-column justify-content-end">
            <div>
              <h4 class="card-title">Turismo Vivencial</h4>
              <p class="card-text">Vive la cultura y tradiciones con las comunidades.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Footer con imágenes e íconos -->
<footer class="bg-body-tertiary text-center text-lg-start text-dark">
  <div class="container p-4">
    <section class="">
      <div class="row">
        <div class="col-lg-2 col-md-4 col-6 mb-4">
          <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/113.webp" class="w-100 rounded shadow-1-strong" alt="Foto 1" />
        </div>
        <div class="col-lg-2 col-md-4 col-6 mb-4">
          <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/111.webp" class="w-100 rounded shadow-1-strong" alt="Foto 2" />
        </div>
        <div class="col-lg-2 col-md-4 col-6 mb-4">
          <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/112.webp" class="w-100 rounded shadow-1-strong" alt="Foto 3" />
        </div>
        <div class="col-lg-2 col-md-4 col-6 mb-4">
          <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/114.webp" class="w-100 rounded shadow-1-strong" alt="Foto 4" />
        </div>
        <div class="col-lg-2 col-md-4 col-6 mb-4">
          <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/115.webp" class="w-100 rounded shadow-1-strong" alt="Foto 5" />
        </div>
        <div class="col-lg-2 col-md-4 col-6 mb-4">
          <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/116.webp" class="w-100 rounded shadow-1-strong" alt="Foto 6" />
        </div>
      </div>
    </section>
  </div>
  <div class="text-center p-4 bg-dark text-white">
    <p class="mb-1">&copy; 2025 Turismo Comunitario Capachica</p>
    <div>
      <a href="#" class="text-white me-4"><i class="fab fa-facebook-f"></i></a>
      <a href="#" class="text-white me-4"><i class="fab fa-instagram"></i></a>
      <a href="#" class="text-white me-4"><i class="fab fa-youtube"></i></a>
      <a href="#" class="text-white"><i class="fab fa-whatsapp"></i></a>
    </div>
  </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>