package com.humanbizz.web.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.humanbizz.web.entities.Ability;
import com.humanbizz.web.entities.DailyTask;
import com.humanbizz.web.entities.Project;
import com.humanbizz.web.entities.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humanbizz.web.entities.ProjectTask;
import com.humanbizz.web.entities.TaskCategory;
import com.humanbizz.web.entities.TaskList;
import com.humanbizz.web.entities.User;

@Service
public class UserService {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	// Since we've setup <tx:annotation-config> and transaction manager on
	// spring-context.xml,
	// any bean method annotated with @Transactional will cause Spring to
	// magically call
	// begin() and commit() at the start/end of the method. If exception occurs
	// it will also
	// call rollback()
	public List<User> getAllUsers() {
		List<User> result = em.createQuery("SELECT u FROM User u", User.class).getResultList();

		return result;
	}

	/**
	 * 
	 * @param user_id
	 *            to get all trainings of this user
	 * @return list of trainings for user with user_id
	 */
	@Transactional
	public List<Training> getTrainingsForUser(Integer user_id) {
		List<Training> trainings = em.createQuery("SELECT t FROM Training t where user_id=:user_id", Training.class)
				.setParameter("user_id", user_id).getResultList();

		return trainings;
	}

	/**
	 * 
	 * @param user_id
	 *            to get all abilities of this user
	 * @return list of abilities for user with user_id
	 */
	@Transactional
	public List<Ability> getAbilities(User user) {
		List<Ability> abilities = em
				.createQuery("SELECT a FROM User u join u.abilities a where u.id=:user_id", Ability.class)
				.setParameter("user_id", user.getId()).getResultList();
		return abilities;
	}

	/**
	 * 
	 * @param user
	 *            object to add training
	 * @param training
	 *            that is added to user
	 * @return
	 */
	@Transactional
	public boolean addTraining(User user, Training training) {
		if (training.getUser() != null && training.getUser() != user)
			return false;

		training.setUser(user);
		em.persist(training);

		return true;
	}

	@Transactional
	public void createAbility(Ability ability) {
		em.merge(ability);
	}

	/**
	 * 
	 * @param user
	 *            object to add ability
	 * @param ability
	 *            that is added to user
	 * @return
	 */
	@Transactional
	public void addAbility(User user, Ability ability) {
		user.addAbility(ability);System.out.println(user.getId() + ":" + ability.getId());
		em.merge(user);
	}

	@Transactional
	public String getCategoryForTask(DailyTask dailyTask) {
		return dailyTask.getCategory().getName();
	}

	@Transactional
	public List<DailyTask> getDailyTasks(User user) {
		return user.getDailyTasks();
	}

	/**
	 * 
	 * @param dailyTask
	 *            add DailyTask to User
	 */
	@Transactional
	public void addDailyTask(DailyTask dailyTask) {
		// rucno stavljeno
		User user = new User();
		user.setId(2);

		dailyTask.setUser(user);
		em.persist(dailyTask);
	}

	@Transactional
	public void addCategory(TaskCategory task_category) {
		task_category.setName("Predjasnji");
		em.persist(task_category);
	}

	/**
	 * 
	 * @param user
	 * @param ability
	 */
	@Transactional
	public boolean deleteAbility(User user, Ability ability) {

		if (user.getAbilities().contains(ability))
			user.getAbilities().remove(ability);
		this.em.merge(em.contains(user) ? user : em.merge(user));

		return true;

	}

	@Transactional
	public boolean addAbilityList(User user, List<Ability> listAbility) {
		for (Ability tempAbility : listAbility) {
			if (user.getAbilities().contains(tempAbility))
				continue;
			user.addAbility(tempAbility);
		}
		System.out.println(em.contains(user));
		em.merge(user);

		return true;
	}

	/**
	 * 
	 * @param u
	 *            add new user
	 */
	@Transactional
	public void add(User u) {

		Project project = new Project();
		project.setName("nas prvi projekat");

		Ability ability = new Ability();
		ability.setName("SQL");

		// u.getAbilities().add(ability);
		// u.addAbility(ability);

		Training training = new Training();
		training.setName("Training3");

		em.persist(u);
		addTraining(u, training);
	}

}
