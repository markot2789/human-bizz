package com.humanbizz.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.humanbizz.web.entities.Ability;
import com.humanbizz.web.entities.TaskList;
import com.humanbizz.web.entities.User;
import com.humanbizz.web.services.UserService;
import com.humanbizz.web.services.ProjectService;

@Controller
@RequestMapping("/")
public class IndexController {

	  @Autowired 
	  private UserService userService;
	   
	  @Autowired 
	  private ProjectService projectService;
	  
	  @RequestMapping(method = RequestMethod.GET)
	  public String listAll(Model model) {
	   	    
	    User user = new User();
	    user.setId(5);
	    Ability ability = new Ability();
	      ability.setId(1);
	      ability.setName("Proba");
	 	    System.out.println(userService.getAbilities(user));
	    
//	    Ability ability2 = new Ability();
//	    ability2.setUserObject(user);
//	    ability2.setName("nesto2");
//	    List<Ability> listAbility = new ArrayList<Ability>();
//	    listAbility.add(ability);
//	    listAbility.add(ability2);
//	    userService.addAbilityList(user, listAbility);
	    
	  
	   
	    userService.addAbility(user, ability);
	    return "home";
	  }

	 
}
