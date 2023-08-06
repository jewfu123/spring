package org.keycloak.examples.rest.jpa;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;

@Table(name = "EVENT_ENTITY")
@NamedQueries({
    @NamedQuery(name="getByUid", query="select u from EventEntity u where u.USER_ID = :uid"),
    @NamedQuery(name="findAll", query="SELECT e FROM EventEntity e"),
    @NamedQuery(name="getByUids", query="select u from EventEntity u where u.USER_ID IN (:uids)"),
})
@Entity
public class EventEntity {
	
	@Id
	private String id;
	
	private String CLIENT_ID;
	private String DETAILS_JSON;
	private String ERROR;
	private String IP_ADDRESS;
	private String REALM_ID;
	private String SESSION_ID;
	private long EVENT_TIME;
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
		if (CLIENT_ID != null) {
			return CLIENT_ID;
		} else {
			return "";
		}
		
	}
	public void setCLIENT_ID(String cLIENT_ID) {
		CLIENT_ID = cLIENT_ID;
	}
	public String getDETAILS_JSON() {
		if (DETAILS_JSON != null) {
			return DETAILS_JSON;
		} else {
			return "";
		}
	}
	public void setDETAILS_JSON(String dETAILS_JSON) {
		DETAILS_JSON = dETAILS_JSON;
	}
	public String getERROR() {
		if (ERROR != null) {
			return ERROR;
		} else {
			return "";
		}
	}
	public void setERROR(String eRROR) {
		ERROR = eRROR;
	}
	public String getIP_ADDRESS() {
		if (IP_ADDRESS != null) {
			return IP_ADDRESS;
		} else {
			return "";
		}
	}
	public void setIP_ADDRESS(String iP_ADDRESS) {
		IP_ADDRESS = iP_ADDRESS;
	}
	public String getREALM_ID() {
		if (REALM_ID != null) {
			return REALM_ID;
		} else {
			return "";
		}
	}
	public void setREALM_ID(String rEALM_ID) {
		REALM_ID = rEALM_ID;
	}
	public String getSESSION_ID() {
		if (SESSION_ID != null) {
			return SESSION_ID;
		} else {
			return "";
		}
	}
	public void setSESSION_ID(String sESSION_ID) {
		SESSION_ID = sESSION_ID;
	}
	public String getTYPE() {
		if (TYPE != null) {
			return TYPE;
		} else {
			return "";
		}
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getUSER_ID() {
		if (USER_ID != null) {
			return USER_ID;
		} else {
			return "";
		}
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	
	
}
