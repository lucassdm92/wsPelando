package br.com.wspedalada.client;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

@Local
public interface ITimeBusiness {

	public void insertTeamToDB(String string) throws PersistenceException;

}
