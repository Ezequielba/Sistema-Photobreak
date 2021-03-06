<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Photobreak</title>
<!-- Bootstrap core CSS -->
<link href="login-util/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
</head>

<body>
	<!-- Navigation -->

	<jsp:include page="menu.jsp" />

	<div class="container">
		<br>

		<form action="/editarproduto" method="POST">
			<input type="hidden" class="form-control" id="id" name="id" path="id"
				value="${produto.id}">
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationTooltip01">Insira o nome do produto</label> <input
						type="text" class="form-control" id="validationTooltip01"
						name="nome" value="${produto.nome}" placeholder="Produto" required>
					<div class="valid-tooltip">Tudo certo!</div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="validationTooltip03">Valor</label> <input type="text"
						class="form-control" id="validationTooltip03" name="valor"
						value="${produto.valor}" value="R$ " placeholder="Valor" required>
					<div class="invalid-tooltip">Por favor, coloque o valor deste
						produto</div>
				</div>
			</div>
			<button class="btn btn-primary" type="submit">Enviar</button>
		</form>

	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="login-util/vendor/jquery/jquery.slim.min.js"></script>
	<script src="login-util/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
</body>
</html>