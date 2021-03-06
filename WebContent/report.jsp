<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="bd.turmaDB"%>
<%@page import="model.Turma"%>
<%@page import="bd.dbConnect"%>
<%@page import="java.io.PrintWriter" %>
<%@page import="java.util.ArrayList" %>
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
			
			dbConnect conn = new dbConnect();
			turmaDB turmadb = new turmaDB();;
			ArrayList<Turma> turmas = new ArrayList<Turma>();
			
			if(conn.openConn()){
				turmadb.setConn(conn.getConn());
				turmas = turmadb.listaTurma();
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
				<form method="get" action="/exibeRelatorioProfessor.jsp" target="_parent">
					<label for="">Selecione a turma:</label><br>
					<select class="form-control form-control-lg" name="turma">
						<% for (int i = 0; i < turmas.size(); i++){ 
							out.println("<option value='" + turmas.get(i).getNome() + "'> " + turmas.get(i).getNome() + "</option>");
						}; %>
					</select>
					<button class="btn btn-primary topMaisVinte" type="submit">Gerar relatório</button>
				</form>
       
       		</div>

		</div>

	</body>
</html>
