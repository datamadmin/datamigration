package com.dataeconomy.datamigration.models.dbo;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_access_token")
public class OauthAccessToken implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "authentication_id")
	private String authenticationId;

	@Column(name = "token_id")
	private String tokenId;

	@Column(name = "token")
	private String token;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "authentication")
	private String authentication;

	@Column(name = "client_id")
	private String clientId;

	@Column(name = "refresh_token")
	private Blob refreshToken;

	// getters and setters

	public String getAuthenticationId() {
		return authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Blob getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(Blob refreshToken) {
		this.refreshToken = refreshToken;
	}

}
