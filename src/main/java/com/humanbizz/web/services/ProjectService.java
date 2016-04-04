package com.humanbizz.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humanbizz.web.entities.Phase;
import com.humanbizz.web.entities.Project;
import com.humanbizz.web.entities.User;

@Service
public class ProjectService {

	 @PersistenceContext
	  private EntityManager em;
	 
//	 Since we've setup <tx:annotation-config> and transaction manager on spring-context.xml,
//	   any bean method annotated with @Transactional will cause Spring to magically call
//	   begin() and commit() at the start/end of the method. If exception occurs it will also
//	   call rollback()
	  @Transactional
	  public List<Project> getAllProjects() {
	    List<Project> result = em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
	    return result;
	  }
	  
	  /**
	   * 
	   * @param project new project that needs to be added to database
	   */
	  @Transactional
	  public void addProject(Project project){
			em.persist(project);
		}
	  
	  /**
	   * 
	   * @param project in witch phase is going to be added 
	   * @param phase that is going to be added to project
	   */
	  @Transactional
	  public void addPhase(Project project,Phase phase){
		  project.addPhase(phase);
			em.persist(project);
		}
	  
	  @Transactional
	  public void addProjectMember(User user, Project project) {
	   /**
	    * fali provera da li vec postoji u sectionMangeru i prebacivanje iz managera u emplyee i obrnuto
	    */
		  project.addMember(user);
	   em.merge(project);
	  }

	  @Transactional
	  public void addProjectResponsible(User user, Project project) {
		  project.addResponsible(user);
	   em.merge(project);
	  }
	  
	  
	  
	  /**
	   * 
	   * @param p adding new project when button add project is clicked
	   */
	  @Transactional
	  public void add(Project p) {
		  
		  p.setName("Projektic");
		  em.persist(p);
		  Phase ph = new Phase();
		  ph.setName("Faza 1b");
		  ph.setDescription("Ovo je prva faza");
		  addPhase(p, ph);
		  
	  }
	  
	  @Transactional
	  public Project getProjectByName(String name) {
	   Project result = em.createQuery("SELECT p FROM Project p WHERE p.name='" + name + "'", Project.class)
	     .setMaxResults(1).getSingleResult();
	   return result;
	  }
	
}
