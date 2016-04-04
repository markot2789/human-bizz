package com.humanbizz.web.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Aleksandar Bogicevic
 *
 */
@Entity
@Table (name="dailyTasks")
public class DailyTask {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String description;
	private Date dueDate;
	
	@ManyToOne
	@JoinColumn(name = "responsible", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private TaskCategory category;
		      
	
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TaskCategory getCategory() {
		return category;
	}

	public void setCategory(TaskCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "DailyTask [id=" + id + ", name=" + name + ", description=" + description + ", dueDate=" + dueDate
				+ ", user=" + user + ", category=" + category + "]";
	}

	
		

}

