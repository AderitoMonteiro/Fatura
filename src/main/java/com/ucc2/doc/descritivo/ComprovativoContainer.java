package com.ucc2.doc.descritivo;

public class ComprovativoContainer {

	String col_1tituloServico;
	String col_1desServico;
	String key;
	String value;
	String nota;
	
	private ComprovativoContainerDet[] ComprovativoContainerDet;

	public ComprovativoContainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComprovativoContainer(
			String col_1tituloServico,
			String col_1desServico,
			String key,
			String value,
			String nota,
			com.ucc2.doc.descritivo.ComprovativoContainerDet[] comprovativoContainerDet) {
		super();
		this.col_1tituloServico = col_1tituloServico;
		this.col_1desServico = col_1desServico;
		this.key = key;
		this.value = value;
		this.nota = nota;
		ComprovativoContainerDet = comprovativoContainerDet;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
