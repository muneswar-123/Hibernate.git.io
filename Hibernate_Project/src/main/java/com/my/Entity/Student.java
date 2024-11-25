package com.my.Entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student") // mapped the table called student
public class Student {
	
	@Id                     //make the id as primary
	@GeneratedValue(strategy = GenerationType.SEQUENCE)         //make the id auto increment based on old studentId, next column id can be generated
	@Column(name = "id") 		//create the column with name id
	private int student_id;
	@Column(name = "name")
	private String student_name;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "pincode")
	private int pincode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "StudentId")
	private StudentDetails sd ;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	List<Subjects> subjects;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch =  FetchType.EAGER) // if mention as lazy so first write code and print the result of code 
	@JoinTable(name = "Student_project", 
	joinColumns ={@JoinColumn(name = "student_id")},
	inverseJoinColumns ={@JoinColumn(name = "project_id")})
	List<Projects> projects;
	
	
	
	public List<Projects> getProjects() {
		return projects;
	}
	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
	public List<Subjects> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}
	public StudentDetails getSd() {
		return sd;
	}
	public void setSd(StudentDetails sd) {
		this.sd = sd;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Student(int student_id, String student_name, String email, String address, int pincode) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.email = email;
		this.address = address;
		this.pincode = pincode;
	}
	public Student() {
		super();
	}
	public Student(String student_name, String email, String address, int pincode) {
		super();
		this.student_name = student_name;
		this.email = email;
		this.address = address;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", email=" + email
				+ ", address=" + address + ", pincode=" + pincode + "]";
	}
	
	
	
}
