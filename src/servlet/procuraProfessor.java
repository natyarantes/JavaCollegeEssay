package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.dbConnect;
import bd.professorDB;
import model.Professor;

public class procuraProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		
		
		String professorMatricula = request.getParameter("professorMatricula");
		
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		
		out.println("<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"	<head>\n" + 
				"\n" + 
				"		<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" + 
				"		<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" + 
				"		<meta charset=\"UTF-8\">\n" + 
				"		<title>SISTEMA DIARIO DE CLASSE</title>\n" + 
				"	</head>\n" + 
				"	<body>\n" + 
				"		<div class=\"container\">\n" + 
				"			<div class=\"class row\">\n" + 
				"				<div class=\"col-md-4\" style=\"padding-top:  40px;\">\n" + 
				"					<img src=\"img/logo.png\" alt=\"\">\n" + 
				"				</div>\n" + 
				"			</div>\n" + 
				"			<div class=\"row mt-5\">");
		
		try {
			
			dbConnect conn = new dbConnect();
			professorDB professordb = new professorDB();
			
			if (conn.openConn()) {
				professordb.setConn(conn.getConn());
				
				Professor professor = professordb.findRecord(professorMatricula);
				
				if(professor != null) {
					out.println("<p>Professor encontrado: " + professor.getNome() + ".");
					out.println("<br><br>");
					out.println("<a href='editaProfessor.jsp?matriculaProfessor="+professor.getMatricula()+"'>Editar</a> ");
				}
				else {
					out.println("<p>Professor não encontrado</p>");
				}
				conn.closeConn();
			}
			else {
				out.println("<p>Não foi possível estabelecer conexão com o  banco de dados.</p>");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			out.println("<p>Erro ao estabelecer conexão com banco de dados</p>");
		}
		
		out.println("</div>\n" + 
				"\n" + 
				"	</body>\n" + 
				"</html>");
	}

}
