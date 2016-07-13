package br.com.wspedalada.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.wspedalada.model.entity.Campeonato;

public class CampeonatoDAO {

	private EntityManager entityManager;

	public CampeonatoDAO(EntityManager eneitty) {
		this.entityManager = eneitty;
	}

	public List<Campeonato> selectAllChampionsDB() {
		Query query = this.entityManager.createNamedQuery(Campeonato.FIND_ALL_CHAMPIONS);
		List<Campeonato> listaCampeonato = query.getResultList();
		return listaCampeonato;
	}

	public Campeonato selectById(String codigo) {

		Query query = null;
		Campeonato campeonto = null;
		try {
			
			query = this.entityManager.createNamedQuery(Campeonato.SELECT_BY_ID);
			query.setParameter("idCampeonato", Integer.parseInt(codigo));
			campeonto = (Campeonato) query.getSingleResult();
			
		} catch (NoResultException e) {

			System.out.println(e.getMessage());
		}

		return campeonto;
	}

}
