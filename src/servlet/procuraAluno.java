package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class procuraAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrinterWriter = 
		String alunoMatricula = request.getParameter("alunoMatricula");
		
		try {
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

}
