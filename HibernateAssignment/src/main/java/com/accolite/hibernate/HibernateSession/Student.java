package com.accolite.hibernate.HibernateSession;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int sid;
	private String name;
	private int age;
	private float marks;
	@OneToMany
	private List<Expense> expenseList;
	@OneToOne
	private Laptop laptop;
	public List<Expense> getexpenseList() {
		return expenseList;
	}
	public Laptop getlaptop() {
		return laptop;
	}
	public void setlaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public void setexpenseList(List<Expense> expenseList) {
		this.expenseList = expenseList;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}

}