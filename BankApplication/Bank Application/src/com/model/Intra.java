package com.model;

public class Intra {
	
	private String beneficiaryaccno;
	private String senderaccno;
	private String amount;
	private String remark;
	private String payment_date;
	public String getBeneficiaryaccno() {
		return beneficiaryaccno;
	}
	public void setBeneficiaryaccno(String beneficiaryaccno) {
		this.beneficiaryaccno = beneficiaryaccno;
	}
	public String getSenderaccno() {
		return senderaccno;
	}
	public void setSenderaccno(String senderaccno) {
		this.senderaccno = senderaccno;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	
}
