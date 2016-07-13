package br.com.wspedalada.client;

import javax.ejb.Local;
import javax.json.JsonObject;

@Local
public interface ICampeonatoFacade {
	
	public String insertChampions(JsonObject json);
	public JsonObject getChampions(String codigo);
}
