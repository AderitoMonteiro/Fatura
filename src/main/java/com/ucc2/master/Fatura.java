package com.ucc2.master;

import com.ucc2.doc.resumo.BodyResumo;
import com.ucc2.doc.resumo.BodyResumoBundle;
import com.ucc2.doc.resumo.MeioPagamento;

public class Fatura {
	
	private String DataProcessamento;
	private String NumCliente;
	private String NumContaCliente;
	private String NumFatura;
	private String NomeCliente;
	private String NominhoCliente;
	private String Nif;
	private String Morada;
	private String ValorMes;
	private String PeriodoFaturacao;
	private String dataVencimento;
	private String rodape;
	private String entidade;
	private String referencia;
	private String mantante;
	private String bi;
	private String bca;
	private String bai;
	private String cecv;
	private String cbn;
    private String TypeHeader;
    private String nomeSubConta;
    
    //campos novos
    private String valor_unitario;
	private String iva;
	private String desconto;
	
	private BodyResumo [] BodyResumo;
	private BodyResumoBundle[] BodyResumoBundle;
	private MeioPagamento[] MeioPagamento;
	
	public Fatura() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Fatura(String dataProcessamento, String numCliente,
			String numContaCliente, String numFatura, String nomeCliente,
			String nominhoCliente, String nif, String morada, String valorMes,
			String periodoFaturacao, String dataVencimento, String rodape,
			String entidade, String referencia, String mantante, String bi,
			String bca, String bai, String cecv, String cbn, String typeHeader,
			String nomeSubConta, String valor_unitario, String iva,
			String desconto, com.ucc2.doc.resumo.BodyResumo[] bodyResumo,
			com.ucc2.doc.resumo.BodyResumoBundle[] bodyResumoBundle,
			com.ucc2.doc.resumo.MeioPagamento[] meioPagamento) {
		super();
		DataProcessamento = dataProcessamento;
		NumCliente = numCliente;
		NumContaCliente = numContaCliente;
		NumFatura = numFatura;
		NomeCliente = nomeCliente;
		NominhoCliente = nominhoCliente;
		Nif = nif;
		Morada = morada;
		ValorMes = valorMes;
		PeriodoFaturacao = periodoFaturacao;
		this.dataVencimento = dataVencimento;
		this.rodape = rodape;
		this.entidade = entidade;
		this.referencia = referencia;
		this.mantante = mantante;
		this.bi = bi;
		this.bca = bca;
		this.bai = bai;
		this.cecv = cecv;
		this.cbn = cbn;
		TypeHeader = typeHeader;
		this.nomeSubConta = nomeSubConta;
		this.valor_unitario = valor_unitario;
		this.iva = iva;
		this.desconto = desconto;
		BodyResumo = bodyResumo;
		BodyResumoBundle = bodyResumoBundle;
		MeioPagamento = meioPagamento;
	}



	public String getDataProcessamento() {
		return DataProcessamento;
	}

	public void setDataProcessamento(String dataProcessamento) {
		DataProcessamento = dataProcessamento;
	}

	public String getNumCliente() {
		return NumCliente;
	}

	public void setNumCliente(String numCliente) {
		NumCliente = numCliente;
	}

	public String getNumContaCliente() {
		return NumContaCliente;
	}

	public void setNumContaCliente(String numContaCliente) {
		NumContaCliente = numContaCliente;
	}

	public String getNumFatura() {
		return NumFatura;
	}

	public void setNumFatura(String numFatura) {
		NumFatura = numFatura;
	}

	public String getNomeCliente() {
		return NomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		NomeCliente = nomeCliente;
	}

	public String getNominhoCliente() {
		return NominhoCliente;
	}

	public void setNominhoCliente(String nominhoCliente) {
		NominhoCliente = nominhoCliente;
	}

	public String getNif() {
		return Nif;
	}

	public void setNif(String nif) {
		Nif = nif;
	}

	public String getMorada() {
		return Morada;
	}

	public void setMorada(String morada) {
		Morada = morada;
	}

	public String getValorMes() {
		return ValorMes;
	}

	public void setValorMes(String valorMes) {
		ValorMes = valorMes;
	}

	public String getPeriodoFaturacao() {
		return PeriodoFaturacao;
	}

	public void setPeriodoFaturacao(String periodoFaturacao) {
		PeriodoFaturacao = periodoFaturacao;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getRodape() {
		return rodape;
	}

	public void setRodape(String rodape) {
		this.rodape = rodape;
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

	public String getCbn() {
		return cbn;
	}

	public void setCbn(String cbn) {
		this.cbn = cbn;
	}

	public String getTypeHeader() {
		return TypeHeader;
	}

	public void setTypeHeader(String typeHeader) {
		TypeHeader = typeHeader;
	}

	public String getNomeSubConta() {
		return nomeSubConta;
	}

	public void setNomeSubConta(String nomeSubConta) {
		this.nomeSubConta = nomeSubConta;
	}

	public BodyResumo[] getBodyResumo() {
		return BodyResumo;
	}

	public void setBodyResumo(BodyResumo[] bodyResumo) {
		BodyResumo = bodyResumo;
	}

	public BodyResumoBundle[] getBodyResumoBundle() {
		return BodyResumoBundle;
	}

	public void setBodyResumoBundle(BodyResumoBundle[] bodyResumoBundle) {
		BodyResumoBundle = bodyResumoBundle;
	}

	public MeioPagamento[] getMeioPagamento() {
		return MeioPagamento;
	}

	public void setMeioPagamento(MeioPagamento[] meioPagamento) {
		MeioPagamento = meioPagamento;
	}

	
	public String getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(String valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	

}
