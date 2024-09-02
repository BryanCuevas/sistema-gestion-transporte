<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
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
	a {
		text-decoration: none;
	}
</style>
<body>

	<jsp:include page="barra-navegacion.jsp" />
	
	<div class="container mt-5">
		<%
		String provincia = (String) request.getAttribute("provincia");
		%>
			
		<h2>Listado de rutas de <%= provincia %> </h2>
		<div class="row">
			<%
			List<Ruta> listaRutas = (List<Ruta>) request.getAttribute("rutas");
			if (listaRutas != null && !listaRutas.isEmpty()) {
				for (Ruta ruta : listaRutas) {
			%>
				<div class="col-md-4 mt-4">
					<a href="/sistema-gestion-transporte/buscar-ruta/<%= ruta.getIdRuta() %>">
					<div class="card">
						<h2 class="card-title">Ruta <%= ruta.getNombreRuta() %></h2>               
                    </div>					
                    </a>	
                </div>
			<%
				}
			} else {
			%>
			<div class="col">
				<p>No se encontraron rutas</p>
			</div>
			<%
			}
			%>
		</div>
		
		<a href="/sistema-gestion-transporte" class="btn btn-warning mt-4 me-3">Ir a inicio</a>
		<a href="/sistema-gestion-transporte/registrar-ruta" class="btn btn-success mt-4">Registrar Ruta</a>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>