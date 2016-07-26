package br.com.wspedalada.business;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.wspedalada.client.IUserBusiness;
import br.com.wspedalada.model.entity.Usuario;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UserBusiness implements IUserBusiness {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void includeUserDB(final JsonObject json) {

		Usuario usuario = new Usuario();

		JsonObject usuarioJson = json.getJsonObject("usuario");

		usuario.setNmUser(usuarioJson.getString("nomeUsuario"));
		usuario.setKeyCoduser(usuarioJson.getString("keyCodUser"));
		usuario.setTelUser(usuarioJson.getString("telUsuario"));
		this.entityManager.persist(usuario);

	}

}
