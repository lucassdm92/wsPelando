package br.com.wspedalada.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.json.JsonObject;
import javax.persistence.PersistenceException;

import br.com.wspedalada.client.ITimeBusiness;
import br.com.wspedalada.client.ITimeFacade;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class TimeFacade implements ITimeFacade {

	@EJB
	private ITimeBusiness iTimeBusiness;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createTeam(JsonObject jsonObject) {
		try{
			
			this.iTimeBusiness.insertTeamToDB(jsonObject.toString());	
			
		}catch(PersistenceException e){
			
			throw new PersistenceException("Ocorreu um erro ao Salvar os dados");
		}
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public JsonObject findTeam(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
