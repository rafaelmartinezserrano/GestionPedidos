<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="com.afdm.gestionpedidos.model.Customer"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link type="image/x-icon" rel="icon" href="imagen/favicon.png"/>
     <link rel="stylesheet" href="listaClientes.css" type="text/css">
<title>Lista de clientes</title>
</head>
<body>
	<%List<Customer> clientes = (List<Customer>)request.getAttribute("clientList"); %>
	 <div id="nav">
	    <nav class="navbar">
	        <div class="titulo">
	          <a class="navbar-brand">Lista de clientes</a>
	        </div>
	    </nav>
     </div>
      
	<main>
		<ul>
		<% for(Customer c: clientes){ %>
			<li>Empresa: <%=c.getCompanyName()%>/ Persona contacto: <%=c.getContactName()%>/ Dirección: <%=c.getAddress()%>/ Ciudad: <%=c.getCity()%>/ Codigo Postal: <%=c.getPostalCode()%>/ País: <%=c.getCountry()%>/ Teléfono: <%=c.getPhone()%></li>
		<% }%>
		</ul>
	</main>
</body>
</html>