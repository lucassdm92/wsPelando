package br.com.wspedalada.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.json.JsonObject;

import br.com.wspedalada.client.ICampeonatoBusiness;
import br.com.wspedalada.client.ICampeonatoFacade;
import br.com.wspedalada.model.entity.Campeonato;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CampeonatoFacade implements ICampeonatoFacade {

	@EJB
	private ICampeonatoBusiness campeonatoBusiness;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String insertChampions(JsonObject json) {
		Campeonato campeonato = new Campeonato();

		JsonObject campeonatoJson = json.getJsonObject("Campeonato");

		campeonato.setNomeCampeonato(campeonatoJson.getString("Nome"));
		campeonato.setDescricaoCampeonato(campeonatoJson.getString("Descricao"));
		campeonato.setQtdTimesCampeonato(Short.valueOf(campeonatoJson.getString("QtdTime")));
		campeonato.setQuantidadeTempo(Short.valueOf(campeonatoJson.getString("QtdTempo")));
		campeonato.setValorTotalCampeonato(Double.parseDouble(campeonatoJson.getString("VlrCamp")));

		this.campeonatoBusiness.incluiCampeonato(campeonato);

		return "";
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public JsonObject getChampions(String codigo) {
		return this.campeonatoBusiness.getAllChampions();
	}

}
