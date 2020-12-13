package com.entity.layer1;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADMININPUTS database table.
 * 
 */
@Entity
@Table(name="ADMININPUTS")
@NamedQuery(name="Admininput.findAll", query="SELECT a FROM Admininput a")
public class Admininput implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String adminuserid;

	private String adminname;

	private String adminpassword;

	public Admininput() {
	}

	public String getAdminuserid() {
		return this.adminuserid;
	}

	public void setAdminuserid(String adminuserid) {
		this.adminuserid = adminuserid;
	}

	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return this.adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

}