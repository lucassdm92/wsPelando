package br.com.wspedalada.client;

import javax.ejb.Local;
import javax.json.JsonObject;

@Local
public interface ITimeFacade {
	
	public void createTeam(JsonObject jsonObject);
	public JsonObject findTeam(String codigo);

}
