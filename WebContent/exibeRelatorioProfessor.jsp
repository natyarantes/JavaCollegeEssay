<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="bd.relatorioDB"%>
<%@page import="model.Aluno"%>
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
			relatorioDB reportdb = new relatorioDB();
			ArrayList<Aluno> alunos = new ArrayList<Aluno>();
			
			if(conn.openConn()){
				reportdb.setConn(conn.getConn());
				alunos = reportdb.notaTotalPorAluno(request.getParameter("turma"));
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
				<table class="table">
					<thead>
						<th>Aluno</th>
						<th>Total</th>
						<th>Resultado</th>
					</thead>
					<tbody>
						<%
							for(int i = 0; i < alunos.size(); i++){
								out.println("<tr><td>"+ alunos.get(i).getNome() + "</td><td>"+ alunos.get(i).getNota() +"</td><td class='"+ (alunos.get(i).getNota() >= 60 ? "text-success": "text-danger") +"'>"+ (alunos.get(i).getNota() >= 60 ? "Aprovado": "Reprovado") +"</td></tr>");
							}
						%>
					</tbody>
				</table>
       
       		</div>

		</div>

	</body>
</html>
