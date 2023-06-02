package com.adference.challenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.adference.troubleshooting.CarDecisionTreeOperations;
import com.adference.troubleshooting.TroubleShootOperations;
import com.adference.troubleshooting.TroubleShootOperationsImpl;
import com.adference.troubleshooting.model.DecisionResponse;

import org.junit.Assert;


@RunWith(SpringRunner.class)
public class TroubleShootOperationsImplTest {
		
	@TestConfiguration
    static class UserServiceImplTestConfiguration {
		
        @Bean
        public TroubleShootOperations troubleShootOperations() {
            return new TroubleShootOperationsImpl();
        }
        
        @Bean
        public CarDecisionTreeOperations carOperations() {
        	return new CarDecisionTreeOperations();
        }
    }

    @Autowired
    private TroubleShootOperations troubleShootOperations;
    
    @Test
    public void getFirstQuestion() {
    	String qn = troubleShootOperations.getFirstQuestion();
    	Assert.assertEquals("Is the car silent when you turn on the key?", qn);
    }
    
    @Test
    public void getQuestionOrAnswerLeftAllBranches() {
    	String question = troubleShootOperations.getFirstQuestion();
    	DecisionResponse response = troubleShootOperations.getAnswerOrQuestion(question, "yes");
    	question = response.getResponse();
    	Assert.assertEquals("Are the battery terminals corroded?", response.getResponse());
    	response = troubleShootOperations.getAnswerOrQuestion(response.getResponse(), "yes");
    	Assert.assertEquals("Clean terminals and try starting again.", response.getResponse());
    	response = troubleShootOperations.getAnswerOrQuestion(question, "no");
    	Assert.assertEquals("Replace cables and try again.", response.getResponse());
    }
    
    @Test
    public void getQuestionOrAnswerRightAllBranches() {
    	String question = troubleShootOperations.getFirstQuestion();
    	DecisionResponse response = troubleShootOperations.getAnswerOrQuestion(question, "no");
    	question = response.getResponse();
    	Assert.assertEquals("Does the car make a clicking noise?", response.getResponse());
    	response = troubleShootOperations.getAnswerOrQuestion(question, "yes");
    	Assert.assertEquals("Replace the battery.", response.getResponse());
    	response = troubleShootOperations.getAnswerOrQuestion(question, "no");
    	question = response.getResponse();
    	Assert.assertEquals("Does the car crank up but fail to start?", question);
    	response = troubleShootOperations.getAnswerOrQuestion(question, "yes");
    	Assert.assertEquals("Check spark plug connections.", response.getResponse());
    	response = troubleShootOperations.getAnswerOrQuestion(question, "no");
    	question = response.getResponse();
    	Assert.assertEquals("Does the engine start and then die?", question);
    	response = troubleShootOperations.getAnswerOrQuestion(question, "yes");
    	question = response.getResponse();
    	Assert.assertEquals("Does your car have fuel injection?", question);
    	response = troubleShootOperations.getAnswerOrQuestion(question, "yes");
    	Assert.assertEquals("Get it in for service.", response.getResponse());
    	response = troubleShootOperations.getAnswerOrQuestion(question, "no");
    	Assert.assertEquals("Check to ensure the choke is opening and closing.", response.getResponse());
    }
    
}
