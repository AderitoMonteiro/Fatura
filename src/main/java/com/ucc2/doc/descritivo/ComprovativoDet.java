package com.ucc2.doc.descritivo;

public class ComprovativoDet {
	
	String col_1tituloServico;
	String col_1desServico;
	String nota;
	
	ComprovativoContainerDet[] ComprovativoContainerDet;


	public ComprovativoDet(
			String col_1tituloServico,
			String col_1desServico,
			String nota,
			com.ucc2.doc.descritivo.ComprovativoContainerDet[] comprovativoContainerDet) {
		super();
		this.col_1tituloServico = col_1tituloServico;
		this.col_1desServico = col_1desServico;
		this.nota = nota;
		ComprovativoContainerDet = comprovativoContainerDet;
	}


	public ComprovativoDet() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCol_1tituloServico() {
		return col_1tituloServico;
	}


	public void setCol_1tituloServico(String col_1tituloServico) {
		this.col_1tituloServico = col_1tituloServico;
	}


	public String getCol_1desServico() {
		return col_1desServico;
	}


	public void setCol_1desServico(String col_1desServico) {
		this.col_1desServico = col_1desServico;
	}


	public String getNota() {
		return nota;
	}


	public void setNota(String nota) {
		this.nota = nota;
	}


	public ComprovativoContainerDet[] getComprovativoContainerDet() {
		return ComprovativoContainerDet;
	}


	public void setComprovativoContainerDet(
			ComprovativoContainerDet[] comprovativoContainerDet) {
		ComprovativoContainerDet = comprovativoContainerDet;
	}


		
	

}
