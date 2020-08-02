<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE html>
	<html lang="pt-BR">
		<head>
  			<title>Banco Cuelhar</title>
			<meta charset="utf-8">
 			<meta name="viewport" content="width=device-width, initial-scale=1">
  			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 			<link rel="stylesheet" type="text/css" href="css/padrao.css" />
  			<link rel="stylesheet" type="text/css" href="css/extratosaldo.css" />
  			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  			<link rel ="stylesheet" href="css/extratosaldo">
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
				</nav>
				<table class="table">
	  			<thead>
					<tr>
		  				<th scope="col">Saldo em conta:</th>
		  				<th scope="col"></th>
		  				<th scope="col"></th> <!--colunas vazias para deixar o valor do saldo em conta no final da tela-->
		  				<th scope="col">R$: XXX,XX</th>
					</tr>
	  			</thead>
	  			<tbody>
					<tr class="debito">
		  				<th scope="row">24/03</th>
		  				<td>LOJA SOCIEDADE ESPORTIVA PALMEIRAS</td>
		  				<td></td> <!--coluna vazia para satisfazer o número de colunas pré determinadas (4), para que a linha reta embaixo das letras fique contínua-->
		  				<td>R$: -XXX,XX</td>
					</tr>
					<tr class="credito">
		  				<th scope="row">23/03</th>
						<td>DEPÓSITO CAIXA 00214 CERQUEIRA CÉSAR</td>
		  				<td></td> 
		  				<td>R$: +XXX,XX</td>
					</tr>
					<tr class="sMovimento">
		  				<th scope="row">22/03</th>
		  				<td><i>Saldo do dia</i></td>
		  				<td></td> 
		  				<td>R$: ~XXX,XX</td>
					</tr>
					<tr class="credito">
		  				<th scope="row">21/03</th>
		  				<td>TRANSFERÊNCIA CAIXA 00219 PINHEIROS</td>
		  				<td></td> 
		  				<td>R$: +XXX,XX</td>
					</tr>
					<tr class="debito">
		  				<th scope="row">20/03</th>
		  				<td>TRANSFERÊNCIA CAIXA 00319 BUTANTÃ</td>
		  				<td></td> 
		  				<td>R$: -XXX,XX</td>
					</tr>
					<tr class="debito">
		  				<th scope="row">19/03</th>
		  				<td>TRANSFERÊNCIA CAIXA 00319 BUTANTÃ</td>
		  				<td></td> 
		  				<td>R$: -XXX,XX</td>
					</tr>
	  			</tbody>
			</table>
		</body>
	</html>
	