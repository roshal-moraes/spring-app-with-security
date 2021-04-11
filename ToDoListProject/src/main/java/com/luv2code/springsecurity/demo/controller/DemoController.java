package com.luv2code.springsecurity.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springsecurity.demo.entity.Todo_elt;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.Todo_eltService;
import com.luv2code.springsecurity.demo.service.UserService;

@Controller
@RequestMapping("/tasks")
public class DemoController {

	@Autowired
	private Todo_eltService todoService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String listTasks(Model theModel) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username;
		if (principal instanceof UserDetails) {
		username = ((UserDetails)principal).getUsername();
		} else {
		username = principal.toString();
		}
		
		System.out.println(username);
		// get customers from the service
		User user = userService.findByUserName(username);
		long uid = user.getId();
		List<Todo_elt> tasks = new ArrayList<Todo_elt>();
		List<Todo_elt> result = todoService.getTodo_elts();
		for(Todo_elt task : result) {
			if(task.getUser().getId() == uid)
				tasks.add(task);
		}
				
		// add the customers to the model
		theModel.addAttribute("tasks", tasks);
		
		return "list-todo";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Todo_elt task = new Todo_elt();
		
		theModel.addAttribute("task", task);
		
		return "add-todo";
	}
	
	@PostMapping("/saveTask")
	public String saveTask(@ModelAttribute("task") Todo_elt task) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username;
		if (principal instanceof UserDetails) {
		username = ((UserDetails)principal).getUsername();
		} else {
		username = principal.toString();
		}
		
		User user = userService.findByUserName(username);
		task.setUser(user);
		
		// save the customer using our service
		todoService.saveTodo_elt(task);
		
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("taskId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Todo_elt theTask = todoService.getTodo_elt(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("task", theTask);
		
		// send over to our form		
		return "add-todo";
	}
	
	@GetMapping("/delete")
	public String deleteTask(@RequestParam("taskId") int theId) {
		
		// delete the customer
		
		todoService.deleteTodo_elt(theId);
		
		
		return "redirect:/";
	}
	
	
	
}










