package com.humanbizz.web.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="projectTask")

public class ProjectTask {
	
	@Id
	@GeneratedValue
	
	private int id ;
	private String name;
	private boolean checked;
	
	@ManyToOne
	@JoinColumn(name = "taskList_id", nullable = false)
	private TaskList taskList;
	
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
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
	public TaskList getTaskList() {
		return taskList;
	}
	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}
	@Override
	public String toString() {
		return "ProjectTask [id=" + id + ", name=" + name + ", checked=" + checked + ", taskList=" + taskList + "]";
	}
	
	
	

}
