package br.com.wspedalada.business;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import br.com.wspedalada.client.ITimeBusiness;
import br.com.wspedalada.model.dao.TimeDAO;
import br.com.wspedalada.model.entity.Time;
import br.com.wspedalada.model.entity.Usuario;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class TimeBusiness implements ITimeBusiness {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertTeamToDB(JsonObject json) throws PersistenceException {
		Time time = new Time();

		JsonObject timeJson = json.getJsonObject("Time");

		time.setNomeTime(timeJson.getString("nomeTime"));
		time.setDescricaoTime(timeJson.getString("descricaoTime"));
		time.setQtdJogadoresTimes(Integer.parseInt(timeJson.getString("qtdJogador")));

		for (JsonObject jsonObject : timeJson.getJsonObject("users").getJsonArray("user")
				.getValuesAs(JsonObject.class)) {
			Usuario usuario = new Usuario();
			usuario.setNmUser(jsonObject.getString("nomeUser"));
			usuario.setTelUser(jsonObject.getString("telUser"));
			usuario.setPosicaoUser(jsonObject.getString("posicaoUser"));

			time.getListaUsuario().add(usuario);
		}

		TimeDAO timeDao = new TimeDAO(entityManager);
		timeDao.includeTeam(time);

	}

}
