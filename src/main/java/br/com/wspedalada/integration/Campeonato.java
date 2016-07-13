package br.com.wspedalada.integration;

import java.io.Serializable;

public class Campeonato implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1101691943487792069L;
	private Integer idCampeonato;
	private String nomeCampeonato;
	
	public Integer getIdCampeonato() {
		return idCampeonato;
	}
	public String getNomeCampeonato() {
		return nomeCampeonato;
	}
	public void setIdCampeonato(Integer idCampeonato) {
		this.idCampeonato = idCampeonato;
	}
	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}
	

}
