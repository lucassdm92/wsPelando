package br.com.wspedalada.model.dao;

import javax.persistence.EntityManager;

public class UsuarioDAO {

	
	private EntityManager entityManager;
	
	public UsuarioDAO(EntityManager entityManager){
		this.entityManager = entityManager;
	}
}
