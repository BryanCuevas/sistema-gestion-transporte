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
</style>
<body>
	<jsp:include page="barra-navegacion.jsp" />
	
	<div class="container mt-5">
		<h2>Registrar Conductor</h2>
		<form action="" method="post">
        	<div class="form-group mb-3">
	            <label for="nombres">Nombres</label>
	            <input type="text" class="form-control" id="nombres" name="nombres" required>
        	</div>
        	<div class="form-group mb-3">
	            <label for="apellido_paterno">Apellido Paterno</label>
	            <input type="text" class="form-control" id="apellido_paterno" name="apellido_paterno" required>
        	</div>
        	<div class="form-group mb-3">
	            <label for="apellido_materno">Apellido Materno</label>
	            <input type="text" class="form-control" id="apellido_materno" name="apellido_materno" required>
        	</div>
        	<div class="form-group mb-3">
	            <label for="documento_identidad">N° de DNI</label>
	            <input type="text" class="form-control" id="documento_identidad" name="documento_identidad" required>
        	</div>
        	<div class="form-group mb-3">
	            <label for="telefono">Teléfono</label>
	            <input type="text" class="form-control" id="telefono" name="telefono" required>
        	</div>
        	<div class="form-group mb-3">
	            <label for="licencia">N° de Licencia</label>
	            <input type="text" class="form-control" id="licencia" name="licencia" required>
        	</div>
        	<div class="form-group mb-3">
			    <label for="exampleFormControlInput1" class="form-label">Provincia</label>
			    <select class="form-select" name="provincia" aria-label="Default select example" required>
			        <option value="" selected disabled hidden>Seleccionar</option>
			        <%
						List<Ruta> listaRutas = (List<Ruta>) request.getAttribute("rutas");
						if (listaRutas != null && !listaRutas.isEmpty()) {
							for (Ruta ruta : listaRutas) {
								%>
								<option value="<%= ruta.getIdRuta() %>"> <%= ruta.getNombreRuta() %> </option>
								<%
							}
						} 
					%>
			    </select>
			</div>
        	<a href="javascript:history.back()" class="btn btn-danger me-3 mb-4">Cancelar</a>
        	<button type="submit" class="btn btn-success mb-4">Registrar</button>
		</form>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>