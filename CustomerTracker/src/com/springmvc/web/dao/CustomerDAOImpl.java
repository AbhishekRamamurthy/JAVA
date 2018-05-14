package com.springmvc.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.web.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//dependency injection see xml
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		//get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query .. sort by last name
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		//get the data from database
		List<Customer> customers = query.getResultList();
		
		//return the result
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Customer.class, theId);
	}


	@Override
	public void delete(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}


	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
		if(theSearchName != null && theSearchName.trim().length() >0) {
			
			theQuery = 
			currentSession.createQuery("from Customer where lower(firstName) like:theName or "
									   + "lower(lastName) like:theName",Customer.class);
			theQuery.setParameter("theName", theSearchName);
		} else {
			theQuery = currentSession.createQuery("from Customer",Customer.class);
		}
		
		List<Customer> customers=  theQuery.getResultList();
		System.out.println("customers: "+customers);
		return customers;
	}

}
