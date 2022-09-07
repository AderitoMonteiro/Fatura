package com.ucc2.master;
import com.ucc2.doc.descritivo.ComprovativoDet;
public class ComprovativoDoc {

	private String NumCliente;
	private String NumDoc;
	private String NomeCliente;
	private String Nif;
	private String Morada;
	
	private ComprovativoDet[] ComprovativoDet;

	public ComprovativoDoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComprovativoDoc(String numCliente, String numDoc,
			String nomeCliente, String nif, String morada,
			com.ucc2.doc.descritivo.ComprovativoDet[] comprovativoDet) {
		super();
		NumCliente = numCliente;
		NumDoc = numDoc;
		NomeCliente = nomeCliente;
		Nif = nif;
		Morada = morada;
		ComprovativoDet = comprovativoDet;
	}

	public String getNumCliente() {
		return NumCliente;
	}

	public void setNumCliente(String numCliente) {
		NumCliente = numCliente;
	}

	public String getNumDoc() {
		return NumDoc;
	}

	public void setNumDoc(String numDoc) {
		NumDoc = numDoc;
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

	public ComprovativoDet[] getComprovativoDet() {
		return ComprovativoDet;
	}

	public void setComprovativoDet(ComprovativoDet[] comprovativoDet) {
		ComprovativoDet = comprovativoDet;
	}
	
	

}

