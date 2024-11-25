package com.hibernate.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.my.Entity.Projects;
import com.my.Entity.Student;
import com.my.Entity.StudentDetails;
import com.my.Entity.Subjects;

public class HibernateDaoImp implements HIbernateDao{
	
	private Session session;
	private Student student;
	private Transaction transaction;

	public HibernateDaoImp() {
		session = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentDetails.class)
				.addAnnotatedClass(Subjects.class)
				.addAnnotatedClass(Projects.class)
				.buildSessionFactory()
				.openSession();
	}

	@Override
	public void insert(Student student) {
		
		transaction = session.beginTransaction();
		session.persist(student);
		transaction.commit();
	}

	@Override
	public ArrayList<Student> fetchAll() {
		return (ArrayList<Student>) (session.createQuery("from Student").list()); 
	}

	@Override
	public Student fetchOne(int sid) {
		return session.get(Student.class, sid);
	}

	@Override
	public void delete(int sid) {
		session.beginTransaction();
		session.delete(fetchOne(sid));
		session.getTransaction().commit();
		System.out.println("Data deleted");
	}

	@Override
	public void update(int sid , String email) {
		session.beginTransaction();
		student = session.get(Student.class, sid);
		if(student != null) {
			student.setEmail(email);
			session.persist(student);
			System.out.println("Updated Successufully");
		}
		System.out.println("Student not found" +" "+ student);
		session.getTransaction().commit();
		
	}

	



	

}
