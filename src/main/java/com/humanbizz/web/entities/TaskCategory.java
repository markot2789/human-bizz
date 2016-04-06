package com.humanbizz.web.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Aleksandar Bogicevic
 *
 */

@Entity
@Table (name="taskCategory")
public class TaskCategory {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<DailyTask> tasks = new ArrayList<DailyTask>();

	
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

	public List<DailyTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<DailyTask> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "TaskCategory [id=" + id + ", name=" + name + ", tasks=" + tasks + "]";
	}

	
	

}
