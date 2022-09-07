package com.model.recibo;

public class reciboContainer {
	
	private String doc;
	private String numDoc;
	private String emissao;
	private String valorTotal;
	private String valorPago;
	private String valorDivida;
	private String valorPagoExtenso;
	private String movType;
	private String docId;

	
	public reciboContainer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public reciboContainer(String doc, String numDoc, String emissao,
			String valorTotal, String valorPago, String valorDivida,
			String valorPagoExtenso, String movType, String docId) {
		super();
		this.doc = doc;
		this.numDoc = numDoc;
		this.emissao = emissao;
		this.valorTotal = valorTotal;
		this.valorPago = valorPago;
		this.valorDivida = valorDivida;
		this.valorPagoExtenso = valorPagoExtenso;
		this.movType = movType;
		this.docId = docId;
	}


	public String getDoc() {
		return doc;
	}


	public void setDoc(String doc) {
		this.doc = doc;
	}


	public String getNumDoc() {
		return numDoc;
	}


	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}


	public String getEmissao() {
		return emissao;
	}


	public void setEmissao(String emissao) {
		this.emissao = emissao;
	}


	public String getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}


	public String getValorPago() {
		return valorPago;
	}


	public void setValorPago(String valorPago) {
		this.valorPago = valorPago;
	}


	public String getValorDivida() {
		return valorDivida;
	}


	public void setValorDivida(String valorDivida) {
		this.valorDivida = valorDivida;
	}


	public String getValorPagoExtenso() {
		return valorPagoExtenso;
	}


	public void setValorPagoExtenso(String valorPagoExtenso) {
		this.valorPagoExtenso = valorPagoExtenso;
	}


	public String getMovType() {
		return movType;
	}


	public void setMovType(String movType) {
		this.movType = movType;
	}


	public String getDocId() {
		return docId;
	}


	public void setDocId(String docId) {
		this.docId = docId;
	}



	
	
	
}
