<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Principal</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="principal.css" type="text/css">
</head>
<body>
	<div id="barra">
		<nav class="navbar navbar-light" style="background-color: #F279B2;">
			<div class="container-fluid">
				<a class="navbar-brand">Gestion de Pedidos</a>
			</div>
		</nav>
	</div>
	<div id="divFoto">
		<img id="foto" src="imgbusqueda.png" alt="Imagen Principal">
	</div>
	<div id="menu">
		<h3>Menú</h3>
	</div>
	<div id="nav">
		<nav>
			<ul>
				<li><a href="BusquedaCategory.jsp">Buscar Productos por
						Categoria</a></li>
				<li><a href="buscarProductosPorId.jsp">Buscar Productos por
						Id</a></li>
			</ul>
		</nav>
	</div>
	<footer>
		<ul class="nav justify-content-center border-bottom pb-3 mb-3">
			<li class="nav-item"><a href="inicioSesion.jsp"
				class="nav-link px-2 text-muted">Inicio</a></li>
			<li class="nav-item"><a href="CerrarSession"
				class="nav-link px-2 text-muted">Salir</a></li>
		</ul>
		<p class="text-center text-muted">&copy; 2023 AFDM</p>
	</footer>
</body>
</html>