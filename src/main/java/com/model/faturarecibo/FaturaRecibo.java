package com.model.faturarecibo;

import java.awt.Image;
import java.util.List;

import com.ucc2.doc.resumo.ItemsBundle;



public class FaturaRecibo {
	
	private String tipoDoc;
	private String venda;
	private String numeroDoc;
	private String nomeCliente;
	private String nif;
	private String morada;
	private String numeroCliente;
	private String numeroConta;
	private String moeda;
	private String data;
	private String col_1tituloServico;
	private String col_1desServico;
	private String col_1image;

	String rodaPe;
	String bi;
	
	String bca;
	String bai;
	String cecv;
	String bcn;

	private String fpagamento;
	private String valorpagamento;
	private String recumendacao;
	private String recumendacao1;
	private String extenso;
	private String datahoravenda;
	private String assistente;
	//campos novos
	private String valor_unitario;
	private String iva;
	private String desconto;
	
	private String col_1desServicoBundle;
	private String col_2quantidade;
	private String col_2quantidadeBundle;
	private String col_5tatal;
	private String col_5tatalBundle;
	private String col_5iva;
	private String col_5totalEuro;
	private String col_5ivaDesc;
	private String total_col5;
	private String col_5totaliva_ultimo;
	private String col_5desciva_ultimo;
	private String taxa;
	private String incidencia;
	private String imposto;
	private String totalIva;
	String total_subtotal;
	String nome_cliente;
	String data_fatura;
	String data_vencimento;
	String total2;
	String sub_total;
	List<faturaReciboContainer> faturaReciboContainer;
	List<ItemsBundle> ItemsBundle;
	String sub_totalR;
	String ivaR;
	String total;
	String totalR;
	String valorR;
	String total_euroR;
	String descontoR;
	
	public FaturaRecibo() {
		super();
		// TODO Auto-generated constructor stub
	}




	public FaturaRecibo(
			String tipoDoc,
			String venda,
			String numeroDoc,
			String nomeCliente,
			String nif,
			String morada,
			String numeroCliente,
			String numeroConta,
			String moeda,
			String data,
			String col_1tituloServico,
			String col_1desServico,
			String col_1image,
			String rodaPe,
			String bi,
			String bca,
			String bai,
			String cecv,
			String bcn,
			String fpagamento,
			String valorpagamento,
			String recumendacao,
			String recumendacao1,
			String extenso,
			String datahoravenda,
			String assistente,
			String valor_unitario,
			String iva,
			String desconto,
			String col_1desServicoBundle,
			String col_2quantidade,
			String col_2quantidadeBundle,
			String col_5tatal,
			String col_5tatalBundle,
			String col_5iva,
			String col_5totalEuro,
			String col_5ivaDesc,
			String total_col5,
			String col_5totaliva_ultimo,
			String col_5desciva_ultimo,
			String taxa,
			String incidencia,
			String imposto,
			String totalIva,
			String total_subtotal,
			String nome_cliente,
			String data_fatura,
			String data_vencimento,
			String total2,
			String sub_total,
			List<com.model.faturarecibo.faturaReciboContainer> faturaReciboContainer,
			List<com.ucc2.doc.resumo.ItemsBundle> itemsBundle,
			String sub_totalR, String ivaR, String total, String totalR,
			String valorR, String total_euroR, String descontoR) {
		super();
		this.tipoDoc = tipoDoc;
		this.venda = venda;
		this.numeroDoc = numeroDoc;
		this.nomeCliente = nomeCliente;
		this.nif = nif;
		this.morada = morada;
		this.numeroCliente = numeroCliente;
		this.numeroConta = numeroConta;
		this.moeda = moeda;
		this.data = data;
		this.col_1tituloServico = col_1tituloServico;
		this.col_1desServico = col_1desServico;
		this.col_1image = col_1image;
		this.rodaPe = rodaPe;
		this.bi = bi;
		this.bca = bca;
		this.bai = bai;
		this.cecv = cecv;
		this.bcn = bcn;
		this.fpagamento = fpagamento;
		this.valorpagamento = valorpagamento;
		this.recumendacao = recumendacao;
		this.recumendacao1 = recumendacao1;
		this.extenso = extenso;
		this.datahoravenda = datahoravenda;
		this.assistente = assistente;
		this.valor_unitario = valor_unitario;
		this.iva = iva;
		this.desconto = desconto;
		this.col_1desServicoBundle = col_1desServicoBundle;
		this.col_2quantidade = col_2quantidade;
		this.col_2quantidadeBundle = col_2quantidadeBundle;
		this.col_5tatal = col_5tatal;
		this.col_5tatalBundle = col_5tatalBundle;
		this.col_5iva = col_5iva;
		this.col_5totalEuro = col_5totalEuro;
		this.col_5ivaDesc = col_5ivaDesc;
		this.total_col5 = total_col5;
		this.col_5totaliva_ultimo = col_5totaliva_ultimo;
		this.col_5desciva_ultimo = col_5desciva_ultimo;
		this.taxa = taxa;
		this.incidencia = incidencia;
		this.imposto = imposto;
		this.totalIva = totalIva;
		this.total_subtotal = total_subtotal;
		this.nome_cliente = nome_cliente;
		this.data_fatura = data_fatura;
		this.data_vencimento = data_vencimento;
		this.total2 = total2;
		this.sub_total = sub_total;
		this.faturaReciboContainer = faturaReciboContainer;
		ItemsBundle = itemsBundle;
		this.sub_totalR = sub_totalR;
		this.ivaR = ivaR;
		this.total = total;
		this.totalR = totalR;
		this.valorR = valorR;
		this.total_euroR = total_euroR;
		this.descontoR = descontoR;
	}




	public String getValorR() {
		return valorR;
	}


	public void setValorR(String valorR) {
		this.valorR = valorR;
	}




	public String getDescontoR() {
		return descontoR;
	}




	public void setDescontoR(String descontoR) {
		this.descontoR = descontoR;
	}




	public String getTotal_euroR() {
		return total_euroR;
	}


	public void setTotal_euroR(String total_euroR) {
		this.total_euroR = total_euroR;
	}




	public String getSub_totalR() {
		return sub_totalR;
	}



	public void setSub_totalR(String sub_totalR) {
		this.sub_totalR = sub_totalR;
	}



	public String getIvaR() {
		return ivaR;
	}



	public void setIvaR(String ivaR) {
		this.ivaR = ivaR;
	}



	public String getTotal() {
		return total;
	}



	public void setTotal(String total) {
		this.total = total;
	}



	public String getTotalR() {
		return totalR;
	}



	public void setTotalR(String totalR) {
		this.totalR = totalR;
	}



	public List<ItemsBundle> getItemsBundle() {
		return ItemsBundle;
	}

	public void setItemsBundle(List<ItemsBundle> itemsBundle) {
		ItemsBundle = itemsBundle;
	}


	public String getTotal_subtotal() {
		return total_subtotal;
	}

	public void setTotal_subtotal(String total_subtotal) {
		this.total_subtotal = total_subtotal;
	}

	public String getData_fatura() {
		return data_fatura;
	}


	public String getTotal2() {
		return total2;
	}


	public void setTotal2(String total2) {
		this.total2 = total2;
	}


	public void setData_fatura(String data_fatura) {
		this.data_fatura = data_fatura;
	}





	public String getData_vencimento() {
		return data_vencimento;
	}





	public void setData_vencimento(String data_vencimento) {
		this.data_vencimento = data_vencimento;
	}





	public String getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}


	public String getVenda() {
		return venda;
	}


	public void setVenda(String venda) {
		this.venda = venda;
	}


	public String getNumeroDoc() {
		return numeroDoc;
	}


	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	public String getMorada() {
		return morada;
	}


	public String getNome_cliente() {
		return nome_cliente;
	}



	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}



	public void setMorada(String morada) {
		this.morada = morada;
	}


	public String getNumeroCliente() {
		return numeroCliente;
	}


	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}


	public String getNumeroConta() {
		return numeroConta;
	}


	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}


	public String getMoeda() {
		return moeda;
	}


	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getRodaPe() {
		return rodaPe;
	}


	public void setRodaPe(String rodaPe) {
		this.rodaPe = rodaPe;
	}


	public String getBi() {
		return bi;
	}


	public void setBi(String bi) {
		this.bi = bi;
	}


	public String getBca() {
		return bca;
	}


	public void setBca(String bca) {
		this.bca = bca;
	}


	public String getBai() {
		return bai;
	}


	public void setBai(String bai) {
		this.bai = bai;
	}


	public String getCecv() {
		return cecv;
	}


	public void setCecv(String cecv) {
		this.cecv = cecv;
	}


	public String getBcn() {
		return bcn;
	}


	public void setBcn(String bcn) {
		this.bcn = bcn;
	}


	public String getFpagamento() {
		return fpagamento;
	}


	public void setFpagamento(String fpagamento) {
		this.fpagamento = fpagamento;
	}


	public String getValorpagamento() {
		return valorpagamento;
	}


	public void setValorpagamento(String valorpagamento) {
		this.valorpagamento = valorpagamento;
	}


	public String getRecumendacao() {
		return recumendacao;
	}


	public void setRecumendacao(String recumendacao) {
		this.recumendacao = recumendacao;
	}


	public String getRecumendacao1() {
		return recumendacao1;
	}


	public void setRecumendacao1(String recumendacao1) {
		this.recumendacao1 = recumendacao1;
	}


	public String getExtenso() {
		return extenso;
	}


	public void setExtenso(String extenso) {
		this.extenso = extenso;
	}


	public String getDatahoravenda() {
		return datahoravenda;
	}


	public void setDatahoravenda(String datahoravenda) {
		this.datahoravenda = datahoravenda;
	}


	public String getAssistente() {
		return assistente;
	}


	public void setAssistente(String assistente) {
		this.assistente = assistente;
	}


	public List<faturaReciboContainer> getFaturaReciboContainer() {
		return faturaReciboContainer;
	}


	public void setFaturaReciboContainer(
			List<faturaReciboContainer> faturaReciboContainer) {
		this.faturaReciboContainer = faturaReciboContainer;
	}

	

	public String getValor_unitario() {
		return valor_unitario;
	}


	public void setValor_unitario(String valor_unitario) {
		this.valor_unitario = valor_unitario;
	}


	public String getIva() {
		return iva;
	}


	public void setIva(String iva) {
		this.iva = iva;
	}


	public String getDesconto() {
		return desconto;
	}


	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}


	public String getCol_1tituloServico() {
		return col_1tituloServico;
	}


	public void setCol_1tituloServico(String col_1tituloServico) {
		this.col_1tituloServico = col_1tituloServico;
	}

	public String getCol_1desServico() {
		return col_1desServico;
	}

	public void setCol_1desServico(String col_1desServico) {
		this.col_1desServico = col_1desServico;
	}


	public String getCol_1image() {
		return col_1image;
	}


	public void setCol_1image(String col_1image2) {
		this.col_1image = col_1image2;
	}





	public String getCol_1desServicoBundle() {
		return col_1desServicoBundle;
	}





	public void setCol_1desServicoBundle(String col_1desServicoBundle) {
		this.col_1desServicoBundle = col_1desServicoBundle;
	}





	public String getCol_2quantidade() {
		return col_2quantidade;
	}





	public void setCol_2quantidade(String col_2quantidade) {
		this.col_2quantidade = col_2quantidade;
	}





	public String getCol_2quantidadeBundle() {
		return col_2quantidadeBundle;
	}





	public void setCol_2quantidadeBundle(String col_2quantidadeBundle) {
		this.col_2quantidadeBundle = col_2quantidadeBundle;
	}





	public String getCol_5tatal() {
		return col_5tatal;
	}





	public void setCol_5tatal(String col_5tatal) {
		this.col_5tatal = col_5tatal;
	}





	public String getCol_5tatalBundle() {
		return col_5tatalBundle;
	}





	public void setCol_5tatalBundle(String col_5tatalBundle) {
		this.col_5tatalBundle = col_5tatalBundle;
	}





	public String getCol_5iva() {
		return col_5iva;
	}





	public void setCol_5iva(String col_5iva) {
		this.col_5iva = col_5iva;
	}





	public String getCol_5totalEuro() {
		return col_5totalEuro;
	}





	public void setCol_5totalEuro(String col_5totalEuro) {
		this.col_5totalEuro = col_5totalEuro;
	}





	public String getCol_5ivaDesc() {
		return col_5ivaDesc;
	}





	public void setCol_5ivaDesc(String col_5ivaDesc) {
		this.col_5ivaDesc = col_5ivaDesc;
	}





	public String getTotal_col5() {
		return total_col5;
	}





	public void setTotal_col5(String total_col5) {
		this.total_col5 = total_col5;
	}





	public String getCol_5totaliva_ultimo() {
		return col_5totaliva_ultimo;
	}





	public void setCol_5totaliva_ultimo(String col_5totaliva_ultimo) {
		this.col_5totaliva_ultimo = col_5totaliva_ultimo;
	}





	public String getCol_5desciva_ultimo() {
		return col_5desciva_ultimo;
	}





	public void setCol_5desciva_ultimo(String col_5desciva_ultimo) {
		this.col_5desciva_ultimo = col_5desciva_ultimo;
	}





	public String getTaxa() {
		return taxa;
	}





	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}





	public String getIncidencia() {
		return incidencia;
	}

	public String getSub_total() {
		return sub_total;
	}



	public void setSub_total(String sub_total) {
		this.sub_total = sub_total;
	}



	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}





	public String getImposto() {
		return imposto;
	}





	public void setImposto(String imposto) {
		this.imposto = imposto;
	}





	public String getTotalIva() {
		return totalIva;
	}





	public void setTotalIva(String totalIva) {
		this.totalIva = totalIva;
	}
	

}
