package com.adference.troubleshooting;

public class CarDecisionTree {
	
	private String question;
	private CarDecisionTree yes;
	private CarDecisionTree no;
	private String answerYes;
	private String answerNo;
	
	public CarDecisionTree(String question) {
		this.question = question;
		this.yes = null;
		this.no = null;
		this.answerYes = null;
		this.answerNo = null;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public CarDecisionTree getYes() {
		return yes;
	}

	public void setYes(CarDecisionTree yes) {
		this.yes = yes;
	}

	public CarDecisionTree getNo() {
		return no;
	}

	public void setNo(CarDecisionTree no) {
		this.no = no;
	}

	public void setAnswerYes(String answerYes) {
		this.answerYes = answerYes;
	}
	
	public String getAnswer(String answer) {
        if (answer.equalsIgnoreCase("yes")) {
            return answerYes;
        } else {
            return answerNo;
        }
    }
	
	public void setAnswerNo(String answerNo) {
		this.answerNo = answerNo;
	}
	
	public CarDecisionTree getNextNode(String answer) {
        if (answer.equalsIgnoreCase("yes")) {
            return yes;
        } else {
            return no;
        }
    }
	
	public boolean hasChildNode(String answer) {
		if(yes!=null || no != null) {
			return true;
		} return false;
	}
}
