package com.valtech.training.hibernateProject;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Laptop {
	
	@Id
	private int id;
	private String aname;
	private String tech;
	
	
	@ManyToMany
	private Set<Student>students;
	
//	private Student student;
	
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}

	public int getId() {
		return id;
	}
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public void setId(int aid) {
		this.id=aid;
	}
	
	public String getAname() {
		return aname;
	}
	
	public void setAname(String aname) {
		this.aname=aname;
	}
	
	public String getTech() {
		return tech;
	}
	
	public void setTech(String tech) {
		this.tech=tech;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", aname=" + aname + ", tech=" + tech;
	}
	
	
	
	
}
