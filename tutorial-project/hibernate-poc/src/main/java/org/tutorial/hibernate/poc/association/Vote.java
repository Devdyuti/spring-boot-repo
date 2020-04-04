package org.tutorial.hibernate.poc.association;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="vote")
@Table(name="tutorial.vote")

public class Vote implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1645019493570348280L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int vtid;
	private String paty_name;
	private Date cdate;
	@OneToOne(cascade=CascadeType.ALL)
	private Voter voter;
	
	public int getVtid() {
		return vtid;
	}
	public void setVtid(int vtid) {
		this.vtid = vtid;
	}
	public String getPaty_name() {
		return paty_name;
	}
	public void setPaty_name(String paty_name) {
		this.paty_name = paty_name;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Voter getVoter() {
		return voter;
	}
	public void setVoter(Voter voter) {
		this.voter = voter;
	}
	public Vote(String paty_name, Date cdate) {
		super();
		this.paty_name = paty_name;
		this.cdate = cdate;
	}
	
	
	
}
