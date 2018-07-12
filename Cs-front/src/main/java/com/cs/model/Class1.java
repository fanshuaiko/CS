package com.cs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cs_class1")
public class Class1 {

	@Id
	@Column(name="class1_id")
	private Integer class1Id;
	@Column(name="class1_name")
	private String class1Name;
	public Integer getClass1Id() {
		return class1Id;
	}
	public void setClass1Id(Integer class1Id) {
		this.class1Id = class1Id;
	}
	public String getClass1Name() {
		return class1Name;
	}
	public void setClass1Name(String class1Name) {
		this.class1Name = class1Name;
	}
	@Override
	public String toString() {
		return "Class1 [class1Id=" + class1Id + ", class1Name=" + class1Name + "]";
	}

	
	
	

}
