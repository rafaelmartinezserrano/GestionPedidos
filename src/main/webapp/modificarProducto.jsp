
<%@page import="com.afdm.gestionpedidos.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link type="image/x-icon" rel="icon" href="imagen/favicon.png"/>
     <link rel="stylesheet" href="altaEmpleado.css" type="text/css">
    <title>Alta Nuevo Empleado</title>
    <link rel="stylesheet" href="modificarProducto.css" type="text/css">
    <link rel="stylesheet" href="GestionPedidos.css" type="text/css">

</head>
<body>

    <div id="nav">
    <nav class="navbar" style="background-color: #F279B2;">
        <div class="titulo">
          <a class="navbar-brand">Modificar Producto</a>


        </div>
      </nav>
      <% Product product = (Product)request.getAttribute("product"); %>
      </div>
		  <div id="divFotoPrincipal">
          <img id="fotoPrincipalBusqueda" src="Imagenes/modificarProducto.png" class="img-fluid fotoPrincipal" alt="Modificar producto">
        </div>

        <div id="container">
          <form class="formulario"  action="/UpdateProduc" method="post">
            <div>
                <label>Categoria: <%= product.getCategory() %></label>
                <label>Nombre del producto: <%= product.getProductName() %></label>
                <label>Precio por unidad: <%= product.getQuantityPerUnit() %></label>
                <label>Unidades ordenadas: <%= product.getUnitsOnOrder() %></label>
                <label>Nivel de pedido: <%= product.getReorderLevel() %></label>
            </div>

          	<div>
	            <label for="txtLastName">UnitPrice:</label>
	            <input type="text" id="txtLastName" placeholder="UnitPrice" name="unitPrice" value="<%= product.getUnitPrice()%>" />
	        </div>

	        <div>
	            <label for="txtFirstName">UnitsInStock:</label>
	            <input type="text" id="txtFirstName" placeHolder="UnitsInStock" name="unitsInStock" value="<%= product.getUnitsInStock()%>" />
	        </div>

	        <!--<div>
	            <label for="isDiscontinued">Discontinued:</label>
	            <input type="radio" id="isDiscontinuedT" class="isDiscontinued" name="true"/>
	            <input type="radio" id="isDiscontinuedF" class="isDiscontinued" name="false"/>
	        </div>-->

	        <div>
	            <input type="button" value="Upload">
	        </div>
          </form>

         </div>
       		<div id="listaCategoryDiv" class="fieldset "> </div>

      <footer id="final">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="paginaInicial.html" class="nav-link px-2 text-muted">Inicio</a></li>
            <li class="nav-item"><a href="" class="nav-link px-2 text-muted">Busqueda por categoria</a></li>
            <li class="nav-item"><a href="CerrarSession" class="nav-link px-2 text-muted">Salir</a></li>
          </ul>

          <p class="text-center text-muted">� 2023 AFDM</p>
    </footer>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script type="text/javascript" src="BuscarCategory.js"></script>
    </html>
