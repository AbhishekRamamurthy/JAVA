package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.DemoCRUD;

public class DemoTest {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(DemoCRUD.class)
				.buildSessionFactory();
		
		try {
			
			// add to data base
			Session session = factory.getCurrentSession();
			DemoCRUD obj = new DemoCRUD("Abhishek","Ramamurthy","OSU");
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
			System.out.println("Commited to Database" + obj);
			
			//get based read 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			int Id = obj.getId();
			obj = session.get(DemoCRUD.class, Id);
			System.out.println("\nRead Object: "+obj);
			session.getTransaction().commit();
			System.out.println("Read Done");
			
			//Read on query
			session = factory.getCurrentSession();
			session.beginTransaction();

			List<DemoCRUD> list = session.createQuery("from DemoCRUD s where s.company='OSU'").getResultList();
			for(DemoCRUD temp: list) {
				System.out.println("Student: "+temp);
			}
			session.getTransaction().commit();
			System.out.println("Read based on Company Done");
			
			//Delete
			session = factory.getCurrentSession();
			session.beginTransaction();

			obj = session.get(DemoCRUD.class, 1);
			session.delete(obj);
			session.getTransaction().commit();
			System.out.println("Delete Based on ID done");
		} finally {
			factory.close();
		}
	}
}
