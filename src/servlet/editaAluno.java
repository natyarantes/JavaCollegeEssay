package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.alunoDB;
import bd.dbConnect;
import model.Aluno;


public class editaAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matriculaAluno, nomeAluno, enderecoAluno, telefoneAluno;
		PrintWriter out;
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		
		matriculaAluno = request.getParameter("matriculaAluno");
		nomeAluno = request.getParameter("nomeAluno");
		enderecoAluno = request.getParameter("enderecoAluno");
		telefoneAluno = request.getParameter("telefoneAluno");
		
		out.println("<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"\n" + 
				"		<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" + 
				"		<link rel=\"stylesheet\" href=\"css/style.css\">\n" + 
				"		<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" + 
				"		<meta charset=\"UTF-8\">\n" + 
				"		<title>SISTEMA DIARIO DE CLASSE</title>\n" + 
				"	</head>\n" + 
				"	<body>\n" + 
				"		<div class=\"container\">\n" + 
				"            <div class=\"class row\">\n" + 
				"				<div class=\"col-md-4\" style=\"padding-top:  40px;\">\n" + 
				"					<a href=\"index.html\"><img src=\"img/logo.png\" alt=\"\"></a>\n" + 
				"				</div>\n" + 
				"			</div>\n" + 
				"			<div class=\"row mt-5\">");
		
		try {
			dbConnect conn = new dbConnect();
			alunoDB alunodb = new alunoDB();
			Aluno aluno = new Aluno();
			
			aluno.setMatricula(matriculaAluno);
			aluno.setNome(nomeAluno);
			aluno.setEndereco(enderecoAluno);
			aluno.setTelefone(telefoneAluno);
			
			if(conn.openConn()) {
				
				alunodb.setConn(conn.getConn());
				
				if(alunodb.updateRecord(aluno) != null) {
					out.println("<p>Aluno atualizado com sucesso.</p>");
					out.println("<br><br>");
					out.println("<a href='index.html'>Voltar</a>");
				}
				else {
					out.println("<p>Erro ao atualizar aluno.</p>");
				}
				
				conn.closeConn();
			}
			else {
				out.println("<p>Não foi possível estabelecer conexão com o banco de dados.</p>");
			}
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			out.println("Erro ao editar aluno.");
		}
		
	}

}
