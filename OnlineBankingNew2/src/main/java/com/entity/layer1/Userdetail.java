package com.entity.layer1;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USERDETAILS database table.
 * 
 */
@Entity
@Table(name="USERDETAILS")
@NamedQuery(name="Userdetail.findAll", query="SELECT u FROM Userdetail u")
public class Userdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String accountno;

	private String adharcard;

	private String adminremark;

	private String approvedbyadmin;

	private String dob;
	
	//public int getAccountBalance() {
	//	return accountBalance;
	//}

	//public void setAccountBalance(int accountBalance) {
	//	this.accountBalance = accountBalance;
	//}
	
	
   // @Column(name="account_balance")
	private int accountbalance;

	public int getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(int accountbalance) {
		this.accountbalance = accountbalance;
	}

	private String email;

	private String fathersname;

	private String firstname;

	private String grossannualincome;

	private String lastname;

	private String mobileno;

	private String occupationtype;

	private String permaddressline1;

	private String permaddressline2;

	private String permcity;

	private String permstate;

	private String permzipcode;

	private String presaddressline1;

	private String presaddressline2;

	private String prescity;

	private String presstate;

	private String preszipcode;

	private String referenceid;

	private String sourceofincome;

	//bi-directional many-to-one association to Logindetail
//	@OneToMany(mappedBy="userdetail1")
//	private List<Logindetail> logindetails;

	//bi-directional one-to-one association to Logindetail
//	@OneToOne
//	@JoinColumn(name="ACCOUNTNO", referencedColumnName="ACCOUNTNUMBER")
//	private Logindetail logindetail;

	public Userdetail() {
	}

	public String getAccountno() {
		return this.accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getAdharcard() {
		return this.adharcard;
	}

	public void setAdharcard(String adharcard) {
		this.adharcard = adharcard;
	}

	public String getAdminremark() {
		return this.adminremark;
	}

	public void setAdminremark(String adminremark) {
		this.adminremark = adminremark;
	}

	public String getApprovedbyadmin() {
		return this.approvedbyadmin;
	}

	public void setApprovedbyadmin(String approvedbyadmin) {
		this.approvedbyadmin = approvedbyadmin;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFathersname() {
		return this.fathersname;
	}

	public void setFathersname(String fathersname) {
		this.fathersname = fathersname;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGrossannualincome() {
		return this.grossannualincome;
	}

	public void setGrossannualincome(String grossannualincome) {
		this.grossannualincome = grossannualincome;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobileno() {
		return this.mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getOccupationtype() {
		return this.occupationtype;
	}

	public void setOccupationtype(String occupationtype) {
		this.occupationtype = occupationtype;
	}

	public String getPermaddressline1() {
		return this.permaddressline1;
	}

	public void setPermaddressline1(String permaddressline1) {
		this.permaddressline1 = permaddressline1;
	}

	public String getPermaddressline2() {
		return this.permaddressline2;
	}

	public void setPermaddressline2(String permaddressline2) {
		this.permaddressline2 = permaddressline2;
	}

	public String getPermcity() {
		return this.permcity;
	}

	public void setPermcity(String permcity) {
		this.permcity = permcity;
	}

	public String getPermstate() {
		return this.permstate;
	}

	public void setPermstate(String permstate) {
		this.permstate = permstate;
	}

	public String getPermzipcode() {
		return this.permzipcode;
	}

	public void setPermzipcode(String permzipcode) {
		this.permzipcode = permzipcode;
	}

	public String getPresaddressline1() {
		return this.presaddressline1;
	}

	public void setPresaddressline1(String presaddressline1) {
		this.presaddressline1 = presaddressline1;
	}

	public String getPresaddressline2() {
		return this.presaddressline2;
	}

	public void setPresaddressline2(String presaddressline2) {
		this.presaddressline2 = presaddressline2;
	}

	public String getPrescity() {
		return this.prescity;
	}

	public void setPrescity(String prescity) {
		this.prescity = prescity;
	}

	public String getPresstate() {
		return this.presstate;
	}

	public void setPresstate(String presstate) {
		this.presstate = presstate;
	}

	public String getPreszipcode() {
		return this.preszipcode;
	}

	public void setPreszipcode(String preszipcode) {
		this.preszipcode = preszipcode;
	}

	public String getReferenceid() {
		return this.referenceid;
	}

	public void setReferenceid(String referenceid) {
		this.referenceid = referenceid;
	}

	public String getSourceofincome() {
		return this.sourceofincome;
	}

	public void setSourceofincome(String sourceofincome) {
		this.sourceofincome = sourceofincome;
	}

//	public List<Logindetail> getLogindetails() {
//		return this.logindetails;
//	}

//	public void setLogindetails(List<Logindetail> logindetails) {
//		this.logindetails = logindetails;
//	}

//	public Logindetail addLogindetail(Logindetail logindetail) {
//		getLogindetails().add(logindetail);
	//	logindetail.setUserdetail1(this);

//		return logindetail;
//	}

//	public Logindetail removeLogindetail(Logindetail logindetail) {
//		getLogindetails().remove(logindetail);
//		logindetail.setUserdetail1(null);

	//	return logindetail;
	//}

	//public Logindetail getLogindetail() {
	//	return this.logindetail;
//	}

//	public void setLogindetail(Logindetail logindetail) {
//		this.logindetail = logindetail;
//	}

}