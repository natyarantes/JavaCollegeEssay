package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.avaliacaoDB;
import bd.dbConnect;


public class avaliaAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matricula;
		int idTipoNota, valorNota;
		PrintWriter out;
		
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		
		matricula = request.getParameter("alunoMatricula");
		idTipoNota = Integer.parseInt(request.getParameter("selectTipoNota"));
		valorNota = Integer.parseInt(request.getParameter("notaAluno"));
		
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
			avaliacaoDB avaliacaodb = new avaliacaoDB();
			
			if(connection.openConn()) {
				avaliacaodb.setConn(connection.getConn());
				
				if(avaliacaodb.insereAvaliacao(matricula, idTipoNota, valorNota)) {
					out.println("Nota registrada com sucesso.");
				}
				else {
					out.println("Não foi possível registrar a nota.");
				}
			}
			else {
				System.out.println("Não foi possível estabelecer conexão com o banco de dados");
			}
			
			
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
