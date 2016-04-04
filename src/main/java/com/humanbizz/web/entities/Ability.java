package com.humanbizz.web.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Nikola
 *
 */
@Entity
@Table(name = "abilities")
public class Ability {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private int rate;

	@ManyToOne
	private User userObject;

	public User getUserObject() {
		return userObject;
	}

	public void setUserObject(User userObject) {
		this.userObject = userObject;
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

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Ability [id=" + id + ", name=" + name + ", rate=" + rate + ", userObject=" + userObject + "]";
	}

}
