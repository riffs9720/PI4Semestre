<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Conta"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Conta e Saldo</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href="css/style.css" rel="stylesheet">
	</head>
<body>
	<c:import url="Menu.jsp" />
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
       				<h4 class="modal-title">Logout</h4>
         		</div>
         		<div class="modal-body">
           			<p>Deseja mesmo Sair?</p>
         		</div>
       			<div class="modal-footer">
       				<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
 	  					<a href="login.jsp"><button type="button" class="btn btn-default">Sim</button></a>
 	  			</div>
       		</div>
     	</div>
   	</div>
 	<hr>
 	<table class="table table-striped">
 		<tr>
 			<td> Nome: ${contAutenticado.getCliente().getNomeCliente() }</td>
 			<td align="right"> Conta: ${contAutenticado.getNumeroConta() }</td>
 		</tr>
 		<tr>
 			<td> Data de referência:</td>
 			<td align="right">${contAutenticado.getDateTime() }</td>
 		</tr>
 		<tr>
 			<td><b> Saldo Total</b></td>
 			<td align="right">R$: ${contAutenticado.getSaldoConta() }</td>
 		</tr>
 	</table>
 	<form action = "controller.do" method = "post">
		<input name = "data[search]" class = "from-control" id = "search" type = "text" placeholder = "Data de Pesquisa">	
		<span class = "input-group-btn">
			<div class = "input-ground h6">
				<button class = "btn btn-primary" type ="submit" name="command" value="ListarTransacao"> 
				<span class = "glyphicon glyphicon-search"></span>
				</button>
			</div>
			</span>	
 	</form>
 	<hr>
 	<h3 style="text-align: center;">Extrato</h3>
 	<hr>
 	<c:if test="${not empty lista}">
	 	<div id = "list" class = "row">
			<div class = "table-responsive col-md-12">
				<div id = "lista"">
					<table class = "table table-striped" cellspacing = "0" cellpadding = "0">
						<thead>
							<tr>
								<th>Data Transaçao</th>
								<th>Identificação da Transação</th>
								<th>Valor da Transação</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var = "pagamento" items = "${lista}">
								<tr>
									<td>
										${pagamento.dtPagamento }
									</td>
									<td>
										${pagamento.identificaPagamento }
									</td>
									<td>
										${pagamento.valorPagamento }
									</td>
								</tr>
							</c:forEach>	
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>