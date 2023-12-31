<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="image/x-icon" rel="icon" href="imagen/favicon.png"/>
    <title>Gestion Pedidos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="inicioSesion.css" type="text/css">
</head>
  <body>
    <div id="nav">
      <nav class="navbar navbar-litgh" style="background-color: #F279B2;">
        <div class="container-fluid"> 
          <a style="color: black;"class="navbar-brand" href="#">GESTION PEDIDOS</a>
        </div>
      </nav>
    </div>
    <div id="imagen">
      <img src="Imagenes/imgprin.png" class="img-fluid fotoCapa" alt="Foto Principal" id="fotoPrincipal">
    </div> 
  

     <header id="inicioSeccion">
        <h2>Iniciar Sesi�n</h2>
    </header>  
    <div id="form">
      <fieldset id="fieldset" class="fieldset">
      
    
        <form action="IniciarSesion" method="post">
          <!-- <div class="mb-3">
           <label for="InputEmail1" class="form-label">Usuario:</label>
            <input type="text" class="form-control" name="nombreUsuario" id="InputEmail1" aria-describedby="emailHelp" placeholder="Introduzca su id" required="required">
            <div id="emailHelp" class="form-text">Ingrese el nombre de usuario para iniciar sesi�n.</div>
          </div>-->
          <div> 
              
               <label for="inputEmpleado" class="form-label">Empleado</label>
               <input type="radio" value="employee" name="tipo" id="inputEmpleado" onclick="visibilidad();"/>
               <label for="inputCliente" class="form-label">Cliente</label>
               <input type="radio" value="customer" name="tipo" id="inputCliente" checked onclick="visibilidad();"/>

          </div>
         
         <div id="empleado" class="oculto">
         
         	<label for="nombreEmpleado" class="form-label">Nombre</label>
            <input type="text" class="form-control" name="nombreEmpleado" id="nombreEmpleado" placeholder="Introduzca el nombre">
         	<label for="apellidosEmpleado" class="form-label">Apellidos</label>
            <input type="text" class="form-control" name="apellidosEmpleado" id="apellidosEmpleado" placeholder="Introduzca los apellidos">     
     
         </div>
          <div id="cliente">
         
         	<label for="idCliente" class="form-label">A�adir Id:</label>
            <input type="text" class="form-control" name="nombreCliente" id="idCliente" placeholder="Introduzca el id"/>
         	 
     
         </div>
         
        
          <input class ="btn btn-light button" style="background-color: #F279B2" type="submit" value="Iniciar Sesi�n"/>
         
         <% String error = (String)request.getAttribute("error"); %>
          <div>
          		<% if (error != null) { %>
          			<span><%=error %></span>
          		<% } %>
          </div>
         			
         
      </form>     
      </fieldset >
     
    </div>
    <footer>
       
          <p class="text-center text-muted">� 2023</p> 
    </footer>
    <script type="text/javascript" src="inicioSesion.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
