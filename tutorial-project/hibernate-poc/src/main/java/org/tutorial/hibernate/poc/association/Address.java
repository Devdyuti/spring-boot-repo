package org.tutorial.hibernate.poc.association;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="address")
@Table(name="tutorial.address")
class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1044845807412191016L;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAddname() {
		return addname;
	}
	public void setAddname(String addname) {
		this.addname = addname;
	}
	
	public List<PGStudent> getStudents() {
		return students;
	}
	public void setStudents(List<PGStudent> students) {
		this.students = students;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	private String addname;
	@javax.persistence.ManyToOne(cascade = CascadeType.ALL)
	private List<PGStudent> students;

	public Address(int aid, String addname) {
		super();
		this.aid = aid;
		this.addname = addname;
	}
	
	
}
