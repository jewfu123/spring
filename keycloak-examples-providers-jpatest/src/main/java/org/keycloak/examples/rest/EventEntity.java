package org.keycloak.examples.rest;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;

@Table(name = "EVENT_ENTITY")
@NamedQueries({
    @NamedQuery(name="getUserByUserid", query="select u from EventEntity u where u.USER_ID = :userid"),
    @NamedQuery(name="findAll", query="SELECT e FROM EventEntity e"),
})
@Entity
public class EventEntity {
	
	@Id
	private long EVENT_TIME;
	private String id;
	private String CLIENT_ID;
	private String DETAILS_JSON;
	private String ERROR;
	private String IP_ADDRESS;
	private String REALM_ID;
	private String SESSION_ID;
	private String TYPE;
	private String USER_ID;
	
	public long getEVENT_TIME() {
		return EVENT_TIME;
	}
	public void setEVENT_TIME(long eVENT_TIME) {
		EVENT_TIME = eVENT_TIME;
	}
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
