package br.com.wspedalada.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.json.JsonObject;

import br.com.wspedalada.client.IUserBusiness;
import br.com.wspedalada.client.IUserFacade;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UserFacade implements IUserFacade {
 
	@EJB
	private IUserBusiness iUserBusiness;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void includeUser(JsonObject jsonObject) {
		
		this.iUserBusiness.includeUserDB(jsonObject);

	}

}
