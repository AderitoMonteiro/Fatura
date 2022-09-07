package com.model.recibo;

import java.util.List;

public class ReciboEnv {

	private String TipoDoc;
	private String Venda;
	private String NumeroDoc;
	private String NomeCliente;
	private String Nif;
	private String Morada;
	private String NumeroCliente;
	private String NumeroConta;
	private String Moeda;
	private String Data;
	
	private reciboContainer[] ArrayReciboContainer;
	private meiosPagamento[] ArraymeiosPagamento;
	private revenueDetail[] ArrayRevenueDetail;
	
	
	
	public ReciboEnv() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ReciboEnv(String tipoDoc, String venda, String numeroDoc,
			String nomeCliente, String nif, String morada,
			String numeroCliente, String numeroConta, String moeda,
			String data, reciboContainer[] arrayReciboContainer,
			meiosPagamento[] arraymeiosPagamento,
			revenueDetail[] arrayRevenueDetail) {
		super();
		TipoDoc = tipoDoc;
		Venda = venda;
		NumeroDoc = numeroDoc;
		NomeCliente = nomeCliente;
		Nif = nif;
		Morada = morada;
		NumeroCliente = numeroCliente;
		NumeroConta = numeroConta;
		Moeda = moeda;
		Data = data;
		ArrayReciboContainer = arrayReciboContainer;
		ArraymeiosPagamento = arraymeiosPagamento;
		ArrayRevenueDetail = arrayRevenueDetail;
	}



	public String getTipoDoc() {
		return TipoDoc;
	}



	public void setTipoDoc(String tipoDoc) {
		TipoDoc = tipoDoc;
	}



	public String getVenda() {
		return Venda;
	}



	public void setVenda(String venda) {
		Venda = venda;
	}



	public String getNumeroDoc() {
		return NumeroDoc;
	}



	public void setNumeroDoc(String numeroDoc) {
		NumeroDoc = numeroDoc;
	}



	public String getNomeCliente() {
		return NomeCliente;
	}



	public void setNomeCliente(String nomeCliente) {
		NomeCliente = nomeCliente;
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



	public String getNumeroCliente() {
		return NumeroCliente;
	}



	public void setNumeroCliente(String numeroCliente) {
		NumeroCliente = numeroCliente;
	}



	public String getNumeroConta() {
		return NumeroConta;
	}



	public void setNumeroConta(String numeroConta) {
		NumeroConta = numeroConta;
	}



	public String getMoeda() {
		return Moeda;
	}



	public void setMoeda(String moeda) {
		Moeda = moeda;
	}



	public String getData() {
		return Data;
	}



	public void setData(String data) {
		Data = data;
	}



	public reciboContainer[] getArrayReciboContainer() {
		return ArrayReciboContainer;
	}



	public void setArrayReciboContainer(reciboContainer[] arrayReciboContainer) {
		ArrayReciboContainer = arrayReciboContainer;
	}



	public meiosPagamento[] getArraymeiosPagamento() {
		return ArraymeiosPagamento;
	}



	public void setArraymeiosPagamento(meiosPagamento[] arraymeiosPagamento) {
		ArraymeiosPagamento = arraymeiosPagamento;
	}



	public revenueDetail[] getArrayRevenueDetail() {
		return ArrayRevenueDetail;
	}



	public void setArrayRevenueDetail(revenueDetail[] arrayRevenueDetail) {
		ArrayRevenueDetail = arrayRevenueDetail;
	}

	


	

	
	
}
