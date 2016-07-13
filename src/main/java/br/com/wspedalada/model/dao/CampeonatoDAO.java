package br.com.wspedalada.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.wspedalada.model.entity.Campeonato;

public class CampeonatoDAO {
	

	private EntityManager entityManager;
	
	public CampeonatoDAO(EntityManager eneitty) {
		this.entityManager = eneitty;
	}
	
	
	
	
	public List<Campeonato> selectAllChampionsDB(){
		Query query = this.entityManager.createNamedQuery(Campeonato.FIND_ALL_CHAMPIONS);
		List<Campeonato> listaCampeonato = query.getResultList();
		return listaCampeonato ;
	}

}
