package com.cs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cs_class2")
public class Class2 {

	@Id
	@Column(name="class2_id")
	private Integer class2Id;
	@Column(name="class2_name")
	private String class2Name;
	@Column(name="class1_id")
	private int class1Id;
	public Integer getClass2Id() {
		return class2Id;
	}
	public void setClass2Id(Integer class2Id) {
		this.class2Id = class2Id;
	}
	public String getClass2Name() {
		return class2Name;
	}
	public void setClass2Name(String class2Name) {
		this.class2Name = class2Name;
	}
	public int getClass1Id() {
		return class1Id;
	}
	public void setClass1Id(int class1Id) {
		this.class1Id = class1Id;
	}
	@Override
	public String toString() {
		return "Class2 [class2Id=" + class2Id + ", class2Name=" + class2Name + ", class1Id=" + class1Id + "]";
	}
	
}
