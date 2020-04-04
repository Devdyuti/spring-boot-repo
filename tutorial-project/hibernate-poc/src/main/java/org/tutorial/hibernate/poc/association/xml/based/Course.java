package org.tutorial.hibernate.poc.association.xml.based;

import java.util.Set;

public class Course{
	
	private long id;
	private String cname;
	private long cfee;
	
	private Set<Faculty> faculties;

	




	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}



	public long getCfee() {
		return cfee;
	}



	public void setCfee(long cfee) {
		this.cfee = cfee;
	}



	public Set<Faculty> getFaculties() {
		return faculties;
	}



	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}



	public Course(long id,String cname, long cfee) {
		this.id=id;
		this.cname = cname;
		this.cfee = cfee;
	}
	
	

}
