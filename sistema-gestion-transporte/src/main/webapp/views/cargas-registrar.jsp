<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<h2>Registrar Carga</h2>
		<form action="" method="post">
			<div class="form-group mb-3">
			    <label for="exampleFormControlInput1" class="form-label">Tipo de carga</label>
			    <select class="form-select" name="tipo_carga" aria-label="Default select example" required>
			        <option value="" selected disabled hidden>Seleccionar</option>
			        <option value='1'>Frágil</option>
			        <option value='2'>Normal</option>
			    </select>
			</div>
        	<div class="form-group mb-3">
	            <label for="descripcion">Descripción</label>
	            <input type="text" class="form-control" id="descripcion" name="descripcion" required>
        	</div>
        	<div class="form-group mb-3">
	            <label for="peso">Peso (kg)</label>
	            <input type="text" class="form-control" id="peso" name="peso" required>
        	</div>
        	<a href="javascript:history.back()" class="btn btn-danger me-3">Cancelar</a>
        	<button type="submit" class="btn btn-success">Registrar</button>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>