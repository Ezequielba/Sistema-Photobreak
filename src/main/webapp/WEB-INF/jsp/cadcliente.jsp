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

		<form action="/cadcliente" method="POST">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Nome</label> <input type="text"
						class="form-control" name="nome" id="inputEmail4"
						placeholder="Nome">
				</div>
				<div class="form-group col-md-2">
					<label for="inputPassword4">Telefone</label> <input type="text"
						class="form-control" id="inputPassword4" name="telefone"
						placeholder="(11) 0 1234-5678">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputAddress">E-mail</label> <input type="text"
						class="form-control" id="inputAddress" name="email"
						placeholder="maria@gmail.com">
				</div>
				<div class="form-group col-md-2" id="datetimepicker1">
					<label for="example-date-input">Data Evento</label> <input data-format="dd/MM/yyyy" type="date"
						class="form-control" id="datetimepicker1" name="dataevento"
						placeholder="01/01/2020">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-5">
					<label for="inputAddress2">Endereço Cliente</label> <input
						type="text" class="form-control" id="inputAddress2"
						name="enderecocliente"
						placeholder="Apartamento, hotel, casa, etc.">
				</div>
				<div class="form-group col-md-5">
					<label for="inputAddress2">Endereço Evento</label> <input
						type="text" class="form-control" id="inputAddress2"
						name="enderecoevento"
						placeholder="Monte Castelo, Isadora Cortez...">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-3">
					<label for="inputCity">Cidade</label> <input type="text"
						class="form-control" id="inputCity" name="cidade"
						placeholder="São Paulo, São Caetano...">
				</div>
				<div class="form-group col-md-2">
					<label for="inputCEP">CEP</label> <input type="text"
						class="form-control" id="inputCEP" name="cep">
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Entrar</button>

	</form>
</div>

<script type="text/javascript">
$(function() {
$('#datetimepicker1').datetimepicker({
	format: "dd/mm/yyyy"
  language: 'pt-BR'
});
});
</script>

	<!-- Modal -->
<div class="modal fade" id="ExemploModalCentralizado" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="TituloModalCentralizado">Wow! Você está excluindo um cliente.</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      Eu gostava dele! :( 
      Podemos seguir?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
        <button type="button" class="btn btn-primary">Salvar mudanças</button>
      </div>
    </div>
  </div>
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