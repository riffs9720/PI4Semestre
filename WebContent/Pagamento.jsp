<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Banco Cuelhar</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/pagamento.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="padrao.css" />
    
</head>
<body>

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
    <!-- Desenvolvimento da tela "pagar conta" -->
<c:import url="Menu.jsp" />
<div class="row">
  <div class="col-75">
    <div class="container">
      <form action="controller.do" method="post">
        <div class="row">
            <div class="row">
              <div class="col-50">
                <h3>Valor do Pagamento</h3>
                <input type="text" name="valorPagamento" id="valorPagamento" placeholder="Valor da Conta">
                <h3>Identificação do Pagamento</h3>
                <input type="text" name="identificacaoPagamento" id="identificacaoPagamento" placeholder="Identificação do Pagamento">
              </div>
              <div class="col-50">
                <label for="zip">Data de Pagamento</label>
                <input type="date" name="dtPagamento" placeholder="DD/MM/YYYY">
              </div>
            </div>
          </div>
        <button type="submit" name="command" value="FazerPagamento" class="btn1">Realizar Pagamento</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>