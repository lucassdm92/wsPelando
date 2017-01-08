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
		campeonato.setNomeCampeonato(json.getJsonString("nomeCampeonato").toString());
		campeonato.setDescricaoCampeonato(json.getJsonString("descricacaoCampeonato").toString());
		campeonato.setQtdTimesCampeonato(Short.valueOf(json.getJsonString("qtdTime").toString()));
		campeonato.setValorTotalCampeonato(Double.parseDouble(json.getJsonString("vlrCampeonato").toString()));

		this.campeonatoBusiness.incluiCampeonato(campeonato);

		return "";
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public JsonObject getChampions(String codigo) {
		JsonObject jsonObject = null;
		
		if (codigo.isEmpty()) {
			jsonObject = this.campeonatoBusiness.getAllChampions();
		}else{
			
			jsonObject = this.campeonatoBusiness.findByID(codigo);
		}
		
		return jsonObject;
	}

}
