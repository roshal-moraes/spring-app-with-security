package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.Todo_eltDAO;
import com.luv2code.springsecurity.demo.entity.Todo_elt;

@Service
public class Todo_eltServiceImpl implements Todo_eltService {

	// need to inject Todo_elt dao
	@Autowired
	private Todo_eltDAO Todo_eltDAO;
	
	@Override
	@Transactional
	public List<Todo_elt> getTodo_elts() {
		return Todo_eltDAO.getTodo_elts();
	}

	@Override
	@Transactional
	public void saveTodo_elt(Todo_elt theTodo_elt) {

		Todo_eltDAO.saveTodo_elt(theTodo_elt);
	}

	@Override
	@Transactional
	public Todo_elt getTodo_elt(int theId) {
		
		return Todo_eltDAO.getTodo_elt(theId);
	}

	@Override
	@Transactional
	public void deleteTodo_elt(int theId) {
		
		Todo_eltDAO.deleteTodo_elt(theId);
	}
}





