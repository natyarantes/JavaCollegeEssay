<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="css/style.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<meta charset="UTF-8">
		<title>SISTEMA DIARIO DE CLASSE</title>
	</head>
	<body>
		<div class="container">
            <div class="class row">
				<div class="col-md-4" style="padding-top:  40px;">
					<a href="index.html"><img src="img/logo.png" alt=""></a>
				</div>
			</div>
			<div class="row mt-5">
				<form method="POST" action="procuraAluno">
					<div class="form-group">
	                    <label for="">Digite o CPF do aluno a editar:</label><br>
	                    <input type="text" name="alunoMatricula" class="form-control defaultInput" placeholder="Digite  o nome do professor">
					</div>
					
					<button class="btn btn-primary topMaisVinte" type="submit">Buscar</button>
                </form>
		</div>

	</body>
</html>