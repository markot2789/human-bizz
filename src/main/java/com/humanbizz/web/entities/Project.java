package com.humanbizz.web.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name="projects")
public class Project {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String description;
	
	private String client;
	
	private Date startDate;
	
	private Date endDate;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Phase> phases = new ArrayList<Phase>();
	
	public boolean addPhase(Phase phase){
		if(phase.getProject()!=null && phase.getProject()!=this)
			return false;
		
		phase.setProject(this);
		phases.add(phase);
		
		return true;
	}
	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private User user;

	@OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="project_member",
            joinColumns = @JoinColumn( name="project_id"),
            inverseJoinColumns = @JoinColumn( name="user_id")
    )
 private List<User> member = new ArrayList<User>();
 
 public boolean addMember(User user){
  if(user.getProject()!=null && user.getProject()!=this)
   return false;
  
  member.add(user);
  
  return true;
 }
 
 @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="project_responsible",
            joinColumns = @JoinColumn( name="project_id"),
            inverseJoinColumns = @JoinColumn( name="user_id")
    )
 private List<User> responsible = new ArrayList<User>();
 
 public boolean addResponsible(User user){
  if(user.getProject()!=null && user.getProject()!=this)
   return false;
  
  responsible.add(user);
  
  return true;
 }
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
}
