package org.tutorial.hibernate.poc.association;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tutorial.faculty")
public class Faculty implements Serializable{
// tutorial is schema here
	/**
	 * 
	 */
	private static final long serialVersionUID = 6510180892945362330L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int fid;
	private String fname;
	private int fexp;
	
	// inverse for the Bidirectional relationship
	@ManyToMany(targetEntity=Course.class, cascade=CascadeType.ALL)
	@JoinTable(name="tutorial.facultycourse", joinColumns= {@JoinColumn(name="fid")},inverseJoinColumns= {@JoinColumn(name="cid")})
	private Set<Course> courses;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getFexp() {
		return fexp;
	}

	public void setFexp(int fexp) {
		this.fexp = fexp;
	}


	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Faculty(int fid, String fname, int fexp) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fexp = fexp;
	}
	
	
	
	
	
}
