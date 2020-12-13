package com.entity.layer1;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the LOGINDETAILS database table.
 * 
 */
@Entity
@Table(name="LOGINDETAILS")
@NamedQuery(name="Logindetail.findAll", query="SELECT l FROM Logindetail l")
public class Logindetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userid;

	private String lastlogin;

	@Column(name="LOGIN_PASSWORD")
	private String loginPassword;

	private int numberofinvalidattempts;

	@Column(name="TRANSACTION_PASSWORD")
	private String transactionPassword;

	//bi-directional many-to-one association to Userdetail
//	@ManyToOne
//	@JoinColumn(name="ACCOUNTNUMBER")
//	private Userdetail userdetail1;

	//bi-directional one-to-one association to Userdetail
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="ACCOUNTNUMBER")
   	private Userdetail userdetail2;

	public Logindetail() {
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLastlogin() {
		return this.lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public int getNumberofinvalidattempts() {
		return this.numberofinvalidattempts;
	}

	public void setNumberofinvalidattempts(int numberofinvalidattempts) {
		this.numberofinvalidattempts = numberofinvalidattempts;
	}

	public String getTransactionPassword() {
		return this.transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

//	public Userdetail getUserdetail1() {
//		return this.userdetail1;
//	}

//	public void setUserdetail1(Userdetail userdetail1) {
//		this.userdetail1 = userdetail1;
//	}

	public Userdetail getUserdetail2() {
		return this.userdetail2;
}

	public void setUserdetail2(Userdetail userdetail2) {
		this.userdetail2 = userdetail2;
	}

}