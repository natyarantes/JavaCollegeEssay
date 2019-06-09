package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bd.dbConnect;
import model.Aluno;
import bd.alunoDB;

/**
 * Servlet implementation class insereAluno
 */
@WebServlet("/insereAluno")
public class insereAluno extends HttpServlet {
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


		out.print("<!DOCTYPE html>\n" + 
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
			dbConnect connection = new dbConnect();
			Aluno aluno = new Aluno();
			alunoDB alunodb = new alunoDB();
			
			aluno.setMatricula(matriculaAluno);
			aluno.setNome(nomeAluno);
			aluno.setEndereco(enderecoAluno);
			aluno.setTelefone(telefoneAluno);
			
			if (connection.openConn()) {
				alunodb.setConn(connection.getConn());
				
				if(alunodb.insertRecord(aluno)) {
					out.println("<p>Aluno inserido com sucesso.</p>");
					out.println("<a href='index.html'>Voltar</a>");
				}
				else {
					out.println("<p>Não foi possível inserir o aluno.</p>");
				}
				
			}
			else {
				out.println("Nao foi possivel estabelecer conexao com o  banco de dados");
			}
			connection.closeConn();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			out.println("Erro ao inserir aluno.");
		}
		
		out.println("</div>\n" + 
				"\n" + 
				"	</body>\n" + 
				"</html>");
	}

}
