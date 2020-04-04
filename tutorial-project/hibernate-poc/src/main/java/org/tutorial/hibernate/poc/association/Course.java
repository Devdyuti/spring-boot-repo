package org.tutorial.hibernate.poc.association;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tutorial.course")
public class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3780250830526563729L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String cname;
	private int cfee;
	
	//private List<Faculty> faculties;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCfee() {
		return cfee;
	}

	public void setCfee(int cfee) {
		this.cfee = cfee;
	}

//	public List<Faculty> getFaculties() {
//		return faculties;
//	}
//
//	public void setFaculties(List<Faculty> faculties) {
//		this.faculties = faculties;
//	}

	public Course(int cid, String cname, int cfee) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cfee = cfee;
	}
	
	

}
