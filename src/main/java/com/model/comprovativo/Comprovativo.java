package com.model.comprovativo;

import java.util.List;

public class Comprovativo {

	
	private String tipoDoc;
	private String numeroDoc;
	private String nomeCliente;
	private String nif;
	private String morada;
	private String numeroCliente;
	private String numeroConta;
	private String dataemitida;
	
	String rodaPe;
	String bi;
	String bca;
	String bai;
	String cecv;
	String bcn;
	List<comprovativoContainer> comprovativoContainer;
	
	public Comprovativo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comprovativo(
			String tipoDoc,
			String numeroDoc,
			String nomeCliente,
			String nif,
			String morada,
			String numeroCliente,
			String numeroConta,
			String dataemitida,
			String rodaPe,
			String bi,
			String bca,
			String bai,
			String cecv,
			String bcn,
			List<com.model.comprovativo.comprovativoContainer> comprovativoContainer) {
		super();
		this.tipoDoc = tipoDoc;
		this.numeroDoc = numeroDoc;
		this.nomeCliente = nomeCliente;
		this.nif = nif;
		this.morada = morada;
		this.numeroCliente = numeroCliente;
		this.numeroConta = numeroConta;
		this.dataemitida = dataemitida;
		this.rodaPe = rodaPe;
		this.bi = bi;
		this.bca = bca;
		this.bai = bai;
		this.cecv = cecv;
		this.bcn = bcn;
		this.comprovativoContainer = comprovativoContainer;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
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

	public String getDataemitida() {
		return dataemitida;
	}

	public void setDataemitida(String dataemitida) {
		this.dataemitida = dataemitida;
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

	public List<comprovativoContainer> getComprovativoContainer() {
		return comprovativoContainer;
	}

	public void setComprovativoContainer(
			List<comprovativoContainer> comprovativoContainer) {
		this.comprovativoContainer = comprovativoContainer;
	}
	
	
	
	
}
