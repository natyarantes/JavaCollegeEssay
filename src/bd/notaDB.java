package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Nota;


public class notaDB {

	private Connection dbConn;
	private PreparedStatement pst;
	
	public void setConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
	
	//insert
	public boolean insereTipoNota(String tipoNota) {
		String strSQL = "INSERT INTO NOTAS (tipoNota) VALUES (?);";
		
		try {
			pst = dbConn.prepareStatement(strSQL);
			pst.setString(1, tipoNota);
			pst.executeQuery();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//select
	public ArrayList<Nota> listaTipoNota() {
				
		String strSQL = "SELECT * from NOTAS;";
		ArrayList<Nota> notas = new ArrayList<Nota>();
		ResultSet result;
		
		try {
			pst = dbConn.prepareStatement(strSQL);
			result = pst.executeQuery();
			
			while (result.next()) {
				Nota nota = new Nota();
				nota.setTipoNota(result.getString(2));
				nota.setIdNotas(result.getInt(1));
				notas.add(nota);
			}
			return notas;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//delete
	public boolean removeTipoNota(int idNota) {
		String strSQL = "DELETE FROM NOTAS WHERE idNotas = ?;";
		
		try {
			pst = dbConn.prepareStatement(strSQL);
			pst.setInt(1, idNota);
			pst.executeQuery();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
}
