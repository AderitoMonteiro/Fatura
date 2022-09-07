package com.ucc2.master;

public class Referencia {

	private String NumeroFatura;
	private String Entidade;
	private String REF_PAG_SISP;
	private String CheckDigit;
	private String REF_PAG;
	
	public Referencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Referencia(String numeroFatura, String entidade,
			String rEF_PAG_SISP, String checkDigit, String rEF_PAG) {
		super();
		NumeroFatura = numeroFatura;
		Entidade = entidade;
		REF_PAG_SISP = rEF_PAG_SISP;
		CheckDigit = checkDigit;
		REF_PAG = rEF_PAG;
	}

	/**
	 * @return the numeroFatura
	 */
	public String getNumeroFatura() {
		return NumeroFatura;
	}

	/**
	 * @param numeroFatura the numeroFatura to set
	 */
	public void setNumeroFatura(String numeroFatura) {
		NumeroFatura = numeroFatura;
	}

	/**
	 * @return the entidade
	 */
	public String getEntidade() {
		return Entidade;
	}

	/**
	 * @param entidade the entidade to set
	 */
	public void setEntidade(String entidade) {
		Entidade = entidade;
	}

	/**
	 * @return the rEF_PAG_SISP
	 */
	public String getREF_PAG_SISP() {
		return REF_PAG_SISP;
	}

	/**
	 * @param rEF_PAG_SISP the rEF_PAG_SISP to set
	 */
	public void setREF_PAG_SISP(String rEF_PAG_SISP) {
		REF_PAG_SISP = rEF_PAG_SISP;
	}

	/**
	 * @return the checkDigit
	 */
	public String getCheckDigit() {
		return CheckDigit;
	}

	/**
	 * @param checkDigit the checkDigit to set
	 */
	public void setCheckDigit(String checkDigit) {
		CheckDigit = checkDigit;
	}

	/**
	 * @return the rEF_PAG
	 */
	public String getREF_PAG() {
		return REF_PAG;
	}

	/**
	 * @param rEF_PAG the rEF_PAG to set
	 */
	public void setREF_PAG(String rEF_PAG) {
		REF_PAG = rEF_PAG;
	}
	
}
