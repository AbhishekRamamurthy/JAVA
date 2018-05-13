package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//Create Session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {
			//Create student object
			System.out.println("Creating a new Student object...");
			Student temp = new Student("Abhishek","Ramamurthy","abhishek.ramamurty@gmail.com");
			//start transaction
			session.beginTransaction();
			//save object
			System.out.println("Saving the student...");
			session.save(temp);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
