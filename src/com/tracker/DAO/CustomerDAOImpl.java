package com.tracker.DAO;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tracker.entity.Customer;

/**
 * 
 * @Repository --> It inherits the @component annotation and auto scan the component of DAO implementation class
 * @Transactional --> It removes the tedious work of being and ending the transaction
 */

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer>  theQuery = session.createQuery("from Customer order by lastName",
				Customer.class);
		
		List<Customer> listOfCustomer = theQuery.getResultList();
		
		return listOfCustomer;
		
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class,id);
		
		return customer;
		
	}

	@Override
	public void deleteCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

	
	
	
	
}
