<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-BR">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Banco Cuelhar</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
        <form action="autenticador" method="post">
         <div class="form-group">
            <label for="exampleInputEmail1">Agência</label>
            <input type="text" name="idAgencia" id="idAgencia" class="form-control" placeholder="Agencia" required/>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Número da Conta</label>
            <input type="text" name="idConta" id="idConta" class="form-control" placeholder="Número da Conta" required/>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Senha</label>
            <input type="password" name="senhaConta" id="senhaConta" class="form-control" placeholder="Senha" required/>
          </div>
          <div class="form-group">
            	<label for="exampleInputPassword1">Token</label>
            	<input type="text" name="token" id="numeroToken" class="form-control" placeholder="Token"/>
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Lembrar Número da Conta</label>
            </div>
          </div>
          <button class="btn btn-primary" type="submit" name='command' value="Logar">Logar</button>
        </form>
        <div class="text-center">
          
          <a class="d-block small" href="forgot-password.html">Esqueceu sua senha?</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>