package com.ucc2.master;

public class NotaResponse {

	private byte[] output;
	private int valorMes;
	
	
	public NotaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NotaResponse(byte[] output, int valorMes) {
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
