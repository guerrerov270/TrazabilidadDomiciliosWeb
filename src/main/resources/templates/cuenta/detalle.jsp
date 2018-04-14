<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>mvc_form_basico_ModelAttributeComoParametro</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h1>
				Formulario Básico <small>mvc_form_basico_ModelAttributeComoParametro</small>
			</h1>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">Resultado datos enviados formato
				form</div>
			<div class="panel-body">
				<div class="container">
					<div class="row">
						<!-- El objeto del model "cuenta" se crea dentro del metodo "crearCuentaForm(Model model)"
			de la clase controladora "CuentaController". -->
						<form:form modelAttribute="cuenta" action="${cuenta.id}"
							method="get" cssClass="form-horizontal" role="form">
							<div class="form-group">
								<form:label for="nombre" path="nombre"
									cssClass="col-sm-2 control-label">Nombre</form:label>
								<div class="col-sm-10">
									<form:input path="nombre" style="width: 300px;" readonly="true"
										cssClass="form-control" />
								</div>
							</div>
							<div class="form-group">
								<form:label for="saldo" path="saldo"
									cssClass="col-sm-2 control-label">Saldo</form:label>
								<div class="col-sm-10">
									<form:input path="saldo" style="width: 300px;" cssClass="form-control"
										readonly="true" />
								</div>
							</div>
							<div class="form-group">
								<form:label for="nivelEndeudamiento" path="nivelEndeudamiento"
									cssClass="col-sm-2 control-label">Nivel Endeudamiento</form:label>
								<div class="col-sm-10">
									<form:input path="nivelEndeudamiento" style="width: 300px;" cssClass="form-control"
										readonly="true" />
								</div>
							</div>
							<div class="form-group">
								<form:label for="fechaRenovacion" path="fechaRenovacion"
									cssClass="col-sm-2 control-label">Fecha Renovación</form:label>
								<div class="col-sm-10">
									<form:input path="fechaRenovacion" style="width: 300px;" cssClass="form-control"
										readonly="true" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<a class="btn btn-default" href=".." role="button">Volver</a>
								</div>
							</div>
						</form:form>

						<table class="table table-striped table-hover table-bordered">
							<thead>
								<tr>
									<th>Productos</th>
								</tr>
							</thead>
							<c:forEach var="item" items="${listaProductos2}">
								<tr>
									<td>${item}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>