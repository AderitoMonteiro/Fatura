package com.model.nota;

public class notaContainer {

	
	private String referencia;
	private String num;
	private String tipo;
	private String valor;
	private String descricao;
	private String total;
	
	
	public notaContainer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public notaContainer(String referencia, String num, String tipo,
			String valor, String descricao, String total) {
		super();
		this.referencia = referencia;
		this.num = num;
		this.tipo = tipo;
		this.valor = valor;
		this.descricao = descricao;
		this.total = total;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}
	
	
}
