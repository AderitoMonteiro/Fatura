package com.ucc2.doc.resumo;

public class MeioPagamento {

	
	private String Amount;
	private String Cnt_Assignment_Nr;
	private String DESCRIPTION;
	
	
	public MeioPagamento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MeioPagamento(String amount, String cnt_Assignment_Nr,
			String dESCRIPTION) {
		super();
		Amount = amount;
		Cnt_Assignment_Nr = cnt_Assignment_Nr;
		DESCRIPTION = dESCRIPTION;
	}


	public String getAmount() {
		return Amount;
	}


	public void setAmount(String amount) {
		Amount = amount;
	}


	public String getCnt_Assignment_Nr() {
		return Cnt_Assignment_Nr;
	}


	public void setCnt_Assignment_Nr(String cnt_Assignment_Nr) {
		Cnt_Assignment_Nr = cnt_Assignment_Nr;
	}


	public String getDESCRIPTION() {
		return DESCRIPTION;
	}


	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	
	
	
}
