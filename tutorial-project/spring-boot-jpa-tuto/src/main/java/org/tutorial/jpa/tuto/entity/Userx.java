package org.tutorial.jpa.tuto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="tutorial.USERX")
public class Userx {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ID_USER")
	private long id;
	@Column(name="USER_NAME")
	private String name;
	@Column(name="USER_AGE")
	private Long age;
	@Column(name="USER_ADD")
	private String address;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
//	@Override
//	public String toString() {
//		return "idx:"+id+",namex:"+name+",agex:"+age+",addressx:"+address;
//	}
	
	
	
	
	
		
}
