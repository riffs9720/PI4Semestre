<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Banco Cuelhar</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav style="background-color:#23238E"class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">             
     <a href="index.html"><img src="logo02.png" width="100" height="50"></a>
    </div>
  
    <ul class="nav navbar-nav">
		<li><a href="index.jsp" style="color:#ffbf00">Ínicio</a></li>
		<li><a href="Extrato.jsp" style="color:#ffbf00">Extrato</a></li>
		<li><a href="Transferencia.jsp" style="color:#ffbf00">Transferência</a></li>
		<li><a href="Pagamento.jsp" style="color:#ffbf00">Pagamento</a></li>
		<li><a href="Conta.jsp" style="color:#ffbf00">Conta</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a style="color: white;"><span class="glyphicon glyphicon-user" style="color: white;">  Você está logado como: ${contAutenticado.getCliente().getNomeCliente()}</span></a></li>
				<li><a href="autenticador" style="color: white;"><span
						class="glyphicon glyphicon-log-in" style="color: white;"></span>
						Logout</a></li>
			</ul>
  </div>
  
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

</body>
</html>