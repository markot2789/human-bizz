package com.humanbizz.web.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table (name="goalComment")
public class GoalComment {

	@Id
	@GeneratedValue
	private int id;
	
	private String comment;	
	private Date date;
	private int userId;
	
	
	@ManyToOne
	@JoinColumn(name = "goal_id", nullable = false)
	private Goal goal;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Goal getGoal() {
		return goal;
	}


	public void setGoal(Goal goal) {
		this.goal = goal;
	}


	@Override
	public String toString() {
		return "GoalComment [id=" + id + ", comment=" + comment + ", date=" + date + ", userId=" + userId + ", goal="
				+ goal + "]";
	}

	
}
