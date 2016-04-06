package com.humanbizz.web.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.humanbizz.web.entities.Training;;

@Entity
@Table (name="users")
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	private String username;
	
	private String password;
	
	private String name;

	@ManyToMany
	@JoinTable(name = "user_ability", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "ability_id"),
	uniqueConstraints =
		    @UniqueConstraint(name = "UK_client_instruments_traded_client_id_instrument_traded_id",
		    columnNames = {"ability_id", "ability_id"}))
		    
	private List<Ability> abilities = new ArrayList<Ability>();

	public boolean addAbility(Ability ability) {
		if (this.getAbilities().contains(ability))
			return false;
		
		this.abilities.add(ability);
		
		return true;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Training> trainings = new ArrayList<Training>();
	
	@ManyToOne(cascade = CascadeType.MERGE)
	 private Project project;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<DailyTask> dailyTasks = new ArrayList<DailyTask>();
	
	public boolean addDailyTasks (DailyTask dailyTask){
		if(dailyTask.getUser()!=null && dailyTask.getUser()!=this)
			return false;
		
		dailyTask.setUser(this);
		dailyTasks.add(dailyTask);
		
		return true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Training> getTrainings() {
		return trainings;
	}

	public List<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<DailyTask> getDailyTasks() {
		return dailyTasks;
	}

	public void setDailyTasks(List<DailyTask> dailyTasks) {
		this.dailyTasks = dailyTasks;
	}
	
	
	
}
