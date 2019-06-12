package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.professorDB;
import bd.dbConnect;
import model.Professor;


public class editaProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matriculaProfessor, nomeProfessor, enderecoProfessor, telefoneProfessor;
		PrintWriter out;
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		
		matriculaProfessor = request.getParameter("matriculaProfessor");
		nomeProfessor = request.getParameter("nomeProfessor");
		enderecoProfessor = request.getParameter("enderecoProfessor");
		telefoneProfessor = request.getParameter("telefoneProfessor");
		
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
			professorDB proefssordb = new professorDB();
			Professor professor = new Professor();
			
			professor.setMatricula(matriculaProfessor);
			professor.setNome(nomeProfessor);
			professor.setEndereco(enderecoProfessor);
			professor.setTelefone(telefoneProfessor);
			
			if(conn.openConn()) {
				
				proefssordb.setConn(conn.getConn());
				
				if(proefssordb.updateRecord(professor) != null) {
					out.println("<p>Professor atualizado com sucesso.</p>");
					out.println("<br><br>");
					out.println("<a href='index.html'>Voltar</a>");
				}
				else {
					out.println("<p>Erro ao atualizar professor.</p>");
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
