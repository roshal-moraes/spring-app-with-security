package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.*;

public interface Todo_eltDAO {

	public List<Todo_elt> getTodo_elts();

	public void saveTodo_elt(Todo_elt theTodo_elt);

	public Todo_elt getTodo_elt(int theId);

	public void deleteTodo_elt(int theId);
	
}
