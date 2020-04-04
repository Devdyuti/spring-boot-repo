package org.tutorial.hibernate.poc.association;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections.functors.FalsePredicate;

@Entity(name="pgstudent")
@Table(name="tutorial.pgstudent")
public class PGStudent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6381729360522774586L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	private String sname;

	
	@ManyToOne
	@JoinColumn(name="aid", nullable=false)
	private Address address;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public PGStudent(int sid, String sname, Address address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.address=address;
	}
	
	
	
	
}