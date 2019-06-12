package bd;

import model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class relatorioDB {
	private Connection dbConn;
	private PreparedStatement psComm;
	private ResultSet rsRecords;
	
	public void setConn(Connection dbConn) {
		this.dbConn = dbConn;
	}


	public ArrayList<Aluno> notaTotalPorAluno(String idTurma){
		String strSQL = "select aluno.nome, sum(avaliacao.valornota) from turma inner join aluno on turma.aluno_matricula = aluno.matricula inner join avaliacao on avaliacao.idaluno = turma.aluno_matricula where turma.nometurma = ? group by aluno.matricula;";
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			psComm = dbConn.prepareStatement(strSQL);
			psComm.setString(1, idTurma);
			rsRecords = psComm.executeQuery();

			while (rsRecords.next()) {
				Aluno alunoObj = new Aluno();
				alunoObj.setNome(rsRecords.getString(1));
				alunoObj.setNota(rsRecords.getInt(2));
				
				alunos.add(alunoObj);
				
			}
			return alunos;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
