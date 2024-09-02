<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.Conductor" %>
<%@ page import="utils.Util" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Transportes MoviPerú</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<style>
	.form-control::placeholder {
		font-weight: bold; /* Cambia el texto del placeholder a negrita */
	}
	.foto-conductor {
		width : 30%;
		height : auto;
	}
</style>
<body>
	<jsp:include page="barra-navegacion.jsp" />
	
	<div class ="container mt-5">
		<%
			Conductor conductor = (Conductor) request.getAttribute("conductor");
			String nombreRuta = (String) request.getAttribute("nombreRuta");
		%>
		<h2>Detalle del conductor <%= conductor.getNombres() %> <%= conductor.getApellidoPaterno() %></h2>
		<img class="foto-conductor" src="<%= conductor.getFotoConductor() %>" alt="Imagen del conductor <%= conductor.getNombres() %>">  
		<div class="mt-4">
			<p class="mb-2"><b>Nombres:</b> <%= conductor.getNombres() %></p>
			<p class="mb-2"><b>Apellidos:</b> <%= conductor.getApellidoPaterno() %> <%= conductor.getApellidoMaterno() %></p>
			<p class="mb-2"><b>DNI:</b> <%= conductor.getDocumentoIdentidad() %></p>
			<p class="mb-2"><b>Teléfono:</b> <a href="https://wa.me/51<%=conductor.getTelefono()%>?text=<%=Util.encodedTextToUrl("Buen día, señor(a) " + conductor.getNombres() + " " + conductor.getApellidoPaterno() + " " + conductor.getApellidoMaterno())%>"><%= conductor.getTelefono() %></a></p>
			<p class="mb-2"><b>Licencia:</b> <%= conductor.getLicencia() %></p>
			<p class="mb-2"><b>Ruta N°:</b> <%= conductor.getIdRuta() %> --- <%= nombreRuta %></p>			
		</div>
		<a href="javascript:history.back()" class="btn btn-info mt-4">Volver</a>
	</div>
	
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>

</body>
</html>