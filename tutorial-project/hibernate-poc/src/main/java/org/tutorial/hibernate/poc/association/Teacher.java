package org.tutorial.hibernate.poc.association;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.JoinType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="teacher")
@Table(name="tutorial.teacher")
public class Teacher implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6404129292549864688L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teacher_id;
	private String name;
	
	@OneToMany(mappedBy = "teacher")
	@Fetch(FetchMode.JOIN)
	private List<Topic> topics;
		
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	public Teacher(int teacher_id, String name) {
		super();
		this.teacher_id = teacher_id;
		this.name = name;
	}
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
