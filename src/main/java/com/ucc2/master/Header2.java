package com.ucc2.master;

import java.awt.Image;

public class Header2 {
	
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
	private Image imglogo;
	
    public Header2(){
    	super();
    }

	public Header2(String dataProcessamento, String numCliente,
			String numContaCliente, String numFatura, String nomeCliente,
			String nominhoCliente, String nif, String morada, String valorMes,
			String periodoFaturacao, Image imglogo) {
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
		this.imglogo = imglogo;
	}

	/**
	 * @return the dataProcessamento
	 */
	public String getDataProcessamento() {
		return DataProcessamento;
	}

	/**
	 * @param dataProcessamento the dataProcessamento to set
	 */
	public void setDataProcessamento(String dataProcessamento) {
		DataProcessamento = dataProcessamento;
	}

	/**
	 * @return the numCliente
	 */
	public String getNumCliente() {
		return NumCliente;
	}

	/**
	 * @param numCliente the numCliente to set
	 */
	public void setNumCliente(String numCliente) {
		NumCliente = numCliente;
	}

	/**
	 * @return the numContaCliente
	 */
	public String getNumContaCliente() {
		return NumContaCliente;
	}

	/**
	 * @param numContaCliente the numContaCliente to set
	 */
	public void setNumContaCliente(String numContaCliente) {
		NumContaCliente = numContaCliente;
	}

	/**
	 * @return the numFatura
	 */
	public String getNumFatura() {
		return NumFatura;
	}

	/**
	 * @param numFatura the numFatura to set
	 */
	public void setNumFatura(String numFatura) {
		NumFatura = numFatura;
	}

	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return NomeCliente;
	}

	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		NomeCliente = nomeCliente;
	}

	/**
	 * @return the nominhoCliente
	 */
	public String getNominhoCliente() {
		return NominhoCliente;
	}

	/**
	 * @param nominhoCliente the nominhoCliente to set
	 */
	public void setNominhoCliente(String nominhoCliente) {
		NominhoCliente = nominhoCliente;
	}

	/**
	 * @return the nif
	 */
	public String getNif() {
		return Nif;
	}

	/**
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		Nif = nif;
	}

	/**
	 * @return the morada
	 */
	public String getMorada() {
		return Morada;
	}

	/**
	 * @param morada the morada to set
	 */
	public void setMorada(String morada) {
		Morada = morada;
	}

	/**
	 * @return the valorMes
	 */
	public String getValorMes() {
		return ValorMes;
	}

	/**
	 * @param valorMes the valorMes to set
	 */
	public void setValorMes(String valorMes) {
		ValorMes = valorMes;
	}

	/**
	 * @return the periodoFaturacao
	 */
	public String getPeriodoFaturacao() {
		return PeriodoFaturacao;
	}

	/**
	 * @param periodoFaturacao the periodoFaturacao to set
	 */
	public void setPeriodoFaturacao(String periodoFaturacao) {
		PeriodoFaturacao = periodoFaturacao;
	}

	/**
	 * @return the imglogo
	 */
	public Image getImglogo() {
		return imglogo;
	}

	/**
	 * @param imglogo the imglogo to set
	 */
	public void setImglogo(Image imglogo) {
		this.imglogo = imglogo;
	}

	
}
