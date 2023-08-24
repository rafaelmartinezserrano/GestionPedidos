
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link type="image/x-icon" rel="icon" href="imagen/favicon.png"/>
     <link rel="stylesheet" href="altaEmpleado.css" type="text/css">
    <title>Alta Nuevo Empleado</title>
    
    <link rel="stylesheet" href="GestionPedidos.css" type="text/css">

</head>
<body>
    
    <div id="nav">
    <nav class="navbar" style="background-color: #F279B2;">
        <div class="titulo">
          <a class="navbar-brand">Alta Nuevo Empleado</a>
       
         
        </div>
      </nav>
      </div>
   	
		  <div id="divFotoPrincipal">
          <img id="fotoPrincipalBusqueda" src="Imagenes/imgprincipal.png" class="img-fluid fotoPrincipal" alt="Imagen Principal">
        </div>
        
        <div id="container">
          <form class="formulario"  action="NewEmployee" method="post">
          	
          	<div>
	            <label for="txtLastName">Apellidos:</label>
	            <input type="text" id="txtLastName" placeholder="Apellidos" name="lastName" />
	        </div>
	        
	        <div>
	            <label for="txtFirstName">Nombre:</label>
	            <input type="text" id="txtFirstName" placeHolder="Nombre" name="FirstName" />
	        </div>
	        
	        <div>
	            <label for="txtTitle">Cargo:</label>
	            <input type="text" id="txtTitle" placeholder="Cargo" name="title" />
	        </div>
	        <div class="select">
	            <label for="selectTitleOfCourtesy">Tratamiento</label>
	            <select id="selectTitleOfCourtesy" name="Title">
	            	<option value=""></option>
	            	<option value="Mrs.">Ella</option>
	            	<option value="Mr.">El</option>
	            	<option value="Dr.">Ello</option>
	            	<option value="Ms.">No me defino</option>
	            </select>  
            </div>
            
            <div>
	            <label for="txtBirthDate">Fecha de nacimiento</label>
	            <input type="text" id="txtBirthDate" placeholder="aaaa-mm-dd" name="birthDate"/>
	        </div>
	        <div>
	            <label for="txtHireDate">Fecha de contratacion</label>
	            <input type="text" id="txtHireDate" placeholder="aaaa-mm-dd" name="hireDate"/>
            </div>
            <div>
	            <label for="txtAdress">Dirección</label>
	            <input type="text" id="txtAddress" placeholder="Dirección" name="address"/>
    		</div>
    		<div>
	            <label for="txtCity">Ciudad</label>
	            <input type="text" id="txtCity" placeholder="Ciudad" name="city"/>
	        </div>
	        <div>
	            <label for="txtPostalCode">Código Postal</label>
	            <input type="number" id="txtPostalCode" placeholder="Código Postal" name="postalCode"/>
            </div>
            
            <div>
	            <label for="txtRegion">Región</label>
	            <input type="text" id="txtRegión" placeholder="Región" name="region"/>
	        </div>
	        <div>
	            <label for="txtPostalCode">Código Postal</label>
	            <input type="number" id="txtPostalCode" placeholder="Código Postal" name="postalCode"/>
	        </div>
	        <div>
	            <label for="txtCpuntry">País</label>
	            <input type="text" id="txtCountry" placeholder="país" name="country"/>
            
            
            <div>
	            <label for="numberHomePhone">Teléfono</label>
	            <input type="number" id="numberHomePhone" placeholder="Teléfono" name="phoneNumber"/>
	        </div>
	        <div>   
	            <label for="numberExtension">Extensión</label>
	            <input type="number" id="numberExtension" placeholder="Extensión" name="extension"/>
	        </div>
	        <div>
	            <label for="txtPhoto">Foto</label>
	            <input type="text" id="txtPhoto" placeholder="Foto" name="photo"/>
	          </div>
	          <div>  
	            <label for="txtNotes">Notas</label>
	            <input type="text" id="txtNotes" placeholder="Notas" name="notes"/>
	            </div>
	            <div>
	            <label for="textPhotoPath">url photo</label>
	            <input type="text" id="textPhotoPath" placeholder="url photo" name="photoPath"/>
            </div>
            <div>
            <button type="submit"> Registrar</button>
            </div>
            <!--  
            <input id="CajaTxt" class="form-control me-2" type="search" placeholder="Buscar por Categoria" aria-label="Search" name="busquedaCategory">
            <button class="btn btn-ligth" style="background-color: #F279B2;"  type="button" onclick="buscarCategory();">Buscar</button>
            -->
         	</div>
          </form>
          
         </div> 
       		<div id="listaCategoryDiv" class="fieldset "> </div>
      
      <footer id="final">
        <!--<ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="paginaInicial.html" class="nav-link px-2 text-muted">Inicio</a></li>
            <li class="nav-item"><a href="" class="nav-link px-2 text-muted">Busqueda por categoria</a></li>
            <li class="nav-item"><a href="CerrarSession" class="nav-link px-2 text-muted">Salir</a></li>
          </ul>
          -->
          <p class="text-center text-muted">© 2023 AFDM</p> 
    </footer>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script type="text/javascript" src="BuscarCategory.js"></script>
    </html>
    