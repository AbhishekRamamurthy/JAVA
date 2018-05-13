package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 2;
			//start transaction
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Get Complete: "+myStudent);
			
			//updating
			myStudent.setFirstName("Ramamurthy");
			myStudent.setLastName("Rangaiah");
			myStudent.setEmail("murthyrama2@gmail.com");
			//commit transaction
			session.getTransaction().commit();
			
			//bulk update
			//get transaction and begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//All students email updated to foo@gmail.com
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
