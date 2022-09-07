package com.model.nota;

import java.util.List;



public class Nota {

	
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
	
	String rodaPe;
	String bi;
	String bca;
	String bai;
	String cecv;
	String bcn;
	
	List<notaContainer> notaContainer;

	public Nota() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nota(String tipoDoc, String venda, String numeroDoc,
			String nomeCliente, String nif, String morada,
			String numeroCliente, String numeroConta, String moeda,
			String data, String rodaPe, String bi, String bca, String bai,
			String cecv, String bcn,
			List<com.model.nota.notaContainer> notaContainer) {
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
		this.rodaPe = rodaPe;
		this.bi = bi;
		this.bca = bca;
		this.bai = bai;
		this.cecv = cecv;
		this.bcn = bcn;
		this.notaContainer = notaContainer;
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

	public String getRodaPe() {
		return rodaPe;
	}

	public void setRodaPe(String rodaPe) {
		this.rodaPe = rodaPe;
	}

	public String getBi() {
		return bi;
	}

	public void setBi(String bi) {
		this.bi = bi;
	}

	public String getBca() {
		return bca;
	}

	public void setBca(String bca) {
		this.bca = bca;
	}

	public String getBai() {
		return bai;
	}

	public void setBai(String bai) {
		this.bai = bai;
	}

	public String getCecv() {
		return cecv;
	}

	public void setCecv(String cecv) {
		this.cecv = cecv;
	}

	public String getBcn() {
		return bcn;
	}

	public void setBcn(String bcn) {
		this.bcn = bcn;
	}

	public List<notaContainer> getNotaContainer() {
		return notaContainer;
	}

	public void setNotaContainer(List<notaContainer> notaContainer) {
		this.notaContainer = notaContainer;
	}
	
	
	
	
}
