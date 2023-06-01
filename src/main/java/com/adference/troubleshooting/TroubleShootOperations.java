package com.adference.troubleshooting;

import com.adference.troubleshooting.model.DecisionResponse;

public interface TroubleShootOperations {
	
	public String getFirstQuestion();
	public DecisionResponse getAnswerOrQuestion(String question, String answer); 
}
