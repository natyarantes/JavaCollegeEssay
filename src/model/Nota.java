package model;

/**
 * CLASSE NOTA 
 * 
 * @author natalia arantes
 * @date may 19
 * @version 1.0
 * @mail a225735013@fumec.edu.br
 *
 */


public abstract class Nota {
	double trabalho;
	double prova;
	double comportamento;
	
	public Nota() {}
	
	
	public double getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(double trabalho) {
		this.trabalho = trabalho;
	}
	public double getProva() {
		return prova;
	}
	public void setProva(double prova) {
		this.prova = prova;
	}
	public double getComportamento() {
		return comportamento;
	}
	public void setComportamento(double comportamento) {
		this.comportamento = comportamento;
	}
	@Override
	public String toString() {
		return "Nota [trabalho=" + trabalho + ", prova=" + prova + ", comportamento=" + comportamento + "]";
	}
	
	
	
}
