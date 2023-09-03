package com.yyt.bp.pojo;

public class Component {
	private String ID;
	private String NAME;
	private String PARENTID;
	private String PROVIDER_ID;
	private String PROVIDER_TYPE;
	private String REALM_ID;
	private String SUB_TYPE;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPARENT_ID() {
		return PARENTID;
	}
	public void setPARENT_ID(String pARENT_ID) {
		PARENTID = pARENT_ID;
	}
	public String getPROVIDER_ID() {
		return PROVIDER_ID;
	}
	public void setPROVIDER_ID(String pROVIDER_ID) {
		PROVIDER_ID = pROVIDER_ID;
	}
	public String getPROVIDER_TYPE() {
		return PROVIDER_TYPE;
	}
	public void setPROVIDER_TYPE(String pROVIDER_TYPE) {
		PROVIDER_TYPE = pROVIDER_TYPE;
	}
	public String getREALM_ID() {
		return REALM_ID;
	}
	public void setREALM_ID(String rEALM_ID) {
		REALM_ID = rEALM_ID;
	}
	public String getSUB_TYPE() {
		return SUB_TYPE;
	}
	public void setSUB_TYPE(String sUB_TYPE) {
		SUB_TYPE = sUB_TYPE;
	}
	
	@Override
	public String toString() {
		return "Component [ID=" + ID + ", NAME=" + NAME + ", PARENTID=" + PARENTID + ", PROVIDER_ID=" + PROVIDER_ID
				+ ", PROVIDER_TYPE=" + PROVIDER_TYPE + ", REALM_ID=" + REALM_ID + ", SUB_TYPE=" + SUB_TYPE + "]";
	}
	
}
