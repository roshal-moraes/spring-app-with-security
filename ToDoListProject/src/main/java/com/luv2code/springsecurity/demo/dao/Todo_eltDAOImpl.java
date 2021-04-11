package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.entity.Todo_elt;

@Repository
public class Todo_eltDAOImpl implements Todo_eltDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Todo_elt> getTodo_elts() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Todo_elt> theQuery = 
				currentSession.createQuery("from Todo_elt",
											Todo_elt.class);
		
		// execute query and get result list
		List<Todo_elt> Todo_elts = theQuery.getResultList();
				
		// return the results		
		return Todo_elts;
	}

	@Override
	public void saveTodo_elt(Todo_elt theTodo_elt) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the Todo_elt ... finally LOL
		currentSession.saveOrUpdate(theTodo_elt);
		
	}

	@Override
	public Todo_elt getTodo_elt(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Todo_elt theTodo_elt = currentSession.get(Todo_elt.class, theId);
		
		return theTodo_elt;
	}

	@Override
	public void deleteTodo_elt(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Todo_elt where id=:Todo_eltId");
		theQuery.setParameter("Todo_eltId", theId);
		
		theQuery.executeUpdate();		
	}

}











