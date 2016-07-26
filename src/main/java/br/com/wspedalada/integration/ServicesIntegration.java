package br.com.wspedalada.integration;

import java.io.InputStream;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.wspedalada.client.ICampeonatoFacade;
import br.com.wspedalada.client.ITimeFacade;
import br.com.wspedalada.client.IUserFacade;
import br.com.wspedalada.utils.WSUtils;

@Path("/wsServicesIntegration")
public class ServicesIntegration {

	@EJB
	private ICampeonatoFacade icampeonatoFacade;

	@EJB
	private ITimeFacade iTimeFacade;
	
	@EJB
	private IUserFacade iUserFacade;

	@POST
	@Path(value = "/create")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String insertChampions(InputStream incomingData) {

		this.icampeonatoFacade.insertChampions(WSUtils.convertStreamToJSON(incomingData));

		return "hahah MANE";
	}

	@GET
	@Path(value = "/getAllChampions")
	@Produces({ MediaType.APPLICATION_JSON })
	public JsonObject getAllChampions() {

		return this.icampeonatoFacade.getChampions("1");
	}

	@POST
	@Path(value = "/createTeam")
	@Produces({ MediaType.APPLICATION_JSON })
	public String insertTeam(InputStream incomingData) {

		try {

			this.iTimeFacade.createTeam(WSUtils.convertStreamToJSON(incomingData));
			
		} catch (Exception e) {

			return e.getMessage();
		}

		return null;
	}
	
	
	@POST
	@Path(value = "/createUser")
	@Produces({ MediaType.APPLICATION_JSON })
	public String createUser(InputStream incomingData) {

		try {
			iUserFacade.includeUser(WSUtils.convertStreamToJSON(incomingData));
			
		} catch (Exception e) {

			return e.getMessage();
		}

		return null;
	}

}
