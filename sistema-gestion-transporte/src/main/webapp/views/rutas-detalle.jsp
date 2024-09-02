<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.Ruta" %>

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
</style>
<body>
	<jsp:include page="barra-navegacion.jsp" />
	
	<div class ="container mt-5">
		<%
			Ruta ruta = (Ruta) request.getAttribute("ruta");
		%>
		<h2>Detalle de la ruta <%= ruta.getNombreRuta() %></h2>
		<div class="mt-4">
        	<p class="mb-2"><b>Ruta N°:</b> <%= ruta.getIdRuta() %></p>
        	<p class="mb-2"><b>Nombre de la ruta:</b> <%= ruta.getNombreRuta() %></p>
        	<p class="mb-2"><b>Provincia:</b> <%= ruta.getProvincia() %></p>
        	<p class="mb-2"><b>Ruta a seguir:</b></p>	
		</div>
		<div style="width: 100%">
			<iframe
				width="100%"
				height="600"
				frameborder="0"
				scrolling="no"
				marginheight="0"
				marginwidth="0"
				src="https://www.google.com/maps/embed?pb=!1m28!1m12!1m3!1d3151.8354345090115!2d<%= ruta.getLongitudOrigen() %>!3d<%= ruta.getLatitudOrigen() %>!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m13!3e0!4m3!3m2!1d<%= ruta.getLatitudOrigen() %>!2d<%= ruta.getLongitudOrigen() %>!4m3!3m2!1d<%= ruta.getLatidudDestino() %>!2d<%= ruta.getLongitudDestino() %>!5e0!3m2!1sen!2s!4v1662720000000!5m2!1sen!2s&zoom=20">
			</iframe>
		</div>
		
		<a href="javascript:history.back()" class="btn btn-info mt-4">Volver</a>
	</div>
	
	<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>
</body>
</html>