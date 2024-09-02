<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.Carga" %>

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
			Carga carga = (Carga) request.getAttribute("carga");
		%>
		<h2>Detalle del pedido N° <%= carga.getIdCarga() %></h2>
		<div class="mt-4">
			<%
	            String tipoCargaTexto = "Frágil";
	            if (carga.getTipoCarga().equals("2")) {
	                tipoCargaTexto = "Normal";
	            }
        	%>
        	<p class="mb-2"><b>Tipo de Carga:</b> <%= tipoCargaTexto %></p>
			<p class="mb-2"><b>Descripción:</b> <%= carga.getDescripcion() %></p>
			<p class="mb-2"><b>Peso (kg):</b> <%= carga.getPeso() %></p>
			
		</div>
		
		<a href="javascript:history.back()" class="btn btn-info mt-4">Volver</a>
	</div>

	<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>

</body>
</html>