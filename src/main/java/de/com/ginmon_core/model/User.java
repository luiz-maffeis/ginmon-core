/**
 * 
 */
package de.com.ginmon_core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Luiz
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	private String login;
	private Integer id;
	private String avatar_url;
	private String gravatar_id;
	private String url;
	private String html_url;
	private String type;
	private String name;
	private String blog;
	private String email;
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
	 * @return the avatar_url
	 */
	public String getAvatar_url() {
		return avatar_url;
	}
	/**
	 * @param avatar_url the avatar_url to set
	 */
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
	/**
	 * @return the gravatar_id
	 */
	public String getGravatar_id() {
		return gravatar_id;
	}
	/**
	 * @param gravatar_id the gravatar_id to set
	 */
	public void setGravatar_id(String gravatar_id) {
		this.gravatar_id = gravatar_id;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the html_url
	 */
	public String getHtml_url() {
		return html_url;
	}
	/**
	 * @param html_url the html_url to set
	 */
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the blog
	 */
	public String getBlog() {
		return blog;
	}
	/**
	 * @param blog the blog to set
	 */
	public void setBlog(String blog) {
		this.blog = blog;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [login=" + login + ", id=" + id + "]";
	}
	
	

}
