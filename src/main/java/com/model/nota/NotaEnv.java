package com.model.nota;

public class NotaEnv {

	
	
	private String tipoDoc;
	private String venda;
	private String numeroDoc;
	private String nomeCliente;
	private String nif;
	private String morada;
	private String numeroCliente;
	private String numeroConta;
	private String moeda;
	private String data;
	
	private notaContainer[] ArraynotaContainer;

	public NotaEnv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotaEnv(String tipoDoc, String venda, String numeroDoc,
			String nomeCliente, String nif, String morada,
			String numeroCliente, String numeroConta, String moeda,
			String data, notaContainer[] arraynotaContainer) {
		super();
		this.tipoDoc = tipoDoc;
		this.venda = venda;
		this.numeroDoc = numeroDoc;
		this.nomeCliente = nomeCliente;
		this.nif = nif;
		this.morada = morada;
		this.numeroCliente = numeroCliente;
		this.numeroConta = numeroConta;
		this.moeda = moeda;
		this.data = data;
		ArraynotaContainer = arraynotaContainer;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getVenda() {
		return venda;
	}

	public void setVenda(String venda) {
		this.venda = venda;
	}

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public String getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public notaContainer[] getArraynotaContainer() {
		return ArraynotaContainer;
	}

	public void setArraynotaContainer(notaContainer[] arraynotaContainer) {
		ArraynotaContainer = arraynotaContainer;
	}

	
	
	
	
	
	
	
}
