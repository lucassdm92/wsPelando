package br.com.wspedalada.integration;

import java.io.InputStream;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.wspedalada.client.ICampeonatoFacade;

@Path("/wsServicesIntegration")
public class ServicesIntegration {

	@EJB
	private ICampeonatoFacade icampeonatoFacade;

	@POST
	@Path(value = "/create")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String insertChampions(InputStream incomingData) {

		JsonReader jsonReader = Json.createReader(incomingData);
		JsonObject object = jsonReader.readObject();
		jsonReader.close();
		this.icampeonatoFacade.insertChampions(object);

		return "hahah MANE";
	}

	@GET
	@Path(value = "/getAllChampions")
	@Produces({ MediaType.APPLICATION_JSON })
	public JsonObject getAllChampions() {
		return this.icampeonatoFacade.getChampions("1");
	}

}
