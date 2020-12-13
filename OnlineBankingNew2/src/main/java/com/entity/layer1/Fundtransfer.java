package com.entity.layer1;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FUNDTRANSFER database table.
 * 
 */
@Entity
@NamedQuery(name="Fundtransfer.findAll", query="SELECT f FROM Fundtransfer f")
public class Fundtransfer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TRANSAC_ID")
	private long transacId;

	private int amount;

	@Column(name="FROM_ACCNO")
	private String fromAccno;

	@Column(name="TO_ACCNO")
	private String toAccno;

	@Temporal(TemporalType.DATE)
	@Column(name="TRANSAC_DATE")
	private Date transacDate;

	@Column(name="TRANSAC_MODE")
	private String transacMode;

	public Fundtransfer() {
	}

	public long getTransacId() {
		return this.transacId;
	}

	public void setTransacId(long transacId) {
		this.transacId = transacId;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getFromAccno() {
		return this.fromAccno;
	}

	public void setFromAccno(String fromAccno) {
		this.fromAccno = fromAccno;
	}

	public String getToAccno() {
		return this.toAccno;
	}

	public void setToAccno(String toAccno) {
		this.toAccno = toAccno;
	}

	public Date getTransacDate() {
		return this.transacDate;
	}

	public void setTransacDate(Date transacDate) {
		this.transacDate = transacDate;
	}

	public String getTransacMode() {
		return this.transacMode;
	}

	public void setTransacMode(String transacMode) {
		this.transacMode = transacMode;
	}

}