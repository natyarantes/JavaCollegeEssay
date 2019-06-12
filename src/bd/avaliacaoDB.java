package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class avaliacaoDB {
	private Connection dbConn;
	private PreparedStatement pst;
	
	public void setConn(Connection dbConn) {
		this.dbConn = dbConn;
	}
	
	//insert
	public boolean insereAvaliacao(String matricula, int tipoNota, int valorNota) {
		
		String strSQL = "INSERT INTO AVALIACAO (VALORNOTA, IDALUNO, IDTIPONOTA) VALUES (?, ?, ?);";	
		
		try {
			pst = dbConn.prepareStatement(strSQL);
			pst.setInt(1, valorNota);
			pst.setString(2, matricula);
			pst.setInt(3, tipoNota);
			pst.executeUpdate();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}
}
