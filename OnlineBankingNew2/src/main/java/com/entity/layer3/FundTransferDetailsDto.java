package com.entity.layer3;

public class FundTransferDetailsDto {
	 private String fromaccno;
	 private String toaccno;
	 private String fundmode;
	 private int balance;
	 private String tnpass;
	 
	 
	 
	public String getFromaccno() {
		return fromaccno;
	}
	public void setFromaccno(String fromaccno) {
		this.fromaccno = fromaccno;
	}
	public String getToaccno() {
		return toaccno;
	}
	public void setToaccno(String toaccno) {
		this.toaccno = toaccno;
	}
	public String getFundmode() {
		return fundmode;
	}
	public void setFundmode(String fundmode) {
		this.fundmode = fundmode;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getTnpass() {
		return tnpass;
	}
	public void setTnpass(String tnpass) {
		this.tnpass = tnpass;
	}
	 
	

}
