package com.adference.troubleshooting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adference.troubleshooting.model.DecisionResponse;

@Service
public class TroubleShootOperationsImpl implements TroubleShootOperations{
	
	@Autowired
	CarDecisionTreeOperations carDecisionTreeOperations;
	
	@Override
	public String getFirstQuestion() {
		return carDecisionTreeOperations.createDecisionTree().getQuestion();
	}

	@Override
	public DecisionResponse getAnswerOrQuestion(String question, String answer) {
		return carDecisionTreeOperations.getAnswerorQuestion(question, answer);
	}

}
