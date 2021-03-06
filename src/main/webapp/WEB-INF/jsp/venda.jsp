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
	</div>
	
	<div class="container">
		<header>
			<h1>Lista de vendas:</h1>
			<a href="cadvenda"><button type="button" class="btn btn-primary btn-lg">Novo
  			</button></a>
			<br></br>
		</header>
		<div class="starter-template">

			<table
				class="table table-striped table-hover table-condensed table-bordered">
				<tr>
					<th>Cliente</th>
					<th>Produto</th>
					<th>Valor Venda</th>
					<th>Data Venda</th>
					<th>Editar</th>
					<th>Excluir</th>
				</tr>
				<c:forEach var="user" items="${venda}">
					<tr>
						<td>${user.cliente}</td>
						<td>${user.produto}</td>
						<td>${user.valorVenda}</td>
						<td>${user.dataVenda}</td>
						<td WIDTH="7%"><a href="editarvenda?id=${user.id}"><button type="button" class="btn btn-info btn-sm">Editar</button></a>
						<td WIDTH="7%"><a href="excluirvenda?id=${user.id}"><button type="button" class="btn btn-danger btn-sm">Excluir</button></a>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
		<!-- Modal -->
<div class="modal fade" id="ExemploModalCentralizado" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="TituloModalCentralizado">Cuidado! Você está excluindo uma venda.</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      Já conversou com o cliente? Tem certeza?
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