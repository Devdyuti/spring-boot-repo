package org.tutorial.hibernate.poc.association;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="voter")
@Table(name="tutorial.voter")
public class Voter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -798942857052784936L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int vid;
	private String name;
	private int age;
	
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Voter(int vid, String name, int age) {
		super();
		this.vid = vid;
		this.name = name;
		this.age = age;
	}
	
	
	
	
	
}
