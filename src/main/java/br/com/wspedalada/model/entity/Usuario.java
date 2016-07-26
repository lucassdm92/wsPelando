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
import javax.persistence.Table;

@Entity
@Table(name = "TBL_USUARIO")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "IDUSER")
	private Integer idUsuario;
	@Column(name = "NMUSER")
	private String nmUser;
	@Column(name = "KEYCODUSER")
	private String keyCoduser;
	@Column(name = "TELUSER")
	private String telUser;
	@Column(name = "POSIUSER")
	private String posicaoUser;

	@ManyToMany(cascade = CascadeType.ALL, targetEntity = Time.class)
	@JoinTable(name = "ASSOCIUSERTIME", joinColumns = { @JoinColumn(name = "IDUSER") }, inverseJoinColumns = {
			@JoinColumn(name = "IDTIME") })
	private List<Time> listTimes;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public String getNmUser() {
		return nmUser;
	}

	public String getKeyCoduser() {
		return keyCoduser;
	}

	public String getTelUser() {
		return telUser;
	}

	public String getPosicaoUser() {
		return posicaoUser;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setNmUser(String nmUser) {
		this.nmUser = nmUser;
	}

	public void setKeyCoduser(String keyCoduser) {
		this.keyCoduser = keyCoduser;
	}

	public void setTelUser(String telUser) {
		this.telUser = telUser;
	}

	public void setPosicaoUser(String posicaoUser) {
		this.posicaoUser = posicaoUser;
	}

	public List<Time> getListTimes() {
		return listTimes;
	}

	public void setListTimes(List<Time> listTimes) {
		this.listTimes = listTimes;
	}

}
