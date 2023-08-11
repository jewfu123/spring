package org.keycloak.examples.rest;

import org.keycloak.examples.rest.jpa.EventEntity;
import org.keycloak.examples.rest.jpa.UserEntity2;

public class EventUserRepresentation {

	private String id;
	private String CLIENT_ID;
	private String DETAILS_JSON;
	private String ERROR;
	private String IP_ADDRESS;
	private String REALM_ID;
	private long EVENT_TIME;
	private String SESSION_ID;
	private String TYPE;
	private String USER_ID;
	
	private String USERNAME;
	private String FIRST_NAME;
	private String LAST_NAME;

	public EventUserRepresentation() {
    }

    public EventUserRepresentation(EventEntity event, UserEntity2 ue) {
        id = event.getId();
        CLIENT_ID = event.getCLIENT_ID();
        DETAILS_JSON = event.getDETAILS_JSON();
        ERROR = event.getERROR();
        IP_ADDRESS = event.getIP_ADDRESS();
        REALM_ID = event.getREALM_ID();
        EVENT_TIME = event.getEVENT_TIME();
        SESSION_ID = event.getSESSION_ID();
        TYPE = event.getTYPE();
        USER_ID = event.getUSER_ID();
        
        USERNAME = ue.getUsername();
        FIRST_NAME = ue.getFirstName();
        LAST_NAME = ue.getLastName();
    }
    // --------------
    public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	// --------------

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCLIENT_ID() {
		return CLIENT_ID;
	}

	public void setCLIENT_ID(String cLIENT_ID) {
		CLIENT_ID = cLIENT_ID;
	}

	public String getDETAILS_JSON() {
		return DETAILS_JSON;
	}

	public void setDETAILS_JSON(String dETAILS_JSON) {
		DETAILS_JSON = dETAILS_JSON;
	}

	public String getERROR() {
		return ERROR;
	}

	public void setERROR(String eRROR) {
		ERROR = eRROR;
	}

	public String getIP_ADDRESS() {
		return IP_ADDRESS;
	}

	public void setIP_ADDRESS(String iP_ADDRESS) {
		IP_ADDRESS = iP_ADDRESS;
	}

	public String getREALM_ID() {
		return REALM_ID;
	}

	public void setREALM_ID(String rEALM_ID) {
		REALM_ID = rEALM_ID;
	}

	public long getEVENT_TIME() {
		return EVENT_TIME;
	}

	public void setEVENT_TIME(long eVENT_TIME) {
		EVENT_TIME = eVENT_TIME;
	}

	public String getSESSION_ID() {
		return SESSION_ID;
	}

	public void setSESSION_ID(String sESSION_ID) {
		SESSION_ID = sESSION_ID;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
    
    
}
