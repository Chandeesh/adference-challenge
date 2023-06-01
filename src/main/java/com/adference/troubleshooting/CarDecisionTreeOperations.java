package com.adference.troubleshooting;

import org.springframework.stereotype.Component;

import com.adference.troubleshooting.model.DecisionResponse;

@Component
public class CarDecisionTreeOperations {
	
	public CarDecisionTree createDecisionTree() {
		CarDecisionTree root = new CarDecisionTree("Is the car silent when you turn on the key?");
		CarDecisionTree yes = new CarDecisionTree("Are the battery terminals corroded?");
		CarDecisionTree no = new CarDecisionTree("Does the car make a clicking noise?");
		yes.setAnswerYes("Clean terminals and try starting again.");
		yes.setAnswerNo("Replace cables and try again.");
		no.setAnswerYes("Replace the battery.");
		root.setYes(yes);
		root.setNo(no);
		no = new CarDecisionTree("Does the car crank up but fail to start?");
		no.setAnswerYes("Check spark plug connections.");
		root.getNextNode("no").setNo(no);
		no = new CarDecisionTree("Does the engine start and then die?");
		yes = new CarDecisionTree("Does your car have fuel injection?");
		yes.setAnswerNo("Check to ensure the choke is opening and closing.");
		yes.setAnswerYes("Get it in for service.");
		no.setYes(yes);
		root.getNextNode("no").getNextNode("no").setNo(no);
		return root;
	}
	
	public DecisionResponse getAnswerorQuestion(String question, String answer) {
		CarDecisionTree curr = this.createDecisionTree();
		curr = findQuestionNode(curr, question);
		DecisionResponse response = new DecisionResponse();
		response.setLastNode(true);
		response.setResponse("Sorry! we could not resolve your issue. Please get in touch with your service partner");
		if(curr.getAnswer(answer) != null) {
			response.setLastNode(true);
			response.setResponse(curr.getAnswer(answer));
			return response;
		}
		if(curr.getNextNode(answer)!= null) {
			response.setLastNode(false);
			response.setResponse(curr.getNextNode(answer).getQuestion());
			return response;
		}
		return response;
	}
	
	public CarDecisionTree findQuestionNode(CarDecisionTree current, String question) {
		if(current == null) {
			return null;
		}
		if(current.getQuestion().equalsIgnoreCase(question)) {
			return current;
		}
		CarDecisionTree foundNode = findQuestionNode(current.getNextNode("yes"), question);
	    if (foundNode == null) {
	        foundNode = findQuestionNode(current.getNextNode("no"), question);
	    }
	    return foundNode;
	}
	
}
