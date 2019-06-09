package model;

import java.util.ArrayList;

/**
 * CLASSE ALUNO 
 * 
 * @author natalia arantes
 * @date may 19
 * @version 1.0
 * @mail a225735013@fumec.edu.br
 *
 */


public class Aluno {
	String nome;
	String matricula;
	String endereco;
	String telefone;
	ArrayList<Nota> Nota;
	
	public Aluno() {}
	
	
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
	public ArrayList<Nota> getNota() {
		return Nota;
	}
	public void setNota(ArrayList<Nota> nota) {
		Nota = nota;
	}
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", matricula=" + matricula + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", Nota=" + Nota + "]";
	}
	
	
	

}
