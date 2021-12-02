package org.tutorial.hibernate.poc.association;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name="topic")
@Table(name="tutorial.topic")
public class Topic implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5220493973322115976L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tid;
	@Column(name="tname", unique = true)
	private String tname;
	private int tduration;
	
	@ManyToOne
	@JoinColumn(name="teacher_id", nullable = false)
//	@Cascade(CascadeType.ALL)
	private Teacher teacher;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTduration() {
		return tduration;
	}
	public void setTduration(int tduration) {
		this.tduration = tduration;
	}
	public Topic(int tid, String tname, int tduration, Teacher teacher) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tduration = tduration;
		this.teacher=teacher;
	}
	
	public Topic() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
