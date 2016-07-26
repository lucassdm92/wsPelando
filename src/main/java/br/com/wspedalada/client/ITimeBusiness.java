package br.com.wspedalada.client;

import javax.ejb.Local;
import javax.json.JsonObject;
import javax.persistence.PersistenceException;

@Local
public interface ITimeBusiness {

	public void insertTeamToDB(JsonObject string) throws PersistenceException;

}
