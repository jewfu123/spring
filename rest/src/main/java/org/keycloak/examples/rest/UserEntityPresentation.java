package org.keycloak.examples.rest;

import java.util.Collection;
import java.util.List;

import org.keycloak.models.jpa.entities.*;

import com.fasterxml.jackson.databind.cfg.MapperBuilder;

import java.util.Map;

public class UserEntityPresentation {

	private Collection<UserAttributeEntity> attributes;
	
	private String realmId;
	
	private String username;
	
	private String uaName;
	private String uaValue;
	
	private List<Map<String, String>> userAttribute;
	
	private Map<String, String> uuerattr;



	public Map<String, String> getUuerattr() {
		return uuerattr;
	}

	public void setUuerattr(Map<String, String> uuerattr) {
		this.uuerattr = uuerattr;
	}

	public List<Map<String, String>> getUserAttribute() {
		return userAttribute;
	}

	public void setUserAttribute(List<Map<String, String>> userAttribute) {
		this.userAttribute = userAttribute;
	}

	public String getUaName() {
		return uaName;
	}

	public void setUaName(String uaName) {
		this.uaName = uaName;
	}

	public String getUaValue() {
		return uaValue;
	}

	public void setUaValue(String uaValue) {
		this.uaValue = uaValue;
	}

	private Collection<UserRequiredActionEntity> requiredActions;

	public UserEntityPresentation() {

	}

    public UserEntityPresentation(UserEntity event, Map<String, String> uae) {
    	
    	//attributes = event.getAttributes();
    	
    	realmId = event.getRealmId();
    	
    	username = event.getUsername();
    	
    	//userAttribute["name"] = List<uae>;
    	//userAttribute = uae;
    	uuerattr = uae;
    			
//    	uaName = uae.getName();
//    	uaValue = uae.getValue();
    	
    	//requiredActions = event.getRequiredActions();
    	 
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
