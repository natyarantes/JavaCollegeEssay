package bd;

import java.sql.*;
import java.util.ArrayList;

import model.Aluno;

public class alunoDB {
	
	private Connection dbConn;
	private PreparedStatement psComm;
	private ResultSet rsRecords;
	
	public void setConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
	
	//insert
	public boolean insertRecord(Aluno aluno) {
		
		String strSQL;
		
		try {
			strSQL = "INSERT INTO ALUNO (MATRICULA, NOME, ENDERECO, TELEFONE) VALUES (' " +
					aluno.getMatricula() + "', '" +
					aluno.getNome() + "','" +
					aluno.getEndereco() + "','" +
					aluno.getTelefone() + "'" +
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
	public Aluno findRecord(String matricula) {
		
		String strSQL;
		
		try {
			strSQL = "SELECT * FROM ALUNO WHERE MATRICULA = " +  matricula + ";";
			
			psComm = dbConn.prepareStatement(strSQL);
			rsRecords = psComm.executeQuery();
			rsRecords.next();
			
			Aluno alunoObj = new Aluno();
			
			alunoObj.setMatricula(matricula);
			alunoObj.setNome(rsRecords.getString(2));
			alunoObj.setEndereco(rsRecords.getString(3));
			alunoObj.setTelefone(rsRecords.getString(4));
			
			return alunoObj;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//select todos os alunos
	public ArrayList<Aluno> listAluno() {
		
		String strSQL;
		
		try {
			strSQL = "SELECT Matricula, Nome FROM ALUNO ;";
			ArrayList<Aluno> alunos = new ArrayList<Aluno>();
			
			psComm = dbConn.prepareStatement(strSQL);
			rsRecords = psComm.executeQuery();
			rsRecords.next();
			
			while (rsRecords.next()) {
				Aluno alunoObj = new Aluno();
				
				alunoObj.setMatricula(rsRecords.getString(1));
				alunoObj.setNome(rsRecords.getString(2));
				
				alunos.add(alunoObj);
			}
			
			return alunos;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//update
	public Aluno updateRecord(Aluno aluno) {
		
		String strSQL;
		
		if (findRecord(aluno.getMatricula()) == null) {
			return null;
		}
		else {
		
			try {
				//Aluno alunoObj = new Aluno();
				
				strSQL = "UPDATE ALUNO SET MATRICULA = '" + aluno.getMatricula() + 
						"', NOME = '" + aluno.getNome() + 
						"', ENDERECO = '" + aluno.getEndereco() +
						"', TELEFONE = '" + aluno.getTelefone() + 
						"' WHERE MATRICULA = '" + aluno.getMatricula() + "';";
				
				psComm = dbConn.prepareStatement(strSQL);
				psComm.executeUpdate();
				
				System.out.println(strSQL);
				return findRecord(aluno.getMatricula());
				
				
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
				strSQL = "DELETE FROM ALUNO WHERE MATRICULA = " + matricula + ";";
				
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
