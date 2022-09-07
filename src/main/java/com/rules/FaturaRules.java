package com.rules;

import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.model.devolucao.Devolucao;
import com.model.devolucao.devolucaoContainer;
import com.model.faturacredito.FaturaCredito;
import com.model.faturacredito.faturaCreditoContainer;
import com.model.faturarecibo.FaturaRecibo;
import com.model.faturarecibo.faturaReciboContainer;
import com.oferta.Oferta;
import com.oferta.ofertaContainer;
import com.ucc2.auxiliar.FormateData;
import com.ucc2.auxiliar.GetByteFromFile;
import com.ucc2.doc.resumo.BodyResumo;
import com.ucc2.doc.resumo.BodyResumoBundle;
import com.ucc2.doc.resumo.ItemsBundle;
import com.ucc2.doc.resumo.MeioPagamento;
import com.ucc2.jasper.ListaDevolucaoGerarPdf;
import com.ucc2.jasper.ListaFaturaCreditoGerarPdf;
import com.ucc2.jasper.ListaFatutaReciboGerarPdf;
import com.ucc2.jasper.ListaOfertaGerarPdf;
import com.ucc2.master.Fatura;
import com.ucc2.master.FaturaReciboResponse;

public class FaturaRules {

	
	public static  FaturaReciboResponse FaturaReciboService(Fatura novafatura){
		
		System.out.println("Antes Gerar Pdf Recibo");

		String col_1tituloServico="";String col_1desServico="";Image col_1image=null;String col_1aux1="";String col_1aux2="";String col_1aux3="";String col_2quantidade="";String col_2unidade="";
		String col_2aux1="";String col_2aux2="";String col_2aux3="";String col_3valorBase="";String col_3moeda="";String col_3aux1="";String col_3aux2="";String col_3aux3="";String col_4extra="";
		String col_4extraDesc="";String col_4moeda="";String col_4aux1="";String col_4aux2="";String col_4aux3="";String col_5tatal="";String col_5moeda="";double col_5iva=0;String col_5aux1="";
		String col_5aux2="";String col_5aux3="";String col_5totalEuro="";String col_5ivaDesc="";String valorMesBodyResumo="";String col_5valBruto="";String col_5valRond="";String total_col3="";
		String total_col4="";String total_col5="";
		String taxa="";String incidencia="";String imposto="";
		String valorMes="";
		String valorMesFormatado="";
		String footerValorTotal="";
		String footerValorTotalIncidencia="";
		String totalEuro="";
		String col_5ivaFinal="";
		String col_5totaliva_ultimo="";
		
		double totalValorBase=0;
		double totalExtra=0;
		double totalTotal=0;
		double percentagem=0;
		double incidenciaresultado=0;
		double impostoresultado=0;
		
		FaturaReciboResponse faturaReciboResponse =null;
		FaturaCredito FaturaCredito = new FaturaCredito();
		List<faturaCreditoContainer> LfaturaCreditoContainer = new ArrayList<faturaCreditoContainer>();
		if(novafatura != null){

			valorMes=novafatura.getValorMes();
			String rodape = "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde";
			FaturaCredito.setBai(novafatura.getBai());
			FaturaCredito.setBca(novafatura.getBca());
			FaturaCredito.setBcn(novafatura.getCbn());
			FaturaCredito.setBi(novafatura.getBi());
			FaturaCredito.setCecv(novafatura.getCecv());
			FaturaCredito.setData(novafatura.getDataProcessamento());
			FaturaCredito.setMoeda("CVE");
			FaturaCredito.setMorada(novafatura.getMorada());
			FaturaCredito.setNif(novafatura.getNif());
			FaturaCredito.setNomeCliente(novafatura.getNomeCliente());
			FaturaCredito.setNumeroCliente(novafatura.getNumCliente());
			FaturaCredito.setNumeroConta(novafatura.getNumContaCliente());
			FaturaCredito.setRodaPe(rodape);
			FaturaCredito.setTipoDoc("Fatura Crédito");
			FaturaCredito.setVenda("");
			FaturaCredito.setNumeroDoc(novafatura.getNumFatura());
			String recumendacao="Os nossos equipamentos têm uma garantia de 12 meses a contar da data de compra. Cobre os efeitos de fabrico e de funcionamento considerando as condições normais de uso, desde que não tenham sofridos reparos por pessoas não autorizadas. (lei nº 88/V/98, de 31de Dezembro regime jurídico de proteção e defesa dos";
			FaturaCredito.setRecumendacao(recumendacao);
			FaturaCredito.setRecumendacao1("Em caso de reclamação deverá apresentar o recibo de compra juntamente com a caixa do equipamento e os acessórios.");

			System.out.println("Assistente ::::: ---->>>>CRED "+novafatura.getNominhoCliente());
			
			FaturaCredito.setAssistente("");
			FaturaCredito.setDatahoravenda(FormateData.DataNowFat());
			
			if(!novafatura.getNominhoCliente().equals("0")){
				FaturaCredito.setAssistente(novafatura.getNominhoCliente());
			}
						
			FaturaCredito.setEntidade(novafatura.getEntidade());
			FaturaCredito.setReferencia(novafatura.getReferencia());
			FaturaCredito.setBanco(getBank());
			FaturaCredito.setBancovalue(getBankValue());
			FaturaCredito.setDataVencimento("Total a pagar até "+getDateLimitPagamento(novafatura.getDataVencimento()));
			
			
			BodyResumo [] ArraybodyResumoFatura=null;
			BodyResumo bodyResumo = new BodyResumo();
			BodyResumoBundle [] ArrayBodyResumoBundle=null;
			BodyResumoBundle bodyResumoBundle=new BodyResumoBundle();
//			MeioPagamento [] ArrayMeioPagamento=novafatura.getMeioPagamento();
			
			System.out.println("FR2");
			ArrayBodyResumoBundle=novafatura.getBodyResumoBundle();
			
			//Get BodyResumo []
			ArraybodyResumoFatura=novafatura.getBodyResumo();
		
			
			String valorBaseValue="";
			String extraValue="";
			String totalComIva="";
			double doubleValorMes=0;
			String footerValorArrendondamento="0";
			faturaCreditoContainer faturaCreditoContainer = null;
			
		
			if(ArrayBodyResumoBundle!=null)
			{
				
				int tma=ArrayBodyResumoBundle.length;				
				for(int x=0;x<tma;x++){
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					valorBaseValue=bodyResumoBundle.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumoBundle.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumoBundle.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumoBundle.getTaxa();
				
				}
				
			}
			
			if(ArraybodyResumoFatura!=null)
			{
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;
			
				
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					valorBaseValue=bodyResumo.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumo.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumo.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumo.getTaxa();
				
				}
			}
			
			if(ArraybodyResumoFatura!=null || ArrayBodyResumoBundle!=null){
				
				try{
				 doubleValorMes=Double.parseDouble(valorMes);
				 valorMesFormatado=FormateData.getVal(doubleValorMes);
		         footerValorArrendondamento="-0,"+valorMesFormatado.substring(valorMesFormatado.length()-2, valorMesFormatado.length());
		        footerValorTotal=valorMesFormatado.substring(0, valorMesFormatado.length()-2)+"00";
		        col_5totaliva_ultimo="("+FormateData.getVal(doubleValorMes/1.15)+")";
				incidencia=valorMes;
				incidenciaresultado=Double.parseDouble(incidencia);
				incidenciaresultado=doubleValorMes/1.15;//Double.parseDouble(incidencia);
				int valExtenso=(int)doubleValorMes;
				String extensoDesc=FormateData.getExtensao(valExtenso);
				FaturaCredito.setExtenso(extensoDesc);
				FaturaCredito.setMantante(valorMesFormatado);
				FaturaCredito.setValorMes(valorMesFormatado);
				percentagem=(Float.parseFloat(taxa)/100)+1;
				impostoresultado=doubleValorMes-incidenciaresultado;//(incidenciaresultado/percentagem);
				imposto=FormateData.getVal(impostoresultado);
				footerValorTotalIncidencia=FormateData.getVal(doubleValorMes/1.15);
				}catch(Exception e){
					e.printStackTrace();
				}
			
			}

			
			if(ArraybodyResumoFatura!=null)
			{
				
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;	

				/********************Item Produto Simples*************************/
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					faturaCreditoContainer = new faturaCreditoContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumo.getProdutoTitulo();
					col_1desServico="";
//					if(bodyResumo.getProdutoDescricao()!=null){
//						col_1desServico=bodyResumo.getProdutoDescricao();
//					}

					if(bodyResumo.getProdutoDescricao()!=null && !bodyResumo.getProdutoDescricao().equals("")){
						col_1desServico=bodyResumo.getProdutoDescricao();
					}else{
						//Valor do Numero que recebeu Serviço
						if(bodyResumo.getTotalEuro()!=null){
							col_1desServico=bodyResumo.getTotalEuro();
						}
						
					}
					
					 imgcol_1image=GetByteFromFile.generate(bodyResumo.getProdutoImagem());

					col_2quantidade=bodyResumo.getValorQuantidadeValue();
					col_2unidade=bodyResumo.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumo.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumo.getValorBaseUnidade();

					col_4extra=bodyResumo.getExtraValue();
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumo.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumo.getValorBaseUnidade();
						double re=doubleValorMes/110.265;
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumo.getValorBruto();
					col_5valRond=bodyResumo.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumo.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					
					faturaCreditoContainer.setCol_1desServicoBundle("");
					faturaCreditoContainer.setCol_1tituloServico(col_1tituloServico);
					faturaCreditoContainer.setCol_1desServico(col_1desServico);

					faturaCreditoContainer.setCol_1image(imgcol_1image);//
					faturaCreditoContainer.setCol_2quantidade(col_2quantidade);
					//faturaCreditoContainer.setCol_2unidade(col_2unidade);
					faturaCreditoContainer.setCol_3valorBase(col_3valorBase);
					//faturaCreditoContainer.setCol_3moeda(col_3moeda);
					faturaCreditoContainer.setCol_4extra(col_4extra);
					faturaCreditoContainer.setCol_4extraDesc(col_4extraDesc);
					faturaCreditoContainer.setCol_5tatal(col_5tatal);
					//faturaCreditoContainer.setCol_5moeda(col_5moeda);
					faturaCreditoContainer.setCol_5iva(col_5ivaFinal);
					faturaCreditoContainer.setCol_5aux1(col_5aux1);
					faturaCreditoContainer.setCol_5aux2(col_5aux2);
					faturaCreditoContainer.setCol_5aux3(col_5aux3);
					faturaCreditoContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaCreditoContainer.setCol_5ivaDesc(col_5ivaDesc);

					faturaCreditoContainer.setCol_5valBruto(valorMesFormatado);
					faturaCreditoContainer.setCol_5valRond(footerValorArrendondamento);
					faturaCreditoContainer.setTotal_col3(total_col3);
					faturaCreditoContainer.setTotal_col4(total_col4);
					faturaCreditoContainer.setTotal_col5(footerValorTotal);
					faturaCreditoContainer.setTaxa(taxa +" %");

					faturaCreditoContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaCreditoContainer.setImposto(imposto);
					faturaCreditoContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaCreditoContainer.setCol_5desciva_ultimo("Sem IVA");
					
					faturaCreditoContainer.setCol_2quantidadeBundle("");
					faturaCreditoContainer.setCol_5tatalBundle("");
					
					LfaturaCreditoContainer.add(faturaCreditoContainer);
				
				}
				
				
				

			}
				
				
				/*****************Items Bundle*****************/
				if(ArrayBodyResumoBundle!=null)
				{
					
					int tma=ArrayBodyResumoBundle.length;
					if(tma==1){
						bodyResumoBundle=ArrayBodyResumoBundle[0];
						if(bodyResumoBundle.getProdutoTitulo().equals("") && bodyResumoBundle.getValorBaseValue().equals("0") ){
							tma=0;
						}
					}
					
					
					for(int x=0;x<tma;x++)
					{
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					faturaCreditoContainer = new faturaCreditoContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumoBundle.getProdutoTitulo();

					col_1desServico=bodyResumoBundle.getProdutoDescricao();

					
					 imgcol_1image=GetByteFromFile.generate(bodyResumoBundle.getProdutoImagem());

					col_2quantidade=bodyResumoBundle.getValorQuantidadeValue();
					col_2unidade=bodyResumoBundle.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumoBundle.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumoBundle.getValorBaseUnidade();

					col_4extra=bodyResumoBundle.getExtraValue();
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumoBundle.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumoBundle.getValorBaseUnidade();
						double re=doubleValorMes/110.265;
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumoBundle.getValorBruto();
					col_5valRond=bodyResumoBundle.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumoBundle.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					ItemsBundle[] ArrayItemsBundle=bodyResumoBundle.getItemsBundle();									
					/******Tratar os Itens do Bundle*****/
					ItemsBundle ItemsBundle=null;
					String titulo="";
					String quantidade="";
					String Valor="";
					String val="";
					if(ArrayItemsBundle!=null){
						int t=ArrayItemsBundle.length;
						System.out.println("FR12");
						for(int k=0; k<t; ++k){
							ItemsBundle= new ItemsBundle();
							ItemsBundle=ArrayItemsBundle[k];
							if(k==0){
								//titulo=ItemsBundle.getProdutoTitulo();
								if(ItemsBundle.getTotalEuro()!=null && !ItemsBundle.getTotalEuro().equals("") ){
									titulo=ItemsBundle.getProdutoTitulo() +" - "+ItemsBundle.getTotalEuro();
								}else{
									
									titulo=ItemsBundle.getProdutoTitulo();
								}
								
								quantidade=ItemsBundle.getValorQuantidadeValue();
								Valor=ItemsBundle.getTotalComIva();
								try{
									Valor=FormateData.getVal(Double.parseDouble(Valor));
									}catch(Exception e){
										Valor=ItemsBundle.getTotalComIva();
									}
							}else{
								
								//titulo=titulo+"\n"+ItemsBundle.getProdutoTitulo();
								if(ItemsBundle.getTotalEuro()!=null && !ItemsBundle.getTotalEuro().equals("") ){
									titulo=titulo+" - "+ItemsBundle.getTotalEuro()+"\n"+ItemsBundle.getProdutoTitulo();
								}else{
									titulo=titulo+"\n"+ItemsBundle.getProdutoTitulo();
								}
								
								quantidade=quantidade+"\n"+ItemsBundle.getValorQuantidadeValue();								
								try{
									val=FormateData.getVal(Double.parseDouble(ItemsBundle.getTotalComIva()));
									}catch(Exception e){
										val=ItemsBundle.getTotalComIva();
									}															
								Valor=Valor+"\n"+val;
							}
							
						}
						
					}
					if(!titulo.equals("")){
						titulo=titulo+"\n";
					}
					if(!quantidade.equals("")){
						quantidade=quantidade+"\n";
					}
					if(!Valor.equals("")){
						Valor=Valor+"\n";
					}

					
					/************/
					
					if(!col_1desServico.equals("") && col_1desServico!=null){
						col_1desServico="\n";
					}
					faturaCreditoContainer.setCol_1tituloServico(col_1tituloServico);
					faturaCreditoContainer.setCol_1desServico(col_1desServico);


					faturaCreditoContainer.setCol_1desServicoBundle(titulo);
					faturaCreditoContainer.setCol_2quantidadeBundle(quantidade);
					faturaCreditoContainer.setCol_5tatalBundle(Valor);
					
					faturaCreditoContainer.setCol_1image(imgcol_1image);//
					faturaCreditoContainer.setCol_2quantidade(col_2quantidade);
					//faturaCreditoContainer.setCol_2unidade(col_2unidade);
					faturaCreditoContainer.setCol_3valorBase(col_3valorBase);
					//faturaCreditoContainer.setCol_3moeda(col_3moeda);
					faturaCreditoContainer.setCol_4extra(col_4extra);
					faturaCreditoContainer.setCol_4extraDesc(col_4extraDesc);
					faturaCreditoContainer.setCol_5tatal(col_5tatal);
					//faturaCreditoContainer.setCol_5moeda(col_5moeda);
					faturaCreditoContainer.setCol_5iva(col_5ivaFinal);
					faturaCreditoContainer.setCol_5aux1(col_5aux1);
					faturaCreditoContainer.setCol_5aux2(col_5aux2);
					faturaCreditoContainer.setCol_5aux3(col_5aux3);
					faturaCreditoContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaCreditoContainer.setCol_5ivaDesc(col_5ivaDesc);
					//faturaCreditoContainer.setValorMes(valorMesBodyResumo);
					faturaCreditoContainer.setCol_5valBruto(valorMesFormatado);
					faturaCreditoContainer.setCol_5valRond(footerValorArrendondamento);
					faturaCreditoContainer.setTotal_col3(total_col3);
					faturaCreditoContainer.setTotal_col4(total_col4);
					faturaCreditoContainer.setTotal_col5(footerValorTotal);
					faturaCreditoContainer.setTaxa(taxa +" %");

					faturaCreditoContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaCreditoContainer.setImposto(imposto);
					faturaCreditoContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaCreditoContainer.setCol_5desciva_ultimo("Sem IVA");
					LfaturaCreditoContainer.add(faturaCreditoContainer);
					}
				}
				
			}
			
			
			
				if(LfaturaCreditoContainer.size()!=0)
				{
					FaturaCredito.setFaturaCreditoContainer(LfaturaCreditoContainer);
					ArrayList<FaturaCredito> listFaturaCredito = new ArrayList<FaturaCredito>(); 
					listFaturaCredito.add(FaturaCredito);
					byte[] output=null;
					
					ListaFaturaCreditoGerarPdf listaFaturaCreditoGerarPdf = new ListaFaturaCreditoGerarPdf();
					output=listaFaturaCreditoGerarPdf.GerarPdfListaFaturaCredito(listFaturaCredito);
					
					System.out.println("DEPOIS Gerar Pdf Recibo");
					
					faturaReciboResponse=new FaturaReciboResponse();
					
					faturaReciboResponse.setOutput(output);
					faturaReciboResponse.setValorMes(0);
			
				}
		
		return faturaReciboResponse;
		
		
	}
	
	
	
	
	

	public static  FaturaReciboResponse Proforma(Fatura novafatura){
		
		System.out.println("Antes Gerar Pdf Recibo");

		String col_1tituloServico="";String col_1desServico="";Image col_1image=null;String col_1aux1="";String col_1aux2="";String col_1aux3="";String col_2quantidade="";String col_2unidade="";
		String col_2aux1="";String col_2aux2="";String col_2aux3="";String col_3valorBase="";String col_3moeda="";String col_3aux1="";String col_3aux2="";String col_3aux3="";String col_4extra="";
		String col_4extraDesc="";String col_4moeda="";String col_4aux1="";String col_4aux2="";String col_4aux3="";String col_5tatal="";String col_5moeda="";double col_5iva=0;String col_5aux1="";
		String col_5aux2="";String col_5aux3="";String col_5totalEuro="";String col_5ivaDesc="";String valorMesBodyResumo="";String col_5valBruto="";String col_5valRond="";String total_col3="";
		String total_col4="";String total_col5="";
		String taxa="";String incidencia="";String imposto="";
		String valorMes="";
		String valorMesFormatado="";
		String footerValorTotal="";
		String footerValorTotalIncidencia="";
		String totalEuro="";
		String col_5ivaFinal="";
		String col_5totaliva_ultimo="";
		
		double totalValorBase=0;
		double totalExtra=0;
		double totalTotal=0;
		double percentagem=0;
		double incidenciaresultado=0;
		double impostoresultado=0;
		
		FaturaReciboResponse faturaReciboResponse =null;
		FaturaCredito FaturaCredito = new FaturaCredito();
		List<faturaCreditoContainer> LfaturaCreditoContainer = new ArrayList<faturaCreditoContainer>();
		if(novafatura != null){

			valorMes=novafatura.getValorMes();
			String rodape = "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde";
			FaturaCredito.setBai(novafatura.getBai());
			FaturaCredito.setBca(novafatura.getBca());
			FaturaCredito.setBcn(novafatura.getCbn());
			FaturaCredito.setBi(novafatura.getBi());
			FaturaCredito.setCecv(novafatura.getCecv());
			FaturaCredito.setData(novafatura.getDataProcessamento());
			FaturaCredito.setMoeda("CVE");
			FaturaCredito.setMorada(novafatura.getMorada());
			FaturaCredito.setNif(novafatura.getNif());
			FaturaCredito.setNomeCliente(novafatura.getNomeCliente());
			FaturaCredito.setNumeroCliente(novafatura.getNumCliente());
			FaturaCredito.setNumeroConta(novafatura.getNumContaCliente());
			FaturaCredito.setRodaPe(rodape);
			FaturaCredito.setTipoDoc("Pro Forma");
			FaturaCredito.setVenda("");
			FaturaCredito.setNumeroDoc(novafatura.getNumFatura());
			String recumendacao="Os nossos equipamentos têm uma garantia de 12 meses a contar da data de compra. Cobre os efeitos de fabrico e de funcionamento considerando as condições normais de uso, desde que não tenham sofridos reparos por pessoas não autorizadas. (lei nº 88/V/98, de 31de Dezembro regime jurídico de proteção e defesa dos";
			FaturaCredito.setRecumendacao(recumendacao);
			FaturaCredito.setRecumendacao1("Em caso de reclamação deverá apresentar o recibo de compra juntamente com a caixa do equipamento e os acessórios.");

			System.out.println("Assistente ::::: ---->>>>Proforma "+novafatura.getNominhoCliente());
			
			FaturaCredito.setAssistente("");
			FaturaCredito.setDatahoravenda(FormateData.DataNowFat());
			
			if(!novafatura.getNominhoCliente().equals("0")){
				FaturaCredito.setAssistente(novafatura.getNominhoCliente());
			}
						
			//FaturaCredito.setEntidade(novafatura.getEntidade());
			//FaturaCredito.setReferencia(novafatura.getReferencia());
			FaturaCredito.setEntidade("");
			FaturaCredito.setReferencia("");
			FaturaCredito.setBanco(getBank());
			FaturaCredito.setBancovalue(getBankValue());
			//FaturaCredito.setDataVencimento(getDateLimitPagamento(novafatura.getDataVencimento()));
			FaturaCredito.setDataVencimento("Valor Total do Documento ");
			
			
			BodyResumo [] ArraybodyResumoFatura=null;
			BodyResumo bodyResumo = new BodyResumo();
			BodyResumoBundle [] ArrayBodyResumoBundle=null;
			BodyResumoBundle bodyResumoBundle=new BodyResumoBundle();
//			MeioPagamento [] ArrayMeioPagamento=novafatura.getMeioPagamento();
			
			System.out.println("FR2");
			ArrayBodyResumoBundle=novafatura.getBodyResumoBundle();
			
			//Get BodyResumo []
			ArraybodyResumoFatura=novafatura.getBodyResumo();
		
			
			String valorBaseValue="";
			String extraValue="";
			String totalComIva="";
			double doubleValorMes=0;
			String footerValorArrendondamento="0";
			faturaCreditoContainer faturaCreditoContainer = null;
			
		
			if(ArrayBodyResumoBundle!=null)
			{
				
				int tma=ArrayBodyResumoBundle.length;				
				for(int x=0;x<tma;x++){
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					valorBaseValue=bodyResumoBundle.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumoBundle.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumoBundle.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumoBundle.getTaxa();
				
				}
				
			}
			
			if(ArraybodyResumoFatura!=null)
			{
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;
			
				
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					valorBaseValue=bodyResumo.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumo.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumo.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumo.getTaxa();
				
				}
			}
			
			if(ArraybodyResumoFatura!=null || ArrayBodyResumoBundle!=null){
				
				try{
				 doubleValorMes=Double.parseDouble(valorMes);
				 valorMesFormatado=FormateData.getVal(doubleValorMes);
		         footerValorArrendondamento="-0,"+valorMesFormatado.substring(valorMesFormatado.length()-2, valorMesFormatado.length());
		        footerValorTotal=valorMesFormatado.substring(0, valorMesFormatado.length()-2)+"00";
		        col_5totaliva_ultimo="("+FormateData.getVal(doubleValorMes/1.15)+")";
				incidencia=valorMes;
				incidenciaresultado=Double.parseDouble(incidencia);
				incidenciaresultado=doubleValorMes/1.15;//Double.parseDouble(incidencia);
				int valExtenso=(int)doubleValorMes;
				String extensoDesc=FormateData.getExtensao(valExtenso);
				FaturaCredito.setExtenso(extensoDesc);
				FaturaCredito.setMantante(valorMesFormatado);
				FaturaCredito.setValorMes(valorMesFormatado);
				percentagem=(Float.parseFloat(taxa)/100)+1;
				impostoresultado=doubleValorMes-incidenciaresultado;//(incidenciaresultado/percentagem);
				imposto=FormateData.getVal(impostoresultado);
				footerValorTotalIncidencia=FormateData.getVal(doubleValorMes/1.15);
				}catch(Exception e){
					e.printStackTrace();
				}
			
			}

			
			if(ArraybodyResumoFatura!=null)
			{
				
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;	

				/********************Item Produto Simples*************************/
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					faturaCreditoContainer = new faturaCreditoContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumo.getProdutoTitulo();
					col_1desServico="";
//					if(bodyResumo.getProdutoDescricao()!=null){
//						col_1desServico=bodyResumo.getProdutoDescricao();
//					}

					if(bodyResumo.getProdutoDescricao()!=null && !bodyResumo.getProdutoDescricao().equals("")){
						col_1desServico=bodyResumo.getProdutoDescricao();
					}else{
						//Valor do Numero que recebeu Serviço
						if(bodyResumo.getTotalEuro()!=null){
							col_1desServico=bodyResumo.getTotalEuro();
						}
						
					}
					
					 imgcol_1image=GetByteFromFile.generate(bodyResumo.getProdutoImagem());

					col_2quantidade=bodyResumo.getValorQuantidadeValue();
					col_2unidade=bodyResumo.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumo.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumo.getValorBaseUnidade();

					col_4extra=bodyResumo.getExtraValue();
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumo.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumo.getValorBaseUnidade();
						double re=doubleValorMes/110.265;
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumo.getValorBruto();
					col_5valRond=bodyResumo.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumo.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					
					faturaCreditoContainer.setCol_1desServicoBundle("");
					faturaCreditoContainer.setCol_1tituloServico(col_1tituloServico);
					faturaCreditoContainer.setCol_1desServico(col_1desServico);

					faturaCreditoContainer.setCol_1image(imgcol_1image);//
					faturaCreditoContainer.setCol_2quantidade(col_2quantidade);
					//faturaCreditoContainer.setCol_2unidade(col_2unidade);
					faturaCreditoContainer.setCol_3valorBase(col_3valorBase);
					//faturaCreditoContainer.setCol_3moeda(col_3moeda);
					faturaCreditoContainer.setCol_4extra(col_4extra);
					faturaCreditoContainer.setCol_4extraDesc(col_4extraDesc);
					faturaCreditoContainer.setCol_5tatal(col_5tatal);
					//faturaCreditoContainer.setCol_5moeda(col_5moeda);
					faturaCreditoContainer.setCol_5iva(col_5ivaFinal);
					faturaCreditoContainer.setCol_5aux1(col_5aux1);
					faturaCreditoContainer.setCol_5aux2(col_5aux2);
					faturaCreditoContainer.setCol_5aux3(col_5aux3);
					faturaCreditoContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaCreditoContainer.setCol_5ivaDesc(col_5ivaDesc);

					faturaCreditoContainer.setCol_5valBruto(valorMesFormatado);
					faturaCreditoContainer.setCol_5valRond(footerValorArrendondamento);
					faturaCreditoContainer.setTotal_col3(total_col3);
					faturaCreditoContainer.setTotal_col4(total_col4);
					faturaCreditoContainer.setTotal_col5(footerValorTotal);
					faturaCreditoContainer.setTaxa(taxa +" %");

					faturaCreditoContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaCreditoContainer.setImposto(imposto);
					faturaCreditoContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaCreditoContainer.setCol_5desciva_ultimo("Sem IVA");
					
					faturaCreditoContainer.setCol_2quantidadeBundle("");
					faturaCreditoContainer.setCol_5tatalBundle("");
					
					LfaturaCreditoContainer.add(faturaCreditoContainer);
				
				}
				
				
				

			}
				
				
				/*****************Items Bundle*****************/
				if(ArrayBodyResumoBundle!=null)
				{
					
					int tma=ArrayBodyResumoBundle.length;
					if(tma==1){
						bodyResumoBundle=ArrayBodyResumoBundle[0];
						if(bodyResumoBundle.getProdutoTitulo().equals("") && bodyResumoBundle.getValorBaseValue().equals("0") ){
							tma=0;
						}
					}
					
					
					for(int x=0;x<tma;x++)
					{
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					faturaCreditoContainer = new faturaCreditoContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumoBundle.getProdutoTitulo();

					col_1desServico=bodyResumoBundle.getProdutoDescricao();

					
					 imgcol_1image=GetByteFromFile.generate(bodyResumoBundle.getProdutoImagem());

					col_2quantidade=bodyResumoBundle.getValorQuantidadeValue();
					col_2unidade=bodyResumoBundle.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumoBundle.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumoBundle.getValorBaseUnidade();

					col_4extra=bodyResumoBundle.getExtraValue();
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumoBundle.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumoBundle.getValorBaseUnidade();
						double re=doubleValorMes/110.265;
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumoBundle.getValorBruto();
					col_5valRond=bodyResumoBundle.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumoBundle.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					ItemsBundle[] ArrayItemsBundle=bodyResumoBundle.getItemsBundle();									
					/******Tratar os Itens do Bundle*****/
					ItemsBundle ItemsBundle=null;
					String titulo="";
					String quantidade="";
					String Valor="";
					String val="";
					if(ArrayItemsBundle!=null){
						int t=ArrayItemsBundle.length;
						System.out.println("FR12");
						for(int k=0; k<t; ++k){
							ItemsBundle= new ItemsBundle();
							ItemsBundle=ArrayItemsBundle[k];
							if(k==0){
								//titulo=ItemsBundle.getProdutoTitulo();
								if(ItemsBundle.getTotalEuro()!=null && !ItemsBundle.getTotalEuro().equals("") ){
									titulo=ItemsBundle.getProdutoTitulo() +" - "+ItemsBundle.getTotalEuro();
								}else{
									
									titulo=ItemsBundle.getProdutoTitulo();
								}
								
								quantidade=ItemsBundle.getValorQuantidadeValue();
								Valor=ItemsBundle.getTotalComIva();
								try{
									Valor=FormateData.getVal(Double.parseDouble(Valor));
									}catch(Exception e){
										Valor=ItemsBundle.getTotalComIva();
									}
							}else{
								
								//titulo=titulo+"\n"+ItemsBundle.getProdutoTitulo();
								if(ItemsBundle.getTotalEuro()!=null && !ItemsBundle.getTotalEuro().equals("") ){
									titulo=titulo+" - "+ItemsBundle.getTotalEuro()+"\n"+ItemsBundle.getProdutoTitulo();
								}else{
									titulo=titulo+"\n"+ItemsBundle.getProdutoTitulo();
								}
								
								quantidade=quantidade+"\n"+ItemsBundle.getValorQuantidadeValue();								
								try{
									val=FormateData.getVal(Double.parseDouble(ItemsBundle.getTotalComIva()));
									}catch(Exception e){
										val=ItemsBundle.getTotalComIva();
									}															
								Valor=Valor+"\n"+val;
							}
							
						}
						
					}
					if(!titulo.equals("")){
						titulo=titulo+"\n";
					}
					if(!quantidade.equals("")){
						quantidade=quantidade+"\n";
					}
					if(!Valor.equals("")){
						Valor=Valor+"\n";
					}

					
					/************/
					
					if(!col_1desServico.equals("") && col_1desServico!=null){
						col_1desServico="\n";
					}
					faturaCreditoContainer.setCol_1tituloServico(col_1tituloServico);
					faturaCreditoContainer.setCol_1desServico(col_1desServico);


					faturaCreditoContainer.setCol_1desServicoBundle(titulo);
					faturaCreditoContainer.setCol_2quantidadeBundle(quantidade);
					faturaCreditoContainer.setCol_5tatalBundle(Valor);
					
					faturaCreditoContainer.setCol_1image(imgcol_1image);//
					faturaCreditoContainer.setCol_2quantidade(col_2quantidade);
					//faturaCreditoContainer.setCol_2unidade(col_2unidade);
					faturaCreditoContainer.setCol_3valorBase(col_3valorBase);
					//faturaCreditoContainer.setCol_3moeda(col_3moeda);
					faturaCreditoContainer.setCol_4extra(col_4extra);
					faturaCreditoContainer.setCol_4extraDesc(col_4extraDesc);
					faturaCreditoContainer.setCol_5tatal(col_5tatal);
					//faturaCreditoContainer.setCol_5moeda(col_5moeda);
					faturaCreditoContainer.setCol_5iva(col_5ivaFinal);
					faturaCreditoContainer.setCol_5aux1(col_5aux1);
					faturaCreditoContainer.setCol_5aux2(col_5aux2);
					faturaCreditoContainer.setCol_5aux3(col_5aux3);
					faturaCreditoContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaCreditoContainer.setCol_5ivaDesc(col_5ivaDesc);
					//faturaCreditoContainer.setValorMes(valorMesBodyResumo);
					faturaCreditoContainer.setCol_5valBruto(valorMesFormatado);
					faturaCreditoContainer.setCol_5valRond(footerValorArrendondamento);
					faturaCreditoContainer.setTotal_col3(total_col3);
					faturaCreditoContainer.setTotal_col4(total_col4);
					faturaCreditoContainer.setTotal_col5(footerValorTotal);
					faturaCreditoContainer.setTaxa(taxa +" %");

					faturaCreditoContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaCreditoContainer.setImposto(imposto);
					faturaCreditoContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaCreditoContainer.setCol_5desciva_ultimo("Sem IVA");
					LfaturaCreditoContainer.add(faturaCreditoContainer);
					}
				}
				
			}
			
			
			
				if(LfaturaCreditoContainer.size()!=0)
				{
					FaturaCredito.setFaturaCreditoContainer(LfaturaCreditoContainer);
					ArrayList<FaturaCredito> listFaturaCredito = new ArrayList<FaturaCredito>(); 
					listFaturaCredito.add(FaturaCredito);
					byte[] output=null;
					
					ListaFaturaCreditoGerarPdf listaFaturaCreditoGerarPdf = new ListaFaturaCreditoGerarPdf();
					output=listaFaturaCreditoGerarPdf.GerarPdfListaFaturaCredito(listFaturaCredito);
					
					System.out.println("DEPOIS Gerar Pdf Recibo");
					
					faturaReciboResponse=new FaturaReciboResponse();
					
					faturaReciboResponse.setOutput(output);
					faturaReciboResponse.setValorMes(0);
			
				}
		
		return faturaReciboResponse;
		
		
	}
	
	public static  FaturaReciboResponse DevolucaoService(Fatura novafatura){
		FaturaReciboResponse faturaReciboResponse =null;

		//BodyResumo
		String col_1tituloServico="";String col_1desServico="";Image col_1image=null;String col_1aux1="";String col_1aux2="";String col_1aux3="";String col_2quantidade="";String col_2unidade="";
		String col_2aux1="";String col_2aux2="";String col_2aux3="";String col_3valorBase="";String col_3moeda="";String col_3aux1="";String col_3aux2="";String col_3aux3="";String col_4extra="";
		String col_4extraDesc="";String col_4moeda="";String col_4aux1="";String col_4aux2="";String col_4aux3="";String col_5tatal="";String col_5moeda="";double col_5iva=0;String col_5aux1="";
		String col_5aux2="";String col_5aux3="";String col_5totalEuro="";String col_5ivaDesc="";String valorMesBodyResumo="";String col_5valBruto="";String col_5valRond="";String total_col3="";
		String total_col4="";String total_col5="";
		String taxa="";String incidencia="";String imposto="";
		String valorMes="";
		String valorMesFormatado="";
		String footerValorTotal="";
		String footerValorTotalIncidencia="";
		String totalEuro="";
		String col_5ivaFinal="";
		String col_5totaliva_ultimo="";
		
		double totalValorBase=0;
		double totalExtra=0;
		double totalTotal=0;
		double percentagem=0;
		double incidenciaresultado=0;
		double impostoresultado=0;
		
		
		Devolucao FaturaRecibo = new Devolucao();
		List<devolucaoContainer> LfaturaReciboContainer = new ArrayList<devolucaoContainer>();
		if(novafatura != null){
			System.out.println("FR1");
			valorMes=novafatura.getValorMes();
			String rodape = "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde";
			FaturaRecibo.setBai(novafatura.getBai());
			FaturaRecibo.setBca(novafatura.getBca());
			FaturaRecibo.setBcn(novafatura.getCbn());
			FaturaRecibo.setBi(novafatura.getBi());
			FaturaRecibo.setCecv(novafatura.getCecv());
			FaturaRecibo.setData(novafatura.getDataProcessamento());
			FaturaRecibo.setMoeda("CVE");
			FaturaRecibo.setMorada(novafatura.getMorada());
			FaturaRecibo.setNif(novafatura.getNif());
			FaturaRecibo.setNomeCliente(novafatura.getNomeCliente());
			FaturaRecibo.setNumeroCliente(novafatura.getNumCliente());
			FaturaRecibo.setNumeroConta(novafatura.getNumContaCliente());
			FaturaRecibo.setRodaPe(rodape);
			FaturaRecibo.setTipoDoc("VOUCHER");
			FaturaRecibo.setVenda("");
			FaturaRecibo.setNumeroDoc(novafatura.getNumFatura());
			String recumendacao="Os nossos equipamentos têm uma garantia de 12 meses a contar da data de compra. Cobre os efeitos de fabrico e de funcionamento considerando as condições normais de uso, desde que não tenham sofridos reparos por pessoas não autorizadas. (lei nº 88/V/98, de 31de Dezembro regime jurídico de proteção e defesa dos";
			FaturaRecibo.setRecumendacao(recumendacao);
			FaturaRecibo.setRecumendacao1("Em caso de reclamação deverá apresentar o recibo de compra juntamente com a caixa do equipamento e os acessórios.");

			System.out.println("Assistente ::::: ---->>>>Devol--------"+novafatura.getRodape()+"------------");

			FaturaRecibo.setAssistente("");
			FaturaRecibo.setDatahoravenda(FormateData.DataNowFat());
			
			if(!novafatura.getRodape().equals("0")){
				FaturaRecibo.setAssistente(novafatura.getRodape());
			}
			
			BodyResumo [] ArraybodyResumoFatura=null;
			BodyResumo bodyResumo = new BodyResumo();
			BodyResumoBundle [] ArrayBodyResumoBundle=null;
			BodyResumoBundle bodyResumoBundle=new BodyResumoBundle();
			MeioPagamento [] ArrayMeioPagamento=novafatura.getMeioPagamento();
			
			System.out.println("RE");
			ArrayBodyResumoBundle=novafatura.getBodyResumoBundle();
			
			//Get BodyResumo []
			ArraybodyResumoFatura=novafatura.getBodyResumo();
		
			
			String valorBaseValue="";
			String extraValue="";
			String totalComIva="";
			double doubleValorMes=0;
			String footerValorArrendondamento="0";
			devolucaoContainer faturaReciboContainer = null;
			
			
			if(ArrayMeioPagamento!=null){
				int tmeios=ArrayMeioPagamento.length;
				MeioPagamento  MeioPagamento = null;
				
				String fpagamento="";
				String valorpagamento="";
				for(int j=0; j<tmeios; ++j){
					MeioPagamento= new MeioPagamento();
					MeioPagamento=ArrayMeioPagamento[j];
					if(j==0){
						fpagamento=MeioPagamento.getDESCRIPTION();
						valorpagamento=MeioPagamento.getAmount();
					}else{
						fpagamento=fpagamento+"\n"+MeioPagamento.getDESCRIPTION();
						valorpagamento=valorpagamento+"\n"+MeioPagamento.getAmount();
					}
					
					
				}
				//FaturaRecibo.setFpagamento(fpagamento);-
				FaturaRecibo.setValorpagamento(valorpagamento);
				
			}
			FaturaRecibo.setFpagamento(novafatura.getNomeSubConta());
			if(ArrayBodyResumoBundle!=null)
			{
				
				int tma=ArrayBodyResumoBundle.length;				
				for(int x=0;x<tma;x++){
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					valorBaseValue=bodyResumoBundle.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumoBundle.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumoBundle.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumoBundle.getTaxa();
				
				}
				
			}
			
			if(ArraybodyResumoFatura!=null)
			{
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;
			
				
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					valorBaseValue=bodyResumo.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumo.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumo.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumo.getTaxa();
				
				}
			}
			
			if(ArraybodyResumoFatura!=null || ArrayBodyResumoBundle!=null){
				
				try{
				 doubleValorMes=Double.parseDouble(valorMes);
				 valorMesFormatado=FormateData.getVal(doubleValorMes);
		         footerValorArrendondamento="-0,"+valorMesFormatado.substring(valorMesFormatado.length()-2, valorMesFormatado.length());
		        footerValorTotal=valorMesFormatado.substring(0, valorMesFormatado.length()-2)+"00";
		        col_5totaliva_ultimo="("+FormateData.getVal(doubleValorMes/1.15)+")";
				incidencia=valorMes;
				incidenciaresultado=Double.parseDouble(incidencia);
				incidenciaresultado=doubleValorMes/1.15;//Double.parseDouble(incidencia);
				int valExtenso=(int)doubleValorMes;
				String extensoDesc=FormateData.getExtensao(valExtenso);
				FaturaRecibo.setExtenso(extensoDesc);
				
				percentagem=(Float.parseFloat(taxa)/100)+1;
				impostoresultado=incidenciaresultado-(incidenciaresultado/percentagem);
				imposto=FormateData.getVal(impostoresultado);
				footerValorTotalIncidencia=FormateData.getVal(doubleValorMes/1.15);
				}catch(Exception e){
					e.printStackTrace();
				}
			
			}

			
			if(ArraybodyResumoFatura!=null)
			{
				
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;	

				/********************Item Produto Simples*************************/
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					faturaReciboContainer = new devolucaoContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumo.getProdutoTitulo();
					col_1desServico="";
					if(bodyResumo.getProdutoDescricao()!=null){
						col_1desServico=bodyResumo.getProdutoDescricao();
					}
					
					 imgcol_1image=GetByteFromFile.generate(bodyResumo.getProdutoImagem());

					col_2quantidade=bodyResumo.getValorQuantidadeValue();
					col_2unidade=bodyResumo.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumo.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumo.getValorBaseUnidade();

					col_4extra=bodyResumo.getExtraValue();
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumo.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumo.getValorBaseUnidade();
						double re=doubleValorMes/110.265;
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumo.getValorBruto();
					col_5valRond=bodyResumo.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumo.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					
					faturaReciboContainer.setCol_1desServicoBundle("");
					faturaReciboContainer.setCol_1tituloServico(col_1tituloServico);
					faturaReciboContainer.setCol_1desServico(col_1desServico);

					faturaReciboContainer.setCol_1image(imgcol_1image);//
					faturaReciboContainer.setCol_2quantidade(col_2quantidade);
					//faturaReciboContainer.setCol_2unidade(col_2unidade);
					faturaReciboContainer.setCol_3valorBase(col_3valorBase);
					//faturaReciboContainer.setCol_3moeda(col_3moeda);
					faturaReciboContainer.setCol_4extra(col_4extra);
					faturaReciboContainer.setCol_4extraDesc(col_4extraDesc);
					faturaReciboContainer.setCol_5tatal(col_5tatal);
					//faturaReciboContainer.setCol_5moeda(col_5moeda);
					faturaReciboContainer.setCol_5iva(col_5ivaFinal);
					faturaReciboContainer.setCol_5aux1(col_5aux1);
					faturaReciboContainer.setCol_5aux2(col_5aux2);
					faturaReciboContainer.setCol_5aux3(col_5aux3);
					faturaReciboContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaReciboContainer.setCol_5ivaDesc(col_5ivaDesc);

					faturaReciboContainer.setCol_5valBruto(valorMesFormatado);
					faturaReciboContainer.setCol_5valRond(footerValorArrendondamento);
					faturaReciboContainer.setTotal_col3(total_col3);
					faturaReciboContainer.setTotal_col4(total_col4);
					faturaReciboContainer.setTotal_col5(footerValorTotal);
					faturaReciboContainer.setTaxa(taxa +" %");

					faturaReciboContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaReciboContainer.setImposto(imposto);
					faturaReciboContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaReciboContainer.setCol_5desciva_ultimo("Sem IVA");
					
					faturaReciboContainer.setCol_2quantidadeBundle("");
					faturaReciboContainer.setCol_5tatalBundle("");
					
					LfaturaReciboContainer.add(faturaReciboContainer);
				
				}
				
				
				

			}
				
				
				/*****************Items Bundle*****************/
				if(ArrayBodyResumoBundle!=null)
				{
					
					int tma=ArrayBodyResumoBundle.length;
					if(tma==1){
						bodyResumoBundle=ArrayBodyResumoBundle[0];
						if(bodyResumoBundle.getProdutoTitulo().equals("") && bodyResumoBundle.getValorBaseValue().equals("0") ){
							tma=0;
						}
					}
					
					
					for(int x=0;x<tma;x++)
					{
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					faturaReciboContainer = new devolucaoContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumoBundle.getProdutoTitulo();

					col_1desServico=bodyResumoBundle.getProdutoDescricao();

					
					 imgcol_1image=GetByteFromFile.generate(bodyResumoBundle.getProdutoImagem());

					col_2quantidade=bodyResumoBundle.getValorQuantidadeValue();
					col_2unidade=bodyResumoBundle.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumoBundle.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumoBundle.getValorBaseUnidade();

					col_4extra=bodyResumoBundle.getExtraValue();
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumoBundle.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumoBundle.getValorBaseUnidade();
						double re=doubleValorMes/110.265;
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumoBundle.getValorBruto();
					col_5valRond=bodyResumoBundle.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumoBundle.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					ItemsBundle[] ArrayItemsBundle=bodyResumoBundle.getItemsBundle();									
					/******Tratar os Itens do Bundle*****/
					ItemsBundle ItemsBundle=null;
					String titulo="";
					String quantidade="";
					String Valor="";
					String val="";
					if(ArrayItemsBundle!=null){
						int t=ArrayItemsBundle.length;
						System.out.println("FR12");
						for(int k=0; k<t; ++k){
							ItemsBundle= new ItemsBundle();
							ItemsBundle=ArrayItemsBundle[k];
							if(k==0){
								titulo=ItemsBundle.getProdutoTitulo();
								quantidade=ItemsBundle.getValorQuantidadeValue();
								Valor=ItemsBundle.getTotalComIva();
								try{
									Valor=FormateData.getVal(Double.parseDouble(Valor));
									}catch(Exception e){
										Valor=ItemsBundle.getTotalComIva();
									}
							}else{
								
								titulo=titulo+"\n"+ItemsBundle.getProdutoTitulo();
								quantidade=quantidade+"\n"+ItemsBundle.getValorQuantidadeValue();								
								try{
									val=FormateData.getVal(Double.parseDouble(ItemsBundle.getTotalComIva()));
									}catch(Exception e){
										val=ItemsBundle.getTotalComIva();
									}															
								Valor=Valor+"\n"+val;
							}
							
						}
						
					}
					if(!titulo.equals("")){
						titulo=titulo+"\n";
					}
					if(!quantidade.equals("")){
						quantidade=quantidade+"\n";
					}
					if(!Valor.equals("")){
						Valor=Valor+"\n";
					}

					
					/************/
					
					if(!col_1desServico.equals("") && col_1desServico!=null){
						col_1desServico="\n";
					}
					faturaReciboContainer.setCol_1tituloServico(col_1tituloServico);
					faturaReciboContainer.setCol_1desServico(col_1desServico);


					faturaReciboContainer.setCol_1desServicoBundle(titulo);
					faturaReciboContainer.setCol_2quantidadeBundle(quantidade);
					faturaReciboContainer.setCol_5tatalBundle(Valor);
					
					faturaReciboContainer.setCol_1image(imgcol_1image);//
					faturaReciboContainer.setCol_2quantidade(col_2quantidade);
					//faturaReciboContainer.setCol_2unidade(col_2unidade);
					faturaReciboContainer.setCol_3valorBase(col_3valorBase);
					//faturaReciboContainer.setCol_3moeda(col_3moeda);
					faturaReciboContainer.setCol_4extra(col_4extra);
					faturaReciboContainer.setCol_4extraDesc(col_4extraDesc);
					faturaReciboContainer.setCol_5tatal(col_5tatal);
					//faturaReciboContainer.setCol_5moeda(col_5moeda);
					faturaReciboContainer.setCol_5iva(col_5ivaFinal);
					faturaReciboContainer.setCol_5aux1(col_5aux1);
					faturaReciboContainer.setCol_5aux2(col_5aux2);
					faturaReciboContainer.setCol_5aux3(col_5aux3);
					faturaReciboContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaReciboContainer.setCol_5ivaDesc(col_5ivaDesc);
					//faturaReciboContainer.setValorMes(valorMesBodyResumo);
					faturaReciboContainer.setCol_5valBruto(valorMesFormatado);
					faturaReciboContainer.setCol_5valRond(footerValorArrendondamento);
					faturaReciboContainer.setTotal_col3(total_col3);
					faturaReciboContainer.setTotal_col4(total_col4);
					faturaReciboContainer.setTotal_col5(footerValorTotal);
					faturaReciboContainer.setTaxa(taxa +" %");

					faturaReciboContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaReciboContainer.setImposto(imposto);
					faturaReciboContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaReciboContainer.setCol_5desciva_ultimo("Sem IVA");
					LfaturaReciboContainer.add(faturaReciboContainer);
					}
				}
				
			}
			
			
			
				if(LfaturaReciboContainer.size()!=0)
				{
					FaturaRecibo.setDevolucaoContainer(LfaturaReciboContainer);
					ArrayList<Devolucao> listFaturaRecibo = new ArrayList<Devolucao>(); 
					listFaturaRecibo.add(FaturaRecibo);
					byte[] output=null;
					
					
					
					ListaDevolucaoGerarPdf listaDevolucaoGerarPdf = new ListaDevolucaoGerarPdf();
					output=listaDevolucaoGerarPdf.GerarPdfListaDevolucao(listFaturaRecibo);					
					System.out.println("DEPOIS Gerar Pdf Recibo Devolucao");
					
					faturaReciboResponse=new FaturaReciboResponse();
					
					faturaReciboResponse.setOutput(output);
					faturaReciboResponse.setValorMes(0);
			
				}
		
		return faturaReciboResponse;
	}
	
	
	public static  FaturaReciboResponse OfertaService(Fatura novafatura){

		FaturaReciboResponse faturaReciboResponse =null;

		//BodyResumo
		String col_1tituloServico="";String col_1desServico="";Image col_1image=null;String col_1aux1="";String col_1aux2="";String col_1aux3="";String col_2quantidade="";String col_2unidade="";
		String col_2aux1="";String col_2aux2="";String col_2aux3="";String col_3valorBase="";String col_3moeda="";String col_3aux1="";String col_3aux2="";String col_3aux3="";String col_4extra="";
		String col_4extraDesc="";String col_4moeda="";String col_4aux1="";String col_4aux2="";String col_4aux3="";String col_5tatal="";String col_5moeda="";double col_5iva=0;String col_5aux1="";
		String col_5aux2="";String col_5aux3="";String col_5totalEuro="";String col_5ivaDesc="";String valorMesBodyResumo="";String col_5valBruto="";String col_5valRond="";String total_col3="";
		String total_col4="";String total_col5="";
		String taxa="";String incidencia="";String imposto="";
		String valorMes="";
		String valorMesFormatado="";
		String footerValorTotal="";
		String footerValorTotalIncidencia="";
		String totalEuro="";
		String col_5ivaFinal="";
		String col_5totaliva_ultimo="";
		
		double totalValorBase=0;
		double totalExtra=0;
		double totalTotal=0;
		double percentagem=0;
		double incidenciaresultado=0;
		double impostoresultado=0;
		
		String caratervaiu="http://ucc_v2.tmais.cv";
		Oferta FaturaRecibo = new Oferta();
		List<ofertaContainer> LfaturaReciboContainer = new ArrayList<ofertaContainer>();
		if(novafatura != null){
			System.out.println("FR1");
			valorMes=novafatura.getValorMes();
			String rodape = "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde";
			FaturaRecibo.setBai(novafatura.getBai());
			FaturaRecibo.setBca(novafatura.getBca());
			FaturaRecibo.setBcn(novafatura.getCbn());
			FaturaRecibo.setBi(novafatura.getBi());
			FaturaRecibo.setCecv(novafatura.getCecv());
			FaturaRecibo.setData(novafatura.getDataProcessamento());
			FaturaRecibo.setMoeda("CVE");
			FaturaRecibo.setMorada(novafatura.getMorada());
			String nif2=novafatura.getNif();
			if(nif2.contains(caratervaiu)){
				nif2="";
			}
			String nome2=novafatura.getNomeCliente();
			if(nome2.contains(caratervaiu)){
				nome2="";
			}
			FaturaRecibo.setNif(nif2);
			FaturaRecibo.setNomeCliente(nome2);
			FaturaRecibo.setNumeroCliente(novafatura.getNumCliente());
			FaturaRecibo.setNumeroConta(novafatura.getNumContaCliente());
			FaturaRecibo.setRodaPe(rodape);
			FaturaRecibo.setTipoDoc("OFERTA");
			FaturaRecibo.setVenda("");
			FaturaRecibo.setNumeroDoc(novafatura.getNumFatura());
			String recumendacao="Os nossos equipamentos têm uma garantia de 12 meses a contar da data de compra. Cobre os efeitos de fabrico e de funcionamento considerando as condições normais de uso, desde que não tenham sofridos reparos por pessoas não autorizadas. (lei nº 88/V/98, de 31de Dezembro regime jurídico de proteção e defesa dos";
			FaturaRecibo.setRecumendacao(recumendacao);
			FaturaRecibo.setRecumendacao1("Em caso de reclamação deverá apresentar o recibo de compra juntamente com a caixa do equipamento e os acessórios.");

			
//			String username="Unitel";//novafatura.getNominhoCliente();
//			String datavenda="2019-10-18";
			System.out.println("Assistente ::::: ---->>>>Oferta "+novafatura.getRodape());
			FaturaRecibo.setAssistente("");
			FaturaRecibo.setDatahoravenda(FormateData.DataNowFat());
			
			if(!novafatura.getRodape().equals("0")){
				FaturaRecibo.setAssistente(novafatura.getRodape());
			}
			
			BodyResumo [] ArraybodyResumoFatura=null;
			BodyResumo bodyResumo = new BodyResumo();
			BodyResumoBundle [] ArrayBodyResumoBundle=null;
			BodyResumoBundle bodyResumoBundle=new BodyResumoBundle();
			MeioPagamento [] ArrayMeioPagamento=novafatura.getMeioPagamento();
			
			System.out.println("YBFD");
			ArrayBodyResumoBundle=novafatura.getBodyResumoBundle();
			
			//Get BodyResumo []
			ArraybodyResumoFatura=novafatura.getBodyResumo();
		
			
			String valorBaseValue="";
			String extraValue="";
			String totalComIva="";
			double doubleValorMes=0;
			String footerValorArrendondamento="0";
			ofertaContainer faturaReciboContainer = null;
			
			

			FaturaRecibo.setFpagamento(novafatura.getNomeSubConta());
			if(ArrayBodyResumoBundle!=null)
			{
				
				int tma=ArrayBodyResumoBundle.length;				
				for(int x=0;x<tma;x++){
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					valorBaseValue=bodyResumoBundle.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumoBundle.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumoBundle.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumoBundle.getTaxa();
				
				}
				
			}
			
			if(ArraybodyResumoFatura!=null)
			{
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;
			
				
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					valorBaseValue=bodyResumo.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumo.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumo.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumo.getTaxa();
				
				}
			}
			
			if(ArraybodyResumoFatura!=null || ArrayBodyResumoBundle!=null){
				
				try{
				 doubleValorMes=Double.parseDouble(valorMes);
				 valorMesFormatado=FormateData.getVal(doubleValorMes);
		         footerValorArrendondamento="-0,"+valorMesFormatado.substring(valorMesFormatado.length()-2, valorMesFormatado.length());
		        footerValorTotal=valorMesFormatado.substring(0, valorMesFormatado.length()-2)+"00";
		        col_5totaliva_ultimo="("+FormateData.getVal(doubleValorMes/1.15)+")";
				incidencia=valorMes;
				incidenciaresultado=Double.parseDouble(incidencia);
				incidenciaresultado=doubleValorMes/1.15;//Double.parseDouble(incidencia);
				int valExtenso=(int)doubleValorMes;
				String extensoDesc=FormateData.getExtensao(valExtenso);
				FaturaRecibo.setExtenso(extensoDesc);
				
				percentagem=(Float.parseFloat(taxa)/100)+1;
				impostoresultado=incidenciaresultado-(incidenciaresultado/percentagem);
				imposto=FormateData.getVal(impostoresultado);
				footerValorTotalIncidencia=FormateData.getVal(doubleValorMes/1.15);
				}catch(Exception e){
					e.printStackTrace();
				}
			
			}

			
			if(ArraybodyResumoFatura!=null)
			{
				
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;	

				/********************Item Produto Simples*************************/
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					faturaReciboContainer = new ofertaContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumo.getProdutoTitulo();
					col_1desServico="";
					if(bodyResumo.getProdutoDescricao()!=null){
						col_1desServico=bodyResumo.getProdutoDescricao();
					}
					
					 imgcol_1image=GetByteFromFile.generate(bodyResumo.getProdutoImagem());

					col_2quantidade=bodyResumo.getValorQuantidadeValue();
					col_2unidade=bodyResumo.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumo.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumo.getValorBaseUnidade();

					col_4extra=bodyResumo.getExtraValue();//---
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumo.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;//---
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumo.getValorBaseUnidade();
						double re=doubleValorMes/110.265;//---
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumo.getValorBruto();
					col_5valRond=bodyResumo.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumo.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					
					faturaReciboContainer.setCol_1desServicoBundle("");
					faturaReciboContainer.setCol_1tituloServico(col_1tituloServico);
					faturaReciboContainer.setCol_1desServico(col_1desServico);

					faturaReciboContainer.setCol_1image(imgcol_1image);//
					faturaReciboContainer.setCol_2quantidade(col_2quantidade);
					//faturaReciboContainer.setCol_2unidade(col_2unidade);
					faturaReciboContainer.setCol_3valorBase(col_3valorBase);
					//faturaReciboContainer.setCol_3moeda(col_3moeda);
					faturaReciboContainer.setCol_4extra(col_4extra);
					faturaReciboContainer.setCol_4extraDesc(col_4extraDesc);
					faturaReciboContainer.setCol_5tatal(col_5tatal);
					//faturaReciboContainer.setCol_5moeda(col_5moeda);
					faturaReciboContainer.setCol_5iva(col_5ivaFinal);
					faturaReciboContainer.setCol_5aux1(col_5aux1);
					faturaReciboContainer.setCol_5aux2(col_5aux2);
					faturaReciboContainer.setCol_5aux3(col_5aux3);
					faturaReciboContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaReciboContainer.setCol_5ivaDesc(col_5ivaDesc);

					faturaReciboContainer.setCol_5valBruto(valorMesFormatado);
					faturaReciboContainer.setCol_5valRond(footerValorArrendondamento);
					faturaReciboContainer.setTotal_col3(total_col3);
					faturaReciboContainer.setTotal_col4(total_col4);
					faturaReciboContainer.setTotal_col5(footerValorTotal);
					faturaReciboContainer.setTaxa(taxa +" %");

					faturaReciboContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaReciboContainer.setImposto(imposto);
					faturaReciboContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaReciboContainer.setCol_5desciva_ultimo("Sem IVA");
					
					faturaReciboContainer.setCol_2quantidadeBundle("");
					faturaReciboContainer.setCol_5tatalBundle("");
					
					LfaturaReciboContainer.add(faturaReciboContainer);
				
				}
				
				
				

			}
				
				
				/*****************Items Bundle*****************/
				if(ArrayBodyResumoBundle!=null)
				{
					
					int tma=ArrayBodyResumoBundle.length;
					if(tma==1){
						bodyResumoBundle=ArrayBodyResumoBundle[0];
						if(bodyResumoBundle.getProdutoTitulo().equals("") && bodyResumoBundle.getValorBaseValue().equals("0") ){
							tma=0;
						}
					}
					
					
					for(int x=0;x<tma;x++)
					{
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					faturaReciboContainer = new ofertaContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumoBundle.getProdutoTitulo();

					col_1desServico=bodyResumoBundle.getProdutoDescricao();

					
					 imgcol_1image=GetByteFromFile.generate(bodyResumoBundle.getProdutoImagem());

					col_2quantidade=bodyResumoBundle.getValorQuantidadeValue();
					col_2unidade=bodyResumoBundle.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumoBundle.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumoBundle.getValorBaseUnidade();

					col_4extra=bodyResumoBundle.getExtraValue();
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumoBundle.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumoBundle.getValorBaseUnidade();
						double re=doubleValorMes/110.265;
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumoBundle.getValorBruto();
					col_5valRond=bodyResumoBundle.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumoBundle.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					ItemsBundle[] ArrayItemsBundle=bodyResumoBundle.getItemsBundle();									
					/******Tratar os Itens do Bundle*****/
					ItemsBundle ItemsBundle=null;
					String titulo="";
					String quantidade="";
					String Valor="";
					String val="";
					if(ArrayItemsBundle!=null){
						int t=ArrayItemsBundle.length;
						System.out.println("FR12");
						for(int k=0; k<t; ++k){
							ItemsBundle= new ItemsBundle();
							ItemsBundle=ArrayItemsBundle[k];
							if(k==0){
								titulo=ItemsBundle.getProdutoTitulo();
								quantidade=ItemsBundle.getValorQuantidadeValue();
								Valor=ItemsBundle.getTotalComIva();
								try{
									Valor=FormateData.getVal(Double.parseDouble(Valor));
									}catch(Exception e){
										Valor=ItemsBundle.getTotalComIva();
									}
							}else{
								
								titulo=titulo+"\n"+ItemsBundle.getProdutoTitulo();
								quantidade=quantidade+"\n"+ItemsBundle.getValorQuantidadeValue();								
								try{
									val=FormateData.getVal(Double.parseDouble(ItemsBundle.getTotalComIva()));
									}catch(Exception e){
										val=ItemsBundle.getTotalComIva();
									}															
								Valor=Valor+"\n"+val;
							}
							
						}
						
					}
					if(!titulo.equals("")){
						titulo=titulo+"\n";
					}
					if(!quantidade.equals("")){
						quantidade=quantidade+"\n";
					}
					if(!Valor.equals("")){
						Valor=Valor+"\n";
					}

					
					/************/
					
					if(!col_1desServico.equals("") && col_1desServico!=null){
						col_1desServico="\n";
					}
					faturaReciboContainer.setCol_1tituloServico(col_1tituloServico);
					faturaReciboContainer.setCol_1desServico(col_1desServico);


					faturaReciboContainer.setCol_1desServicoBundle(titulo);
					faturaReciboContainer.setCol_2quantidadeBundle(quantidade);
					faturaReciboContainer.setCol_5tatalBundle(Valor);
					
					faturaReciboContainer.setCol_1image(imgcol_1image);//
					faturaReciboContainer.setCol_2quantidade(col_2quantidade);
					//faturaReciboContainer.setCol_2unidade(col_2unidade);
					faturaReciboContainer.setCol_3valorBase(col_3valorBase);
					//faturaReciboContainer.setCol_3moeda(col_3moeda);
					faturaReciboContainer.setCol_4extra(col_4extra);
					faturaReciboContainer.setCol_4extraDesc(col_4extraDesc);
					faturaReciboContainer.setCol_5tatal(col_5tatal);
					//faturaReciboContainer.setCol_5moeda(col_5moeda);
					faturaReciboContainer.setCol_5iva(col_5ivaFinal);
					faturaReciboContainer.setCol_5aux1(col_5aux1);
					faturaReciboContainer.setCol_5aux2(col_5aux2);
					faturaReciboContainer.setCol_5aux3(col_5aux3);
					faturaReciboContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaReciboContainer.setCol_5ivaDesc(col_5ivaDesc);
					//faturaReciboContainer.setValorMes(valorMesBodyResumo);
					faturaReciboContainer.setCol_5valBruto(valorMesFormatado);
					faturaReciboContainer.setCol_5valRond(footerValorArrendondamento);
					faturaReciboContainer.setTotal_col3(total_col3);
					faturaReciboContainer.setTotal_col4(total_col4);
					faturaReciboContainer.setTotal_col5(footerValorTotal);
					faturaReciboContainer.setTaxa(taxa +" %");

					faturaReciboContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaReciboContainer.setImposto(imposto);
					faturaReciboContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaReciboContainer.setCol_5desciva_ultimo("Sem IVA");
					LfaturaReciboContainer.add(faturaReciboContainer);
					}
				}
				
			}
			
			
			
				if(LfaturaReciboContainer.size()!=0)
				{
					FaturaRecibo.setOfertaContainer(LfaturaReciboContainer);
					ArrayList<Oferta> listFaturaRecibo = new ArrayList<Oferta>(); 
					listFaturaRecibo.add(FaturaRecibo);
					byte[] output=null;
					
					
					
					ListaOfertaGerarPdf listaDevolucaoGerarPdf = new ListaOfertaGerarPdf();
					output=listaDevolucaoGerarPdf.GerarPdfListaOferta(listFaturaRecibo);					
					System.out.println("DEPOIS Gerar Pdf Recibo Oferta");
					
					faturaReciboResponse=new FaturaReciboResponse();
					
					faturaReciboResponse.setOutput(output);
					faturaReciboResponse.setValorMes(0);
			
				}
		
		return faturaReciboResponse;
	
	}
	
	public static  FaturaReciboResponse NC(Fatura novafatura) {
		

		//BodyResumo
		String col_1tituloServico="";String col_1desServico="";Image col_1image=null;String col_1aux1="";String col_1aux2="";String col_1aux3="";String col_2quantidade="";String col_2unidade="";
		String col_2aux1="";String col_2aux2="";String col_2aux3="";String col_3valorBase="";String col_3moeda="";String col_3aux1="";String col_3aux2="";String col_3aux3="";String col_4extra="";
		String col_4extraDesc="";String col_4moeda="";String col_4aux1="";String col_4aux2="";String col_4aux3="";String col_5tatal="";String col_5moeda="";double col_5iva=0;String col_5aux1="";
		String col_5aux2="";String col_5aux3="";String col_5totalEuro="";String col_5ivaDesc="";String valorMesBodyResumo="";String col_5valBruto="";String col_5valRond="";String total_col3="";
		String total_col4="";String total_col5="";String nominhoCliente="";
		String taxa="";String incidencia="";String imposto="";
		String valorMes="";
		String valorMesFormatado="";
		String footerValorTotal="";
		String footerValorTotalIncidencia="";
		String totalEuro="";
		String col_5ivaFinal="";
		String col_5totaliva_ultimo="";
		String caratervaiu="http://ucc_v2.tmais.cv";
		double totalValorBase=0;
		double totalExtra=0;
		double totalTotal=0;
		double percentagem=0;
		double incidenciaresultado=0;
		double impostoresultado=0;
		String fatRef="";
		
		FaturaReciboResponse faturaReciboResponse =null;
		FaturaRecibo FaturaRecibo = new FaturaRecibo();
		List<faturaReciboContainer> LfaturaReciboContainer = new ArrayList<faturaReciboContainer>();
		if(novafatura != null){
			System.out.println("FR1");
			fatRef=novafatura.getRodape();
			if(fatRef.startsWith("3")){
				fatRef=" - referente a Fatura "+fatRef;
			}else{
				fatRef="";
				
			}
			valorMes=novafatura.getValorMes();
			String rodape = "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde";
			FaturaRecibo.setBai(novafatura.getBai());
			FaturaRecibo.setBca(novafatura.getBca());
			FaturaRecibo.setBcn(novafatura.getCbn());
			FaturaRecibo.setBi(novafatura.getBi());
			FaturaRecibo.setCecv(novafatura.getCecv());
			FaturaRecibo.setData(novafatura.getDataProcessamento());
			FaturaRecibo.setMoeda("CVE");
			FaturaRecibo.setMorada(novafatura.getMorada());
			
//			String username="Unitel";//novafatura.getNominhoCliente();
//			String datavenda="2019-10-18";
//			FaturaRecibo.setAssistente(username);
//			FaturaRecibo.setDatahoravenda(datavenda);
			System.out.println("Assistente---->>>> Pronto---"+novafatura.getNominhoCliente()+"-----------------");
			FaturaRecibo.setAssistente("");
			FaturaRecibo.setDatahoravenda(FormateData.DataNowFat());
			
			if(!novafatura.getNominhoCliente().equals("0")){
				FaturaRecibo.setAssistente(novafatura.getNominhoCliente());
			}
			
			String nif2="";
			String header2="";
			
			header2=novafatura.getNomeCliente();
			if(header2.contains(caratervaiu)){
				header2="";
			}
			nif2=novafatura.getNif();
			if(nif2.contains(caratervaiu)){
				nif2="";
			}
			
			FaturaRecibo.setNif(nif2);
			FaturaRecibo.setNomeCliente(header2);
			FaturaRecibo.setNumeroCliente(novafatura.getNumCliente());
			FaturaRecibo.setNumeroConta(novafatura.getNumContaCliente());
			FaturaRecibo.setRodaPe(rodape);
			FaturaRecibo.setTipoDoc("Nota de Crédito");
			FaturaRecibo.setVenda("");
			FaturaRecibo.setNumeroDoc("NC/"+novafatura.getNumFatura());
			String recumendacao="Os nossos equipamentos têm uma garantia de 12 meses a contar da data de compra. Cobre os efeitos de fabrico e de funcionamento considerando as condições normais de uso, desde que não tenham sofridos reparos por pessoas não autorizadas. (lei nº 88/V/98, de 31de Dezembro regime jurídico de proteção e defesa dos";
			FaturaRecibo.setRecumendacao(recumendacao);
			FaturaRecibo.setRecumendacao1("Em caso de reclamação deverá apresentar o recibo de compra juntamente com a caixa do equipamento e os acessórios.");

			BodyResumo [] ArraybodyResumoFatura=null;
			BodyResumo bodyResumo = new BodyResumo();
			BodyResumoBundle [] ArrayBodyResumoBundle=null;
			BodyResumoBundle bodyResumoBundle=new BodyResumoBundle();
			MeioPagamento [] ArrayMeioPagamento=novafatura.getMeioPagamento();
			
			System.out.println("FR2");
			ArrayBodyResumoBundle=novafatura.getBodyResumoBundle();
			
			//Get BodyResumo []
			ArraybodyResumoFatura=novafatura.getBodyResumo();
		
			
			String valorBaseValue="";
			String extraValue="";
			String totalComIva="";
			double doubleValorMes=0;
			String footerValorArrendondamento="0";
			faturaReciboContainer faturaReciboContainer = null;
			
			
			if(ArrayMeioPagamento!=null){
				int tmeios=ArrayMeioPagamento.length;
				MeioPagamento  MeioPagamento = null;
				
				String fpagamento="";
				String valorpagamento="";
				double valMP=0;
				String valMPres="";
				
				for(int j=0; j<tmeios; ++j){
					MeioPagamento= new MeioPagamento();
					MeioPagamento=ArrayMeioPagamento[j];
					
					if(j==0){
						fpagamento=MeioPagamento.getDESCRIPTION();
						
						 valMP=Double.parseDouble(MeioPagamento.getAmount());
						 valMPres=FormateData.getVal(valMP);
						 valorpagamento=valMPres.substring(0, valMPres.length()-2)+"00";
					}else{
						 fpagamento=fpagamento+"\n"+MeioPagamento.getDESCRIPTION();
						 valMP=Double.parseDouble(MeioPagamento.getAmount());
						 valMPres=FormateData.getVal(valMP);
						 valorpagamento=valorpagamento+"\n"+valMPres.substring(0, valMPres.length()-2)+"00";
					}
					

					
				}
//				FaturaRecibo.setFpagamento(fpagamento);
//				FaturaRecibo.setValorpagamento(valorpagamento);
				FaturaRecibo.setFpagamento("");
				FaturaRecibo.setValorpagamento("");
			}
			
			FaturaRecibo.setFpagamento("");
			FaturaRecibo.setValorpagamento("");
			
			if(ArrayBodyResumoBundle!=null)
			{
				
				int tma=ArrayBodyResumoBundle.length;				
				for(int x=0;x<tma;x++){
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					valorBaseValue=bodyResumoBundle.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumoBundle.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumoBundle.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumoBundle.getTaxa();
				
				}
				
			}
			
			if(ArraybodyResumoFatura!=null)
			{
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;
			
				
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					valorBaseValue=bodyResumo.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumo.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumo.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumo.getTaxa();
				
				}
			}
			
			if(ArraybodyResumoFatura!=null || ArrayBodyResumoBundle!=null){
				
				try{
				 doubleValorMes=Double.parseDouble(valorMes);
				 valorMesFormatado=FormateData.getVal(doubleValorMes);
		         footerValorArrendondamento="-0,"+valorMesFormatado.substring(valorMesFormatado.length()-2, valorMesFormatado.length());
		        footerValorTotal=valorMesFormatado.substring(0, valorMesFormatado.length()-2)+"00";
		        col_5totaliva_ultimo="("+FormateData.getVal(doubleValorMes/1.15)+")";
				incidencia=valorMes;
				incidenciaresultado=Double.parseDouble(incidencia);
				incidenciaresultado=doubleValorMes/1.15;//Double.parseDouble(incidencia);
				int valExtenso=(int)doubleValorMes;
				String extensoDesc=FormateData.getExtensao(valExtenso);
				FaturaRecibo.setExtenso(extensoDesc);
				
				percentagem=(Float.parseFloat(taxa)/100)+1;
				impostoresultado=doubleValorMes-incidenciaresultado;//(incidenciaresultado/percentagem);
				imposto=FormateData.getVal(impostoresultado);
				footerValorTotalIncidencia=FormateData.getVal(doubleValorMes/1.15);
				}catch(Exception e){
					e.printStackTrace();
				}
			
			}

			
			if(ArraybodyResumoFatura!=null)
			{
				
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;	

				/********************Item Produto Simples*************************/
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					faturaReciboContainer = new faturaReciboContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumo.getProdutoTitulo();
					col_1desServico="";

					if(bodyResumo.getProdutoDescricao()!=null && !bodyResumo.getProdutoDescricao().equals("")){
						col_1desServico=bodyResumo.getProdutoDescricao();
					}else{
						//Valor do Numero que recebeu Serviço
						if(bodyResumo.getTotalEuro()!=null){
							col_1desServico=bodyResumo.getTotalEuro();
						}
						
					}
					
					 imgcol_1image=GetByteFromFile.generate(bodyResumo.getProdutoImagem());

					col_2quantidade=bodyResumo.getValorQuantidadeValue();
					col_2unidade=bodyResumo.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumo.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumo.getValorBaseUnidade();

					col_4extra=bodyResumo.getExtraValue();
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumo.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumo.getValorBaseUnidade();
						double re=doubleValorMes/110.265;
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumo.getValorBruto();
					col_5valRond=bodyResumo.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumo.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					
					faturaReciboContainer.setCol_1desServicoBundle("");
					faturaReciboContainer.setCol_1tituloServico(col_1tituloServico +fatRef);
					faturaReciboContainer.setCol_1desServico(col_1desServico);

					faturaReciboContainer.setCol_1image(imgcol_1image);//
					faturaReciboContainer.setCol_2quantidade(col_2quantidade);
					//faturaReciboContainer.setCol_2unidade(col_2unidade);
					faturaReciboContainer.setCol_3valorBase(col_3valorBase);
					//faturaReciboContainer.setCol_3moeda(col_3moeda);
					faturaReciboContainer.setCol_4extra(col_4extra);
					faturaReciboContainer.setCol_4extraDesc(col_4extraDesc);
					faturaReciboContainer.setCol_5tatal(col_5tatal);
					//faturaReciboContainer.setCol_5moeda(col_5moeda);
					faturaReciboContainer.setCol_5iva(col_5ivaFinal);
					faturaReciboContainer.setCol_5aux1(col_5aux1);
					faturaReciboContainer.setCol_5aux2(col_5aux2);
					faturaReciboContainer.setCol_5aux3(col_5aux3);
					faturaReciboContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaReciboContainer.setCol_5ivaDesc(col_5ivaDesc);

					faturaReciboContainer.setCol_5valBruto(valorMesFormatado);
					faturaReciboContainer.setCol_5valRond(footerValorArrendondamento);
					faturaReciboContainer.setTotal_col3(total_col3);
					faturaReciboContainer.setTotal_col4(total_col4);
					faturaReciboContainer.setTotal_col5(footerValorTotal);
					faturaReciboContainer.setTaxa(taxa +" %");

					faturaReciboContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaReciboContainer.setImposto(imposto);
					faturaReciboContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaReciboContainer.setCol_5desciva_ultimo("Sem IVA");
					
					faturaReciboContainer.setCol_2quantidadeBundle("");
					faturaReciboContainer.setCol_5tatalBundle("");
					
					LfaturaReciboContainer.add(faturaReciboContainer);
				
				}
				
				
				

			}
				
				
				/*****************Items Bundle*****************/
				if(ArrayBodyResumoBundle!=null)
				{
					
					int tma=ArrayBodyResumoBundle.length;
					if(tma==1){
						bodyResumoBundle=ArrayBodyResumoBundle[0];
						if(bodyResumoBundle.getProdutoTitulo().equals("") && bodyResumoBundle.getValorBaseValue().equals("0") ){
							tma=0;
						}
					}
					
					
					for(int x=0;x<tma;x++)
					{
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					faturaReciboContainer = new faturaReciboContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumoBundle.getProdutoTitulo();

					col_1desServico=bodyResumoBundle.getProdutoDescricao();

					
					 imgcol_1image=GetByteFromFile.generate(bodyResumoBundle.getProdutoImagem());

					col_2quantidade=bodyResumoBundle.getValorQuantidadeValue();
					col_2unidade=bodyResumoBundle.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumoBundle.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumoBundle.getValorBaseUnidade();

					col_4extra=bodyResumoBundle.getExtraValue();
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumoBundle.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumoBundle.getValorBaseUnidade();
						double re=doubleValorMes/110.265;
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumoBundle.getValorBruto();
					col_5valRond=bodyResumoBundle.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumoBundle.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					ItemsBundle[] ArrayItemsBundle=bodyResumoBundle.getItemsBundle();									
					/******Tratar os Itens do Bundle*****/
					ItemsBundle ItemsBundle=null;
					String titulo="";
					String quantidade="";
					String Valor="";
					String val="";
					if(ArrayItemsBundle!=null){
						int t=ArrayItemsBundle.length;
						System.out.println("FR12");
						for(int k=0; k<t; ++k){
							ItemsBundle= new ItemsBundle();
							ItemsBundle=ArrayItemsBundle[k];
							
							if(ItemsBundle.getProdutoDescricao()!=null)
							{
									if(ItemsBundle.getProdutoDescricao().equals("1") || ItemsBundle.getProdutoDescricao().equals("2")  ){
										if(k==0){
											
											if(ItemsBundle.getTotalEuro()!=null && !ItemsBundle.getTotalEuro().equals("") ){
												titulo=ItemsBundle.getProdutoTitulo() +" - "+ItemsBundle.getTotalEuro();
											}else{
												
												titulo=ItemsBundle.getProdutoTitulo();
											}
											
											
											quantidade=ItemsBundle.getValorQuantidadeValue();
											Valor=ItemsBundle.getTotalComIva();
											try{
												Valor=FormateData.getVal(Double.parseDouble(Valor));
												}catch(Exception e){
													Valor=ItemsBundle.getTotalComIva();
												}
										}else{
											
											if(ItemsBundle.getTotalEuro()!=null && !ItemsBundle.getTotalEuro().equals("") ){
												titulo=titulo+" - "+ItemsBundle.getTotalEuro()+"\n"+ItemsBundle.getProdutoTitulo();
											}else{
												titulo=titulo+"\n"+ItemsBundle.getProdutoTitulo();
											}
											
											
											
											quantidade=quantidade+"\n"+ItemsBundle.getValorQuantidadeValue();								
											try{
												val=FormateData.getVal(Double.parseDouble(ItemsBundle.getTotalComIva()));
												}catch(Exception e){
													val=ItemsBundle.getTotalComIva();
												}															
											Valor=Valor+"\n"+val;
										}
									}
							}
							
						}
						
					}
					if(!titulo.equals("")){
						titulo=titulo+"\n";
					}
					if(!quantidade.equals("")){
						quantidade=quantidade+"\n";
					}
					if(!Valor.equals("")){
						Valor=Valor+"\n";
					}

					
					/************/
					
					if(!col_1desServico.equals("") && col_1desServico!=null){
						col_1desServico="\n";
					}
					faturaReciboContainer.setCol_1tituloServico(col_1tituloServico +fatRef);
					faturaReciboContainer.setCol_1desServico(col_1desServico);


					faturaReciboContainer.setCol_1desServicoBundle(titulo);
					faturaReciboContainer.setCol_2quantidadeBundle(quantidade);
					faturaReciboContainer.setCol_5tatalBundle(Valor);
					
					faturaReciboContainer.setCol_1image(imgcol_1image);//
					faturaReciboContainer.setCol_2quantidade(col_2quantidade);
					//faturaReciboContainer.setCol_2unidade(col_2unidade);
					faturaReciboContainer.setCol_3valorBase(col_3valorBase);
					//faturaReciboContainer.setCol_3moeda(col_3moeda);
					faturaReciboContainer.setCol_4extra(col_4extra);
					faturaReciboContainer.setCol_4extraDesc(col_4extraDesc);
					faturaReciboContainer.setCol_5tatal(col_5tatal);
					//faturaReciboContainer.setCol_5moeda(col_5moeda);
					faturaReciboContainer.setCol_5iva(col_5ivaFinal);
					faturaReciboContainer.setCol_5aux1(col_5aux1);
					faturaReciboContainer.setCol_5aux2(col_5aux2);
					faturaReciboContainer.setCol_5aux3(col_5aux3);
					faturaReciboContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaReciboContainer.setCol_5ivaDesc(col_5ivaDesc);
					//faturaReciboContainer.setValorMes(valorMesBodyResumo);
					faturaReciboContainer.setCol_5valBruto(valorMesFormatado);
					faturaReciboContainer.setCol_5valRond(footerValorArrendondamento);
					faturaReciboContainer.setTotal_col3(total_col3);
					faturaReciboContainer.setTotal_col4(total_col4);
					faturaReciboContainer.setTotal_col5(footerValorTotal);
					faturaReciboContainer.setTaxa(taxa +" %");

					faturaReciboContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaReciboContainer.setImposto(imposto);
					faturaReciboContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaReciboContainer.setCol_5desciva_ultimo("Sem IVA");
					LfaturaReciboContainer.add(faturaReciboContainer);
					}
				}
				
			}
			
			
			
				if(LfaturaReciboContainer.size()!=0)
				{
					FaturaRecibo.setFaturaReciboContainer(LfaturaReciboContainer);
					ArrayList<FaturaRecibo> listFaturaRecibo = new ArrayList<FaturaRecibo>(); 
					listFaturaRecibo.add(FaturaRecibo);
					byte[] output=null;
					
					
					
					ListaFatutaReciboGerarPdf listaFatutaReciboGerarPdf = new ListaFatutaReciboGerarPdf();
					output=listaFatutaReciboGerarPdf.GerarPdfListaFaturaRecibo(listFaturaRecibo);
					
					System.out.println("DEPOIS Gerar Pdf Recibo NC");
					
					faturaReciboResponse=new FaturaReciboResponse();
					
					faturaReciboResponse.setOutput(output);
					faturaReciboResponse.setValorMes(0);
			
				}
		
		
		return faturaReciboResponse ;
	}
	
public static  FaturaReciboResponse ND(Fatura novafatura) {
		

		//BodyResumo
		String col_1tituloServico="";String col_1desServico="";Image col_1image=null;String col_1aux1="";String col_1aux2="";String col_1aux3="";String col_2quantidade="";String col_2unidade="";
		String col_2aux1="";String col_2aux2="";String col_2aux3="";String col_3valorBase="";String col_3moeda="";String col_3aux1="";String col_3aux2="";String col_3aux3="";String col_4extra="";
		String col_4extraDesc="";String col_4moeda="";String col_4aux1="";String col_4aux2="";String col_4aux3="";String col_5tatal="";String col_5moeda="";double col_5iva=0;String col_5aux1="";
		String col_5aux2="";String col_5aux3="";String col_5totalEuro="";String col_5ivaDesc="";String valorMesBodyResumo="";String col_5valBruto="";String col_5valRond="";String total_col3="";
		String total_col4="";String total_col5="";String nominhoCliente="";
		String taxa="";String incidencia="";String imposto="";
		String valorMes="";
		String valorMesFormatado="";
		String footerValorTotal="";
		String footerValorTotalIncidencia="";
		String totalEuro="";
		String col_5ivaFinal="";
		String col_5totaliva_ultimo="";
		String caratervaiu="http://ucc_v2.tmais.cv";
		double totalValorBase=0;
		double totalExtra=0;
		double totalTotal=0;
		double percentagem=0;
		double incidenciaresultado=0;
		double impostoresultado=0;
		String fatRef="";
		
		FaturaReciboResponse faturaReciboResponse =null;
		FaturaRecibo FaturaRecibo = new FaturaRecibo();
		List<faturaReciboContainer> LfaturaReciboContainer = new ArrayList<faturaReciboContainer>();
		if(novafatura != null){
			System.out.println("FR1");
			fatRef=novafatura.getRodape();
			if(fatRef.startsWith("3")){
				fatRef=" - referente a Fatura "+fatRef;
			}else{
				fatRef="";
				
			}
			
			valorMes=novafatura.getValorMes();
			String rodape = "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde";
			FaturaRecibo.setBai(novafatura.getBai());
			FaturaRecibo.setBca(novafatura.getBca());
			FaturaRecibo.setBcn(novafatura.getCbn());
			FaturaRecibo.setBi(novafatura.getBi());
			FaturaRecibo.setCecv(novafatura.getCecv());
			FaturaRecibo.setData(novafatura.getDataProcessamento());
			FaturaRecibo.setMoeda("CVE");
			FaturaRecibo.setMorada(novafatura.getMorada());
			
//			String username="Unitel";//novafatura.getNominhoCliente();
//			String datavenda="2019-10-18";
//			FaturaRecibo.setAssistente(username);
//			FaturaRecibo.setDatahoravenda(datavenda);
			System.out.println("Assistente---->>>> Pronto---"+novafatura.getNominhoCliente()+"-----------------");
			FaturaRecibo.setAssistente("");
			FaturaRecibo.setDatahoravenda(FormateData.DataNowFat());
			
			if(!novafatura.getNominhoCliente().equals("0")){
				FaturaRecibo.setAssistente(novafatura.getNominhoCliente());
			}
			
			String nif2="";
			String header2="";
			
			header2=novafatura.getNomeCliente();
			if(header2.contains(caratervaiu)){
				header2="";
			}
			nif2=novafatura.getNif();
			if(nif2.contains(caratervaiu)){
				nif2="";
			}
			
			FaturaRecibo.setNif(nif2);
			FaturaRecibo.setNomeCliente(header2);
			FaturaRecibo.setNumeroCliente(novafatura.getNumCliente());
			FaturaRecibo.setNumeroConta(novafatura.getNumContaCliente());
			FaturaRecibo.setRodaPe(rodape);
			FaturaRecibo.setTipoDoc("Nota de Débito");
			FaturaRecibo.setVenda("");
			FaturaRecibo.setNumeroDoc("ND/"+novafatura.getNumFatura());
			String recumendacao="Os nossos equipamentos têm uma garantia de 12 meses a contar da data de compra. Cobre os efeitos de fabrico e de funcionamento considerando as condições normais de uso, desde que não tenham sofridos reparos por pessoas não autorizadas. (lei nº 88/V/98, de 31de Dezembro regime jurídico de proteção e defesa dos";
			FaturaRecibo.setRecumendacao(recumendacao);
			FaturaRecibo.setRecumendacao1("Em caso de reclamação deverá apresentar o recibo de compra juntamente com a caixa do equipamento e os acessórios.");

			BodyResumo [] ArraybodyResumoFatura=null;
			BodyResumo bodyResumo = new BodyResumo();
			BodyResumoBundle [] ArrayBodyResumoBundle=null;
			BodyResumoBundle bodyResumoBundle=new BodyResumoBundle();
			MeioPagamento [] ArrayMeioPagamento=novafatura.getMeioPagamento();
			
			System.out.println("FR2");
			ArrayBodyResumoBundle=novafatura.getBodyResumoBundle();
			
			//Get BodyResumo []
			ArraybodyResumoFatura=novafatura.getBodyResumo();
		
			
			String valorBaseValue="";
			String extraValue="";
			String totalComIva="";
			double doubleValorMes=0;
			String footerValorArrendondamento="0";
			faturaReciboContainer faturaReciboContainer = null;
			
			
			if(ArrayMeioPagamento!=null){
				int tmeios=ArrayMeioPagamento.length;
				MeioPagamento  MeioPagamento = null;
				
				String fpagamento="";
				String valorpagamento="";
				double valMP=0;
				String valMPres="";
				
				for(int j=0; j<tmeios; ++j){
					MeioPagamento= new MeioPagamento();
					MeioPagamento=ArrayMeioPagamento[j];
					
					if(j==0){
						fpagamento=MeioPagamento.getDESCRIPTION();
						
						 valMP=Double.parseDouble(MeioPagamento.getAmount());
						 valMPres=FormateData.getVal(valMP);
						 valorpagamento=valMPres.substring(0, valMPres.length()-2)+"00";
					}else{
						 fpagamento=fpagamento+"\n"+MeioPagamento.getDESCRIPTION();
						 valMP=Double.parseDouble(MeioPagamento.getAmount());
						 valMPres=FormateData.getVal(valMP);
						 valorpagamento=valorpagamento+"\n"+valMPres.substring(0, valMPres.length()-2)+"00";
					}
					

					
				}
				FaturaRecibo.setFpagamento("");
				FaturaRecibo.setValorpagamento("");
				
			}
			
			FaturaRecibo.setFpagamento("");
			FaturaRecibo.setValorpagamento("");			
			if(ArrayBodyResumoBundle!=null)
			{
				
				int tma=ArrayBodyResumoBundle.length;				
				for(int x=0;x<tma;x++){
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					valorBaseValue=bodyResumoBundle.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumoBundle.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumoBundle.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumoBundle.getTaxa();
				
				}
				
			}
			
			if(ArraybodyResumoFatura!=null)
			{
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;
			
				
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					valorBaseValue=bodyResumo.getValorBaseValue();
					if(valorBaseValue==null || valorBaseValue==""){
						valorBaseValue="0";
					}
					extraValue=bodyResumo.getExtraValue();
					if(extraValue==null || extraValue==""){
						extraValue="0";
					}
					totalComIva=bodyResumo.getTotalComIva();
					if(totalComIva==null || totalComIva==""){
						totalComIva="0";
					}
					totalValorBase=totalValorBase+Float.parseFloat(valorBaseValue);
					totalExtra=totalExtra+Float.parseFloat(extraValue);
					totalTotal=totalTotal+Float.parseFloat(totalComIva);
					taxa=bodyResumo.getTaxa();
				
				}
			}
			
			if(ArraybodyResumoFatura!=null || ArrayBodyResumoBundle!=null){
				
				try{
				 doubleValorMes=Double.parseDouble(valorMes);
				 valorMesFormatado=FormateData.getVal(doubleValorMes);
		         footerValorArrendondamento="-0,"+valorMesFormatado.substring(valorMesFormatado.length()-2, valorMesFormatado.length());
		        footerValorTotal=valorMesFormatado.substring(0, valorMesFormatado.length()-2)+"00";
		        col_5totaliva_ultimo="("+FormateData.getVal(doubleValorMes/1.15)+")";
				incidencia=valorMes;
				incidenciaresultado=Double.parseDouble(incidencia);
				incidenciaresultado=doubleValorMes/1.15;//Double.parseDouble(incidencia);
				int valExtenso=(int)doubleValorMes;
				String extensoDesc=FormateData.getExtensao(valExtenso);
				FaturaRecibo.setExtenso(extensoDesc);
				
				percentagem=(Float.parseFloat(taxa)/100)+1;
				impostoresultado=doubleValorMes-incidenciaresultado;//(incidenciaresultado/percentagem);
				imposto=FormateData.getVal(impostoresultado);
				footerValorTotalIncidencia=FormateData.getVal(doubleValorMes/1.15);
				}catch(Exception e){
					e.printStackTrace();
				}
			
			}

			
			if(ArraybodyResumoFatura!=null)
			{
				
				int tamBodyResumoFatura=ArraybodyResumoFatura.length;	

				/********************Item Produto Simples*************************/
				for(int x=0;x<tamBodyResumoFatura;x++){
					
					bodyResumo=ArraybodyResumoFatura[x];
					faturaReciboContainer = new faturaReciboContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumo.getProdutoTitulo();
					col_1desServico="";

					if(bodyResumo.getProdutoDescricao()!=null && !bodyResumo.getProdutoDescricao().equals("")){
						col_1desServico=bodyResumo.getProdutoDescricao();
					}else{
						//Valor do Numero que recebeu Serviço
						if(bodyResumo.getTotalEuro()!=null){
							col_1desServico=bodyResumo.getTotalEuro();
						}
						
					}
					
					 imgcol_1image=GetByteFromFile.generate(bodyResumo.getProdutoImagem());

					col_2quantidade=bodyResumo.getValorQuantidadeValue();
					col_2unidade=bodyResumo.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumo.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumo.getValorBaseUnidade();

					col_4extra=bodyResumo.getExtraValue();
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumo.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumo.getValorBaseUnidade();
						double re=doubleValorMes/110.265;
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumo.getValorBruto();
					col_5valRond=bodyResumo.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumo.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					
					faturaReciboContainer.setCol_1desServicoBundle("");
					faturaReciboContainer.setCol_1tituloServico(col_1tituloServico+ fatRef );
					faturaReciboContainer.setCol_1desServico(col_1desServico);

					faturaReciboContainer.setCol_1image(imgcol_1image);//
					faturaReciboContainer.setCol_2quantidade(col_2quantidade);
					//faturaReciboContainer.setCol_2unidade(col_2unidade);
					faturaReciboContainer.setCol_3valorBase(col_3valorBase);
					//faturaReciboContainer.setCol_3moeda(col_3moeda);
					faturaReciboContainer.setCol_4extra(col_4extra);
					faturaReciboContainer.setCol_4extraDesc(col_4extraDesc);
					faturaReciboContainer.setCol_5tatal(col_5tatal);
					//faturaReciboContainer.setCol_5moeda(col_5moeda);
					faturaReciboContainer.setCol_5iva(col_5ivaFinal);
					faturaReciboContainer.setCol_5aux1(col_5aux1);
					faturaReciboContainer.setCol_5aux2(col_5aux2);
					faturaReciboContainer.setCol_5aux3(col_5aux3);
					faturaReciboContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaReciboContainer.setCol_5ivaDesc(col_5ivaDesc);

					faturaReciboContainer.setCol_5valBruto(valorMesFormatado);
					faturaReciboContainer.setCol_5valRond(footerValorArrendondamento);
					faturaReciboContainer.setTotal_col3(total_col3);
					faturaReciboContainer.setTotal_col4(total_col4);
					faturaReciboContainer.setTotal_col5(footerValorTotal);
					faturaReciboContainer.setTaxa(taxa +" %");

					faturaReciboContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaReciboContainer.setImposto(imposto);
					faturaReciboContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaReciboContainer.setCol_5desciva_ultimo("Sem IVA");
					
					faturaReciboContainer.setCol_2quantidadeBundle("");
					faturaReciboContainer.setCol_5tatalBundle("");
					
					LfaturaReciboContainer.add(faturaReciboContainer);
				
				}
				
				
				

			}
				
				
				/*****************Items Bundle*****************/
				if(ArrayBodyResumoBundle!=null)
				{
					
					int tma=ArrayBodyResumoBundle.length;
					if(tma==1){
						bodyResumoBundle=ArrayBodyResumoBundle[0];
						if(bodyResumoBundle.getProdutoTitulo().equals("") && bodyResumoBundle.getValorBaseValue().equals("0") ){
							tma=0;
						}
					}
					
					
					for(int x=0;x<tma;x++)
					{
					bodyResumoBundle=new BodyResumoBundle();
					bodyResumoBundle=ArrayBodyResumoBundle[x];
					faturaReciboContainer = new faturaReciboContainer();
					Image imgcol_1image=null;

					col_1tituloServico=bodyResumoBundle.getProdutoTitulo();

					col_1desServico=bodyResumoBundle.getProdutoDescricao();

					
					 imgcol_1image=GetByteFromFile.generate(bodyResumoBundle.getProdutoImagem());

					col_2quantidade=bodyResumoBundle.getValorQuantidadeValue();
					col_2unidade=bodyResumoBundle.getValorQuantidadeUnidade();

					col_3valorBase=bodyResumoBundle.getValorBaseValue();
					if(col_3valorBase == null || col_3valorBase==""){
						col_3valorBase="0";
					}
					col_3valorBase=FormateData.getVal(Double.parseDouble(col_3valorBase));
					col_3moeda=bodyResumoBundle.getValorBaseUnidade();

					col_4extra=bodyResumoBundle.getExtraValue();
					if(col_4extra == null || col_4extra==""){
						col_4extra="0";
					}
					col_4extra=FormateData.getVal(Double.parseDouble(col_4extra));
					if(col_4extra.equals("0,00")){
						col_4extra="-";
					}
					col_4extraDesc="";

					col_5tatal=bodyResumoBundle.getTotalComIva();
					if(col_5tatal == null || col_5tatal==""){
						col_5tatal="0";
						col_5ivaFinal="(0)";
					}else{
						col_5iva=Double.parseDouble(col_5tatal)/1.15;
						col_5ivaFinal="("+FormateData.getVal(col_5iva)+")";
					}
					col_5tatal=FormateData.getVal(Double.parseDouble(col_5tatal));
					col_5moeda=bodyResumoBundle.getValorBaseUnidade();
						double re=doubleValorMes/110.265;
						totalEuro=FormateData.getVal(re);
	
					col_5ivaDesc="Sem IVA";

					col_5valBruto=bodyResumoBundle.getValorBruto();
					col_5valRond=bodyResumoBundle.getValorRond();

					total_col3=FormateData.getVal(totalValorBase);
					total_col4=FormateData.getVal(totalExtra);
					total_col5=FormateData.getVal(totalTotal);
					taxa=bodyResumoBundle.getTaxa();
					if(total_col4.equals("0,00")){
						total_col4="-";
					}					
					
					ItemsBundle[] ArrayItemsBundle=bodyResumoBundle.getItemsBundle();									
					/******Tratar os Itens do Bundle*****/
					ItemsBundle ItemsBundle=null;
					String titulo="";
					String quantidade="";
					String Valor="";
					String val="";
					if(ArrayItemsBundle!=null){
						int t=ArrayItemsBundle.length;
						System.out.println("FR12");
						for(int k=0; k<t; ++k){
							ItemsBundle= new ItemsBundle();
							ItemsBundle=ArrayItemsBundle[k];
							
							if(ItemsBundle.getProdutoDescricao()!=null)
							{
									if(ItemsBundle.getProdutoDescricao().equals("1") || ItemsBundle.getProdutoDescricao().equals("2")  ){
										if(k==0){
											
											if(ItemsBundle.getTotalEuro()!=null && !ItemsBundle.getTotalEuro().equals("") ){
												titulo=ItemsBundle.getProdutoTitulo() +" - "+ItemsBundle.getTotalEuro();
											}else{
												
												titulo=ItemsBundle.getProdutoTitulo();
											}
											
											
											quantidade=ItemsBundle.getValorQuantidadeValue();
											Valor=ItemsBundle.getTotalComIva();
											try{
												Valor=FormateData.getVal(Double.parseDouble(Valor));
												}catch(Exception e){
													Valor=ItemsBundle.getTotalComIva();
												}
										}else{
											
											if(ItemsBundle.getTotalEuro()!=null && !ItemsBundle.getTotalEuro().equals("") ){
												titulo=titulo+" - "+ItemsBundle.getTotalEuro()+"\n"+ItemsBundle.getProdutoTitulo();
											}else{
												titulo=titulo+"\n"+ItemsBundle.getProdutoTitulo();
											}
											
											
											
											quantidade=quantidade+"\n"+ItemsBundle.getValorQuantidadeValue();								
											try{
												val=FormateData.getVal(Double.parseDouble(ItemsBundle.getTotalComIva()));
												}catch(Exception e){
													val=ItemsBundle.getTotalComIva();
												}															
											Valor=Valor+"\n"+val;
										}
									}
							}
							
						}
						
					}
					if(!titulo.equals("")){
						titulo=titulo+"\n";
					}
					if(!quantidade.equals("")){
						quantidade=quantidade+"\n";
					}
					if(!Valor.equals("")){
						Valor=Valor+"\n";
					}

					
					/************/
					
					if(!col_1desServico.equals("") && col_1desServico!=null){
						col_1desServico="\n";
					}
					faturaReciboContainer.setCol_1tituloServico(col_1tituloServico + fatRef);
					faturaReciboContainer.setCol_1desServico(col_1desServico);


					faturaReciboContainer.setCol_1desServicoBundle(titulo);
					faturaReciboContainer.setCol_2quantidadeBundle(quantidade);
					faturaReciboContainer.setCol_5tatalBundle(Valor);
					
					faturaReciboContainer.setCol_1image(imgcol_1image);//
					faturaReciboContainer.setCol_2quantidade(col_2quantidade);
					//faturaReciboContainer.setCol_2unidade(col_2unidade);
					faturaReciboContainer.setCol_3valorBase(col_3valorBase);
					//faturaReciboContainer.setCol_3moeda(col_3moeda);
					faturaReciboContainer.setCol_4extra(col_4extra);
					faturaReciboContainer.setCol_4extraDesc(col_4extraDesc);
					faturaReciboContainer.setCol_5tatal(col_5tatal);
					//faturaReciboContainer.setCol_5moeda(col_5moeda);
					faturaReciboContainer.setCol_5iva(col_5ivaFinal);
					faturaReciboContainer.setCol_5aux1(col_5aux1);
					faturaReciboContainer.setCol_5aux2(col_5aux2);
					faturaReciboContainer.setCol_5aux3(col_5aux3);
					faturaReciboContainer.setCol_5totalEuro(totalEuro+" Euro");
					faturaReciboContainer.setCol_5ivaDesc(col_5ivaDesc);
					//faturaReciboContainer.setValorMes(valorMesBodyResumo);
					faturaReciboContainer.setCol_5valBruto(valorMesFormatado);
					faturaReciboContainer.setCol_5valRond(footerValorArrendondamento);
					faturaReciboContainer.setTotal_col3(total_col3);
					faturaReciboContainer.setTotal_col4(total_col4);
					faturaReciboContainer.setTotal_col5(footerValorTotal);
					faturaReciboContainer.setTaxa(taxa +" %");

					faturaReciboContainer.setIncidencia(footerValorTotalIncidencia);
					
					faturaReciboContainer.setImposto(imposto);
					faturaReciboContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
					faturaReciboContainer.setCol_5desciva_ultimo("Sem IVA");
					LfaturaReciboContainer.add(faturaReciboContainer);
					}
				}
				
			}
			
			
			
				if(LfaturaReciboContainer.size()!=0)
				{
					FaturaRecibo.setFaturaReciboContainer(LfaturaReciboContainer);
					ArrayList<FaturaRecibo> listFaturaRecibo = new ArrayList<FaturaRecibo>(); 
					listFaturaRecibo.add(FaturaRecibo);
					byte[] output=null;
					
					
					
					ListaFatutaReciboGerarPdf listaFatutaReciboGerarPdf = new ListaFatutaReciboGerarPdf();
					output=listaFatutaReciboGerarPdf.GerarPdfListaFaturaRecibo(listFaturaRecibo);
					
					System.out.println("DEPOIS Gerar Pdf Recibo NC");
					
					faturaReciboResponse=new FaturaReciboResponse();
					
					faturaReciboResponse.setOutput(output);
					faturaReciboResponse.setValorMes(0);
			
				}
		
		
		return faturaReciboResponse ;
	}
		
	public static String  getBank(){
		return "BAI \nBCA \nBCN \nBI \nCECV";
		
	}
	public static String  getBankValue(){
		return "000810010001038900369\n000300008809918410176\n000400000648098110195\n000500000701222810197\n000200003702309810106";
	
	}
	
	public static String  getDateLimitPagamento(String payment_terms){
		String addDays="30";
		if(payment_terms.startsWith("ZP")){
			addDays="30";
		}
		if(payment_terms.startsWith("Z0")){
			try{
				addDays=payment_terms.substring(2, payment_terms.length());
			}catch(Exception e){
				addDays="30";
			}
		}
		if(payment_terms.startsWith("Z1") || payment_terms.startsWith("Z2") || payment_terms.startsWith("Z3") ){
			addDays="30";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, Integer.parseInt(addDays)); // Adding  days
		String output = sdf.format(c.getTime());
		return FormateData.GetDescMes(output);
		
		
	}
	
	public static faturaReciboContainer  getLineDesconto(faturaReciboContainer faturaReciboContainer2, String ValDesconto){
		
		faturaReciboContainer faturaReciboContainer = new faturaReciboContainer();
		faturaReciboContainer=faturaReciboContainer2;
		faturaReciboContainer.setCol_1desServicoBundle("");
		faturaReciboContainer.setCol_1tituloServico("DescontoA");
		faturaReciboContainer.setCol_1desServico("");

	//	faturaReciboContainer.setCol_1image(imgcol_1image);//
		//faturaReciboContainer.setCol_2quantidade(col_2quantidade);
		faturaReciboContainer.setCol_2quantidade("");
		//faturaReciboContainer.setCol_2unidade(col_2unidade);
		faturaReciboContainer.setCol_3valorBase(ValDesconto);
		//faturaReciboContainer.setCol_3moeda(col_3moeda);
//		faturaReciboContainer.setCol_4extra(col_4extra);
//		faturaReciboContainer.setCol_4extraDesc(col_4extraDesc);
		//faturaReciboContainer.setCol_5tatal(col_5tatal);
		faturaReciboContainer.setCol_5tatal(ValDesconto);
		//faturaReciboContainer.setCol_5moeda(col_5moeda);
	//	faturaReciboContainer.setCol_5iva(col_5ivaFinal);
	//	faturaReciboContainer.setCol_5aux1(col_5aux1);
	//	faturaReciboContainer.setCol_5aux2(col_5aux2);
	//	faturaReciboContainer.setCol_5aux3(col_5aux3);
	//	faturaReciboContainer.setCol_5totalEuro(totalEuro+" Euro");
	///	faturaReciboContainer.setCol_5ivaDesc(col_5ivaDesc);

		//faturaReciboContainer.setCol_5valBruto(valorMesFormatado);
		//faturaReciboContainer.setCol_5valRond(footerValorArrendondamento);
		//faturaReciboContainer.setTotal_col3(total_col3);
		//faturaReciboContainer.setTotal_col4(total_col4);
		//faturaReciboContainer.setTotal_col5(footerValorTotal);
		//faturaReciboContainer.setTaxa(taxa +" %");

		//faturaReciboContainer.setIncidencia(footerValorTotalIncidencia);
		
		//faturaReciboContainer.setImposto(imposto);
		//faturaReciboContainer.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
		//faturaReciboContainer.setCol_5desciva_ultimo("Sem IVA");
		faturaReciboContainer.setCol_5desciva_ultimo("");
		
		return faturaReciboContainer;
	
	}
	
	
}
