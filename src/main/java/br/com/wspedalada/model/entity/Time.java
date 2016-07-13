package br.com.wspedalada.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBLTIME")
public class Time  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="IDTIME")
	private Integer idTime;
	@Column(name="NMTIME")
	private String nomeTime;
	@Column(name="DESCTIM")
	private String descricaoTime;
	@Column(name="QTDJOGTIME")
	private Integer qtdJogadoresTimes;
	@ManyToMany(mappedBy="listTimes")
	private List<Usuario> listaUsuario;
	
	@ManyToMany(mappedBy="listaTimes")
	private List<Campeonato> listaUsuariosCamp;
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			listaUsuario = new ArrayList<Usuario>();
			
		}
		return listaUsuario;
	}
	public List<Campeonato> getListaUsuarios() {
		if (listaUsuariosCamp == null) {
			listaUsuariosCamp = new ArrayList<Campeonato>();
			
		}
		
		return listaUsuariosCamp;
	}
	public void setListaUsuarios(List<Campeonato> listaUsuariosCamp) {
		this.listaUsuariosCamp = listaUsuariosCamp;
	}
	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	public Integer getIdTime() {
		return idTime;
	}
	public String getNomeTime() {
		return nomeTime;
	}
	public String getDescricaoTime() {
		return descricaoTime;
	}
	public Integer getQtdJogadoresTimes() {
		return qtdJogadoresTimes;
	}
	public void setIdTime(Integer idTime) {
		this.idTime = idTime;
	}
	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}
	public void setDescricaoTime(String descricaoTime) {
		this.descricaoTime = descricaoTime;
	}
	public void setQtdJogadoresTimes(Integer qtdJogadoresTimes) {
		this.qtdJogadoresTimes = qtdJogadoresTimes;
	}

}
