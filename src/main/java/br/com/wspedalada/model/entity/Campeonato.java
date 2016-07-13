package br.com.wspedalada.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name=Campeonato.FIND_ALL_CHAMPIONS, query="SELECT c FROM Campeonato c"),
	@NamedQuery(name=Campeonato.SELECT_BY_ID, query="SELECT c FROM Campeonato c WHERE c.idCampeonato=:idCampeonato")
})
@Entity
@Table(name = "TBL_CAMPEONATO")
public class Campeonato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  static final String FIND_ALL_CHAMPIONS ="Campeonato.selectAllChampionsDB";
	public  static final String SELECT_BY_ID ="Campeonato.selectById";

	@Id
	@GeneratedValue
	@Column(name = "IDCAMP")
	private Integer idCampeonato;
	@Column(name = "NMCAMP")
	private String nomeCampeonato;
	@Column(name = "DESCCAMP")
	private String DescricaoCampeonato;
	@Column(name = "QTDTEMPCAMP")
	private Short quantidadeTempo;
	@Column(name = "VLRCAMP")
	private Double valorTotalCampeonato;
	@Column(name = "QTDTMCAMP")
	private Short qtdTimesCampeonato;
	
	@ManyToMany(cascade = CascadeType.ALL, targetEntity = Time.class)
	@JoinTable(name = "ASSOCICAMPTIME", joinColumns = { @JoinColumn(name = "IDCAMP") }, inverseJoinColumns = {
			@JoinColumn(name = "IDTIME") })
	private List<Time> listaTimes;
	

	public Integer getIdCampeonato() {
		return idCampeonato;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public String getDescricaoCampeonato() {
		return DescricaoCampeonato;
	}

	public Short getQuantidadeTempo() {
		return quantidadeTempo;
	}

	public Double getValorTotalCampeonato() {
		return valorTotalCampeonato;
	}

	public Short getQtdTimesCampeonato() {
		return qtdTimesCampeonato;
	}

	public void setIdCampeonato(Integer idCampeonato) {
		this.idCampeonato = idCampeonato;
	}

	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}

	public void setDescricaoCampeonato(String descricaoCampeonato) {
		DescricaoCampeonato = descricaoCampeonato;
	}

	public void setQuantidadeTempo(Short quantidadeTempo) {
		this.quantidadeTempo = quantidadeTempo;
	}

	public void setValorTotalCampeonato(Double valorTotalCampeonato) {
		this.valorTotalCampeonato = valorTotalCampeonato;
	}

	public void setQtdTimesCampeonato(Short qtdTimesCampeonato) {
		this.qtdTimesCampeonato = qtdTimesCampeonato;
	}

	public List<Time> getListaTimes() {
		return listaTimes;
	}

	public void setListaTimes(List<Time> listaTimes) {
		this.listaTimes = listaTimes;
	}

}
