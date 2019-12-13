package org.hibernate.poc.orm.inheritance;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity(name="phpstudent")
@Table(name="tutorial.phpstudent")
@DiscriminatorValue("ps")
public class PhpStudent extends Student implements Serializable{
	
	private String branch;

	public PhpStudent(int id, String name, String roll, String phone, String branch) {
		super(id, name, roll, phone);
		this.branch=branch;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2990142958929924723L;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
}
