package com.ucc2.master;

public class FaturaResponse {

	private byte[] output;
	private int valorMes;
	
	public FaturaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FaturaResponse(byte[] output, int valorMes) {
		super();
		this.output = output;
		this.valorMes = valorMes;
	}

	/**
	 * @return the output
	 */
	public byte[] getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(byte[] output) {
		this.output = output;
	}

	/**
	 * @return the valorMes
	 */
	public int getValorMes() {
		return valorMes;
	}

	/**
	 * @param valorMes the valorMes to set
	 */
	public void setValorMes(int valorMes) {
		this.valorMes = valorMes;
	}
	
	
}
