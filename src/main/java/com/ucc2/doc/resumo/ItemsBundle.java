package com.ucc2.doc.resumo;

public class ItemsBundle {

	private String ProdutoTitulo;
	private String ProdutoDescricao;
	private byte []  ProdutoImagem;
	private String ValorQuantidadeValue;
	private String ValorQuantidadeUnidade;
	private String ValorBaseValue;
	private String ValorBaseUnidade;
	private String ExtraValue;
	private String TotalValueSemIva;
	private String TotalComIva;
	private String TotalUnidade;
	private String totalEuro;
	private String vaDesc;
	private String valorMes;
	private String valorBruto;
	private String valorRond;
	private String Taxa;
	private String desconto;
	private String total;
	
	public ItemsBundle() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ItemsBundle(String produtoTitulo, String produtoDescricao,
			byte[] produtoImagem, String valorQuantidadeValue,
			String valorQuantidadeUnidade, String valorBaseValue,
			String valorBaseUnidade, String extraValue,
			String totalValueSemIva, String totalComIva, String totalUnidade,
			String totalEuro, String vaDesc, String valorMes,
			String valorBruto, String valorRond, String taxa, String desconto,
			String total) {
		super();
		ProdutoTitulo = produtoTitulo;
		ProdutoDescricao = produtoDescricao;
		ProdutoImagem = produtoImagem;
		ValorQuantidadeValue = valorQuantidadeValue;
		ValorQuantidadeUnidade = valorQuantidadeUnidade;
		ValorBaseValue = valorBaseValue;
		ValorBaseUnidade = valorBaseUnidade;
		ExtraValue = extraValue;
		TotalValueSemIva = totalValueSemIva;
		TotalComIva = totalComIva;
		TotalUnidade = totalUnidade;
		this.totalEuro = totalEuro;
		this.vaDesc = vaDesc;
		this.valorMes = valorMes;
		this.valorBruto = valorBruto;
		this.valorRond = valorRond;
		Taxa = taxa;
		this.desconto = desconto;
		this.total = total;
	}


	public String getDesconto() {
		return desconto;
	}


	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public String getProdutoTitulo() {
		return ProdutoTitulo;
	}

	public void setProdutoTitulo(String produtoTitulo) {
		ProdutoTitulo = produtoTitulo;
	}

	public String getProdutoDescricao() {
		return ProdutoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		ProdutoDescricao = produtoDescricao;
	}

	public byte[] getProdutoImagem() {
		return ProdutoImagem;
	}

	public void setProdutoImagem(byte[] produtoImagem) {
		ProdutoImagem = produtoImagem;
	}

	public String getValorQuantidadeValue() {
		return ValorQuantidadeValue;
	}

	public void setValorQuantidadeValue(String valorQuantidadeValue) {
		ValorQuantidadeValue = valorQuantidadeValue;
	}

	public String getValorQuantidadeUnidade() {
		return ValorQuantidadeUnidade;
	}

	public void setValorQuantidadeUnidade(String valorQuantidadeUnidade) {
		ValorQuantidadeUnidade = valorQuantidadeUnidade;
	}

	public String getValorBaseValue() {
		return ValorBaseValue;
	}

	public void setValorBaseValue(String valorBaseValue) {
		ValorBaseValue = valorBaseValue;
	}

	public String getValorBaseUnidade() {
		return ValorBaseUnidade;
	}

	public void setValorBaseUnidade(String valorBaseUnidade) {
		ValorBaseUnidade = valorBaseUnidade;
	}

	public String getExtraValue() {
		return ExtraValue;
	}

	public void setExtraValue(String extraValue) {
		ExtraValue = extraValue;
	}

	public String getTotalValueSemIva() {
		return TotalValueSemIva;
	}

	public void setTotalValueSemIva(String totalValueSemIva) {
		TotalValueSemIva = totalValueSemIva;
	}

	public String getTotalComIva() {
		return TotalComIva;
	}

	public void setTotalComIva(String totalComIva) {
		TotalComIva = totalComIva;
	}

	public String getTotalUnidade() {
		return TotalUnidade;
	}

	public void setTotalUnidade(String totalUnidade) {
		TotalUnidade = totalUnidade;
	}

	public String getTotalEuro() {
		return totalEuro;
	}

	public void setTotalEuro(String totalEuro) {
		this.totalEuro = totalEuro;
	}

	public String getVaDesc() {
		return vaDesc;
	}

	public void setVaDesc(String vaDesc) {
		this.vaDesc = vaDesc;
	}

	public String getValorMes() {
		return valorMes;
	}

	public void setValorMes(String valorMes) {
		this.valorMes = valorMes;
	}

	public String getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(String valorBruto) {
		this.valorBruto = valorBruto;
	}

	public String getValorRond() {
		return valorRond;
	}

	public void setValorRond(String valorRond) {
		this.valorRond = valorRond;
	}

	public String getTaxa() {
		return Taxa;
	}

	public void setTaxa(String taxa) {
		Taxa = taxa;
	}
	
	
}
