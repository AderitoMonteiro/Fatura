package com.model.faturacredito;

import java.util.List;


public class FaturaCredito {

	
	
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
	
	private String entidade;
	private String referencia;
	private String mantante;
	private String banco;
	private String bancovalue;
	private String dataVencimento;
	private String valorMes;
	
	private String assistente;
	private String datahoravenda;
	
	List<faturaCreditoContainer> faturaCreditoContainer;


	public FaturaCredito() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FaturaCredito(
			String tipoDoc,
			String venda,
			String numeroDoc,
			String nomeCliente,
			String nif,
			String morada,
			String numeroCliente,
			String numeroConta,
			String moeda,
			String data,
			String rodaPe,
			String bi,
			String bca,
			String bai,
			String cecv,
			String bcn,
			String fpagamento,
			String valorpagamento,
			String recumendacao,
			String recumendacao1,
			String extenso,
			String entidade,
			String referencia,
			String mantante,
			String banco,
			String bancovalue,
			String dataVencimento,
			String valorMes,
			String assistente,
			String datahoravenda,
			List<com.model.faturacredito.faturaCreditoContainer> faturaCreditoContainer) {
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
		this.entidade = entidade;
		this.referencia = referencia;
		this.mantante = mantante;
		this.banco = banco;
		this.bancovalue = bancovalue;
		this.dataVencimento = dataVencimento;
		this.valorMes = valorMes;
		this.assistente = assistente;
		this.datahoravenda = datahoravenda;
		this.faturaCreditoContainer = faturaCreditoContainer;
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


	public String getEntidade() {
		return entidade;
	}


	public void setEntidade(String entidade) {
		this.entidade = entidade;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public String getMantante() {
		return mantante;
	}


	public void setMantante(String mantante) {
		this.mantante = mantante;
	}


	public String getBanco() {
		return banco;
	}


	public void setBanco(String banco) {
		this.banco = banco;
	}


	public String getBancovalue() {
		return bancovalue;
	}


	public void setBancovalue(String bancovalue) {
		this.bancovalue = bancovalue;
	}


	public String getDataVencimento() {
		return dataVencimento;
	}


	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}


	public String getValorMes() {
		return valorMes;
	}


	public void setValorMes(String valorMes) {
		this.valorMes = valorMes;
	}


	public String getAssistente() {
		return assistente;
	}


	public void setAssistente(String assistente) {
		this.assistente = assistente;
	}


	public String getDatahoravenda() {
		return datahoravenda;
	}


	public void setDatahoravenda(String datahoravenda) {
		this.datahoravenda = datahoravenda;
	}


	public List<faturaCreditoContainer> getFaturaCreditoContainer() {
		return faturaCreditoContainer;
	}


	public void setFaturaCreditoContainer(
			List<faturaCreditoContainer> faturaCreditoContainer) {
		this.faturaCreditoContainer = faturaCreditoContainer;
	}



	
}
