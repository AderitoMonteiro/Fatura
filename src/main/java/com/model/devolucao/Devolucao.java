package com.model.devolucao;

import java.util.List;

public class Devolucao {

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

	private String fpagamento;
	private String valorpagamento;
	private String recumendacao;
	private String recumendacao1;
	private String extenso;
	private String datahoravenda;
	private String assistente;	
	
	List<devolucaoContainer> devolucaoContainer;


	
	public Devolucao() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Devolucao(String tipoDoc, String venda, String numeroDoc,
			String nomeCliente, String nif, String morada,
			String numeroCliente, String numeroConta, String moeda,
			String data, String rodaPe, String bi, String bca, String bai,
			String cecv, String bcn, String fpagamento, String valorpagamento,
			String recumendacao, String recumendacao1, String extenso,
			String datahoravenda, String assistente,
			List<com.model.devolucao.devolucaoContainer> devolucaoContainer) {
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
		this.fpagamento = fpagamento;
		this.valorpagamento = valorpagamento;
		this.recumendacao = recumendacao;
		this.recumendacao1 = recumendacao1;
		this.extenso = extenso;
		this.datahoravenda = datahoravenda;
		this.assistente = assistente;
		this.devolucaoContainer = devolucaoContainer;
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



	public String getFpagamento() {
		return fpagamento;
	}



	public void setFpagamento(String fpagamento) {
		this.fpagamento = fpagamento;
	}



	public String getValorpagamento() {
		return valorpagamento;
	}



	public void setValorpagamento(String valorpagamento) {
		this.valorpagamento = valorpagamento;
	}



	public String getRecumendacao() {
		return recumendacao;
	}



	public void setRecumendacao(String recumendacao) {
		this.recumendacao = recumendacao;
	}



	public String getRecumendacao1() {
		return recumendacao1;
	}



	public void setRecumendacao1(String recumendacao1) {
		this.recumendacao1 = recumendacao1;
	}



	public String getExtenso() {
		return extenso;
	}



	public void setExtenso(String extenso) {
		this.extenso = extenso;
	}



	public String getDatahoravenda() {
		return datahoravenda;
	}



	public void setDatahoravenda(String datahoravenda) {
		this.datahoravenda = datahoravenda;
	}



	public String getAssistente() {
		return assistente;
	}



	public void setAssistente(String assistente) {
		this.assistente = assistente;
	}



	public List<devolucaoContainer> getDevolucaoContainer() {
		return devolucaoContainer;
	}



	public void setDevolucaoContainer(List<devolucaoContainer> devolucaoContainer) {
		this.devolucaoContainer = devolucaoContainer;
	}


	
	
}
