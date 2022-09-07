package com.ucc2.jasper;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.model.fatura.BodyDescritivo;
import com.model.fatura.BodyDetalhado;
import com.model.fatura.BodyResumoJasper;
import com.model.fatura.fatura;
import com.ucc2.auxiliar.FormateData;
import com.ucc2.auxiliar.IBB;
import com.ucc2.auxiliar.Validator;
import com.ucc2.faturacao.FaturacaoService;
import com.ucc2.master.Fatura;

public class teste {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String x =FormateData.getVal2(482496.76);
//		//Float valor = Float.valueOf(x);
//		System.out.println("Valor "+x);
		System.out.println("init**********************************************");
		fatura fatura= new fatura();
		fatura.setBai("");
		fatura.setBca("");
		fatura.setBi("");
		
		/**********************/
		List<BodyDescritivo> listBodyDescritivo= new ArrayList<BodyDescritivo>();
		BodyDescritivo BodyDescritivo= new BodyDescritivo();
		BodyDescritivo.setServicoDescIva("1");
		BodyDescritivo.setServicoDescritivo("1");
		BodyDescritivo.setServicoMoeda("1");
		BodyDescritivo.setServicoValor("1");
		BodyDescritivo.setServicoValorIva("1");
		BodyDescritivo.setTituloDesciva("1");
		BodyDescritivo.setTituloDiscricao("1");
		BodyDescritivo.setTituloImagem(null);
		BodyDescritivo.setTituloMoeda("1");
		BodyDescritivo.setTituloServico("1");
		BodyDescritivo.setTituloValor("1");
		BodyDescritivo.setTituloValorIva("1");		
		listBodyDescritivo.add(BodyDescritivo);
		fatura.setBodyDescritivo(listBodyDescritivo);
		
		/*********************************************/
		List<BodyDetalhado> listBodyDetalhado= new ArrayList<BodyDetalhado>();
		BodyDetalhado BodyDetalhado= new BodyDetalhado();
		BodyDetalhado.setCol_1data("1");
		BodyDetalhado.setCol_2label("1");
		BodyDetalhado.setCol_2value("1");
		BodyDetalhado.setCol_3duracao("1");
		BodyDetalhado.setCol_4extra("1");
		BodyDetalhado.setCol_5tipochamada("1");
		BodyDetalhado.setCol_6valor("1");
		BodyDetalhado.setHeader_quantidade("1");
		BodyDetalhado.setHeader_valor("1");
		BodyDetalhado.setImagemServico(null);
		BodyDetalhado.setTipoDetalhe("1");
		BodyDetalhado.setTipoDImagem_imagem(null);
		BodyDetalhado.setTituloDescricao("1");
		BodyDetalhado.setTituloServico("1");	
		listBodyDetalhado.add(BodyDetalhado);
		fatura.setBodyDetalhado(listBodyDetalhado);
		/*********************************************/
		
		List<BodyResumoJasper> listBodyResumoJasper= new ArrayList<BodyResumoJasper>();
		BodyResumoJasper BodyResumoJasper= new BodyResumoJasper();
		BodyResumoJasper.setCol_1aux1("1");
		BodyResumoJasper.setCol_1aux2("1");
		BodyResumoJasper.setCol_1aux3("1");
		BodyResumoJasper.setCol_1desServico("1");
		BodyResumoJasper.setCol_1image(null);
		BodyResumoJasper.setCol_1tituloServico("1");
		BodyResumoJasper.setCol_2aux1("1");
		BodyResumoJasper.setCol_2aux2("1");
		BodyResumoJasper.setCol_2aux3("1");
		BodyResumoJasper.setCol_2quantidade("1");
		BodyResumoJasper.setCol_2unidade("1");
		BodyResumoJasper.setCol_3aux1("1");
		BodyResumoJasper.setCol_3aux2("1");
		BodyResumoJasper.setCol_3aux3("1");
		BodyResumoJasper.setCol_3moeda("1");
		BodyResumoJasper.setCol_3valorBase("1");
		BodyResumoJasper.setCol_4aux1("1");
		BodyResumoJasper.setCol_4aux2("1");
		BodyResumoJasper.setCol_4aux3("1");
		BodyResumoJasper.setCol_4extra("1");
		BodyResumoJasper.setCol_4extraDesc("1");
		BodyResumoJasper.setCol_4moeda("1");
		listBodyResumoJasper.add(BodyResumoJasper);
		fatura.setBodyResumo(listBodyResumoJasper);
		/***************************************************/
		
		fatura.setCbn("1");
		fatura.setCecv("1");
		fatura.setDataProcessamento("2018-04-01 22:22:22");
		fatura.setDataVencimento("2018-04-01 22:22:22");
		fatura.setEntidade("123456987");
		fatura.setMantante("11");
		fatura.setMorada("Praia");
		fatura.setNif("123456789");
		fatura.setNomeCliente("xxxx");
		fatura.setNomeSubConta("ttttt");
		fatura.setNominhoCliente("ddd");
		fatura.setNumCliente("2222222");
		fatura.setNumContaCliente("25866666");
		fatura.setNumFatura("300000");
		fatura.setPeriodoFaturacao("20180501");
		fatura.setReferencia("00046");
		fatura.setRodape("dddddddddd");
		fatura.setTipoFatura("");
		fatura.setValorMes("500");
		/*****************************************************/
		ArrayList<fatura> listFatura=new ArrayList<fatura>();  
		listFatura.add(fatura);

		ListaFaturaGerarPdf listaFaturaGerarPdf = new ListaFaturaGerarPdf();
		listaFaturaGerarPdf.GerarPdfListaFatura(listFatura);
		System.out.println("end**********************************************");
	}

}
