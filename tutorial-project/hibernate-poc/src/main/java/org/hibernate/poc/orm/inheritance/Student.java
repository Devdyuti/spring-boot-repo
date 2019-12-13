package org.hibernate.poc.orm.inheritance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name="student")
@Table(name="tutorial.student")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="stype", discriminatorType=DiscriminatorType.STRING, length=20)
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4602963205831843571L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String name;
	@Column(name="roll", unique=true, columnDefinition="varchar(64)")
	private String roll;
	@Column(name="phone", unique=true, columnDefinition="varchar(15)")
	private String phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Student(int id, String name, String roll, String phone) {
		super();
		this.id=id;
		this.name = name;
		this.roll = roll;
		this.phone = phone;
	}
	
	
	
	
}
