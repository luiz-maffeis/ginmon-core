package de.com.ginmon_core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUser;
	
	private String login;
	private Integer id;
	private String comment;
	
	protected UserComment() {}
	
	
	public UserComment(String login, Integer id, String comment) {
		this.login = login;
		this.id = id;
		this.comment = comment;
	}


	/**
	 * @return the idUser
	 */
	public Integer getIdUser() {
		return idUser;
	}
/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the opinion
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param opinion the opinion to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserOpinion [login=" + login + ", id=" + id + ", comment=" + comment + "]";
	}

}
