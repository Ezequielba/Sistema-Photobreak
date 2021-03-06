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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>




</head>

<body>

<script>
	function hideList(input) {
		var datalist = document.querySelector("datalist");

		if (input.value) {
			datalist.id = "clientes";
			$(document).ready(
					function() {
						var data = {};
						$("#clientes option").each(function(i, el) {
							data[$(el).data("value")] = $(el).val();
						});
						var value = $('#cliente').val();
						document.getElementById('idCliente').value = value = $(
								'#clientes [value="' + value + '"]').data(
								'value');
						console.log($('#idCliente').val());
					});

		} else {
			datalist.id = "";
		}
	}
	 $(document).ready(function(){

		 var datalist = document.querySelector("datalist");
		 datalist.id = "clientes";
				var data = {};
				$("#clientes option").each(function(i, el) {
					data[$(el).data("value")] = $(el).val();
				});
				var value = $('#cliente').val();
				document.getElementById('idCliente').value = value = $(
						'#clientes [value="' + value + '"]').data(
						'value');
				console.log($('#idCliente').val());
			});



		
</script>

<script>
$(document).ready(function(){

	var data = {};
	$("#produtos option").each(function(i, el) {
		data[$(el).data("value")] = $(el).val();
	});
	var value = $('#produto').val();
	document.getElementById('idProduto').value = value = $(
			'#produtos [value="' + value + '"]').data(
			'value');
	console.log($('#idProduto').val());
});

function hideListproduto(input) {
	var data = {};
	$("#produtos option").each(function(i, el) {
		data[$(el).data("value")] = $(el).val();
	});
	var value = $('#produto').val();
	document.getElementById('idProduto').value = value = $(
			'#produtos [value="' + value + '"]').data(
			'value');
	console.log($('#idProduto').val());
}
</script>

	<!-- Navigation -->

	<jsp:include page="menu.jsp" />

	<div class="container">
		<br>

		<form action="/editarvenda" method="POST">
		<input type="hidden" class="form-control" id="id" name="id" path="id"
				value="${venda.id}">
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="cliente">Buscar Clientes</label> <input type="text" 
						class="form-control mdb-autocomplete" list="clientes" id="cliente" 
						oninput="hideList(this)" autocomplete="off" value="${venda.cliente}"></input>
					<datalist id="">
						<c:forEach var="user" items="${cliente}">
							<option data-value="${user.id}" value="${user.nome}"></option>
						</c:forEach>
					</datalist>
					<input type="hidden" id="idCliente" name="cliente"></input>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="produto">Buscar Produtos</label> <input type="text" 
						class="form-control mdb-autocomplete" list="produtos" id="produto" 
						oninput="hideListproduto(this)" autocomplete="off" value="${venda.produto}"></input>
					<datalist id="produtos">
						<c:forEach var="user" items="${produto}">
							<option data-value="${user.id}" value="${user.nome}"></option>
						</c:forEach>
					</datalist>
					<input type="hidden" id="idProduto" name="produto"></input>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationTooltip03">Valor venda</label> <input
						type="text" class="form-control" id="validationTooltip03"
						name="valorvenda" value="${venda.valorVenda}" placeholder="R$ " required>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="example-date-input">Data da Venda</label> <input
						type="date" class="form-control" id="validationTooltip03"
						name="datavenda" value="${venda.dataVenda}" placeholder="Data Venda" required>
				</div>
			</div>
			<button class="btn btn-primary" type="submit">Enviar</button>
		</form>
	</div>

<!-- 	<script>
		$(function() {
			var nome = [];
			$.ajax({
				url : '<c:url value="/listaClientes"/>',
				type : 'GET',
				success : function(data) {
					for (var i = 0; i < data.length; i++) {
						nome.push(data[i]["nome"]);
						console.log(nome);
					}
				}
			});

			$("#tags").autocomplete({
				source : nome
			});
		});
	</script> -->

	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="login-util/vendor/jquery/jquery.slim.min.js"></script>
	<script src="login-util/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	-->
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