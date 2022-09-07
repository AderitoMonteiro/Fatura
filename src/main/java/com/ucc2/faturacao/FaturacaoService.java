package com.ucc2.faturacao;

import java.awt.Image;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.json.JSONObject;

import com.ibm.icu.text.DecimalFormat;
import com.model.comprovativo.Comprovativo;
import com.model.comprovativo.comprovativoContainer;
import com.model.fatura.BodyDescritivo;
import com.model.fatura.BodyDetalhado;
import com.model.fatura.BodyResumoJasper;
import com.model.fatura.fatura;
import com.model.faturarecibo.FaturaRecibo;
import com.model.faturarecibo.faturaReciboContainer;
import com.model.recibo.Recibo;
import com.model.recibo.meiosPagamento;
import com.model.recibo.reciboContainer;
import com.model.recibo.ReciboEnv;
import com.model.recibo.revenueDetail;
import com.model.nota.Nota;
import com.model.nota.NotaEnv;
import com.model.nota.notaContainer;
import com.rules.FaturaRules;
import com.ucc2.auxiliar.FormateData;
import com.ucc2.auxiliar.GetByteFromFile;
import com.ucc2.auxiliar.IBB;
import com.ucc2.auxiliar.Validator;
import com.ucc2.doc.Detalhado.BodyResumoDetalhado;
import com.ucc2.doc.descritivo.BodyResumoDesc;
import com.ucc2.doc.descritivo.ComprovativoContainerDet;
import com.ucc2.doc.descritivo.ComprovativoDet;
import com.ucc2.doc.resumo.BodyResumo;
import com.ucc2.doc.resumo.BodyResumoBundle;
import com.ucc2.doc.resumo.ItemsBundle;
import com.ucc2.doc.resumo.MeioPagamento;
import com.ucc2.jasper.ListaCoprovativoGerarPdf;
import com.ucc2.jasper.ListaFaturaGerarPdf;
import com.ucc2.jasper.ListaFatutaReciboGerarPdf;
import com.ucc2.jasper.ListaNotaGerarPdf;
import com.ucc2.jasper.ListaReciboGerarPdf;
import com.ucc2.jasper.testeListaFaturaGerarPdf;
import com.ucc2.master.ComprovativoDoc;
import com.ucc2.master.ComprovativoResponse;
import com.ucc2.master.Extenso;
import com.ucc2.master.Fatura;
import com.ucc2.master.FaturaReciboResponse;
import com.ucc2.master.FaturaResponse;
import com.ucc2.master.Header;
import com.ucc2.master.Header2;
import com.ucc2.master.NotaResponse;
import com.ucc2.master.ReciboResponse;
import com.ucc2.master.Referencia;
import com.ucc2.master.ValidateFatura;

import java.lang.Math;

public class FaturacaoService {

	public FaturaResponse InvoiceService(Fatura novafatura) {
		System.out.println("######    New Request #####");
		// tipoFatura
		// nomeSubConta
		// int tam = novafatura
		String reposta = "";
		String TypeHeader = "";
		String nomeSubConta = "";
		String tipoFatura = "";
		byte[] output = null;
		FaturaResponse faturaResponse = null;
		try {
			String caratervaiu = "http://ucc_v2.tmais.cv";
			BodyResumo[] ArraybodyResumoFatura = null;
			BodyResumo bodyResumo = new BodyResumo();

			// Header
			String dataProcessamento = "";
			String morada = "";
			String nif = "";
			String nomeCliente = "";
			String nominhoCliente = "";
			String numCliente = "";
			String numContaCliente = "";
			String numFatura = "";
			String periodoFaturacao = "";
			String valorMes = "";
			String dataVencimento = "";
			String rodape = "";
			String entidade = "";
			String referencia = "";
			String mantante = "";
			String bi = "";
			String bca = "";
			String bai = "";
			String cecv = "";
			String cbn = "";

			// BodyResumo
			String col_1tituloServico = "";
			String col_1desServico = "";
			Image col_1image = null;
			String col_1aux1 = "";
			String col_1aux2 = "";
			String col_1aux3 = "";
			String col_2quantidade = "";
			String col_2unidade = "";
			String col_2aux1 = "";
			String col_2aux2 = "";
			String col_2aux3 = "";
			String col_3valorBase = "";
			String col_3moeda = "";
			String col_3aux1 = "";
			String col_3aux2 = "";
			String col_3aux3 = "";
			String col_4extra = "";
			String col_4extraDesc = "";
			String col_4moeda = "";
			String col_4aux1 = "";
			String col_4aux2 = "";
			String col_4aux3 = "";
			String col_5tatal = "";
			String col_5moeda = "";
			double col_5iva = 0;
			String col_5aux1 = "";
			String col_5aux2 = "";
			String col_5aux3 = "";
			String col_5totalEuro = "";
			String col_5ivaDesc = "";
			String valorMesBodyResumo = "";
			String col_5valBruto = "";
			String col_5valRond = "";
			String total_col3 = "";
			String total_col4 = "";
			String total_col5 = "";
			String taxa = "";
			String incidencia = "";
			String imposto = "";
			// BodyDescritivo
			Image tituloImagem = null;
			String tituloServico = "";
			String tituloDiscricao = "";
			String tituloValor = "";
			String tituloMoeda = "";
			String tituloValorIva = "";
			double tituloValorIvaDouble = 0;
			String servicoDescritivo = "";
			String servicoValor = "";
			String servicoMoeda = "";
			String servicoValorIva = "";
			double servicoValorIvaDouble = 0;
			String servicoDescIva = "";
			String tituloDesciva = "";

			int valorMesResult = 0;
			// BodyDetalhado
			Image imagemServico = null;
			String tituloServicoBodyDetalhado = "";
			String tituloDescricao = "";
			Image tipoDImagem_imagem = null;
			String tipoDetalhe = "";
			String header_quantidade = "";
			String header_valor = "";
			String col_1data = "";
			String col_2label = "";
			String col_4extraBodyDetalhado = "";
			String col_5tipochamada = "";
			String col_6valor = "";
			String col_3duracao = "";
			String col_2value = "";
			String valorMesFormatado = "";
			String footerValorTotal = "";
			String footerValorTotalIncidencia = "";
			String totalEuro = "";
			String col_5ivaFinal = "";
			String col_5totaliva_ultimo = "";
			if (novafatura != null) {

				ArrayList<fatura> listFatura = new ArrayList<fatura>();
				fatura f = new fatura();

				List<BodyDescritivo> List_bodyDescritivo = new ArrayList<BodyDescritivo>();
				List<BodyDetalhado> List_bodyDetalhado = new ArrayList<BodyDetalhado>();
				List<BodyResumoJasper> List_bodyResumoJasper = new ArrayList<BodyResumoJasper>();

				BodyResumoJasper bodyResumoJasper = new BodyResumoJasper();
				BodyDescritivo bodyDescritivo = new BodyDescritivo();
				BodyDetalhado bodyDetalhado = new BodyDetalhado();
				BodyResumoDesc[] ArraybodyResumoDesc = null;
				BodyResumoDetalhado[] ArrayBodyResumoDetalhado = null;
				// Get Header
				dataProcessamento = novafatura.getDataProcessamento();
				// dataProcessamento="09/18 a 09/19";//novafatura.getDataProcessamento();
				morada = novafatura.getMorada();
				nif = novafatura.getNif();
				nomeCliente = novafatura.getNomeCliente();
				nominhoCliente = novafatura.getNominhoCliente();
				numCliente = novafatura.getNumCliente();
				numContaCliente = novafatura.getNumContaCliente();
				numFatura = novafatura.getNumFatura();
				// periodoFaturacao="09/18 a 09/19";
				periodoFaturacao = novafatura.getPeriodoFaturacao();
				valorMes = novafatura.getValorMes();
				dataVencimento = novafatura.getDataVencimento();
				rodape = "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde";
				entidade = novafatura.getEntidade();
				referencia = novafatura.getReferencia();
				mantante = novafatura.getMantante();
				// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> NIF "+nif
				// + "  "+numCliente);
				System.out.println("dataVencimento ---->>> " + dataVencimento);
				System.out.println("periodoFaturacao ---->>> "
						+ periodoFaturacao);
				System.out.println("dataProcessamento ---->>> "
						+ dataProcessamento);

				if (mantante == null) {
					mantante = "0";
				}
				bi = novafatura.getBi();
				bca = novafatura.getBca();
				bai = novafatura.getBai();
				cecv = novafatura.getCecv();
				cbn = novafatura.getCbn();
				TypeHeader = novafatura.getTypeHeader();
				nomeSubConta = novafatura.getNomeSubConta();
				if (nomeSubConta == null) {
					nomeSubConta = "";
				}
				double totalValorBase = 0;
				double totalExtra = 0;
				double totalTotal = 0;
				double percentagem = 0;
				double incidenciaresultado = 0;
				double impostoresultado = 0;

				// Get BodyResumo []
				ArraybodyResumoFatura = novafatura.getBodyResumo();
				if (ArraybodyResumoFatura != null) {
					int tamBodyResumoFatura = ArraybodyResumoFatura.length;
					// System.out.println("3");

					String valorBaseValue = "";
					String extraValue = "";
					String totalComIva = "";

					for (int x = 0; x < tamBodyResumoFatura; x++) {
						bodyResumo = ArraybodyResumoFatura[x];
						valorBaseValue = bodyResumo.getValorBaseValue();
						if (valorBaseValue == null || valorBaseValue == "") {
							valorBaseValue = "0";
						}
						extraValue = bodyResumo.getExtraValue();
						if (extraValue == null || extraValue == "") {
							extraValue = "0";
						}
						totalComIva = bodyResumo.getTotalComIva();
						if (totalComIva == null || totalComIva == "") {
							totalComIva = "0";
						}
						totalValorBase = totalValorBase
								+ Float.parseFloat(valorBaseValue);
						totalExtra = totalExtra + Float.parseFloat(extraValue);
						totalTotal = totalTotal + Float.parseFloat(totalComIva);
						taxa = bodyResumo.getTaxa();

					}

					double doubleValorMes = Double.parseDouble(valorMes);
					valorMesFormatado = FormateData.getVal(doubleValorMes);
					String footerValorArrendondamento = "-0,"
							+ valorMesFormatado.substring(
									valorMesFormatado.length() - 2,
									valorMesFormatado.length());
					// String footerValorRegConta="0,00";
					footerValorTotal = valorMesFormatado.substring(0,
							valorMesFormatado.length() - 2) + "00";
					col_5totaliva_ultimo = "("
							+ FormateData.getVal(doubleValorMes / 1.15)
							+ " CVE)";
					incidencia = valorMes;
					incidenciaresultado = Double.parseDouble(incidencia);
					// incidenciaresultado=doubleValorMes/1.15;//Double.parseDouble(incidencia);

					percentagem = (Float.parseFloat(taxa) / 100) + 1;
					impostoresultado = incidenciaresultado
							- (incidenciaresultado / percentagem);
					imposto = FormateData.getVal(impostoresultado);
					footerValorTotalIncidencia = FormateData
							.getVal(doubleValorMes / 1.15);
					for (int j = 0; j < tamBodyResumoFatura; j++) {
						bodyResumoJasper = new BodyResumoJasper();
						bodyResumo = new BodyResumo();
						bodyResumo = ArraybodyResumoFatura[j];
						Image imgcol_1image = null;
						// Get Variaveis
						col_1tituloServico = bodyResumo.getProdutoTitulo();
						// System.out.println("ProdutoTitulo "+bodyResumo.getProdutoTitulo());
						col_1desServico = bodyResumo.getProdutoDescricao();
						// System.out.println("ProdutoImagem "+bodyResumo.getProdutoImagem());

						imgcol_1image = GetByteFromFile.generate(bodyResumo
								.getProdutoImagem());
						// System.out.println("imgcol_1image "+imgcol_1image);
						// col_1image=imgcol_1image;
						// col_1aux1
						// col_1aux2
						// col_1aux3
						col_2quantidade = bodyResumo.getValorQuantidadeValue();
						col_2unidade = bodyResumo.getValorQuantidadeValue();
						// col_2aux1
						// col_2aux2
						// col_2aux3
						col_3valorBase = bodyResumo.getValorBaseValue();
						if (col_3valorBase == null || col_3valorBase == "") {
							col_3valorBase = "0";
						}
						col_3valorBase = FormateData.getVal(Double
								.parseDouble(col_3valorBase));
						col_3moeda = bodyResumo.getValorBaseUnidade();
						// col_3aux1
						// col_3aux2
						// col_3aux3
						col_4extra = bodyResumo.getExtraValue();
						if (col_4extra == null || col_4extra == "") {
							col_4extra = "0";
						}
						col_4extra = FormateData.getVal(Double
								.parseDouble(col_4extra));
						if (col_4extra.equals("0,00")) {
							col_4extra = "-";
						}
						col_4extraDesc = "";
						// col_4moeda
						// col_4aux1
						// col_4aux2
						// col_4aux3
						col_5tatal = bodyResumo.getTotalComIva();
						if (col_5tatal == null || col_5tatal == "") {
							col_5tatal = "0";
							col_5ivaFinal = "(0)";
						} else {
							col_5iva = Double.parseDouble(col_5tatal) / 1.15;
							col_5ivaFinal = "(" + FormateData.getVal(col_5iva)
									+ " CVE)";
						}
						col_5tatal = FormateData.getVal(Double
								.parseDouble(col_5tatal));
						col_5moeda = bodyResumo.getValorBaseUnidade();

						// bodyResumo.getTotalValueSemIva();
						// /col_5aux1=bodyResumo.get
						// col_5aux2
						// col_5aux3
						// col_5totalEuro=bodyResumo.getTotalEuro();
						// System.out.println("col_5totalEuro : "+col_5totalEuro);
						// if(col_5totalEuro!=null){
						double re = doubleValorMes / 110.265;
						// double re=r+0.0;
						totalEuro = FormateData.getVal(re);
						// }
						col_5ivaDesc = "Sem IVA";
						// bodyResumo.getVaDesc();
						// valorMes=bodyResumo.getValorMes();
						col_5valBruto = bodyResumo.getValorBruto();
						col_5valRond = bodyResumo.getValorRond();
						// totalValorBase=totalValorBase+bodyResumo.get
						total_col3 = FormateData.getVal(totalValorBase);
						total_col4 = FormateData.getVal(totalExtra);
						total_col5 = FormateData.getVal(totalTotal);
						taxa = bodyResumo.getTaxa();
						if (total_col4.equals("0,00")) {
							total_col4 = "-";
						}
						bodyResumoJasper
								.setCol_1tituloServico(col_1tituloServico);
						bodyResumoJasper.setCol_1desServico(col_1desServico);
						// System.out.println(" imgcol_1image 02  "+imgcol_1image);
						bodyResumoJasper.setCol_1image(imgcol_1image);//
						bodyResumoJasper.setCol_2quantidade(col_2quantidade);
						bodyResumoJasper.setCol_2unidade(col_2unidade);
						bodyResumoJasper.setCol_3valorBase(col_3valorBase);
						bodyResumoJasper.setCol_3moeda(col_3moeda);
						bodyResumoJasper.setCol_4extra(col_4extra);
						bodyResumoJasper.setCol_4extraDesc(col_4extraDesc);
						bodyResumoJasper.setCol_5tatal(col_5tatal);
						bodyResumoJasper.setCol_5moeda(col_5moeda);
						bodyResumoJasper.setCol_5iva(col_5ivaFinal);
						bodyResumoJasper.setCol_5aux1(col_5aux1);
						bodyResumoJasper.setCol_5aux2(col_5aux2);
						bodyResumoJasper.setCol_5aux3(col_5aux3);
						bodyResumoJasper.setCol_5totalEuro(totalEuro + " Euro");
						bodyResumoJasper.setCol_5ivaDesc(col_5ivaDesc);
						bodyResumoJasper.setValorMes(valorMesBodyResumo);
						bodyResumoJasper.setCol_5valBruto(valorMesFormatado
								+ " CVE");
						bodyResumoJasper
								.setCol_5valRond(footerValorArrendondamento);
						bodyResumoJasper.setTotal_col3(total_col3);
						bodyResumoJasper.setTotal_col4(total_col4);
						bodyResumoJasper.setTotal_col5(footerValorTotal);
						bodyResumoJasper.setTaxa(taxa + " %");
						// bodyResumoJasper.setIncidencia(footerValorTotal);
						bodyResumoJasper
								.setIncidencia(footerValorTotalIncidencia);

						bodyResumoJasper.setImposto(imposto);
						bodyResumoJasper
								.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
						bodyResumoJasper.setCol_5desciva_ultimo("Sem IVA");
						List_bodyResumoJasper.add(bodyResumoJasper);

						// GET BodyResumoDesc
						ArraybodyResumoDesc = bodyResumo.getBodyResumoDesc();

						if (ArraybodyResumoDesc != null) {
							int tambodyResumoDesc = ArraybodyResumoDesc.length;
							BodyResumoDesc bodyResumoDesc = new BodyResumoDesc();
							System.out.println("tambodyResumoDesc ---> "
									+ tambodyResumoDesc);

							for (int i = 0; i < tambodyResumoDesc; i++) {
								bodyResumoDesc = new BodyResumoDesc();
								bodyDescritivo = new BodyDescritivo();
								bodyResumoDesc = ArraybodyResumoDesc[i];
								// Image imgCol_tituloImagem =
								// GetByteFromFile.generate(bodyResumoDesc.getTituloImagem());
								// tituloImagem =imgcol_1image;
								// GetByteFromFile.generate(bodyResumoDesc.getTituloImagem());
								// imgcol_1image;
								tituloServico = bodyResumoDesc
										.getTituloServico();
								tituloDiscricao = bodyResumoDesc
										.getTituloDiscricao();
								tituloValor = bodyResumoDesc.getTituloValor()
										+ "";
								if (tituloValor == null || tituloValor == "") {
									tituloValor = "0";
								} else {
									tituloValorIvaDouble = Double
											.parseDouble(tituloValor) / 1.15;
								}
								tituloValor = FormateData.getVal(Double
										.parseDouble(tituloValor));
								tituloMoeda = bodyResumoDesc.getTituloMoeda();
								tituloValorIva = "("
										+ FormateData
												.getVal(tituloValorIvaDouble)
										+ ")";
								// = bodyResumoDesc.getTituloValorIva();

								servicoDescritivo = bodyResumoDesc
										.getServicoDescritivo();
								servicoValor = bodyResumoDesc.getServicoValor();
								servicoMoeda = bodyResumoDesc.getServicoMoeda();
								if (servicoValor == null || servicoValor == "") {
									servicoValor = "0";
								} else {
									servicoValorIvaDouble = Double
											.parseDouble(servicoValor) / 1.15;
								}
								servicoValor = FormateData.getVal(Double
										.parseDouble(servicoValor));
								servicoValorIva = "("
										+ FormateData
												.getVal(servicoValorIvaDouble)
										+ " CVE)";
								// bodyResumoDesc.getServicoValorIva();
								servicoDescIva = "Sem IVA";
								// bodyResumoDesc.getServicoDescIva();
								tituloDesciva = "Sem IVA";
								// bodyResumoDesc.getTituloDesciva();

								// if(servicoValor!=null){
								// doubleTituloValor=doubleTituloValor+Double.parseDouble(servicoValor);
								// servicoValor=servicoValor+"";
								// }

								// System.out.println("tituloImagem : "+tituloImagem);
								// System.out.println("tituloServico : "+tituloServico);
								// System.out.println("tituloDiscricao : "+tituloDiscricao);
								// System.out.println("tituloValor : "+tituloValor);
								// System.out.println("tituloMoeda : "+tituloMoeda);
								// System.out.println("tituloValorIva : "+tituloValorIva);
								// System.out.println("servicoDescritivo : "+servicoDescritivo);
								// System.out.println("servicoValor : "+servicoValor);
								// System.out.println("servicoMoeda : "+servicoMoeda);
								// System.out.println("servicoValorIva : "+servicoValorIva);
								// System.out.println("servicoDescIva : "+servicoDescIva);
								// System.out.println("tituloDesciva : "+tituloDesciva);
								// Set bodyDescritivo
								bodyDescritivo.setTituloImagem(imgcol_1image);
								bodyDescritivo
										.setTituloServico(col_1tituloServico);
								bodyDescritivo
										.setTituloDiscricao(tituloDiscricao);
								bodyDescritivo.setTituloValor(tituloValor);
								bodyDescritivo.setTituloMoeda(tituloMoeda);
								bodyDescritivo
										.setTituloValorIva(tituloValorIva);
								bodyDescritivo
										.setServicoDescritivo(servicoDescritivo);
								bodyDescritivo.setServicoValor(servicoValor);
								bodyDescritivo.setServicoMoeda(servicoMoeda);
								bodyDescritivo
										.setServicoValorIva(servicoValorIva);
								bodyDescritivo
										.setServicoDescIva(servicoDescIva);
								bodyDescritivo.setTituloDesciva(tituloDesciva);

								List_bodyDescritivo.add(bodyDescritivo);

								// Get BodyResumoDetalhado
								ArrayBodyResumoDetalhado = bodyResumoDesc
										.getBodyResumoDetalhado();

								if (ArrayBodyResumoDetalhado != null) {
									int tamBodyResumoDetalhado = ArrayBodyResumoDetalhado.length;
									BodyResumoDetalhado bodyResumoDetalhado = new BodyResumoDetalhado();
									for (int k = 0; k < tamBodyResumoDetalhado; k++) {
										bodyResumoDetalhado = ArrayBodyResumoDetalhado[k];
										bodyResumoDetalhado = new BodyResumoDetalhado();
										bodyDetalhado = new BodyDetalhado();
										Image imgCol_imagemServico = GetByteFromFile
												.generate(bodyResumoDetalhado
														.getImagemServico());
										imagemServico = imgCol_imagemServico;
										tituloServicoBodyDetalhado = bodyResumoDetalhado
												.getTituloServico();
										tituloDescricao = bodyResumoDetalhado
												.getTituloDescricao();
										Image imgCol_tipoDImagem_imagem = GetByteFromFile
												.generate(bodyResumoDetalhado
														.getTipoImagem());
										tipoDImagem_imagem = imgCol_tipoDImagem_imagem;
										tipoDetalhe = bodyResumoDetalhado
												.getTipoDetalhe();

										// System.out.println("tipoDetalhe : "+tipoDetalhe);

										if (tipoDetalhe.equals("Dados")) {
											col_2label = "MB´s";
										} else {
											col_2label = "Nº Destino";
										}
										header_quantidade = bodyResumoDetalhado
												.getHeaderQuantidade();
										header_valor = bodyResumoDetalhado
												.getHeaderValor();
										col_1data = bodyResumoDetalhado
												.getData();
										col_2label = bodyResumoDetalhado
												.getLabel();
										col_4extraBodyDetalhado = bodyResumoDetalhado
												.getExtra();
										col_5tipochamada = bodyResumoDetalhado
												.getTipochamada();
										col_6valor = bodyResumoDetalhado
												.getValor();
										col_3duracao = bodyResumoDetalhado
												.getDuracao();
										col_2value = bodyResumoDetalhado
												.getValue();

										// set BodyDetalhado
										bodyDetalhado
												.setImagemServico(imagemServico);
										bodyDetalhado
												.setTituloServico(tituloServicoBodyDetalhado);
										bodyDetalhado
												.setTituloDescricao(tituloDescricao);
										bodyDetalhado
												.setTipoDImagem_imagem(tipoDImagem_imagem);
										bodyDetalhado
												.setTipoDetalhe(tipoDetalhe);
										bodyDetalhado
												.setHeader_quantidade(header_quantidade);
										bodyDetalhado
												.setHeader_valor(header_valor);
										bodyDetalhado.setCol_1data(col_1data);
										bodyDetalhado.setCol_2label(col_2label);
										bodyDetalhado
												.setCol_4extra(col_4extraBodyDetalhado);
										bodyDetalhado
												.setCol_5tipochamada(col_5tipochamada);
										bodyDetalhado.setCol_6valor(col_6valor);
										bodyDetalhado
												.setCol_3duracao(col_3duracao);
										bodyDetalhado.setCol_2value(col_2value);

										List_bodyDetalhado.add(bodyDetalhado);
									}
								}
							}

						}

					}
				}

				if (TypeHeader.equals("5")) {
					dataProcessamento = dataProcessamento + " 00:00:00";
					periodoFaturacao = periodoFaturacao + " 00:00:00";
				}
				if (dataProcessamento.length() > 10) {
					dataProcessamento = dataProcessamento.substring(0, 10);
					dataProcessamento = FormateData
							.GetDescMes(dataProcessamento);

				}
				f.setDataProcessamento(dataProcessamento);
				f.setMorada(morada);
				f.setNif(nif);
				f.setNomeCliente(nomeCliente);
				f.setNominhoCliente(nominhoCliente);
				f.setNumCliente(numCliente);
				f.setNumContaCliente(numContaCliente);
				f.setNumFatura(numFatura);

				if (TypeHeader.equals("2") || TypeHeader.equals("3")
						|| TypeHeader.equals("4")) {
					f.setNumFatura("");
				}

				if (periodoFaturacao != null && periodoFaturacao != "") {

					if (TypeHeader.equals("5")) {
						periodoFaturacao = FormateData
								.GetPeriodoFaturacao2(periodoFaturacao);
					} else {
						periodoFaturacao = FormateData
								.GetPeriodoFaturacao(periodoFaturacao);
					}

				}
				f.setPeriodoFaturacao(periodoFaturacao);
				f.setValorMes(footerValorTotal);
				if (dataVencimento.length() > 10) {
					dataVencimento = dataVencimento.substring(0, 10);
					dataVencimento = FormateData.GetDescMes(dataVencimento);

				}
				f.setDataVencimento(dataVencimento);
				f.setRodape(rodape);
				f.setEntidade(entidade);
				f.setReferencia(referencia);
				f.setMantante(footerValorTotal);
				if (TypeHeader.equals("2") || TypeHeader.equals("3")
						|| TypeHeader.equals("4")) {
					f.setEntidade("");
					f.setReferencia("");
					f.setMantante("");
				}

				f.setBi(bi);
				f.setBca(bca);
				f.setBai(bai);
				f.setCecv(cecv);
				f.setCbn(cbn);

				if (TypeHeader.equals("1")) {
					tipoFatura = "Fatura";
					System.out
							.println(" ##########   PosPago FATURA IMPRIMIDO ########## ");
				}
				if (TypeHeader.equals("2")) {
					tipoFatura = "Fatura Proforma";
					System.out
							.println(" ##########   FATURA PROFORMA IMPRIMIDO ########## ");
				}
				if (TypeHeader.equals("3")) {
					tipoFatura = "Fatura Preview";
					System.out
							.println(" ##########   FATURA PREVIEW IMPRIMIDO ########## ");
				}
				if (TypeHeader.equals("4")) {
					tipoFatura = "Fatura Proforma Preview";
					System.out
							.println(" ##########   FATURA PROFORMA PREVIEW IMPRIMIDO ########## ");
				}
				if (TypeHeader.equals("5")) {
					tipoFatura = "Fatura";
					System.out
							.println(" ##########   FATURA Credito IMPRIMIDO ########## ");
				}

				f.setTipoFatura(tipoFatura);
				f.setNomeSubConta(nomeSubConta);
				f.setBodyResumo(List_bodyResumoJasper);
				f.setBodyDescritivo(List_bodyDescritivo);
				f.setBodyDetalhado(List_bodyDetalhado);

				listFatura = new ArrayList<fatura>();
				listFatura.add(f);
				// Thread.sleep(10000);
				System.out.println("ANTES Gerar Pdf : " + listFatura.size());
				System.out.println("ANTES Gerar ___Pdf222345678 __: "
						+ listFatura.size());
				ListaFaturaGerarPdf listaFaturaGerarPdf = new ListaFaturaGerarPdf();
				output = listaFaturaGerarPdf.GerarPdfListaFatura(listFatura);
				System.out.println("DEPOIS Gerar Pdf");
				if (valorMes != null && valorMes != "") {
					// System.out.println("valorMes : "+valorMes);
					valorMesResult = (int) Float.parseFloat(valorMes);
				}

				faturaResponse = new FaturaResponse();

				faturaResponse.setOutput(output);
				faturaResponse.setValorMes(valorMesResult);

				// return output;
			} else {
				return faturaResponse;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro no ficheiro");
		}

		return faturaResponse;
	}

	public String GetTimer(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ok";
	}

	public String InvoiceHeader(Header header) {

		List<Header2> faturas = new ArrayList<Header2>();

		Header2 header2 = new Header2();
		Image imglogo = GetByteFromFile.generate(header.getImglogo());
		// generate

		// byte[] imglogo;
		header2.setImglogo(imglogo);

		header2.setPeriodoFaturacao(header.getPeriodoFaturacao());
		header2.setValorMes(header.getValorMes());
		header2.setMorada(header.getMorada());

		faturas.add(header2);

		testeListaFaturaGerarPdf.GerarPdfListaFatura(faturas);
		return null;
	}

	public Referencia getReferencia(String NumFatura, String Entidade,
			String TypeHeader) {

		Referencia referencia = new Referencia();

		if (Entidade == null || NumFatura == null || Entidade == "") {
			return null;
		} else {
			try {

				// TypeHeader 1 fatura
				if (TypeHeader.equals("1") && NumFatura != "") {
					IBB ibb = new IBB();

					String ref_pag = NumFatura.substring(
							NumFatura.length() - 7, NumFatura.length());

					String iban = Entidade + ref_pag;
					String checkD = ibb.calculate(iban);
					String REF_PAG_SISP = ref_pag + checkD;
					String CheckDigit = checkD;
					String REF_PAG = ref_pag;

					referencia.setNumeroFatura(NumFatura);
					referencia.setEntidade(Entidade);
					referencia.setREF_PAG_SISP(REF_PAG_SISP);
					referencia.setCheckDigit(CheckDigit);
					referencia.setREF_PAG(REF_PAG);
				} else {
					if (TypeHeader.equals("2") || TypeHeader.equals("3")
							|| TypeHeader.equals("4")) {
						referencia.setNumeroFatura("");
						referencia.setEntidade("");
						referencia.setREF_PAG_SISP("000000000");
						referencia.setCheckDigit("");
						referencia.setREF_PAG("000000000");
					} else {
						referencia.setNumeroFatura("");
						referencia.setEntidade("");
						referencia.setREF_PAG_SISP("");
						referencia.setCheckDigit("");
						referencia.setREF_PAG("000000000");
					}
				}
				return referencia;

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
		}
		// return referencia;
	}

	public int ValidateFatura(ValidateFatura validateFatura) {

		int resultado = 0;
		String numFatura = "";
		String TypeHeader = "";

		if (validateFatura != null) {
			numFatura = validateFatura.getNumFatura();
			TypeHeader = validateFatura.getTypeHeader();

			try {
				resultado = Validator.ValidateFatura(numFatura, TypeHeader);
				return resultado;

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return resultado;

	}

	public String Teste(String numFatura) {
		System.out.println("TESTE");
		return numFatura;

	}

	public ReciboResponse ReciboService(ReciboEnv novoRecibo) {

		ReciboResponse reciboResponse = null;
		byte[] output = null;

		ListaReciboGerarPdf listaReciboGerarPdf = new ListaReciboGerarPdf();

		try {
			if (novoRecibo != null
					&& novoRecibo.getArrayReciboContainer() != null) {

				ArrayList<Recibo> listRecibo = new ArrayList<Recibo>();

				Recibo recibo = new Recibo();
				recibo.setTipoDoc("Recibo");
				recibo.setData(novoRecibo.getData());
				recibo.setMoeda(novoRecibo.getMoeda());
				recibo.setNif("");
				if (novoRecibo.getNif() != null) {
					if (novoRecibo.getNif().contains("http")) {
						recibo.setNif("");
					} else {
						recibo.setNif(novoRecibo.getNif());
					}
				}

				recibo.setNomeCliente(novoRecibo.getNomeCliente());
				recibo.setNumeroCliente(novoRecibo.getNumeroCliente());
				recibo.setNumeroDoc(novoRecibo.getNumeroDoc());
				recibo.setVenda(novoRecibo.getVenda());
				recibo.setMorada(novoRecibo.getMorada());
				recibo.setMoeda("CVE");
				recibo.setData(FormateData.DataNow());

				recibo.setBi("000500000701222810197");
				recibo.setBca("000300008809918410176");
				recibo.setBai("000810010001038900369");
				recibo.setCecv("000200003702309810106");
				recibo.setBcn("000400000648098110195");

				String rodape = "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde";

				recibo.setRodaPe(rodape);

				if (novoRecibo.getArrayReciboContainer().length != 0) {
					revenueDetail[] ArrayRevenueDetail = novoRecibo
							.getArrayRevenueDetail();
					revenueDetail rv = null;
					List<reciboContainer> reciboContainer = new ArrayList<reciboContainer>();
					reciboContainer rc = null;
					double valorTotalFat = 0;
					double valorCred = 0;
					double valorDivida = 0;
					int valorPago = 0;
					int valorTotal = 0;

					/**
					 * Acrescentado 04-01-2021 Validar exisencia do meio
					 * pagamento NC
					 **/
					int valorcreditoNC = 0;
					try {
						if (novoRecibo.getArraymeiosPagamento() != null) {
							meiosPagamento mpnc = null;
							for (int i = 0; i < novoRecibo
									.getArraymeiosPagamento().length; ++i) {
								System.out
										.println("meio pag: "
												+ novoRecibo
														.getArraymeiosPagamento()[i]
														.getMeiosPagamento());
								mpnc = new meiosPagamento();
								mpnc = novoRecibo.getArraymeiosPagamento()[i];
								if (mpnc.getMeiosPagamento().equalsIgnoreCase(
										"Q")) {
									valorcreditoNC = valorcreditoNC
											+ (int) (Double.parseDouble(mpnc
													.getMeiosPagamentoValor()));
								}

							}
						}
					} catch (Exception e) {
						valorcreditoNC = 0;
						System.out
								.println("Erro na leitura do valor da nota de Credito");
					}
					/** End **/

					int valorcedito = 0;
					int valordebito = 0;
					double valorceditoDepositoBancario = 0;
					String valorceditoDepositoBancarioSTR = "";
					for (int i = 0; i < novoRecibo.getArrayReciboContainer().length; ++i) {
						rc = new reciboContainer();
						rc = novoRecibo.getArrayReciboContainer()[i];
						if (rc.getMovType().equals("0002")) {
							valordebito = valordebito
									+ (int) Double.parseDouble(rc
											.getValorPago());
							System.out.println(rc.getNumDoc() + "  "
									+ rc.getValorPago());

						}
						if (rc.getMovType().equals("0001")) {
							valorcedito = valorcedito
									+ (int) Double.parseDouble(rc
											.getValorPago());
							System.out.println(rc.getNumDoc() + "  "
									+ rc.getValorPago());
							if (rc.getNumDoc().startsWith("DB")) {
								valorceditoDepositoBancario = valorceditoDepositoBancario
										+ Double.parseDouble(rc.getValorPago());
								valorceditoDepositoBancarioSTR = "1";
							}

						}
					}

					valorcedito = valorcedito * (-1);
					valorTotal = valordebito - valorcedito;
					// valorTotal=valordebito+valorcedito;
					if (valorTotal < 0) {
						valorTotal = 0;
					}

					String[] args = new String[20];
					args[0] = Integer.toString(valorTotal);// valor em Extenso
					Extenso valor_Extenso = new Extenso(new BigDecimal(args[0]));
					String texto_extensao = valor_Extenso.toString();

					if (valorTotal == 1 || valorTotal == 2) {
						/** Problema de arredondamento 1 e 2 escudo **/
						texto_extensao = "Zero Escudos";
						if (valorcedito > 0) {
							// args[0]=Integer.toString(valorcedito);//valor em
							// Extenso
							args[0] = Integer.toString(valorcedito
									- valorcreditoNC);// valor em Extenso
														// 04-01-2021
							valor_Extenso = new Extenso(new BigDecimal(args[0]));
							texto_extensao = valor_Extenso.toString();
						}
					}
					if (valorTotal == 0) {
						texto_extensao = "Zero Escudos";
						// tratamento do adiantamento
						if (valorcedito > 0) {
							// args[0]=Integer.toString(valorcedito);//valor em
							// Extenso
							args[0] = Integer.toString(valorcedito
									- valorcreditoNC);// valor em Extenso
														// 04-01-2021

							valor_Extenso = new Extenso(new BigDecimal(args[0]));
							texto_extensao = valor_Extenso.toString();
						}
					}

					valorPago = 0;
					for (int i = 0; i < novoRecibo.getArrayReciboContainer().length; ++i) {
						rc = new reciboContainer();
						rc = novoRecibo.getArrayReciboContainer()[i];
						if (rc.getMovType().equals("0002")) {
							rc.setDoc(rc.getDoc());
							System.out.println("Doc: " + rc.getDoc());
							if (rc.getEmissao().contains("T")) {
								rc.setEmissao(FormateData.receiv(rc
										.getEmissao().split("T")[0]));
							}

							if (ArrayRevenueDetail != null) {
								for (int k = 0; k < ArrayRevenueDetail.length; ++k) {
									rv = ArrayRevenueDetail[k];
									if (rc.getDocId().equals(rv.getDocDeb())) {
										valorPago = (int) Double.parseDouble(rv
												.getTotalAmountDeb());// (rc.getValorPago());
										// break;
									}
								}
							}

							valorTotalFat = (double) Double.parseDouble(rc
									.getValorDivida());// valorPago+valorDivida;
							valorDivida = (int) (valorTotalFat - valorPago);
							if (rc.getValorPagoExtenso().equals("00")) {// Validar
																		// em
																		// QAS
																		// 11/05/2022
																		// @DB
								valorTotalFat = (double) Double.parseDouble(rc
										.getValorTotal());// valorPago+valorDivida;
								valorDivida = (int) ((double) Double
										.parseDouble(rc.getValorDivida()));
							}

							rc.setValorDivida(FormateData.getVal(valorDivida));
							rc.setValorPago(FormateData
									.getVal((double) valorPago));// (rc.getValorPago())));
							rc.setValorTotal(FormateData.getVal(valorTotalFat));
							rc.setValorPagoExtenso(FormateData
									.extensoUP(texto_extensao));

							reciboContainer.add(rc);
						}
						if (rc.getMovType().equals("0001")) {
							rc.setDoc(rc.getDoc());
							System.out.println("Doc: " + rc.getDoc());
							if (rc.getEmissao().contains("T")) {
								rc.setEmissao(FormateData.receiv(rc
										.getEmissao().split("T")[0]));
							}

							if (ArrayRevenueDetail != null) {
								for (int k = 0; k < ArrayRevenueDetail.length; ++k) {
									rv = ArrayRevenueDetail[k];
									if (rc.getDocId().equals(rv.getDocCred())) {
										valorPago = (int) Double.parseDouble(rv
												.getTotalAmountCred()) * (-1);// (rc.getValorPago());
										System.out
												.println("Doc CRED TotalAmountCred: "
														+ valorPago);
										// break;
									}
								}
							}

							System.out.println("Doc CRED valorDivida: "
									+ rc.getValorDivida());
							valorTotalFat = (double) Double.parseDouble(rc
									.getValorDivida());// valorPago+valorDivida;
							valorDivida = (int) (valorTotalFat - valorPago);
							System.out.println("Doc CRED aberto: "
									+ valorDivida);

							rc.setValorDivida(FormateData.getVal(valorDivida));
							rc.setValorPago(FormateData
									.getVal((double) valorPago));// (rc.getValorPago())));
							rc.setValorTotal(FormateData.getVal(valorTotalFat));
							rc.setValorPagoExtenso(FormateData
									.extensoUP(texto_extensao));

							if (rc.getNumDoc().startsWith("DB")) {

							} else {

								reciboContainer.add(rc);
							}
						}
					}
					recibo.setReciboContainer(reciboContainer);
					List<meiosPagamento> meiosPagamento = new ArrayList<meiosPagamento>();
					meiosPagamento mp = null;
					int amount = 0;
					if (novoRecibo.getArraymeiosPagamento() != null) {
						for (int i = 0; i < novoRecibo.getArraymeiosPagamento().length; ++i) {
							System.out.println("meio pag: "
									+ novoRecibo.getArraymeiosPagamento()[i]
											.getMeiosPagamento());
							mp = new meiosPagamento();
							mp = novoRecibo.getArraymeiosPagamento()[i];
							amount = (int) (Double.parseDouble(mp
									.getMeiosPagamentoValor()));
							mp.setMeiosPagamentoValor(FormateData.getVal(Double
									.parseDouble(mp.getMeiosPagamentoValor())));
							if (amount == 1 || amount == 2) {
								/** Problema de arredondamento 1 e 2 escudo **/
								mp.setMeiosPagamentoValor(FormateData
										.getVal(Double.parseDouble("0")));
							}

							if (mp.getMeiosPagamento().equalsIgnoreCase("M")) {
								mp.setMeiosPagamento("Dinheiro");
							}
							if (mp.getMeiosPagamento().equalsIgnoreCase("Y")) {
								mp.setMeiosPagamento("Vinti4");
							}
							if (mp.getMeiosPagamento().equalsIgnoreCase("X")) {
								mp.setMeiosPagamento("Visa");
							}
							if (mp.getMeiosPagamento().equalsIgnoreCase("S")) {
								mp.setMeiosPagamento("Cheques Clientes");
							}
							if (mp.getMeiosPagamento().equalsIgnoreCase("W")) {
								mp.setMeiosPagamento("Voucher de Desconto");
							}
							if (mp.getMeiosPagamento().equalsIgnoreCase("K")) {
								mp.setMeiosPagamento("Utilização de Voucher");
							}
							if (mp.getMeiosPagamento().equalsIgnoreCase("R")) {
								mp.setMeiosPagamento("Deposito Bancário");
							}
							if (!mp.getMeiosPagamento().equalsIgnoreCase("Q")) {
								// mp.setMeiosPagamento("Nota de Crédito");
								meiosPagamento.add(mp);
							}

						}

						double dep = valorceditoDepositoBancario * (-1);
						if (dep > 0) {
							if (valorceditoDepositoBancarioSTR.equals("1")) {
								mp = new meiosPagamento();
								mp.setMeiosPagamento("Deposito Bancário");
								try {
									mp.setMeiosPagamentoValor(FormateData
											.getVal(valorceditoDepositoBancario
													* (-1)));
								} catch (Exception e) {
									mp.setMeiosPagamentoValor("-");
								}
								meiosPagamento.add(mp);
							}
						}
					} else {
						mp = new meiosPagamento();
						mp.setMeiosPagamento("Dinheiro");
						mp.setMeiosPagamentoValor("0");
						meiosPagamento.add(mp);
						if (valorceditoDepositoBancarioSTR.equals("1")) {
							mp = new meiosPagamento();
							mp.setMeiosPagamento("Deposito Bancário");
							try {
								mp.setMeiosPagamentoValor(FormateData
										.getVal(valorceditoDepositoBancario
												* (-1)));
							} catch (Exception e) {
								mp.setMeiosPagamentoValor("-");
							}
							meiosPagamento.add(mp);
						}
					}

					recibo.setMeiosPagamento(meiosPagamento);
					listRecibo.add(recibo);
					output = listaReciboGerarPdf
							.GerarPdfListaRecibo(listRecibo);

					System.out.println("DEPOIS Gerar Pdf Recibo");

					reciboResponse = new ReciboResponse();

					reciboResponse.setOutput(output);
					reciboResponse.setValorMes(0);
				}

			}
		} catch (Exception e) {
			System.out.println("Aqui---------------->>>>");
			e.printStackTrace();
		}

		return reciboResponse;
	}

	public NotaResponse NotaService(NotaEnv novoNota) {

		NotaResponse notaResponse = null;
		byte[] output = null;

		ListaNotaGerarPdf listaNotaGerarPdf = new ListaNotaGerarPdf();

		if (novoNota != null && novoNota.getArraynotaContainer() != null) {

			ArrayList<Nota> listNota = new ArrayList<Nota>();

			System.out.println("Tipo: " + novoNota.getTipoDoc());
			Nota nota = new Nota();
			nota.setTipoDoc(novoNota.getTipoDoc());
			nota.setData(FormateData.DataNow());
			nota.setMoeda("CVE");
			nota.setNif(novoNota.getNif());
			nota.setNomeCliente(novoNota.getNomeCliente());
			nota.setNumeroCliente(novoNota.getNumeroCliente());
			nota.setNumeroDoc(novoNota.getNumeroDoc());
			nota.setVenda("Venda");
			nota.setMorada(novoNota.getMorada());

			nota.setBi("000500000701222810197");
			nota.setBca("000300008809918410176");
			nota.setBai("000810010001038900369");
			nota.setCecv("000200003702309810106");
			nota.setBcn("000400000648098110195");

			String rodape = "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde";

			nota.setRodaPe(rodape);

			if (novoNota.getArraynotaContainer().length != 0) {
				List<notaContainer> notaContainer = new ArrayList<notaContainer>();
				notaContainer notac = null;
				double total = 0;
				for (int i = 0; i < novoNota.getArraynotaContainer().length; ++i) {
					notac = new notaContainer();
					notac = novoNota.getArraynotaContainer()[i];
					total = total + Double.parseDouble(notac.getValor());

					// notaContainer.add();
				}
				for (int i = 0; i < novoNota.getArraynotaContainer().length; ++i) {
					notac = new notaContainer();
					notac = novoNota.getArraynotaContainer()[i];
					// FormateData.getVal(Double.parseDouble(col_4extra));
					if (notac.getReferencia().equalsIgnoreCase("Cliente")) {
						notac.setNum("-");
						notac.setTipo("-");
					} else {

					}

					notac.setValor(FormateData.getVal(Double.parseDouble(notac
							.getValor())));
					notac.setTotal(FormateData.getVal(total));

					notaContainer.add(notac);
				}

				nota.setNotaContainer(notaContainer);

				listNota.add(nota);
				output = listaNotaGerarPdf.GerarPdfListaNota(listNota);

				System.out.println("DEPOIS Gerar Pdf Recibo");

				notaResponse = new NotaResponse();

				notaResponse.setOutput(output);
				notaResponse.setValorMes(0);
			}

		}

		return notaResponse;
	}

	/*
	 * public FaturaReciboResponse FaturaReciboService(FaturaReciboEnv
	 * novoFaturaRecibo){
	 * 
	 * FaturaReciboResponse faturaReciboResponse =null; byte[] output=null;
	 * 
	 * 
	 * 
	 * ListaFatutaReciboGerarPdf listaFatutaReciboGerarPdf = new
	 * ListaFatutaReciboGerarPdf();
	 * 
	 * 
	 * if(novoFaturaRecibo != null &&
	 * novoFaturaRecibo.getArrayfaturaReciboContainer()!=null){
	 * 
	 * ArrayList<FaturaRecibo> listFaturaRecibo = new ArrayList<FaturaRecibo>();
	 * 
	 * 
	 * FaturaRecibo faturarecibo = new FaturaRecibo();
	 * faturarecibo.setTipoDoc(novoFaturaRecibo.getTipoDoc());
	 * faturarecibo.setData(novoFaturaRecibo.getData());
	 * faturarecibo.setMoeda(novoFaturaRecibo.getMoeda());
	 * faturarecibo.setNif(novoFaturaRecibo.getNif());
	 * faturarecibo.setNomeCliente(novoFaturaRecibo.getNomeCliente());
	 * faturarecibo.setNumeroCliente(novoFaturaRecibo.getNumeroCliente());
	 * faturarecibo.setNumeroDoc(novoFaturaRecibo.getNumeroDoc());
	 * faturarecibo.setVenda(novoFaturaRecibo.getVenda());
	 * faturarecibo.setMorada(novoFaturaRecibo.getMorada());
	 * 
	 * faturarecibo.setBi("000500000701222810197");
	 * faturarecibo.setBca("000300008809918410176");
	 * faturarecibo.setBai("000810010001038900369");
	 * faturarecibo.setCecv("000200003702309810106");
	 * faturarecibo.setBcn("000400000648098110195");
	 * 
	 * 
	 * String rodape =
	 * "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde"
	 * ;
	 * 
	 * novoFaturaRecibo.setRodaPe(rodape);
	 * 
	 * if(novoFaturaRecibo.getArrayfaturaReciboContainer().length!=0){
	 * List<faturaReciboContainer> faturaReciboContainer = new
	 * ArrayList<faturaReciboContainer>(); for(int i =0;
	 * i<novoFaturaRecibo.getArrayfaturaReciboContainer().length ; ++i){
	 * 
	 * faturaReciboContainer.add(novoFaturaRecibo.getArrayfaturaReciboContainer()
	 * [i]); } faturarecibo.setFaturaReciboContainer(faturaReciboContainer);
	 * 
	 * listFaturaRecibo.add(faturarecibo);
	 * output=listaFatutaReciboGerarPdf.GerarPdfListaFaturaRecibo
	 * (listFaturaRecibo);
	 * 
	 * System.out.println("DEPOIS Gerar Pdf Recibo");
	 * 
	 * faturaReciboResponse=new FaturaReciboResponse();
	 * 
	 * faturaReciboResponse.setOutput(output);
	 * faturaReciboResponse.setValorMes(0); }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * return faturaReciboResponse; }
	 */
	public FaturaReciboResponse FaturaReciboService(Fatura novafatura) {

		StringBuffer date = new StringBuffer(novafatura.getPeriodoFaturacao());
		int anoI = date.indexOf("2"), anof = date.indexOf("-");

		String strngano = "" + date.substring(anoI, anof), stringdia = date
				.substring((anof + 4), (anof + 6)), Stringmes = date.substring(
				(anoI + 5), (anoI + 7));

		FaturaReciboResponse faturaReciboResponse = null;

		System.out.println("Antes Gerar Pdf Recibo");

		/*** Impressão Fatura Credito ***/
		if (novafatura.getTypeHeader().equals("F2")) {
			faturaReciboResponse = FaturaRules.FaturaReciboService(novafatura);
		}
		/*** Impressão Pró Forma ***/
		if (novafatura.getTypeHeader().equals("PF")) {
			faturaReciboResponse = FaturaRules.Proforma(novafatura);
		}
		/*** Impressão NC ***/
		if (novafatura.getTypeHeader().equals("NC")) {
			faturaReciboResponse = FaturaRules.NC(novafatura);
		}
		/*** Impressão ND ***/
		if (novafatura.getTypeHeader().equals("ND")) {
			faturaReciboResponse = FaturaRules.ND(novafatura);
		}
		/*** Impressão Fatura Recibo ***/
		if (novafatura.getTypeHeader().equals("ZVD")) {

			JSONObject object1 = new JSONObject(novafatura);
			String json1 = object1.toString();
			System.out.println("novafatura " + json1);

			// BodyResumo
			String col_1tituloServico = "";
			String col_1desServico = "";
			Image col_1image = null;
			String col_1aux1 = "";
			String col_1aux2 = "";
			String col_1aux3 = "";
			String col_2quantidade = "";
			String col_2unidade = "";
			String col_2aux1 = "";
			String col_2aux2 = "";
			String col_2aux3 = "";
			String col_3valorBase = "";
			String col_3moeda = "";
			String col_3aux1 = "";
			String col_3aux2 = "";
			String col_3aux3 = "";
			String col_4extra = "";
			String col_4extraDesc = "";
			String col_4moeda = "";
			String col_4aux1 = "";
			String col_4aux2 = "";
			String col_4aux3 = "";
			String col_5tatal = "";
			String col_5moeda = "";
			double col_5iva = 0;
			String col_5aux1 = "";
			String col_5aux2 = "";
			String col_5aux3 = "";
			String col_5totalEuro = "";
			String col_5ivaDesc = "";
			String valorMesBodyResumo = "";
			String col_5valBruto = "";
			String col_5valRond = "";
			String total_col3 = "";
			String total_col4 = "";
			String total_col5 = "";
			String nominhoCliente = "";
			String taxa = "";
			String incidencia = "";
			String imposto = "";
			String valorMes = "";
			String valorMesFormatado = "";
			String footerValorTotal = "";
			String footerValorTotalIncidencia = "";
			String totalEuro = "";
			String col_5ivaFinal = "";
			String col_5totaliva_ultimo = "";
			String caratervaiu = "http://ucc_v2.tmais.cv";
			double totalValorBase = 0;
			double totalExtra = 0;
			double totalTotal = 0;
			double percentagem = 0;
			double incidenciaresultado = 0;
			double impostoresultado = 0;
			double descontoR = 0, valorR = 0, sub_totalR = 0, totalR = 0, totalS = 0, SOMA_VALOR_IVA = 0, incedenciat = 0, impostot = 0, MULT_VALOR_IVA = 0, DIFERENC_DESC = 0, TOTAL_SIVA = 0, DESC_VALOR = 0, DIF = 0, DIF_TOTAL = 0, QNT = 0;

			FaturaRecibo FaturaRecibo = new FaturaRecibo();
			List<faturaReciboContainer> LfaturaReciboContainer = new ArrayList<faturaReciboContainer>();
			List<faturaReciboContainer> LfaturaReciboContainerDesconto = new ArrayList<faturaReciboContainer>();
			if (novafatura != null) {

				System.out.println("FR1");
				valorMes = novafatura.getValorMes();
				String rodape = "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde";
				FaturaRecibo.setBai(novafatura.getBai());
				FaturaRecibo.setBca(novafatura.getBca());
				FaturaRecibo.setBcn(novafatura.getCbn());
				FaturaRecibo.setBi(novafatura.getBi());
				FaturaRecibo.setCecv(novafatura.getCecv());
				FaturaRecibo.setData(novafatura.getDataProcessamento());
				FaturaRecibo.setMoeda("CVE");
				FaturaRecibo.setMorada(novafatura.getMorada());
				FaturaRecibo.setData_fatura(stringdia
						+ " "
						+ Month.of(Integer.parseInt(Stringmes)).getDisplayName(
								TextStyle.FULL, new Locale("pt")) + " "
						+ strngano);
				FaturaRecibo.setData_vencimento(25
						+ " "
						+ Month.of(Integer.parseInt(Stringmes)).getDisplayName(
								TextStyle.FULL, new Locale("pt")) + " "
						+ strngano);
				System.out.println("Assistente---->>>> Pronto---"
						+ novafatura.getNominhoCliente() + "-----------------");
				FaturaRecibo.setAssistente("");
				FaturaRecibo.setDatahoravenda(FormateData.DataNowFat());

				if (!novafatura.getNominhoCliente().equals("0")) {
					FaturaRecibo.setAssistente(novafatura.getNominhoCliente());
				}

				String nif2 = "";
				String header2 = "";

				header2 = novafatura.getNomeCliente();
				if (header2.contains(caratervaiu)) {
					header2 = "";
				}
				nif2 = novafatura.getNif();
				if (nif2.contains(caratervaiu)) {
					nif2 = "";
				}

				FaturaRecibo.setNif(nif2);
				FaturaRecibo.setNome_cliente(novafatura.getNominhoCliente());
				FaturaRecibo.setNomeCliente(header2);
				FaturaRecibo.setNumeroCliente(novafatura.getNumCliente());
				FaturaRecibo.setNumeroConta(novafatura.getNumContaCliente());
				FaturaRecibo.setRodaPe(rodape);
				FaturaRecibo.setTipoDoc("Fatura/Recibo");
				FaturaRecibo.setVenda(novafatura.getNumContaCliente());
				FaturaRecibo.setNumeroDoc(novafatura.getNumFatura());
				String recumendacao = "Os nossos equipamentos têm uma garantia de 12 meses a contar da data de compra. Cobre os efeitos de fabrico e de funcionamento considerando as condições normais de uso, desde que não tenham sofridos reparos por pessoas não autorizadas. (lei nº 88/V/98, de 31de Dezembro regime jurídico de proteção e defesa dos";
				FaturaRecibo.setRecumendacao(recumendacao);
				FaturaRecibo
						.setRecumendacao1("Em caso de reclamação deverá apresentar o recibo de compra juntamente com a caixa do equipamento e os acessórios.");
				BodyResumo[] ArraybodyResumoFatura = null;
				BodyResumo bodyResumo = new BodyResumo();
				BodyResumoBundle[] ArrayBodyResumoBundle = null;
				BodyResumoBundle bodyResumoBundle = new BodyResumoBundle();
				MeioPagamento[] ArrayMeioPagamento = novafatura
						.getMeioPagamento();
				int length;

				System.out.println("FR2");
				// getBodyResumoBundle bodyResumoBundle
				ArrayBodyResumoBundle = novafatura.getBodyResumoBundle();

				// Get BodyResumo []
				ArraybodyResumoFatura = novafatura.getBodyResumo();

				String valorBaseValue = "";
				String extraValue = "";
				String totalComIva = "";
				double doubleValorMes = 0;
				String footerValorArrendondamento = "0";
				faturaReciboContainer faturaReciboContainer = null;
				// Meios de Pagamento
				if (ArrayMeioPagamento != null) {
					int tmeios = ArrayMeioPagamento.length;
					MeioPagamento MeioPagamento = null;

					String fpagamento = "";
					String valorpagamento = "";
					double valMP = 0;
					String valMPres = "";

					for (int j = 0; j < tmeios; ++j) {
						MeioPagamento = new MeioPagamento();
						MeioPagamento = ArrayMeioPagamento[j];

						if (j == 0) {
							fpagamento = MeioPagamento.getDESCRIPTION();

							valMP = Double.parseDouble(MeioPagamento
									.getAmount());
							valMPres = FormateData.getVal(valMP);
							valorpagamento = valMPres.substring(0,
									valMPres.length() - 2)
									+ "00";
						} else {
							fpagamento = fpagamento + "\n"
									+ MeioPagamento.getDESCRIPTION();
							valMP = Double.parseDouble(MeioPagamento
									.getAmount());
							valMPres = FormateData.getVal(valMP);
							valorpagamento = valorpagamento
									+ "\n"
									+ valMPres.substring(0,
											valMPres.length() - 2) + "00";
						}

						// if(j==0){
						// fpagamento=MeioPagamento.getDESCRIPTION();
						// valorpagamento=MeioPagamento.getAmount();
						// }else{
						// fpagamento=fpagamento+"\n"+MeioPagamento.getDESCRIPTION();
						// valorpagamento=valorpagamento+"\n"+MeioPagamento.getAmount();
						// }
						//

					}

				}

				if (ArrayBodyResumoBundle != null) {

					int tma = ArrayBodyResumoBundle.length;
					for (int x = 0; x < tma; x++) {
						bodyResumoBundle = new BodyResumoBundle();
						bodyResumoBundle = ArrayBodyResumoBundle[x];
						valorBaseValue = bodyResumoBundle.getValorBaseValue();
						if (valorBaseValue == null || valorBaseValue == "") {
							valorBaseValue = "0";
						}
						extraValue = bodyResumoBundle.getExtraValue();
						if (extraValue == null || extraValue == "") {
							extraValue = "0";
						}
						totalComIva = bodyResumoBundle.getTotalComIva();
						if (totalComIva == null || totalComIva == "") {
							totalComIva = "0";
						}
						totalValorBase = totalValorBase
								+ Float.parseFloat(valorBaseValue);
						totalExtra = totalExtra + Float.parseFloat(extraValue);
						totalTotal = totalTotal + Float.parseFloat(totalComIva);
						taxa = bodyResumoBundle.getTaxa();

					}

				}

				if (ArraybodyResumoFatura != null) {
					int tamBodyResumoFatura = ArraybodyResumoFatura.length;

					for (int x = 0; x < tamBodyResumoFatura; x++) {

						bodyResumo = ArraybodyResumoFatura[x];
						valorBaseValue = bodyResumo.getValorBaseValue();
						if (valorBaseValue == null || valorBaseValue == "") {
							valorBaseValue = "0";
						}
						extraValue = bodyResumo.getExtraValue();
						if (extraValue == null || extraValue == "") {
							extraValue = "0";
						}
						totalComIva = bodyResumo.getTotalComIva();
						if (totalComIva == null || totalComIva == "") {
							totalComIva = "0";
						}
						totalValorBase = totalValorBase
								+ Float.parseFloat(valorBaseValue);
						totalExtra = totalExtra + Float.parseFloat(extraValue);
						totalTotal = totalTotal + Float.parseFloat(totalComIva);
						taxa = bodyResumo.getTaxa();

					}
				}

				if (ArraybodyResumoFatura != null
						|| ArrayBodyResumoBundle != null) {
					//
					// try {
					//
					// footerValorArrendondamento = "-0,"
					// + valorMesFormatado.substring(
					// valorMesFormatado.length() - 2,
					// valorMesFormatado.length());
					// footerValorTotal = valorMesFormatado.substring(0,
					// valorMesFormatado.length() - 2) + "00";
					// col_5totaliva_ultimo = "("
					// + FormateData.getVal(doubleValorMes / 1.15)
					// + ")";
					// incidencia = valorMes;
					// incidenciaresultado = Double.parseDouble(incidencia);
					// incidenciaresultado = doubleValorMes / 1.15;//
					// Double.parseDouble(incidencia);
					// int valExtenso = (int) doubleValorMes;
					// String extensoDesc = FormateData
					// .getExtensao(valExtenso);
					// FaturaRecibo.setExtenso(extensoDesc);
					//
					// percentagem = (Float.parseFloat(taxa) / 100) + 1;
					// impostoresultado = doubleValorMes -
					// incidenciaresultado;// (incidenciaresultado/percentagem);
					// imposto = FormateData.getVal(impostoresultado);
					// footerValorTotalIncidencia = FormateData
					// .getVal(doubleValorMes / 1.15);
					// } catch (Exception e) {
					// e.printStackTrace();
					// }
					//
					// }

					if (ArraybodyResumoFatura != null) {
						faturaReciboContainer faturaReciboContainerdesconto = new faturaReciboContainer();
						int tamBodyResumoFatura = ArraybodyResumoFatura.length;
						int valdesconto = 0;
						/******************** Item Produto Simples *************************/
						for (int x = 0; x < tamBodyResumoFatura; x++) {

							bodyResumo = ArraybodyResumoFatura[x];
							faturaReciboContainer = new faturaReciboContainer();
							Image imgcol_1image = null;

							bodyResumo.getTotalEuro();
							col_1tituloServico = bodyResumo.getProdutoTitulo();
							col_1desServico = "";
							System.out.println("Entrada do Titulo "
									+ col_1tituloServico + "  i " + x);
							if (bodyResumo.getProdutoDescricao() != null
									&& !bodyResumo.getProdutoDescricao()
											.equals("")) {
								col_1desServico = bodyResumo
										.getProdutoDescricao();
							} else {
								// Valor do Numero que recebeu Serviço
								if (bodyResumo.getTotalEuro() != null) {
									col_1desServico = bodyResumo.getTotalEuro();
								}

							}

							imgcol_1image = GetByteFromFile.generate(bodyResumo
									.getProdutoImagem());

							col_2quantidade = bodyResumo
									.getValorQuantidadeValue();
							col_2unidade = bodyResumo.getValorQuantidadeValue();

							col_3valorBase = bodyResumo.getValorBaseValue();
							if (col_3valorBase == null || col_3valorBase == "") {
								col_3valorBase = "0";
							}
							col_3valorBase = FormateData.getVal(Double
									.parseDouble(col_3valorBase));
							col_3moeda = bodyResumo.getValorBaseUnidade();

							col_4extra = bodyResumo.getExtraValue();
							if (col_4extra == null || col_4extra == "") {
								col_4extra = "0";
							}
							col_4extra = FormateData.getVal(Double
									.parseDouble(col_4extra));
							if (col_4extra.equals("0,00")) {
								col_4extra = "-";
							}
							col_4extraDesc = "";

							col_5tatal = bodyResumo.getTotalComIva();
							if (col_5tatal == null || col_5tatal == "") {
								col_5tatal = "0";
								col_5ivaFinal = "(0)";
							} else {
								col_5iva = Double.parseDouble(col_5tatal) / 1.15;
								col_5ivaFinal = "("
										+ FormateData.getVal(col_5iva) + ")";
							}
							col_5tatal = FormateData.getVal(Double
									.parseDouble(col_5tatal));
							col_5moeda = bodyResumo.getValorBaseUnidade();
							double re = doubleValorMes / 110.265;
							totalEuro = FormateData.getVal(re);

							col_5ivaDesc = "Sem IVA";

							col_5valBruto = bodyResumo.getValorBruto();
							col_5valRond = bodyResumo.getValorRond();

							total_col3 = FormateData.getVal(totalValorBase);
							total_col4 = FormateData.getVal(totalExtra);
							total_col5 = FormateData.getVal(totalTotal);
							taxa = bodyResumo.getTaxa();
							if (total_col4.equals("0,00")) {
								total_col4 = "-";
							}

							faturaReciboContainer.setCol_1desServicoBundle("");
							faturaReciboContainer
									.setCol_1tituloServico(col_1tituloServico);
							faturaReciboContainer
									.setCol_1desServico(col_1desServico);

							faturaReciboContainer.setCol_1image(imgcol_1image);//
							faturaReciboContainer
									.setCol_2quantidade(col_2quantidade);
							// faturaReciboContainer.setCol_2unidade(col_2unidade);
							faturaReciboContainer
									.setCol_3valorBase(col_3valorBase);
							// faturaReciboContainer.setCol_3moeda(col_3moeda);
							faturaReciboContainer.setCol_4extra(col_4extra);
							faturaReciboContainer
									.setCol_4extraDesc(col_4extraDesc);
							faturaReciboContainer.setCol_5tatal(col_5tatal);
							// faturaReciboContainer.setCol_5moeda(col_5moeda);
							faturaReciboContainer.setCol_5aux1(col_5aux1);
							faturaReciboContainer.setCol_5aux2(col_5aux2);
							faturaReciboContainer.setCol_5aux3(col_5aux3);
							faturaReciboContainer.setCol_5totalEuro(totalEuro
									+ " Euro");
							faturaReciboContainer.setCol_5ivaDesc(col_5ivaDesc);

							faturaReciboContainer
									.setCol_5valBruto(valorMesFormatado);
							faturaReciboContainer
									.setCol_5valRond(footerValorArrendondamento);
							faturaReciboContainer.setTotal_col3(total_col3);
							faturaReciboContainer.setTotal_col4(total_col4);
							faturaReciboContainer
									.setTotal_col5(footerValorTotal);
							faturaReciboContainer.setTaxa(taxa + " %");

							faturaReciboContainer
									.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
							faturaReciboContainer
									.setCol_5desciva_ultimo("Sem IVA");

							faturaReciboContainer.setCol_2quantidadeBundle("");
							faturaReciboContainer.setCol_5tatalBundle("");

							System.out
									.println("Entrada do desconto ------------SizeF "
											+ LfaturaReciboContainer.size());
							LfaturaReciboContainer.add(faturaReciboContainer);

							if (bodyResumo.getDescontoId() != null) {
								System.out
										.println("Entrada do desconto --------->>>>>>>>>>>>>>>>k "
												+ bodyResumo.getDescontoId()
												+ faturaReciboContainer
														.getCol_1tituloServico());
								try {

									valdesconto = Integer.parseInt(bodyResumo
											.getDescontoId());
									if (valdesconto > 0) {
										faturaReciboContainerdesconto = new faturaReciboContainer();
										// faturaReciboContainerdesconto=faturaReciboContainer;
										System.out
												.println("Entrada do desconto ----------------EntreiA "
														+ bodyResumo
																.getDescontoId()
														+ "  "
														+ faturaReciboContainerdesconto
																.getCol_1tituloServico());
										System.out
												.println("Entrada do desconto ------------Size "
														+ LfaturaReciboContainer
																.size());

										if (bodyResumo.getDescontoDesc() != null) {
											faturaReciboContainerdesconto
													.setCol_1tituloServico(bodyResumo
															.getDescontoDesc());
										} else {
											faturaReciboContainerdesconto
													.setCol_1tituloServico("Desconto Comercial");
										}

										faturaReciboContainerdesconto
												.setCol_1desServico("");
										faturaReciboContainerdesconto
												.setCol_2quantidade("");
										faturaReciboContainerdesconto
												.setCol_2quantidadeBundle("");
										faturaReciboContainerdesconto
												.setCol_5tatal(valdesconto + "");
										faturaReciboContainerdesconto
												.setCol_5ivaDesc("");
										faturaReciboContainerdesconto
												.setCol_5iva("");
										faturaReciboContainerdesconto
												.setCol_5aux1("");
										faturaReciboContainerdesconto
												.setCol_5aux2("");
										faturaReciboContainerdesconto
												.setCol_5aux3("");
										faturaReciboContainerdesconto
												.setCol_2quantidadeBundle("");
										faturaReciboContainerdesconto
												.setCol_5tatalBundle("");
										faturaReciboContainerdesconto
												.setCol_1desServicoBundle("");

										faturaReciboContainerdesconto
												.setCol_5valBruto(valorMesFormatado);
										faturaReciboContainerdesconto
												.setCol_5valRond(footerValorArrendondamento);
										faturaReciboContainerdesconto
												.setTotal_col3(total_col3);
										faturaReciboContainerdesconto
												.setTotal_col4(total_col4);
										faturaReciboContainerdesconto
												.setTotal_col5(footerValorTotal);
										faturaReciboContainerdesconto
												.setTaxa(taxa + " %");
										faturaReciboContainerdesconto
												.setCol_5totalEuro(totalEuro
														+ " Euro");
										faturaReciboContainerdesconto
												.setIncidencia(footerValorTotalIncidencia);

										faturaReciboContainerdesconto
												.setImposto(imposto);
										faturaReciboContainerdesconto
												.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
										faturaReciboContainerdesconto
												.setCol_5desciva_ultimo("Sem IVA");

										LfaturaReciboContainerDesconto
												.add(faturaReciboContainerdesconto);
										System.out
												.println("Entrada do desconto ------------Sizeeeee "
														+ LfaturaReciboContainer
																.size());
										// faturaReciboContainer.setCol_1tituloServico(col_1tituloServico);
									}
								} catch (Exception e) {

								}
							}

						}

						for (int j = 0; j < LfaturaReciboContainerDesconto
								.size(); ++j) {

							LfaturaReciboContainer
									.add(LfaturaReciboContainerDesconto.get(j));

						}

					}

					if (ArrayBodyResumoBundle != null) {

						int tma = ArrayBodyResumoBundle.length;
						if (tma == 1) {
							bodyResumoBundle = ArrayBodyResumoBundle[0];
							if (bodyResumoBundle.getProdutoTitulo().equals("")
									&& bodyResumoBundle.getValorBaseValue()
											.equals("0")) {
								tma = 0;
							}
						}

						bodyResumoBundle = new BodyResumoBundle();
						bodyResumoBundle = ArrayBodyResumoBundle[0];
						List<String> titlulo = new ArrayList<String>();
						ItemsBundle[] ArrayItemsBundle = bodyResumoBundle
								.getItemsBundle();

						ItemsBundle ItemsBundle = new ItemsBundle();

						for (int x = 0; x < bodyResumoBundle.getItemsBundle().length; x++) {

							ItemsBundle = ArrayItemsBundle[x];
							titlulo.add("");
							if (!titlulo.contains(ItemsBundle
									.getProdutoTitulo())) {

								titlulo.add(ItemsBundle.getProdutoTitulo());

								faturaReciboContainer = new faturaReciboContainer();

								Image imgcol_1image = null;

								if (x == 0) {

									faturaReciboContainer faturacontainer = new faturaReciboContainer();
									faturacontainer
											.setCol_1tituloServico(bodyResumoBundle
													.getProdutoTitulo());
									faturacontainer
											.setCol_2quantidadeBundle(bodyResumoBundle
													.getValorQuantidadeValue());
									faturacontainer
											.setCol_2quantidade(bodyResumoBundle
													.getValorQuantidadeValue());

									SOMA_VALOR_IVA = (Float
											.parseFloat(bodyResumoBundle
													.getTotalComIva()) / Float
											.parseFloat("1."
													+ bodyResumoBundle
															.getTaxa()));
									faturacontainer.setCol_5iva(String.format(
											"%.2f", SOMA_VALOR_IVA));
									MULT_VALOR_IVA = SOMA_VALOR_IVA
											* Float.parseFloat(bodyResumoBundle
													.getValorQuantidadeValue());
									faturacontainer.setCol_5iva2(String.format(
											"%.2f", MULT_VALOR_IVA));

									QNT = Float.parseFloat(bodyResumoBundle
											.getValorQuantidadeValue() + "")
											* Float.parseFloat(bodyResumoBundle
													.getTotalComIva());
									faturacontainer.setSub_total("" + QNT);
									faturacontainer.setCol_5aux1(col_5aux1);
									faturacontainer.setCol_5aux2(col_5aux2);
									faturacontainer.setCol_5aux3(col_5aux3);
									faturacontainer.setCol_5totalEuro(totalEuro
											+ " Euro");
									faturacontainer.setCol_5ivaDesc("Sem IVA");

									// faturaReciboContainer.setCol_2unidade(col_2unidade);
									// faturaReciboContainer.setCol_3moeda(col_3moeda);
									faturacontainer
											.setCol_4extraDesc(col_4extraDesc);
									faturacontainer
											.setCol_5tatal(bodyResumoBundle
													.getTotalComIva());

									if (faturacontainer.getDesconto() != null) {

										length = String
												.valueOf(
														Integer.parseInt(faturacontainer
																.getDesconto()))
												.length();

										if (length > 1) {

											DESC_VALOR = Float
													.parseFloat(faturacontainer
															.getSub_total())
													- (Float.parseFloat(faturacontainer
															.getSub_total()) * Float
															.parseFloat("0."
																	+ faturacontainer
																			.getDesconto()));
											descontoR = descontoR + DESC_VALOR;
											faturacontainer
													.setDesconto(String.format(
															"%.2f", DESC_VALOR));

											DIF = Float
													.parseFloat(faturacontainer
															.getSub_total())
													- DESC_VALOR;

											DIFERENC_DESC = MULT_VALOR_IVA
													* Float.parseFloat("0."
															+ faturacontainer
																	.getDesconto());
											faturacontainer.setCol_5iva3(String
													.format("%.2f",
															DIFERENC_DESC));

											DIF_TOTAL = Float
													.parseFloat(faturacontainer
															.getSub_total())
													- DESC_VALOR;
											faturacontainer.setTotal2(String
													.format("%.2f", DIF_TOTAL));

											TOTAL_SIVA = MULT_VALOR_IVA
													- DIFERENC_DESC;
											faturacontainer
													.setCol_5iva4(String
															.format("%.2f",
																	TOTAL_SIVA));

										} else {

											DESC_VALOR = Float
													.parseFloat(faturacontainer
															.getSub_total())
													* Float.parseFloat("0.0"
															+ faturacontainer
																	.getDesconto());
											descontoR = descontoR + DESC_VALOR;
											faturacontainer
													.setDesconto(String.format(
															"%.2f", DESC_VALOR));

											DIF = Float
													.parseFloat(faturacontainer
															.getSub_total())
													- DESC_VALOR;

											DIFERENC_DESC = MULT_VALOR_IVA
													* Float.parseFloat("0.0"
															+ faturacontainer
																	.getDesconto());
											faturacontainer.setCol_5iva3(String
													.format("%.2f",
															DIFERENC_DESC));

											DIF_TOTAL = Float
													.parseFloat(faturacontainer
															.getSub_total())
													- DESC_VALOR;
											faturacontainer.setTotal2(String
													.format("%.2f", DIF_TOTAL));

											TOTAL_SIVA = MULT_VALOR_IVA
													- DIFERENC_DESC;
											faturacontainer
													.setCol_5iva4(String
															.format("%.2f",
																	TOTAL_SIVA));

										}

									} else {

										faturacontainer.setDesconto("0");
										faturacontainer.setCol_5iva3("0");
										faturacontainer
												.setCol_5iva4(String.format(
														"%.2f", MULT_VALOR_IVA));
										faturacontainer
												.setTotal2(faturacontainer
														.getSub_total());
									}

									LfaturaReciboContainer.add(faturacontainer);

								}

								// col_1tituloServico=bodyResumoBundle.getProdutoTitulo();
								//
								// col_1desServico=bodyResumoBundle.getProdutoDescricao();
								//
								//
								// imgcol_1image=GetByteFromFile.generate(bodyResumoBundle.getProdutoImagem());
								//
								// col_2quantidade=bodyResumoBundle.getValorQuantidadeValue();
								// col_2unidade=bodyResumoBundle.getValorQuantidadeValue();

								col_3valorBase = bodyResumoBundle
										.getValorBaseValue();
								if (col_3valorBase == null
										|| col_3valorBase == "") {
									col_3valorBase = "0";
								}
								col_3valorBase = FormateData.getVal(Double
										.parseDouble(col_3valorBase));
								col_3moeda = bodyResumoBundle
										.getValorBaseUnidade();

								col_4extra = bodyResumoBundle.getExtraValue();
								if (col_4extra == null || col_4extra == "") {
									col_4extra = "0";
								}
								col_4extra = FormateData.getVal(Double
										.parseDouble(col_4extra));
								if (col_4extra.equals("0,00")) {
									col_4extra = "-";
								}
								col_4extraDesc = "";

								col_5tatal = bodyResumoBundle.getTotalComIva();
								if (col_5tatal == null || col_5tatal == "") {
									col_5tatal = "0";
									col_5ivaFinal = "(0)";
								} else {
									col_5iva = Double.parseDouble(col_5tatal) / 1.15;
									col_5ivaFinal = "("
											+ FormateData.getVal(col_5iva)
											+ ")";
								}
								col_5tatal = FormateData.getVal(Double
										.parseDouble(col_5tatal));
								col_5moeda = bodyResumoBundle
										.getValorBaseUnidade();
								double re = doubleValorMes / 110.265;
								totalEuro = FormateData.getVal(re);

								col_5ivaDesc = "Sem IVA";

								col_5valBruto = bodyResumoBundle
										.getValorBruto();
								col_5valRond = bodyResumoBundle.getValorRond();

								total_col3 = FormateData.getVal(totalValorBase);
								total_col4 = FormateData.getVal(totalExtra);
								total_col5 = FormateData.getVal(totalTotal);
								taxa = bodyResumoBundle.getTaxa();
								if (total_col4.equals("0,00")) {
									total_col4 = "-";
								}

								/****** Tratar os Itens do Bundle *****/
								String titulo = "";
								String quantidade = "";
								String Valor = "";
								String val = "";
								if (ArrayItemsBundle != null) {
									int t = ArrayItemsBundle.length;
									System.out.println("FR12");

									FaturaRecibo.setTaxa(ItemsBundle.getTaxa());
									if (ItemsBundle.getProdutoDescricao() != null) {
										// if(ItemsBundle.getProdutoDescricao().equals("1")
										// ||
										// ItemsBundle.getProdutoDescricao().equals("2")
										// ){
										// if(x==0){
										//
										// if(ItemsBundle.getTotalEuro()!=null
										// &&
										// !ItemsBundle.getTotalEuro().equals("")
										// ){
										// titulo=ItemsBundle.getProdutoTitulo()
										// +" - "+ItemsBundle.getTotalEuro();
										// }else{
										//
										// titulo=ItemsBundle.getProdutoTitulo();
										// }
										//
										//
										// quantidade=ItemsBundle.getValorQuantidadeValue();
										// Valor=ItemsBundle.getTotalComIva();
										// try{
										// Valor=FormateData.getVal(Double.parseDouble(Valor));
										// }catch(Exception e){
										// Valor=ItemsBundle.getTotalComIva();
										// }
										// }else{
										//
										// if(ItemsBundle.getTotalEuro()!=null
										// &&
										// !ItemsBundle.getTotalEuro().equals("")
										// ){
										// titulo=titulo+" - "+ItemsBundle.getTotalEuro()+"\n"+ItemsBundle.getProdutoTitulo();
										// }else{
										// titulo=titulo+"\n"+ItemsBundle.getProdutoTitulo();
										// }
										//
										//
										//
										// quantidade=quantidade+"\n"+ItemsBundle.getValorQuantidadeValue();
										// try{
										// val=FormateData.getVal(Double.parseDouble(ItemsBundle.getTotalComIva()));
										// }catch(Exception e){
										// val=ItemsBundle.getTotalComIva();
										// }
										// Valor=Valor+"\n"+val;
										// }
										// }
									}

								}
								// if(!titulo.equals("")){
								// titulo=titulo+"\n";
								// }
								// if(!quantidade.equals("")){
								// quantidade=quantidade+"\n";
								// }
								// if(!Valor.equals("")){
								// Valor=Valor+"\n";
								// }

								/************/

								if (LfaturaReciboContainer.contains(ItemsBundle
										.getProdutoTitulo()))
									if (!col_1desServico.equals("")
											&& col_1desServico != null) {
										col_1desServico = "\n";
									}
								faturaReciboContainer
										.setCol_1tituloServico(ItemsBundle
												.getProdutoTitulo());
								faturaReciboContainer
										.setCol_1desServico(col_1desServico);

								faturaReciboContainer
										.setCol_1desServicoBundle(titulo);
								faturaReciboContainer
										.setCol_2quantidadeBundle(ItemsBundle
												.getValorQuantidadeValue());

								faturaReciboContainer
										.setCol_1image(imgcol_1image);//
								faturaReciboContainer
										.setCol_2quantidade(ItemsBundle
												.getValorQuantidadeValue());
								// faturaReciboContainer.setCol_2unidade(col_2unidade);
								faturaReciboContainer
										.setCol_3valorBase(col_3valorBase);
								// faturaReciboContainer.setCol_3moeda(col_3moeda);
								faturaReciboContainer.setCol_4extra(col_4extra);
								faturaReciboContainer
										.setCol_4extraDesc(col_4extraDesc);
								faturaReciboContainer.setCol_5tatal(ItemsBundle
										.getTotalComIva());
								// faturaReciboContainer.setCol_5moeda(col_5moeda);

								SOMA_VALOR_IVA = (Float.parseFloat(ItemsBundle
										.getTotalComIva()) / Float
										.parseFloat("1."
												+ ItemsBundle.getTaxa()));
								faturaReciboContainer.setCol_5iva(String
										.format("%.2f", SOMA_VALOR_IVA));
								MULT_VALOR_IVA = SOMA_VALOR_IVA
										* Float.parseFloat(faturaReciboContainer
												.getCol_2quantidade());
								faturaReciboContainer.setCol_5iva2(String
										.format("%.2f", MULT_VALOR_IVA));
								sub_totalR = sub_totalR
										+ (SOMA_VALOR_IVA * Float
												.parseFloat(faturaReciboContainer
														.getCol_2quantidade()));

								QNT = Float.parseFloat(faturaReciboContainer
										.getCol_2quantidade() + "")
										* Float.parseFloat(ItemsBundle
												.getTotalComIva());
								faturaReciboContainer.setSub_total("" + QNT);
								faturaReciboContainer.setCol_5aux1(col_5aux1);
								faturaReciboContainer.setCol_5aux2(col_5aux2);
								faturaReciboContainer.setCol_5aux3(col_5aux3);
								faturaReciboContainer
										.setCol_5totalEuro(totalEuro + " Euro");
								faturaReciboContainer
										.setCol_5ivaDesc("Sem IVA");
								// faturaReciboContainer.setValorMes(valorMesBodyResumo);
								faturaReciboContainer
										.setCol_5valBruto(valorMesFormatado);
								faturaReciboContainer
										.setCol_5valRond(footerValorArrendondamento);
								faturaReciboContainer.setTotal_col3(total_col3);
								faturaReciboContainer.setTotal_col4(total_col4);
								faturaReciboContainer
										.setTotal_col5(footerValorTotal);
								faturaReciboContainer.setTaxa(taxa);
								FaturaRecibo.setImposto(imposto);

								if (FaturaRecibo.getDesconto() != null) {

									length = String.valueOf(
											Integer.parseInt(FaturaRecibo
													.getDesconto())).length();

									if (length > 1) {

										DESC_VALOR = Float
												.parseFloat(faturaReciboContainer
														.getSub_total())
												* Float.parseFloat("0."
														+ FaturaRecibo
																.getDesconto());
										descontoR = descontoR + DESC_VALOR;
										faturaReciboContainer
												.setDesconto(String.format(
														"%.2f", DESC_VALOR));

										DIF = Float
												.parseFloat(faturaReciboContainer
														.getSub_total())
												- DESC_VALOR;

										DIFERENC_DESC = MULT_VALOR_IVA
												* Float.parseFloat("0."
														+ FaturaRecibo
																.getDesconto());
										faturaReciboContainer
												.setCol_5iva3(String.format(
														"%.2f", DIFERENC_DESC));

										DIF_TOTAL = Float
												.parseFloat(faturaReciboContainer
														.getSub_total())
												- DESC_VALOR;
										faturaReciboContainer.setTotal2(String
												.format("%.2f", DIF_TOTAL));

										TOTAL_SIVA = MULT_VALOR_IVA
												- DIFERENC_DESC;
										faturaReciboContainer
												.setCol_5iva4(String.format(
														"%.2f", TOTAL_SIVA));

									} else {

										DESC_VALOR = Float
												.parseFloat(faturaReciboContainer
														.getSub_total())
												* Float.parseFloat("0.0"
														+ FaturaRecibo
																.getDesconto());
										descontoR = descontoR + DESC_VALOR;
										faturaReciboContainer
												.setDesconto(String.format(
														"%.2f", DESC_VALOR));

										DIF = Float
												.parseFloat(faturaReciboContainer
														.getSub_total())
												- DESC_VALOR;

										DIFERENC_DESC = MULT_VALOR_IVA
												* Float.parseFloat("0.0"
														+ FaturaRecibo
																.getDesconto());
										faturaReciboContainer
												.setCol_5iva3(String.format(
														"%.2f", DIFERENC_DESC));

										DIF_TOTAL = Float
												.parseFloat(faturaReciboContainer
														.getSub_total())
												- DESC_VALOR;
										faturaReciboContainer.setTotal2(String
												.format("%.2f", DIF_TOTAL));

										TOTAL_SIVA = MULT_VALOR_IVA
												- DIFERENC_DESC;
										faturaReciboContainer
												.setCol_5iva4(String.format(
														"%.2f", TOTAL_SIVA));

									}

								} else {

									totalR = totalR
											+ Float.parseFloat(faturaReciboContainer
													.getSub_total());
									faturaReciboContainer.setDesconto("0");
									faturaReciboContainer.setCol_5iva3("0");
									faturaReciboContainer.setCol_5iva4(String
											.format("%.2f", MULT_VALOR_IVA));
									faturaReciboContainer
											.setTotal2(faturaReciboContainer
													.getSub_total());
								}

								faturaReciboContainer
										.setCol_5totaliva_ultimo(col_5totaliva_ultimo);
								faturaReciboContainer
										.setCol_5desciva_ultimo("Sem IVA");
								LfaturaReciboContainer
										.add(faturaReciboContainer);

								// }else{
								// double subtotal=0,subtotalSI=0,descontodf=0;
								// int
								// leng=String.valueOf(LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).getDesconto()).length(),index=0;
								// index =
								// LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).setCol_2quantidade(""+(Integer.parseInt(LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).getCol_2quantidade())
								// + 1));
								// subtotal =
								// Float.parseFloat(LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).getCol_5tatal())
								// *
								// Integer.parseInt(LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).getCol_2quantidade());
								// //subtotalSI
								// =Float.parseFloat(LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).getCol_5iva())
								// *
								// Integer.parseInt(LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).getCol_2quantidade());
								// LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).setSub_total(""+subtotal);
								//
								//
								// if(LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).getDesconto()
								// != null){
								//
								// if(leng > 1){
								//
								// descontodf = subtotal - (subtotal *
								// Float.parseFloat("0."+LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).getDesconto()));
								// LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).setDesconto(""+descontodf);
								//
								// }else{
								//
								// descontodf = subtotal - (subtotal *
								// Float.parseFloat("0.0"+LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).getDesconto()));
								// LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).setDesconto(""+descontodf);
								// }
								//
								// }else{
								//
								// LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).setDesconto("0");
								// LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).setTotal2(""+subtotal);
								//
								// }
								// //LfaturaReciboContainer.get(titlulo.indexOf(ItemsBundle.getProdutoTitulo())).setCol_5iva(""+subtotalSI);
								//
								// }

							}

						}

						FaturaRecibo.setSub_totalR(String.format("%.2f",
								sub_totalR));
						// totalS =
						// Float.parseFloat(FaturaRecibo.getSub_totalR()) +
						// (Float.parseFloat(FaturaRecibo.getSub_totalR()) *
						// Float.parseFloat("0."+FaturaRecibo.getTaxa()));
						FaturaRecibo.setTotalR(String.format("%.2f", totalR));
						FaturaRecibo.setValorR(String.format("%.2f",
								totalR / 110.265));
						incedenciat = totalR / 1.15;
						FaturaRecibo.setIncidencia(String.format("%.2f",
								incedenciat));
						impostot = totalR - incedenciat;
						FaturaRecibo.setImposto(String
								.format("%.2f", +impostot));

						FaturaRecibo.setDescontoR(""
								+ String.format("%.2f", descontoR));
					}

					if (LfaturaReciboContainer.size() != 0) {
						FaturaRecibo
								.setFaturaReciboContainer(LfaturaReciboContainer);
						ArrayList<FaturaRecibo> listFaturaRecibo = new ArrayList<FaturaRecibo>();
						listFaturaRecibo.add(FaturaRecibo);
						byte[] output = null;

						JSONObject object = new JSONObject(FaturaRecibo);
						String json = object.toString();
						System.out.println("FaturaRecibo " + json);

						ListaFatutaReciboGerarPdf listaFatutaReciboGerarPdf = new ListaFatutaReciboGerarPdf();
						output = listaFatutaReciboGerarPdf
								.GerarPdfListaFaturaRecibo(listFaturaRecibo);

						System.out.println("DEPOIS Gerar Pdf Recibo");

						faturaReciboResponse = new FaturaReciboResponse();

						faturaReciboResponse.setOutput(output);
						faturaReciboResponse.setValorMes(0);

					}
				}
			}
		}
		return faturaReciboResponse;

	}

	public ComprovativoResponse ComprovativoService(
			ComprovativoDoc comprovativoDoc) {

		System.out.println("Antes Gerar Pdf Recibo");
		String col_1tituloServico;
		String col_1desServico;
		String nota;

		ComprovativoResponse comprovativoResponse = null;
		Comprovativo Comprovativo = new Comprovativo();
		if (comprovativoDoc != null) {

			String rodape = "NIF:252214420 | Registo comercial: Conservatória dos Registos da Praia – Secção Comercial nº 1874\nAv. Cidade Lisboa - Edifício BAI Center 4º e 6º Piso - 346ª Praia - Santiago, Cabo Verde";

			Comprovativo.setMorada(comprovativoDoc.getMorada());
			Comprovativo.setNif(comprovativoDoc.getNif());
			Comprovativo.setNomeCliente(comprovativoDoc.getNomeCliente());
			Comprovativo.setNumeroCliente(comprovativoDoc.getNumCliente());
			Comprovativo.setNumeroConta("");
			Comprovativo.setRodaPe(rodape);
			Comprovativo.setTipoDoc("Comprovativo");
			Comprovativo.setDataemitida(FormateData.DataNow());

			Comprovativo.setNumeroDoc(comprovativoDoc.getNumDoc());

			List<comprovativoContainer> LcomprovativoContainer = new ArrayList<comprovativoContainer>();

			ComprovativoDet[] ArrayComprovativoDet = null;
			ComprovativoDet comprovativoDet = new ComprovativoDet();

			ArrayComprovativoDet = comprovativoDoc.getComprovativoDet();

			if (ArrayComprovativoDet != null) {
				int tamComprovativoDet = ArrayComprovativoDet.length;

				comprovativoContainer comprovativoContainer = null;
				for (int x = 0; x < tamComprovativoDet; x++) {
					comprovativoDet = ArrayComprovativoDet[x];
					comprovativoContainer = new comprovativoContainer();

					comprovativoContainer.setTotalIva("");
					col_1tituloServico = comprovativoDet
							.getCol_1tituloServico();
					col_1desServico = comprovativoDet.getCol_1desServico();

					comprovativoContainer
							.setCol_1tituloServico(col_1tituloServico);
					comprovativoContainer.setNota("");

					ComprovativoContainerDet[] ArrayComprovativoContainerDet = comprovativoDet
							.getComprovativoContainerDet();
					if (ArrayComprovativoContainerDet != null) {

						int tam = ArrayComprovativoContainerDet.length;
						ComprovativoContainerDet ComprovativoContainerDet = null;
						String lineDet = "";
						for (int k = 0; k < tam; ++k) {
							ComprovativoContainerDet = new ComprovativoContainerDet();
							ComprovativoContainerDet = ArrayComprovativoContainerDet[k];

							if (ComprovativoContainerDet.getKey()
									.equalsIgnoreCase("obsOp")) {
								comprovativoContainer
										.setNota(ComprovativoContainerDet
												.getValue());
							} else {
								String key = ComprovativoContainerDet.getKey()
										.toUpperCase();
								if (lineDet.equals("")) {
									lineDet = key
											+ " - "
											+ ComprovativoContainerDet
													.getValue();
								} else {
									lineDet = lineDet
											+ "\n"
											+ key
											+ " - "
											+ ComprovativoContainerDet
													.getValue();

								}
							}

						}
						System.out.println("Col_1desServico --->" + lineDet);
						comprovativoContainer.setCol_1desServico(lineDet);

					}

					LcomprovativoContainer.add(comprovativoContainer);

				}
				Comprovativo.setComprovativoContainer(LcomprovativoContainer);
				ArrayList<Comprovativo> listComprovativo = new ArrayList<Comprovativo>();
				listComprovativo.add(Comprovativo);
				byte[] output = null;

				ListaCoprovativoGerarPdf listaCoprovativoGerarPdf = new ListaCoprovativoGerarPdf();
				output = listaCoprovativoGerarPdf
						.GerarPdfListaConprovativo(listComprovativo);

				System.out.println("DEPOIS Gerar Pdf Recibo");

				comprovativoResponse = new ComprovativoResponse();

				comprovativoResponse.setOutput(output);

			}
		}

		return comprovativoResponse;

	}

	public FaturaReciboResponse DevolucaoService(Fatura novafatura) {

		FaturaReciboResponse faturaReciboResponse = null;

		System.out.println("Antes Gerar Pdf Recibo");

		/*** Impressão Devolucao ***/
		if (novafatura.getTypeHeader().equals("RE")) {
			faturaReciboResponse = FaturaRules.DevolucaoService(novafatura);
		}

		return faturaReciboResponse;

	}

	public FaturaReciboResponse OfertaService(Fatura novafatura) {

		FaturaReciboResponse faturaReciboResponse = null;

		System.out.println("Antes Gerar Pdf Oferta");

		/*** Impressão Oferta ***/
		if (novafatura.getTypeHeader().equals("YBFD")) {
			faturaReciboResponse = FaturaRules.OfertaService(novafatura);
		}

		return faturaReciboResponse;

	}

}