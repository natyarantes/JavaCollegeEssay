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


public class Nota {
	int idNotas;
	String tipoNota;
	
	public Nota() {}

	public int getIdNotas() {
		return idNotas;
	}

	public void setIdNotas(int idNotas) {
		this.idNotas = idNotas;
	}

	public String getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}

	@Override
	public String toString() {
		return "Nota [idNotas=" + idNotas + ", tipoNota=" + tipoNota + "]";
	}
	
	
	
	
	
	
}
