package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		//Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//Create Session
		Session session = factory.getCurrentSession();

		try {
			//Create 3 student object
			System.out.println("Creating 3 Student objects...");
			Student temp = new Student("Abhishek","Ramamurthy","abhishek.ramamurty@gmail.com");
			Student temp1 = new Student("Abhishek1","Ramamurthy1","abhishek1.ramamurty1@gmail.com");
			Student temp2= new Student("Abhishek2","Ramamurthy2","abhishek2.ramamurty2@gmail.com");
			
			//start transaction
			session.beginTransaction();
			//save object
			System.out.println("Saving the student...");
			session.save(temp);
			session.save(temp1);
			session.save(temp2);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
