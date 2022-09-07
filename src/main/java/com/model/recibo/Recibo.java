package com.model.recibo;

import java.util.List;

public class Recibo {

	
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
	
	List<reciboContainer> reciboContainer;
	List<meiosPagamento> meiosPagamento;
	

	public Recibo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Recibo(String tipoDoc, String venda, String numeroDoc,
			String nomeCliente, String nif, String morada,
			String numeroCliente, String numeroConta, String moeda,
			String data, String rodaPe, String bi, String bca, String bai,
			String cecv, String bcn,
			List<com.model.recibo.reciboContainer> reciboContainer,
			List<com.model.recibo.meiosPagamento> meiosPagamento) {
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
		this.reciboContainer = reciboContainer;
		this.meiosPagamento = meiosPagamento;
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


	public List<reciboContainer> getReciboContainer() {
		return reciboContainer;
	}


	public void setReciboContainer(List<reciboContainer> reciboContainer) {
		this.reciboContainer = reciboContainer;
	}


	public List<meiosPagamento> getMeiosPagamento() {
		return meiosPagamento;
	}


	public void setMeiosPagamento(List<meiosPagamento> meiosPagamento) {
		this.meiosPagamento = meiosPagamento;
	}



	

	
}
