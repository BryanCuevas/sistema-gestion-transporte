<nav class="navbar bg-warning-subtle navbar-expand-lg">
    <div class="container">
        <div class="navbar-brand link-primary fs-3"><b>Transportes MoviPerú</b></div>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" 
        aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav mx-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item me-3">
                    <a class="nav-link link-dark" aria-current="page" 
                    href="/sistema-gestion-transporte">
                    	<b>Inicio</b>
                    </a>
                </li>
                <li class="nav-item dropdown me-3">           
                    <a class="nav-link link-dark dropdown-toggle" role="button" data-bs-toggle="dropdown" 
                    aria-expanded="false">
                        <b>Vehículos</b>
                    </a>
                    <ul class="dropdown-menu bg-warning-subtle">
                        <li><a class="dropdown-item" href="/sistema-gestion-transporte/listar-ligeros"><b>Carga ligera</b></a></li>
                        <li><a class="dropdown-item" href="/sistema-gestion-transporte/listar-pesados"><b>Carga pesada</b></a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown me-3">
                    <a class="nav-link link-dark dropdown-toggle" role="button" data-bs-toggle="dropdown" 
                    aria-expanded="false">
                        <b>Rutas</b>
                    </a>
                    <ul class="dropdown-menu bg-warning-subtle">
                        <li><a class="dropdown-item" href="/sistema-gestion-transporte/listar-rutas/Huancayo"><b>Huancayo</b></a></li>
                        <li><a class="dropdown-item" href="/sistema-gestion-transporte/listar-rutas/Lima"><b>Lima</b></a></li>
                    </ul>
                </li>
                <li class="nav-item me-3">           
                    <a class="nav-link link-dark" href="/sistema-gestion-transporte/listar-conductores" role="button" aria-expanded="false">
                        <b>Conductores</b>
                    </a>
                </li>
                <li class="nav-item me-3">
                    <a class="nav-link link-dark" href="/sistema-gestion-transporte/listar-cargas" role="button" aria-expanded="false">
                        <b>Cargas</b>
                    </a>
                </li>
                <li class="nav-item me-3">
                    <a class="nav-link link-dark" href="/sistema-gestion-transporte/monitoreo" role="button" aria-expanded="false">
                        <b>Monitoreo</b>
                    </a>
                </li>
            </ul>
            <form class="d-flex" role="search">
        		<input class="form-control me-2 text-dark" type="search" placeholder="Buscar" aria-label="Search">
        		<button class="btn btn-outline-primary" type="submit"><b>Buscar</b></button>
      		</form>
        </div>
    </div>
</nav>