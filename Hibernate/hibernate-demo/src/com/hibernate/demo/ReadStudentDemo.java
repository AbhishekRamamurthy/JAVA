package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student temp = new Student("Daffy","Duck","daffy.duck@gmail.com");
			//start transaction
			session.beginTransaction();
			//save object
			System.out.println("Saving the student...");
			session.save(temp);
			System.out.println(temp);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Saved Student, Generated Id: "+temp.getId());

			// retrieve based on primary key
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Getting Student with Id: "+ temp.getId());
			Student myStudent = session.get(Student.class, temp.getId());
			System.out.println("Get Complete: " + myStudent);
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
		
	}
}
