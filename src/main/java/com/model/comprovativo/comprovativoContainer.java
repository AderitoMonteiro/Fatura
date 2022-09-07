package com.model.comprovativo;

public class comprovativoContainer {

	String col_1tituloServico;
	String col_1desServico;
	String nota;
	String totalIva;
	
	public comprovativoContainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public comprovativoContainer(String col_1tituloServico,
			String col_1desServico, String nota, String totalIva) {
		super();
		this.col_1tituloServico = col_1tituloServico;
		this.col_1desServico = col_1desServico;
		this.nota = nota;
		this.totalIva = totalIva;
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

	public String getTotalIva() {
		return totalIva;
	}

	public void setTotalIva(String totalIva) {
		this.totalIva = totalIva;
	}
	
	
	
	
}
