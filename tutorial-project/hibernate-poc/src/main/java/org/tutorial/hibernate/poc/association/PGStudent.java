package org.tutorial.hibernate.poc.association;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	public PGStudent(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}
	
	
	
	
}