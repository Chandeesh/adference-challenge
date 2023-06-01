package com.adference.troubleshooting.model;

public class DecisionResponse {
	
	private String response;
	private boolean isLastNode;
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public boolean isLastNode() {
		return isLastNode;
	}
	public void setLastNode(boolean isLastNode) {
		this.isLastNode = isLastNode;
	}
	
}
