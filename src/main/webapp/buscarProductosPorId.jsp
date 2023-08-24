<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Buscar Por Id</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="buscarProductosPorId.css" type="text/css">
</head>
<body>
	<div id="nav">
		<nav class="navbar navbar-light" style="background-color: #F279B2;">
			<div class="container-fluid">
				<a class="navbar-brand">Gestion de Pedidos</a>
			</div>
		</nav>
	</div>
	<main>
		<div id="divFotoPrincipal">
			<img id="fotoPrincipal" src="Imagenes/imgbusqueda.png"
				class="img-fluid fotoPrincipal" alt="Imagen Principal">
		</div>
		<fieldset id="busqueda">
			<form action="BuscarProductosPorId.jsp" class="d-flex">
				<input id="cajaTxt" class="form-control me-2" type="search"
					placeholder="Buscar Por Id" aria-label="Search" name="busquedaId">
				<button class="btn btn-light" style="background-color: #F279B2"
					type="button" onclick="imprimirProductos();">Buscar</button>
				
			</form>
		</fieldset>
		<div id="divProductos"></div>
	</main>
	<footer>
		<ul class="nav justify-content-center border-bottom pb-3 mb-3">
			<li class="nav-item"><a href="inicioSesion.jsp"
				class="nav-link px-2 text-muted">Inicio</a></li>
			<li class="nav-item"><a href="principal.jsp"
				class="nav-link px-2 text-muted">Pagina Principal</a></li>
			<li class="nav-item"><a href="BusquedaCategory.jsp"
				class="nav-link px-2 text-muted">Buscar por categoria</a></li>
			<li class="nav-item"><a href="CerrarSession"
				class="nav-link px-2 text-muted">Salir</a></li>
		</ul>
		<p class="text-center text-muted">&copy; 2023 AFDM</p>
	</footer>
</body>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="buscarProductosPorId.js"></script>
</html>
