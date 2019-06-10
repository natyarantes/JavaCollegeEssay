<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="bd.alunoDB"%>
<%@page import="model.Aluno"%>
<%@page import="bd.dbConnect"%>
<%@page import="java.io.PrintWriter" %>
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
		<%
			alunoDB alunodb = new alunoDB();
			Aluno alunoObj = new Aluno();
			String alunoMatricula = request.getParameter("matriculaAluno");
			
			dbConnect conn = new dbConnect();
			
			if(conn.openConn()){
				alunodb.setConn(conn.getConn());
				
				alunoObj = alunodb.findRecord(alunoMatricula);
				
				conn.closeConn();
			}
			else {
				out.println("<p>Falha na conexão com o banco de dados.</p>");
			}
		%>
		
		
		<div class="container">
            <div class="class row">
				<div class="col-md-4" style="padding-top:  40px;">
					<a href="index.html"><img src="img/logo.png" alt=""></a>
				</div>
			</div>
			<div class="row mt-5">
				<form method="post" action="/editaAluno" target="_parent">
					<div class="form-group">
	                    <label for="">Nome do aluno:</label><br>
	                    <input type="text" name="nomeAluno" class="form-control defaultInput" placeholder="Digite  o nome do aluno" value="<%= alunoObj.getNome() %>"/>
					</div>
					<div class="form-group">
	                    <label for="">CPF: </label>
	                    <input type="text" name="matriculaAluno" class="form-control defaultInput" placeholder="Digite o CPF do aluno" value="<%= alunoObj.getMatricula() %>" />
	                    <br>
	                    <p class="formObs">Obs.: O CPF será o número de matricula do aluno</p>
					</div>
					<div class="form-group">
						<label for="">Endereço: </label><br>
	                    <input type="text" name="enderecoAluno" class="form-control defaultInput" placeholder="Digite o endereço completo do aluno" value="<%= alunoObj.getEndereco() %>" />
					</div>
					<div class="form-group">
						<label for="">Telefone</label><br>
						<input type="text" name="telefoneAluno" class="form-control defaultInput" placeholder="Digite o telefone do aluno" value="<%= alunoObj.getTelefone() %>" />
					</div>
					<button class="btn btn-primary topMaisVinte" type="submit">Editar aluno</button>
                </form>
              </div>
		</div>

	</body>
</html>