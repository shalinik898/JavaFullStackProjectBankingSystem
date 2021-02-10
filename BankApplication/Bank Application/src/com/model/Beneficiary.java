package com.model;

public class Beneficiary {
	private String beneficiaryname;
	private String beneficiaryaccno;
	private String beneficiarybranch;
	private String beneficiaryamount;
	public String getBeneficiarybranch() {
		return beneficiarybranch;
	}
	public void setBeneficiarybranch(String beneficiarybranch) {
		this.beneficiarybranch = beneficiarybranch;
	}
	public String getBeneficiaryname() {
		return beneficiaryname;
	}
	public String getBeneficiaryamount() {
		return beneficiaryamount;
	}
	public void setBeneficiaryamount(String beneficiaryamount) {
		this.beneficiaryamount = beneficiaryamount;
	}
	public void setBeneficiaryname(String beneficiaryname) {
		this.beneficiaryname = beneficiaryname;
	}
	public String getBeneficiaryaccno() {
		return beneficiaryaccno;
	}
	public void setBeneficiaryaccno(String beneficiaryaccno) {
		this.beneficiaryaccno = beneficiaryaccno;
	}
	
}
