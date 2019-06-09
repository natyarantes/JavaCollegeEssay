package model;

import java.util.ArrayList;



/**
 * CLASSE PROFESSOR 
 * 
 * @author natalia arantes
 * @date may 19
 * @version 1.0
 * @mail a225735013@fumec.edu.br
 *
 */


public class Professor {
	String nome;
	String matricula;
	String endereco;
	String telefone;
	ArrayList<Turma> Turma;
	
	public Professor() {}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public ArrayList<Turma> getTurma() {
		return Turma;
	}
	public void setTurma(ArrayList<Turma> turma) {
		Turma = turma;
	}
	
	
	@Override
	public String toString() {
		return "Professor [nome=" + nome + ", matricula=" + matricula + ", endereco=" + endereco + ", telefone="
				+ telefone + ", Turma=" + Turma + "]";
	}
	
	
	
}
