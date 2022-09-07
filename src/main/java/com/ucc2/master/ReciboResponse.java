package com.ucc2.master;

public class ReciboResponse {

	private byte[] output;
	private int valorMes;
	
	public ReciboResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReciboResponse(byte[] output, int valorMes) {
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
