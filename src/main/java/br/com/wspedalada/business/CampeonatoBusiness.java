package br.com.wspedalada.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.wspedalada.client.ICampeonatoBusiness;
import br.com.wspedalada.model.dao.CampeonatoDAO;
import br.com.wspedalada.model.entity.Campeonato;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CampeonatoBusiness implements ICampeonatoBusiness {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void incluiCampeonato(Campeonato campeonato) {

		entityManager.persist(campeonato);

	}

	@Override
	public JsonObject getAllChampions() {
		CampeonatoDAO campeonatoDAO = new CampeonatoDAO(entityManager);
		List<Campeonato> listaCampeonato = campeonatoDAO.selectAllChampionsDB();

		JsonObjectBuilder obj = Json.createObjectBuilder();
		JsonObjectBuilder ob = obj.add("Campeonato", Json.createArrayBuilder());

		JsonArrayBuilder jsonArrayBuider = Json.createArrayBuilder();

		for (Campeonato campeonato : listaCampeonato) {
			JsonObjectBuilder jasonobjt = Json.createObjectBuilder();
			jasonobjt.add("Nome", campeonato.getNomeCampeonato());
			jsonArrayBuider.add(jasonobjt);
		}
		obj.add("Campeonato", jsonArrayBuider);

		return ob.build();
	}

}
