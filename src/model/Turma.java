package model;

import java.util.ArrayList;

/**
 * CLASSE TURMA 
 * 
 * @author natalia arantes
 * @date may 19
 * @version 1.0
 * @mail a225735013@fumec.edu.br
 *
 */


public class Turma {
	String nome;
	String idTurma;
	ArrayList<Aluno> Aluno;
	
	public Turma() {}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(String idTurma) {
		this.idTurma = idTurma;
	}
	public ArrayList<Aluno> getAluno() {
		return Aluno;
	}
	public void setAluno(ArrayList<Aluno> aluno) {
		Aluno = aluno;
	}
	@Override
	public String toString() {
		return "Turma [nome=" + nome + ", idTurma=" + idTurma + ", Aluno=" + Aluno + "]";
	}
	
	
	
}
