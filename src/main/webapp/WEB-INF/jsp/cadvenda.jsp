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

<!-- COPIAR ESSE SCRIPT ELE QUEM PREENCHE O CAMPO DATA DA VENDA AUTOMATICAMENTE -->
<script>
$(document).ready(
		function Data()
        {
            data = new Date();
            var hora = data.getHours();
            var min  = data.getMinutes();
            var monthArray =new Array("01","02","03","04","05","06","07","08","09","10","11","12");
            var dayArray =new Array("00","01","02","03","04","05","06","07","08","09");
			var dia;
            if(data.getDate() > 0 && data.getDate() < 10){
					dia = dayArray[data.getDate()];
                }
            else{
            	dia = data.getDate();
                }
            
            ano = data.getFullYear();
            dataCompleta = dia+'/'+monthArray[data.getMonth()];
            document.getElementById('datavenda').value =ano+"-"+monthArray[data.getMonth()]+"-"+dia;
            //document.getElementById('datavenda').value =ano+"-"+monthArray[data.getMonth()]+"-"+dia+"T"+hora+":"+min;
		});
</script>

<script type="text/javascript">
function check_status(obj) {
	  var uid = obj.options[obj.selectedIndex].getAttribute('data');
	  document.getElementById('valorVenda').value = uid;
	}
</script>

<!-- FIM DA COPIA -->
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

<!-- COPIAR ESSE E REMOVER O SEU SCRIPT DE CRICACAO DE PARCELA-->
<script type="text/javascript">
	//Funcao para atualizar as parcelas e seus valores
	function atualizaValores() {
		
		function correcaoDia(dia) {
		    if (isNaN(dia)) return false;
		    
		    return dia < 10 ? "0" + dia : dia ;
		}

		function correcaoMes(mes) {
		    if (isNaN(mes)) return false;
		    
		    return mes < 10 ? "0" + mes : mes ;
		}
		
		// pegando a quantidade de parcelas
		var valor = $("#n-parcelas").val();

		//variavel que recebe os inputs(HTML)
		var geraInputs = "";

		//Calculando o valor de cada parcela
		var valorParcela = parseFloat($("#valorVenda").val() / valor).toFixed(2);

		//Pegando data do primeiro vencimento
		var vencimento = $("#firstVencimento").val();

		//Tratamento do input vencimento parcela
		 var ano = vencimento.substring(0,4);
		    var mes = vencimento.substring(5,7);
		    var dia = vencimento.substring(8,10);

		  if(dia =='29' && leapYear(ano )) dia = '28';

		    var dataInicial = new Date(ano,mes,dia);
		    var dataParcela = new Date();
		    var resultado = "";
		    var novoMes = 0;
		    var novoAno = 0;
		
		//gerando os inputs com os valores de cada parcela
		for (var i = 0; i < valor; i++) {
			//Calcula data de vencimento parcela
				novoMes = ( dataInicial.getMonth() + i ) % 12;
		        novoMes = novoMes == 0 ? 12 : novoMes;
		        novoAno = dataInicial.getFullYear() + ( ( ( dataInicial.getMonth() + i ) - novoMes ) / 12 );
		        
		 		dataParcela.setDate(dia);
		        dataParcela.setMonth(novoMes);
		        dataParcela.setYear(novoAno);
		        
		        resultado += dataParcela.getFullYear();     
		        resultado += "-";
		        resultado += correcaoMes(dataParcela.getMonth() + 1);
		        resultado += "-";
		        resultado += correcaoDia(dataParcela.getDate());
		        
		      //Exibe input de parcelas  
			geraInputs += "<tr><td><input class='form-control' type='text' name='parcelamento' value='"+valorParcela+"'></td><td><input class='form-control' type='date' name='vencimentoParcela' value='"+resultado+"'></td></tr>";
			//Limpa a variavel resultado para o proximo input
			resultado = "";
			}

		 //Verifica ano Bissexto
		  function leapYear(year){
			return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
		  }

		// inserindo as parcelas 
		$("#parcelas").html(geraInputs);
	}

	
	$(document).ready(function(e) {
		$("#valorVenda").on('change keyup keydown keypress', function() {
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
<!-- FIM DA COPIA -->
</head>

<body>
	<!-- Navigation -->

	<jsp:include page="menu.jsp" />

	<div class="container">
		<br>

		<!-- COPIAR ESSE CODIGO TODO -->
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
						id="inputProduto" class="form-control" onchange="check_status(this);">
						<option selected>Escolher...</option>
						<c:forEach var="user" items="${produto}">
							<option value="${user.id}" data="${user.valor}">${user.nome}</option>				
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="validationTooltip03">Valor venda</label> <input
						type="text" class="form-control" id="valorVenda"
						name="valorvenda" value="" placeholder="R$ " required>
				</div>
			</div>
			
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="example-date-input">Primeiro Vencimento</label> <input
						type="date" class="form-control" id="firstVencimento"
						name="firstVencimento" value="" placeholder="Vencimento" required>
				</div>
			</div>
			
			<div class="form-row">
				<div class="col-md-4 mb-3" name="condicao-pag" id="condicao-pag">
				<label for="validationTooltip03">Forma de Pagamento</label>
					<select class="form-control">
						<option value=0>À vista</option>
						<option value=1>À prazo</option>
					</select>
				</div>
			</div>
			
			<div class="form-row">
				<div class="col-md-4 mb-3" id="parcelamento" style="display: none">
					<label for="inputParcela">Parcela</label> <select id="n-parcelas" name="numParcela" class="form-control">
						<option value="2" selected>2x</option>
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
						<tr id="parcelas" style="display: none">
						</tr>
					</tbody>
				</table>
			</div>

			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label for="example-date-input">Data da Venda</label> <input
						type="date" class="form-control" id="datavenda"
						name="datavenda" value="" placeholder="Data Venda" readonly>
				</div>
			</div>
			<button class="btn btn-primary" type="submit">Enviar</button>
		</form>
	</div>
<!-- FIM DA COPIA -->

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