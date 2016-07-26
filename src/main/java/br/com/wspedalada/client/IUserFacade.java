package br.com.wspedalada.client;

import javax.ejb.Local;
import javax.json.JsonObject;

@Local
public interface IUserFacade {

	public void includeUser(JsonObject jsonObject);

}
