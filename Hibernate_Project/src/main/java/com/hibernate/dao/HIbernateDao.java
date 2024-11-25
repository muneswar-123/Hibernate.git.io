package com.hibernate.dao;

import java.util.ArrayList;

import com.my.Entity.Student;

public interface HIbernateDao {
	void insert(Student student);
	ArrayList<Student> fetchAll();
	Student fetchOne(int sid);
	void delete(int sid);
	void update(int sid , String email);
}
