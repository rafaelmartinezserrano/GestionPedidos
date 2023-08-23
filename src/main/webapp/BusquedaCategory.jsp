
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
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
          <a class="navbar-brand">Gestion de Pedidos</a>
           
          <form action="BuscarCategory.jsp" method="post" class="d-flex">
            <input id="CajaTxt" class="form-control me-2" type="search" placeholder="Buscar Categoria" aria-label="Search" name="busquedaCategory">
            <button class="btn btn-dark" type="button" onclick="imprimirCategory(lista);">Buscar</button>
          </form> 
        </div>
      </nav>
      </div>
   	
		  <div id="divFotoPrincipal">
          <img id="fotoPrincipal" src="Imagenes/imgprincipal.png" class="img-fluid fotoPrincipal" alt="">
        </div>
        
       		<div id="listaCancionesDiv" class="fieldset "> </div>
            <div id="divLetraCancion" class="fieldset2"></div>
      <footer>
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="paginaInicial.html" class="nav-link px-2 text-muted">Inicio</a></li>
            <li class="nav-item"><a href="" class="nav-link px-2 text-muted">Apoyo</a></li>
            <li class="nav-item"><a href="CerrarSession" class="nav-link px-2 text-muted">Salir</a></li>
          </ul>
          <p class="text-center text-muted">© 2023</p> 
    </footer>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script type="text/javascript" src="buscarCanciones.js"></script>
    </html>
    