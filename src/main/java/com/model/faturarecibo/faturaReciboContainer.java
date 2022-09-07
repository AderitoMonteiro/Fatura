package com.model.faturarecibo;

import java.awt.Image;
import java.util.ArrayList;

import antlr.collections.List;

import com.ucc2.doc.resumo.ItemsBundle;

public class faturaReciboContainer {

	
	String col_1tituloServico;
	String col_1desServico;
	private Image col_1image;
	String col_1aux1;
	String col_1aux2;
	String col_1aux3;
	String col_2quantidade;
	String col_2aux1;
	String col_2aux2;
	String col_2aux3;
	String col_3valorBase;
	String col_3aux1;
	String col_3aux2;
	String col_3aux3;
	String col_4extra;
	String col_4extraDesc;
	String col_4moeda;
	String col_4aux1;
	String col_4aux2;
	String col_4aux3;
	String col_5tatal;
	String col_5iva;
	String col_5aux1;
	String col_5aux2;
	String col_5aux3;
	String col_5totalEuro;
	String col_5ivaDesc;
	String total_col5;
	String col_5valBruto;
	String col_5valRond;
	String total_col3;
	String total_col4;
	String col_5totaliva_ultimo;
	String col_5desciva_ultimo;
	String taxa;
	String incidencia;
	String imposto;
	String totalIva;
	String valorespace;
	
	
	String col_1desServicoBundle;
	String col_2quantidadeBundle;
	String col_5tatalBundle;
	
	String valor_unitario;
	String iva;
	String desconto;
	String sub_total;
	String sub_totalR;
	String ivaR;
	String total;
	String totalR;
	String descontoR;
	
	String total_euroR;
	String total_subtotal;
	String nome_cliente;
	String data_fatura;
	String data_vencimento;
	String total2;
	String col_5iva2;
	String col_5iva3;
	String col_5iva4;

	
	ArrayList <ItemsBundle> itemsBundle = new ArrayList();
	
	public faturaReciboContainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public faturaReciboContainer(String col_1tituloServico,
			String col_1desServico, Image col_1image, String col_1aux1,
			String col_1aux2, String col_1aux3, String col_2quantidade,
			String col_2aux1, String col_2aux2, String col_2aux3,
			String col_3valorBase, String col_3aux1, String col_3aux2,
			String col_3aux3, String col_4extra, String col_4extraDesc,
			String col_4moeda, String col_4aux1, String col_4aux2,
			String col_4aux3, String col_5tatal, String col_5iva,
			String col_5aux1, String col_5aux2, String col_5aux3,
			String col_5totalEuro, String col_5ivaDesc, String total_col5,
			String col_5valBruto, String col_5valRond, String total_col3,
			String total_col4, String col_5totaliva_ultimo,
			String col_5desciva_ultimo, String taxa, String incidencia,
			String imposto, String totalIva, String valorespace,
			String col_1desServicoBundle, String col_2quantidadeBundle,
			String col_5tatalBundle, String valor_unitario, String iva,
			String desconto, String sub_total, String sub_totalR, String ivaR,
			String total, String totalR, String descontoR, String total_euroR,
			String total_subtotal, String nome_cliente, String data_fatura,
			String data_vencimento, String total2, String col_5iva2,
			String col_5iva3, String col_5iva4,
			ArrayList<ItemsBundle> itemsBundle) {
		super();
		this.col_1tituloServico = col_1tituloServico;
		this.col_1desServico = col_1desServico;
		this.col_1image = col_1image;
		this.col_1aux1 = col_1aux1;
		this.col_1aux2 = col_1aux2;
		this.col_1aux3 = col_1aux3;
		this.col_2quantidade = col_2quantidade;
		this.col_2aux1 = col_2aux1;
		this.col_2aux2 = col_2aux2;
		this.col_2aux3 = col_2aux3;
		this.col_3valorBase = col_3valorBase;
		this.col_3aux1 = col_3aux1;
		this.col_3aux2 = col_3aux2;
		this.col_3aux3 = col_3aux3;
		this.col_4extra = col_4extra;
		this.col_4extraDesc = col_4extraDesc;
		this.col_4moeda = col_4moeda;
		this.col_4aux1 = col_4aux1;
		this.col_4aux2 = col_4aux2;
		this.col_4aux3 = col_4aux3;
		this.col_5tatal = col_5tatal;
		this.col_5iva = col_5iva;
		this.col_5aux1 = col_5aux1;
		this.col_5aux2 = col_5aux2;
		this.col_5aux3 = col_5aux3;
		this.col_5totalEuro = col_5totalEuro;
		this.col_5ivaDesc = col_5ivaDesc;
		this.total_col5 = total_col5;
		this.col_5valBruto = col_5valBruto;
		this.col_5valRond = col_5valRond;
		this.total_col3 = total_col3;
		this.total_col4 = total_col4;
		this.col_5totaliva_ultimo = col_5totaliva_ultimo;
		this.col_5desciva_ultimo = col_5desciva_ultimo;
		this.taxa = taxa;
		this.incidencia = incidencia;
		this.imposto = imposto;
		this.totalIva = totalIva;
		this.valorespace = valorespace;
		this.col_1desServicoBundle = col_1desServicoBundle;
		this.col_2quantidadeBundle = col_2quantidadeBundle;
		this.col_5tatalBundle = col_5tatalBundle;
		this.valor_unitario = valor_unitario;
		this.iva = iva;
		this.desconto = desconto;
		this.sub_total = sub_total;
		this.sub_totalR = sub_totalR;
		this.ivaR = ivaR;
		this.total = total;
		this.totalR = totalR;
		this.descontoR = descontoR;
		this.total_euroR = total_euroR;
		this.total_subtotal = total_subtotal;
		this.nome_cliente = nome_cliente;
		this.data_fatura = data_fatura;
		this.data_vencimento = data_vencimento;
		this.total2 = total2;
		this.col_5iva2 = col_5iva2;
		this.col_5iva3 = col_5iva3;
		this.col_5iva4 = col_5iva4;
		this.itemsBundle = itemsBundle;
	}





	public String getTotal_euroR() {
		return total_euroR;
	}

	public void setTotal_euroR(String total_euroR) {
		this.total_euroR = total_euroR;
	}



	public ArrayList<ItemsBundle> getItemsBundle() {
		return itemsBundle;
	}


	public void setItemsBundle(ArrayList<ItemsBundle> itemsBundle) {
		this.itemsBundle = itemsBundle;
	}

	public String getCol_5iva2() {
		return col_5iva2;
	}

	public void setCol_5iva2(String col_5iva2) {
		this.col_5iva2 = col_5iva2;
	}

	public String getCol_5iva3() {
		return col_5iva3;
	}

	public void setCol_5iva3(String col_5iva3) {
		this.col_5iva3 = col_5iva3;
	}

	public String getCol_5iva4() {
		return col_5iva4;
	}

	public void setCol_5iva4(String col_5iva4) {
		this.col_5iva4 = col_5iva4;
	}

	public void setCol_5iva14(String col_5iva14) {
		this.col_5iva4 = col_5iva14;
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

	public String getDescontoR() {
		return descontoR;
	}

	public void setDescontoR(String descontoR) {
		this.descontoR = descontoR;
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



	public String getTotal2() {
		return total2;
	}



	public void setTotal2(String total2) {
		this.total2 = total2;
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

	public Image getCol_1image() {
		return col_1image;
	}

	
	public String getNome_cliente() {
		return nome_cliente;
	}




	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}




	public String getData_fatura() {
		return data_fatura;
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




	public void setCol_1image(Image col_1image) {
		this.col_1image = col_1image;
	}

	public String getCol_1aux1() {
		return col_1aux1;
	}

	public void setCol_1aux1(String col_1aux1) {
		this.col_1aux1 = col_1aux1;
	}

	public String getCol_1aux2() {
		return col_1aux2;
	}

	public void setCol_1aux2(String col_1aux2) {
		this.col_1aux2 = col_1aux2;
	}

	public String getCol_1aux3() {
		return col_1aux3;
	}

	public void setCol_1aux3(String col_1aux3) {
		this.col_1aux3 = col_1aux3;
	}

	public String getCol_2quantidade() {
		return col_2quantidade;
	}

	public void setCol_2quantidade(String col_2quantidade) {
		this.col_2quantidade = col_2quantidade;
	}

	public String getCol_2aux1() {
		return col_2aux1;
	}

	public void setCol_2aux1(String col_2aux1) {
		this.col_2aux1 = col_2aux1;
	}

	public String getCol_2aux2() {
		return col_2aux2;
	}

	public void setCol_2aux2(String col_2aux2) {
		this.col_2aux2 = col_2aux2;
	}

	public String getCol_2aux3() {
		return col_2aux3;
	}

	public void setCol_2aux3(String col_2aux3) {
		this.col_2aux3 = col_2aux3;
	}

	public String getCol_3valorBase() {
		return col_3valorBase;
	}

	public void setCol_3valorBase(String col_3valorBase) {
		this.col_3valorBase = col_3valorBase;
	}

	public String getCol_3aux1() {
		return col_3aux1;
	}

	public void setCol_3aux1(String col_3aux1) {
		this.col_3aux1 = col_3aux1;
	}

	public String getCol_3aux2() {
		return col_3aux2;
	}

	public void setCol_3aux2(String col_3aux2) {
		this.col_3aux2 = col_3aux2;
	}

	public String getCol_3aux3() {
		return col_3aux3;
	}

	public void setCol_3aux3(String col_3aux3) {
		this.col_3aux3 = col_3aux3;
	}

	public String getCol_4extra() {
		return col_4extra;
	}

	public void setCol_4extra(String col_4extra) {
		this.col_4extra = col_4extra;
	}

	public String getCol_4extraDesc() {
		return col_4extraDesc;
	}

	public void setCol_4extraDesc(String col_4extraDesc) {
		this.col_4extraDesc = col_4extraDesc;
	}

	public String getCol_4moeda() {
		return col_4moeda;
	}

	public void setCol_4moeda(String col_4moeda) {
		this.col_4moeda = col_4moeda;
	}

	public String getCol_4aux1() {
		return col_4aux1;
	}

	public void setCol_4aux1(String col_4aux1) {
		this.col_4aux1 = col_4aux1;
	}

	public String getCol_4aux2() {
		return col_4aux2;
	}

	public void setCol_4aux2(String col_4aux2) {
		this.col_4aux2 = col_4aux2;
	}

	public String getCol_4aux3() {
		return col_4aux3;
	}

	public void setCol_4aux3(String col_4aux3) {
		this.col_4aux3 = col_4aux3;
	}

	public String getCol_5tatal() {
		return col_5tatal;
	}

	public void setCol_5tatal(String col_5tatal) {
		this.col_5tatal = col_5tatal;
	}

	public String getCol_5iva() {
		return col_5iva;
	}

	public void setCol_5iva(String col_5iva) {
		this.col_5iva = col_5iva;
	}

	public String getCol_5aux1() {
		return col_5aux1;
	}

	public void setCol_5aux1(String col_5aux1) {
		this.col_5aux1 = col_5aux1;
	}

	public String getCol_5aux2() {
		return col_5aux2;
	}

	public void setCol_5aux2(String col_5aux2) {
		this.col_5aux2 = col_5aux2;
	}

	public String getCol_5aux3() {
		return col_5aux3;
	}

	public void setCol_5aux3(String col_5aux3) {
		this.col_5aux3 = col_5aux3;
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

	public String getCol_5valBruto() {
		return col_5valBruto;
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


	public void setCol_5valBruto(String col_5valBruto) {
		this.col_5valBruto = col_5valBruto;
	}

	public String getCol_5valRond() {
		return col_5valRond;
	}

	public void setCol_5valRond(String col_5valRond) {
		this.col_5valRond = col_5valRond;
	}

	public String getTotal_col3() {
		return total_col3;
	}

	public void setTotal_col3(String total_col3) {
		this.total_col3 = total_col3;
	}

	public String getTotal_col4() {
		return total_col4;
	}

	public void setTotal_col4(String total_col4) {
		this.total_col4 = total_col4;
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

	public String getValorespace() {
		return valorespace;
	}

	public void setValorespace(String valorespace) {
		this.valorespace = valorespace;
	}

	public String getCol_1desServicoBundle() {
		return col_1desServicoBundle;
	}

	public void setCol_1desServicoBundle(String col_1desServicoBundle) {
		this.col_1desServicoBundle = col_1desServicoBundle;
	}

	public String getCol_2quantidadeBundle() {
		return col_2quantidadeBundle;
	}

	public void setCol_2quantidadeBundle(String col_2quantidadeBundle) {
		this.col_2quantidadeBundle = col_2quantidadeBundle;
	}

	public String getTotal_subtotal() {
		return total_subtotal;
	}






	public void setTotal_subtotal(String total_subtotal) {
		this.total_subtotal = total_subtotal;
	}






	public String getSub_total() {
		return sub_total;
	}


	public void setSub_total(String sub_total) {
		this.sub_total = sub_total;
	}


	public String getCol_5tatalBundle() {
		return col_5tatalBundle;
	}

	public void setCol_5tatalBundle(String col_5tatalBundle) {
		this.col_5tatalBundle = col_5tatalBundle;
	}


	
}
