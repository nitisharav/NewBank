package com.entity.layer1;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PAYEEDETAILS database table.
 * 
 */
@Entity
@Table(name="PAYEEDETAILS")
@NamedQuery(name="Payeedetail.findAll", query="SELECT p FROM Payeedetail p")
public class Payeedetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String payeeid;

	private String payeeaccountnumber;

	private String payeename;

	private String useraccountnumber;

	public Payeedetail() {
	}

	public String getPayeeid() {
		return this.payeeid;
	}

	public void setPayeeid(String payeeid) {
		this.payeeid = payeeid;
	}

	public String getPayeeaccountnumber() {
		return this.payeeaccountnumber;
	}

	public void setPayeeaccountnumber(String payeeaccountnumber) {
		this.payeeaccountnumber = payeeaccountnumber;
	}

	public String getPayeename() {
		return this.payeename;
	}

	public void setPayeename(String payeename) {
		this.payeename = payeename;
	}

	public String getUseraccountnumber() {
		return this.useraccountnumber;
	}

	public void setUseraccountnumber(String useraccountnumber) {
		this.useraccountnumber = useraccountnumber;
	}

}