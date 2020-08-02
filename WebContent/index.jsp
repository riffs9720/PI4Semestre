<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!DOCTYPE html>
	<html lang="pt-BR">
  		<head>
  			<title>Banco Cuelhar</title>
  			<meta charset="utf-8">
	  		<meta name="viewport" content="width=device-width, initial-scale=1">
  			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  			<link rel="stylesheet" type="text/css" href="css/index.css">
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
			<div class="container">
				<div>
					<img src="img/logo.png" class="fundo">
					<a href="Conta.jsp"><h2 id="rcorners3">Saldo da Conta</h2></a>
					<a href="Transferencia.jsp"><h2 id="rcorners5">Transferência</h2></a>
					<a href="Pagamento.jsp"><h2 id="rcorners6">Pagamento</h2></a>
		
				</div>
			</div>
		</body>
	</html>