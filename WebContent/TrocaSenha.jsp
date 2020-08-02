<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<link rel="stylesheet" type="text/css" href="#####" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Alteração de Senha</title>
  </head>
  <body>
    <c:import url="Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header" style="text-align: center;">Alteração de Senha</h3>
        <!-- Formulario para alteração de senha -->
        <form name="valida" action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row"  style="padding-top: 10%;">
                <div class="form-group col-md-6">
                    <label for="novaSenha">Nova Senha</label>
                    <input type="password" class="form-control" name="novaSenha" id="novaSenha" placeholder="Digite sua nova senha">
                </div>
                <div class="form-group col-md-6">
                    <label for="novaSenha2">Confirme a nova Senha</label>
                    <input type="password" class="form-control" name="novaSenha2" id="novaSenha2" placeholder="Confirme sua nova senha">
                </div>
                <div style="margin-top: 8%">
                    <button type="submit" class="btn btn-primary" name="command" value="AlterarSenha"
                    	onClick="return confirma()" style="margin-left: 42%;">Alterar</button>
                    <a href="index.jsp" class="btn btn-default">Cancelar</a>
                </div>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/cont.js"> </script>
  </body>
</html>
