package com.my.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Projects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id")
	private int pId;
	@Column(name = "project_name")
	private String projectName;
	@Column(name = "no_of_hours")
	private int noOfHours;
	
	@ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
	List<Student> studentList;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Projects(int pId, String projectName, int noOfHours, List<Student> studentList) {
		super();
		this.pId = pId;
		this.projectName = projectName;
		this.noOfHours = noOfHours;
		this.studentList = studentList;
	}

	public Projects(String projectName, int noOfHours) {
		super();
		this.projectName = projectName;
		this.noOfHours = noOfHours;
	}

	public Projects() {
		super();
	}

	@Override
	public String toString() {
		return "Projects [pId=" + pId + ", projectName=" + projectName + ", noOfHours=" + noOfHours + "]";
	}
	

}
