package com.humanbizz.web.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="goal")
public class Goal {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;	
	private String description;	
	private Date dueDate;
	
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name="members",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="member_id")
    )
	private List<User> users = new ArrayList<User>();
	
	@OneToMany(mappedBy = "goal", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<GoalComment> goalComments = new ArrayList<GoalComment>();
	
	public boolean addComment(GoalComment goalComment){
		if(goalComment.getGoal()!=null && goalComment.getGoal()!=this)
			return false;
		
		goalComment.setGoal(this);
		goalComments.add(goalComment);
		
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
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
		
	public List<GoalComment> getGoalComments() {
		return goalComments;
	}
	public void setGoalComments(List<GoalComment> goalComments) {
		this.goalComments = goalComments;
	}
	
	@Override
	public String toString() {
		return "Goal [id=" + id + ", name=" + name + ", description=" + description + ", dueDate=" + dueDate
				+ ", users=" + users + ", goalComments=" + goalComments + "]";
	}
	
	
	
}
