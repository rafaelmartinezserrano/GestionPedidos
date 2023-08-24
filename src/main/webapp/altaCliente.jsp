<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link type="image/x-icon" rel="icon" href="imagen/favicon.png" />
<title>Alta Cliente</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="altaCliente.css" type="text/css">
<body>
		<header id="nav" class="navbar navbar-light" style="background-color: Darkslateblue"> 			
				<h2 class="encabezado container-fluid">Gestion de Pedidos</h2>
		</header>
		<%String error = (String)request.getAttribute("error");%>
	<%Boolean registrado = (Boolean)request.getAttribute("Register");%>
		<%if (error != null) {%>
		<p><%=error%></p>
		<%}%>
		<%if (registrado != null && registrado != false){ %>
		<p>Se ha registrado correctamente</p>
		<%}%>
	<fieldset id="busqueda">
	<form action="NewCustomer" id="Form">
	<div  class="formulario">
	<div class="divForm">
	<div>
	<label for="inputNombreComp">Nombre de la Compañía:</label>
	<input type="text" id="inputNombreComp" name="nombreCompañia" placeholder="Amazon, Potafy..."/>
	</div>
	<div>
	<label for="inputNombreCliente">Nombre Cliente:</label>
	<input type="text" id="inputNombreCliente" name="nombreCliente" placeholder="Luis, Pepe..."/>
	</div>
	<div>
	<label for="inputCargo">Cargo que desempeña:</label>
	<input type="text" id="inputCargo" name="Cargo" placeholder="Presidente, representante..."/>
	</div>
	<label for="inputDireccion">Dirección:</label>
	<input type="text" id="inputDireccion" name="Direccion" placeholder="c/pepito de los palotes"/>
	<label for="inputCiudad">Ciudad:</label>
	<input type="text" id="inputCiudad" name="Ciudad" placeholder="Arteixo"/>
	</div>
	<div class="divForm">
	<label for="inputProvincia">Provincia:</label>
	<input type="text" id="inputProvincia" name="Provincia" placeholder="A coruña"/>
	<label for="inputPais">País:</label>
	<input type="text" id="inputPais" name="pais" placeholder="España"/>
	<label for="inputCP">Código postal:</label>
	<input type="text" id="inputCP" name="CP" placeholder="21410" pattern="[0-9]{5}"/>
	<label for="inputTel">Número de Teléfono:</label>
	<input type="text" id="inputTel" name="Tlf" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}"/>
	<label for="inputFax">Número de Fax:</label>
	<input type="text" id="inputFax" name="Fax" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}"/>
	</div>
	</div>
	<input type="submit" id="botonEnviar" value="ENVIAR"/>
	
	
	</form>
	</fieldset>
	
<footer>
       <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="inicioSesion.jsp" class="nav-link px-2 text-muted">Inicio</a></li>
            <li class="nav-item"><a href="BusquedaCategory.jsp" class="nav-link px-2 text-muted">Buscar por categoria</a></li>
            <li class="nav-item"><a href="CerrarSession" class="nav-link px-2 text-muted">Salir</a></li>
          </ul>
		<p class="text-center text-muted"> &copy; 2023 AFDM</p>
	</footer>
</body>
</html>