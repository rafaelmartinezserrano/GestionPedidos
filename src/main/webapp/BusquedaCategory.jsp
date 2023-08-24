
<%@page import="com.afdm.gestionpedidos.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link type="image/x-icon" rel="icon" href="imagen/favicon.png"/>
    <title>Busqueda Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="GestionPedidos.css" type="text/css">

</head>
<body>
    <div id="nav">
    	<nav class="navbar navbar-ligth" style="background-color: #F279B2;">
        	<div class="container-fluid">
         		 <a class="navbar-brand">Gestion de Pedidos</a> 
        	</div>
      	</nav>
  	</div>
  	
  <div id="divFotoPrincipal"> 
     <img id="fotoPrincipalBusqueda" src="Imagenes/imgprincipal.png" class="img-fluid fotoPrincipal" alt="Imagen Principal">
  </div>
  
	 <% List<Category> lista=(List<Category>)request.getAttribute("categoryList"); %>
        <fieldset id="busqueda">
          <form  class="d-flex" method="get">
        	  <select id="select" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" oninput="buscarCategory();">
				 <% for (Category categoria:lista){ %>
					 <option value="<%=categoria.getCategoryID()%>"><%=categoria.getCategoryName()%></option>
				<%  } %>
				</select>
          	</form>
          </fieldset>
          
<div id="listaCategoryDiv" class="fieldset "> </div>
      
      <footer id="final">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="paginaInicial.html" class="nav-link px-2 text-muted">Inicio</a></li>
            <li class="nav-item"><a href="" class="nav-link px-2 text-muted">Busqueda por categoria</a></li>
            <li class="nav-item"><a href="CerrarSession" class="nav-link px-2 text-muted">Salir</a></li>
          </ul>
          <p class="text-center text-muted">© 2023 AFDM</p> 
    </footer>
</body>
   <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
   <script type="text/javascript" src="BuscarCategory.js"></script>
</html>
    