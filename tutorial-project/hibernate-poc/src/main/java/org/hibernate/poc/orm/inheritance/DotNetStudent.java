package org.hibernate.poc.orm.inheritance;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="dotnetstudent")
@Table(name="tutorial.student")
@DiscriminatorValue("ds")
public class DotNetStudent extends Student implements Serializable{
	
	private double workingHr;

	public DotNetStudent(int id, String name, String roll, String phone, double workingHr) {
		super(id, name, roll, phone);
		this.workingHr=workingHr;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7164318306396533057L;

	public double getWorkingHr() {
		return workingHr;
	}

	public void setWorkingHr(double workingHr) {
		this.workingHr = workingHr;
	}

}
