package br.com.wspedalada.business;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.com.wspedalada.client.ITimeBusiness;
import br.com.wspedalada.model.dao.TimeDAO;
import br.com.wspedalada.model.entity.Time;

@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class TimeBusiness implements ITimeBusiness{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertTeamToDB(String string) throws PersistenceException{
		Time time = null;
		TimeDAO timeDao = new TimeDAO(entityManager);
		
		timeDao.includeTeam(time);
		
	}
	

}
