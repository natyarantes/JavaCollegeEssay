package bd;

import java.sql.*;
import java.util.ArrayList;

import model.Turma;
import model.Aluno;
import model.Professor;

public class turmaDB {

	private Connection dbConn;
	private PreparedStatement psComm;
	private ResultSet rsRecords;
	
	public void setConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
	
	//select - RETORNA TODOS OS DADOS DA TURMA
//	public boolean findTurma (Turma idTurma) {
//		
//		String strSQL;
//		
//		try {
//			strSQL = "SELECT * FROM TURMA WHERE";
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		
//	}
	
	//insert
	public boolean createTurma(String[] aluno, String matriculaProfessor, String nomeTurma) {
		
		String strSQL = "INSERT INTO TURMA (ALUNO_MATRICULA, PROFESSOR_MATRICULA, NOMETURMA) VALUES (?, ?, ?);";
		
		try {
			psComm = dbConn.prepareStatement(strSQL);
			
			for (int i =0; i < aluno.length; i++) {
				psComm.setString(1, aluno[i]);
				psComm.setString(2, matriculaProfessor);
				psComm.setString(3, nomeTurma);
				psComm.executeUpdate();
			}
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
}
