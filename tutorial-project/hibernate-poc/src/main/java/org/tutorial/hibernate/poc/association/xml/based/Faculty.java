package org.tutorial.hibernate.poc.association.xml.based;


import java.util.Set;

public class Faculty{

	private long id;
	private String fname;
	private long fexp;
	
	private Set<Course> courses;
	
	






	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getFname() {
		return fname;
	}




	public void setFname(String fname) {
		this.fname = fname;
	}




	public long getFexp() {
		return fexp;
	}




	public void setFexp(long fexp) {
		this.fexp = fexp;
	}




	public Set<Course> getCourses() {
		return courses;
	}




	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}




	public Faculty(long id,String fname, long fexp) {
		this.id=id;
		this.fname = fname;
		this.fexp = fexp;
	}
	
	
	
	
	
}
