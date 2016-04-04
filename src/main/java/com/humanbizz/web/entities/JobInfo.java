package com.humanbizz.web.entities;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*
 * 
 * ctreated jobInfo entity
 */
@Entity
@Table(name = "jobInfo")
public class JobInfo {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String positions;
	private String sectors;
	private Date startDate;
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name = "responsible", nullable = false)
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}

	public String getSectors() {
		return sectors;
	}

	public void setSectors(String sectors) {
		this.sectors = sectors;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "JobInfo [id=" + id + ", positions=" + positions + ", sectors=" + sectors + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", user=" + user + "]";
	}
	
	
	
}
