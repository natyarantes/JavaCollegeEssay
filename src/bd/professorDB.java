package bd;

import java.sql.*;

import model.Professor;

public class professorDB {

	private Connection dbConn;
	private PreparedStatement psComm;
	private ResultSet rsRecords;
	
	public void setConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
	
	//insert
	public boolean insertRecord(Professor professor) {
		
		String strSQL;
		
		try {
			strSQL = "INSERT INTO PROFESSOR (MATRICULA, NOME, ENDERECO, TELEFONE) VALUES (" +
					professor.getMatricula() + "," +
					professor.getNome() + "," +
					professor.getEndereco() + "," +
					professor.getTelefone() + "," +
					")";
			
			psComm = dbConn.prepareStatement(strSQL);
			psComm.executeUpdate();
			
			return true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	//select
	public Professor findRecord(String matricula) {
		
		String strSQL;
		
		try {
			strSQL = "SELECT * FROM PROFESSOR WHERE MATRICULA = " +  matricula + ";";
			
			psComm = dbConn.prepareStatement(strSQL);
			rsRecords = psComm.executeQuery();
			rsRecords.next();
			
			Professor professorObj = new Professor();
			
			professorObj.setMatricula(matricula);
			professorObj.setNome(rsRecords.getString(2));
			professorObj.setEndereco(rsRecords.getString(3));
			professorObj.setTelefone(rsRecords.getString(4));
			
			return professorObj;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//update
	public Professor updateRecord(Professor professor) {
		
		String strSQL;
		
		if (findRecord(professor.getMatricula()) == null) {
			return null;
		}
		else {
		
			try {
				
				strSQL = "UPDATE PROFESSOR SET MATRICULA = " + professor.getMatricula() + 
						", NOME = " + professor.getNome() + 
						", ENDERECO = " + professor.getEndereco() +
						", TELEFONE = " + professor.getTelefone() + 
						"WHERE MATRICULA = " + professor.getMatricula() + ";";
				
				psComm = dbConn.prepareStatement(strSQL);
				psComm.executeUpdate();
				
				return findRecord(professor.getMatricula());
				
				
			}
			catch (Exception e){
				e.printStackTrace();
				return null;
			}
		}
	}
	
	
	//delete
	public boolean removeRecord(String matricula) {
		String strSQL;
		
		if(findRecord(matricula) == null) {
			return false;
		}
		else {
			try {
				strSQL = "DELETE FROM PROFESSOR WHERE MATRICULA = " + matricula + ";";
				
				psComm = dbConn.prepareStatement(strSQL);
				psComm.executeUpdate();
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}
}
