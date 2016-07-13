package br.com.wspedalada.client;

import javax.ejb.Local;
import javax.json.JsonObject;

import br.com.wspedalada.model.entity.Campeonato;

@Local
public interface ICampeonatoBusiness {

	public void incluiCampeonato(Campeonato campeonato);
	public JsonObject getAllChampions();

}
