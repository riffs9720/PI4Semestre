<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">

	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="css/tranferencia.css">
    	<title>Banco Cuelhar</title>
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
  	<form action="controller.do" method="post">		
        <div>
            <div class="row">
                <div class="col-sm-4">
                </div>
                <div class="col-sm-4">
                    <h3 style="text-align: center">Realizar Transferência</h3>
                </div>
                <div class="col-sm-4">
                </div>
            </div>
            <hr>
            <div class="container">
                <div class="row">
                	<div class="col-sm-6">
                        Conta Origem:
                        <input type="text" name="numeroConta" maxlength="6" style="width: 70px">
                    </div>
                    <div class="col-sm-6">
                        Agencia:
                        <input type="text" name="idAgencia" maxlength="6" style="width: 70px">
                    </div>
                    <div class="col-sm-6">
                        Conta Destino:
                        <input type="text" name="digitoContaDestino" maxlength="6" style="width: 90px"> 
                        Dígito:
                        <input type="text" style="width: 30px" maxlength="1">
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <br><br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        CPF do Beneficiado:
                        <input type="text" name="cpfBeneficiadoTransferencia" maxlength="11" style="width: 100px">
                    </div>
                    <div class="col-sm-6">
                        Valor R$:
                        <input type="text" name="valorTransferencia" style="width: 90px">
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <br><br>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            Identificação da Transferência:
                            <input type="text" name="identificacaoTransferencia" maxlength="100" style="width: 975px">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <br><br>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                    </div>
                    <div class="col-sm-4" style="text-align: center">
                        <input type="submit" name="command" value="FazerTransferencia" style="background-color: #23238E; color: #ffbf00">
                    </div>
                    <div class="col-sm-4">
                    </div>
                </div>
            </div>
        </div>
    </form>
    </body>
</html>