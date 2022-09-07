package com.ucc2.master;

public class FaturaReciboResponse {

	
	private byte[] output;
	private int valorMes;
	
	public FaturaReciboResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FaturaReciboResponse(byte[] output, int valorMes) {
		super();
		this.output = output;
		this.valorMes = valorMes;
	}

	public byte[] getOutput() {
		return output;
	}

	public void setOutput(byte[] output) {
		this.output = output;
	}

	public int getValorMes() {
		return valorMes;
	}

	public void setValorMes(int valorMes) {
		this.valorMes = valorMes;
	}
	
	
	
}
