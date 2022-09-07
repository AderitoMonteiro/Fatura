package com.model.recibo;

public class revenueDetail {
	
	
	String docDeb;
	String docCred;
	String totalAmountCred;
	String totalAmountDeb;
	
	public revenueDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public revenueDetail(String docDeb, String docCred, String totalAmountCred,
			String totalAmountDeb) {
		super();
		this.docDeb = docDeb;
		this.docCred = docCred;
		this.totalAmountCred = totalAmountCred;
		this.totalAmountDeb = totalAmountDeb;
	}

	public String getDocDeb() {
		return docDeb;
	}

	public void setDocDeb(String docDeb) {
		this.docDeb = docDeb;
	}

	public String getDocCred() {
		return docCred;
	}

	public void setDocCred(String docCred) {
		this.docCred = docCred;
	}

	public String getTotalAmountCred() {
		return totalAmountCred;
	}

	public void setTotalAmountCred(String totalAmountCred) {
		this.totalAmountCred = totalAmountCred;
	}

	public String getTotalAmountDeb() {
		return totalAmountDeb;
	}

	public void setTotalAmountDeb(String totalAmountDeb) {
		this.totalAmountDeb = totalAmountDeb;
	}

	
}
