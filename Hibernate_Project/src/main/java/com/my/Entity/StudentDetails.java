package com.my.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_details")
public class StudentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Student_id")
	private int sId;
	@Column(name = "Course")
	private String course;
	@Column(name = "Year")
	private int year;
	@Column(name = "Mobile Number")
	private long mobile;
	
	@OneToOne(mappedBy = "sd", cascade = CascadeType.ALL)
	private Student student;
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public StudentDetails(int sId, String course, int Year, long mobile) {
		super();
		this.sId = sId;
		this.course = course;
		this.year = year;
		this.mobile = mobile;
	}
	public StudentDetails(String course, int year, long mobile) {
		super();
		this.course = course;
		this.year = year;
		this.mobile = mobile;
		this.student = student;
	}
	
	public StudentDetails() {
		super();
	}
	@Override
	public String toString() {
		return "StudentDetails [sId=" + sId + ", course=" + course + ", year=" + year + ", mobile=" + mobile + "]";
	}
	
	
	
	
}
