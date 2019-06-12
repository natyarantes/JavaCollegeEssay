<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Aluno"%>
<%@page import="model.Professor"%>
<%@page import="bd.dbConnect"%>
<%@page import="bd.professorDB"%>
<%@page import="bd.alunoDB"%>
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
			alunoDB alunodb = new alunoDB();
			ArrayList<Aluno> alunos = new ArrayList<Aluno>();
			professorDB professordb = new professorDB();
			ArrayList<Professor> professores = new ArrayList<Professor>();
			
			if(conn.openConn()){
				
				alunodb.setConn(conn.getConn());
				alunos = alunodb.listAluno();
				professordb.setConn(conn.getConn());
				professores = professordb.listaProfessor();
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
				<form method="post" action="/insereTurma" target="_parent">
                    <div class="form-group">
                        <label for="">Nome da turma/Disciplina: </label><br>
                        <input type="text" class="form-control defaultInput" name="nomeTurma">
                    </div>
                    <div class="form-group">
              			<label for="">Selecione o professor da turma:</label><br>
							<select class="form-control form-control-lg" name="professorTurma">
								<% for (int i = 0; i < professores.size(); i++){ 
									out.println("<option value='" + professores.get(i).getMatricula() + "'> " + professores.get(i).getNome() + "</option>");
									}; %>
							</select>
					</div>
                    <div class="form-group">
              			<label for="">Selecione os alunos:</label><br>
							<select class="form-control form-control-lg" name="alunoTurma" multiple>
								<% for (int i = 0; i < alunos.size(); i++){ 
									out.println("<option value='" + alunos.get(i).getMatricula() + "'> " + alunos.get(i).getNome() + "</option>");
									}; %>
							</select>
					</div>
					<button class="btn btn-primary topMaisVinte" type="submit">Cadastrar turma</button>
                </form>
		</div>

	</body>
</html>
