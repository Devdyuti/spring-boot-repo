package org.hibernate.poc.orm.inheritance;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="javastudent")
@Table(name="tutorial.student")
@DiscriminatorValue("js")
public class JavaStudent extends Student implements Serializable{
	
	public JavaStudent(int id, String name, String roll, String phone, String tool) {
		super(id, name, roll, phone);
		this.tool=tool;
		// TODO Auto-generated constructor stub
	}

	private String tool;

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5831526166585413167L;

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}
	
	
	
}
