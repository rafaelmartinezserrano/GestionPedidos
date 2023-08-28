<%@page import="com.afdm.gestionpedidos.model.carrito.CarritoElement"%>
<%@page import="com.afdm.gestionpedidos.model.carrito.Carrito"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Carrito</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href="carrito.css" type="text/css">
	</head>
	<body>
		<div id="barra">
			<nav class="navbar navbar-light" style="background-color: #F279B2;">
				<div class="container-fluid">
					<a href="principal.jsp" class="navbar-brand">Gestion de Pedidos</a>
				</div>
			</nav>
		</div>
		<% String mensaje = (String)request.getAttribute("mensaje"); %>
		<% Carrito carrito = (Carrito)session.getAttribute("carrito"); %>
		<main class="main">
			<div id="divFoto">
				<img id="foto" src="Imagenes/carritoNav.png" alt="Imagen Carrito">
			</div>
			<div id="prodInCartList">
				<% if(carrito != null && !carrito.getListOD().isEmpty()) { %>
					<% for(CarritoElement i : carrito.getListOD()) { %>
						<ul>
							<li id="${i.getProduct()}">
								<div class="btn_box">
									<input type="button" value="-" id="btnDeleteOne" onclick="deleteOne();">
									<input type="number" readonly="readonly" value="<%=i.getQuantity() %>" id="quantity">
									<input type="button" value="+" id="btnAddOne" onclick="addOne();">
								<div class="prodDetail">
									<%=i.getProduct() %>
								</div>
								</div>
								<div class="btnDelete_box">
									<img alt="delete" src="Imagenes/itemCarritoDelete.png" id="itemDelete" onclick="deleteAll(<%=i.getProduct()%>);">
								</div>
							</li>
						</ul>
					<% } %>
				<% } else { %>
					<div id="msgBox"><p>Aún NO hay productos añadidos...</p></div>
				<% } %>
			
			
			</div>
		</main>
		<footer>
		<ul class="nav justify-content-center border-bottom pb-3 mb-3">
			<li class="nav-item"><a href="principal.jsp"
				class="nav-link px-2 text-muted">Inicio</a></li>
			<li class="nav-item"><a href="CerrarSession"
				class="nav-link px-2 text-muted">Salir</a></li>
		</ul>
		<p class="text-center text-muted">&copy; 2023 AFDM</p>
	</footer>
	</body>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script type="text/javascript" src="carrito.js"></script>
</html>