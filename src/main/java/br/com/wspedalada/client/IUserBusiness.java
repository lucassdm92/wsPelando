package br.com.wspedalada.client;

import javax.ejb.Local;
import javax.json.JsonObject;

@Local
public interface IUserBusiness {

	public void includeUserDB(JsonObject usuario);
}
