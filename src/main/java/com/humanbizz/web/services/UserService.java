package com.humanbizz.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humanbizz.web.entities.ProjectTask;
import com.humanbizz.web.entities.TaskList;
import com.humanbizz.web.entities.User;

@Service
public class UserService {

	  @PersistenceContext
	  private EntityManager em;
	  
	  /**
	   * Creates 3 fake Users 
	   * @return List of Users
	   */
	  @Transactional
	  public List<User> getAllUsers(){
		  
		  List<User> fakeData = new ArrayList<User>();

		  User fakeUser1 = new User();
		  fakeUser1.setId(0);
		  fakeUser1.setName("Adam");
		  
		  User fakeUser2 = new User();
		  fakeUser2.setId(1);
		  fakeUser2.setName("Steva");
		  
		  User fakeUser3 = new User();
		  fakeUser3.setId(2);
		  fakeUser3.setName("Nikoleta");

		  fakeData.add(fakeUser1);
		  fakeData.add(fakeUser2);
		  fakeData.add(fakeUser3);
		  
		  return fakeData;
	  }
	    
	/**
	 * 
	 * @param tl
	 * TaskList will be saved in database
	 */
	@Transactional
	public void addTaskList (TaskList tl) {
		
		
	     
	    em.persist(tl);
	}
	
	/**
	 * 
	 * @param pt
	 * ProjectTask will be saved in database
	 * 
	 * 
	 */
	@Transactional
	public void addProjectTask (ProjectTask pt ) {
		
		
	      em.persist(pt);
	}
}


