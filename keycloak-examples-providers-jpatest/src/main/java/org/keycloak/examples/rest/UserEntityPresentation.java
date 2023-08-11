package org.keycloak.examples.rest;

import java.util.Collection;

import org.keycloak.models.jpa.entities.*;

public class UserEntityPresentation {

	private Collection<UserAttributeEntity> attributes;
	
	private String realmId;
	
	private String username;
	
	private Collection<UserRequiredActionEntity> requiredActions;

	public UserEntityPresentation() {

	}

    public UserEntityPresentation(UserEntity event) {
    	attributes = event.getAttributes();
    	
    	realmId = event.getRealmId();
    	
    	username = event.getUsername();
    	
    	requiredActions = event.getRequiredActions();
    	 
    }
	
	
	public Collection<UserAttributeEntity> getAttributes() {
		return attributes;
	}

	public void setAttributes(Collection<UserAttributeEntity> attributes) {
		this.attributes = attributes;
	}

	public String getRealmId() {
		return realmId;
	}

	public void setRealmId(String realmId) {
		this.realmId = realmId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<UserRequiredActionEntity> getRequiredActions() {
		return requiredActions;
	}

	public void setRequiredActions(Collection<UserRequiredActionEntity> requiredActions) {
		this.requiredActions = requiredActions;
	}
}
