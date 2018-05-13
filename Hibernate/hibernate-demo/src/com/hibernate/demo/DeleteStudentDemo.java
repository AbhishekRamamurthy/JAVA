package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			//int studentId =5;
			//start transaction
			session.beginTransaction();
			//Student myStudent = session.get(Student.class, studentId);
			
			//delete the student
			//System.out.println("Deleting Student: "+ studentId);
			//session.delete(myStudent);
			
			System.out.println("\nDeleting Students with First Name ending with 2");
			session.createQuery("delete from Student s where s.firstName LIKE '%2'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
		
	}
}
