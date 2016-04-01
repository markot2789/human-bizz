package com.humanbizz.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.humanbizz.web.entities.TaskList;
import com.humanbizz.web.services.UserService;

@Controller
@RequestMapping("/")
public class IndexController {

	  @Autowired 
	  private UserService userService;
	   
	  
	  @RequestMapping(method = RequestMethod.GET)
	  public String listAll(Model model) {
	    model.addAttribute("persons", userService.getAllUsers());
	    TaskList taskList = new TaskList();
	    taskList.setName("Bizz");
	    userService.addTaskList(taskList);
	    return "home";
	  }
	  
	  
	 
}
