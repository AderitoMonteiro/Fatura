package com.ucc2.teste;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.ucc2.jasper.testeListaFaturaGerarPdf;
import com.ucc2.master.Header2;

public class ByteArrayToFile {
	
	 public static void ByteArrayToPDF(byte[] input, String filepath) {
	        try 
	             {   
	                  java.io.File fp = new java.io.File(filepath);
	                  java.io.FileOutputStream fos = new java.io.FileOutputStream(fp);
	                  fos.write(input);
	                  fos.close();
	             }
	             catch(Exception err)
	             {
	                 err.printStackTrace();
	                 
	             }
	      }
	 
	 public static void main(String []args){
		
		String filepath="C:\\Users\\alexandre.correia\\Desktop\\Teste";
		 
		String dataProcessamento="2018-04-05";
		String numCliente="123456987";
		String numContaCliente="369852147";
		String numFatura="897456213";
		String nomeCliente="Alexandre Correia";
		String nominhoCliente="Alex";
		String nif="142563987";
		String morada="Bela Vista";
		String valorMes="25.600";
		String periodoFaturacao="Maio a Junho de 2018";
		Image imglogo;
			
		 List<Header2> faturas = new ArrayList<Header2>();
		 
		 Header2 header = new Header2(dataProcessamento, numCliente, numContaCliente, numFatura, nomeCliente, nominhoCliente, nif, morada, valorMes, periodoFaturacao, null);		 
		 faturas.add(header);
		 
		 byte[] input = testeListaFaturaGerarPdf.GerarPdfListaFatura(faturas );
		
		
		ByteArrayToPDF(input, filepath);
		 
	 }

}
