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






@Entity
@Table(name="taskList")

public class TaskList {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy = "taskList", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<ProjectTask> projectTasks = new ArrayList<ProjectTask>();
	
	public boolean addProjectTask (ProjectTask projectTask){
		if(projectTask.getTaskList()!=null && projectTask.getTaskList()!=this)
			return false;
		
		projectTask.setTaskList(this);
		projectTasks.add(projectTask);
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

	@Override
	public String toString() {
		return "TaskList [id=" + id + ", name=" + name + "]";
	}

		
	
}