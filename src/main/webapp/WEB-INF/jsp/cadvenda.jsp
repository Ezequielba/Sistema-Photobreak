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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

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
</script>


<script type="text/javascript">
	//Funcao para atualizar as parcelas e seus valores
	function atualizaValores() {
		// pegando a quantidade de parcelas
		var valor = $("#n-parcelas").val();

		//variavel que recebe os inputs(HTML)
		var geraInputs = "";

		//Calculando o valor de cada parcela
		var valorParcela = parseFloat($(".total").val() / valor).toFixed(2);

		//gerando os inputs com os valores de cada parcela
		for (var i = 0; i < valor; i++) {
			geraInputs += "<tr><td> <input class='table table-striped table-hover table-condensed table-bordered' type='text' name='parcela[]' value='"+valorParcela+"'></td> <td><input class='table table-striped table-hover table-condensed table-bordered' type='date' value=''></td></tr>";
			}

		// inserindo as parcelas 
		$("#parcelas").html(geraInputs);
	}

	$(document).ready(function(e) {
		$(".total").on('change keyup keydown keypress', function() {
			// ao alterar o valor total, chama a funcao para alterar as parcelas
			atualizaValores();

		});
		$('#condicao-pag').on('change', 'select', function() {
			// ao alterar a condicao de pagamento,chama a funcao para alterar as parcelas
			atualizaValores();
			if ($(this).val() == 1) {
				$('#parcelamento').show();
				/*Calcular valor das parcelas (2x, 3x, 4x) e preencher inputs*/
				$('#parcelas').show();
			} else {
				$('#parcelamento').hide();
				$('#parcelas').hide();
				$("input[name='parcela[]']").val('');
			}
		})

		$('#n-parcelas').on('change', function() {
			/*Calcular valor das parcelas (2x, 3x, 4x) e preencher inputs*/
			//Ao alterar a quantidade e parcelas chama a funcao para alterar as parcelas
			atualizaValores();
		});

	});
</script>



</head>

<body>
	<!-- Navigation -->

	<jsp:include page="menu.jsp" />

	<div class="container">
		<br>

		<form action="/cadvenda" method="POST">
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="cliente">Buscar Clientes</label> <input type="text"
						class="form-control mdb-autocomplete" list="clientes" id="cliente"
						oninput="hideList(this)" autocomplete="off"></input>
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
					<label for="inputProduto">Produto</label> <select name="produto"
						id="inputProduto" class="form-control">
						<option selected>Escolher...</option>
						<c:forEach var="user" items="${produto}">
							<option value="${user.id}">${user.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationTooltip03">Valor venda</label> <input
						type="text" class="form-control" id="validationTooltip03"
						name="valorvenda" value="" placeholder="R$ " required>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="inputParcela">Parcela</label> <select name="parcela"
						id="inputParcela" class="form-control">
						<option selected>Parcela...</option>
						<option value="1">À vista</option>
						<option value="2">2x</option>
						<option value="3">3x</option>
						<option value="4">4x</option>
						<option value="5">5x</option>
						<option value="6">6x</option>
						<option value="7">7x</option>
						<option value="8">8x</option>
						<option value="9">9x</option>
						<option value="10">10x</option>
					</select>
				</div>
			</div>

			<div class="starter-template">
				<table>
					<tbody>
						<tr>
							<td><label>Total R$</label></td>
							<td><input type="number" min="0" class="total" value="100" /></td>
						</tr>
						<tr name="condicao-pag" id="condicao-pag">
							<td><label>Condição de pagamento:</label></td>
							<td><select />
								<option value=0>À vista</option>
								<option value=1>À prazo</option> </select></td>
						</tr>
						<tr id="parcelamento" style="display: none">
							<td>Parcelar em</td>
							<td><select id="n-parcelas">
									<option></option>
									<option value="2" selected>2x</option>
									<option value="3">3x</option>
									<option value="4">4x</option>
									<option value="5">5x</option>
									<option value="6">6x</option>
									<option value="7">7x</option>
									<option value="8">8x</option>
									<option value="9">9x</option>
									<option value="10">10x</option>
							</select></td>
						</tr>

						<tr id="parcelas" style="display: none">

						</tr>
					</tbody>
				</table>
			</div>

			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="example-date-input">Data da Venda</label> <input
						type="date" class="form-control" id="validationTooltip03"
						name="datavenda" value="" placeholder="Data Venda" required>
				</div>
			</div>
			<button class="btn btn-primary" type="submit">Enviar</button>
		</form>
	</div>

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