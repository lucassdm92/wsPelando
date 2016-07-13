package br.com.wspedalada.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.wspedalada.model.entity.Time;

public class TimeDAO {

	private EntityManager entityManager;

	public TimeDAO(EntityManager entityManager) {

		this.entityManager = entityManager;

	}

	public void includeTeam(Time time) throws PersistenceException {
		this.entityManager.persist(time);
	}

}
