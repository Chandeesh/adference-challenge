package com.adference.challenge;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;

import com.adference.troubleshooting.model.DecisionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChallengeApp.class)
@WebAppConfiguration
public class TroubleShootAppControllerTest {
	
	protected MockMvc mvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
	   mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test()
	public void getFirstQuestion() throws Exception {
		String uri = "/adference/getquestion";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			      .accept(MediaType.TEXT_EVENT_STREAM_VALUE)).andReturn();
		Assert.assertEquals(mvcResult.getResponse().getStatus(), 200);
		Assert.assertEquals(mvcResult.getResponse().getContentAsString(), "Is the car silent when you turn on the key?");
	}
	
	@Test()
	public void getAnswerOrQuestionQuestion() throws Exception {
		String uri = "/adference/getanswerorquestion";
		String qn = "Is the car silent when you turn on the key?";
		uri = uri+"?question="+qn+"&answer=no";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			      .accept(MediaType.APPLICATION_JSON)).andReturn();
		ObjectMapper objectMapper = new ObjectMapper();
		DecisionResponse response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), DecisionResponse.class);
		Assert.assertEquals(mvcResult.getResponse().getStatus(), 200);
		Assert.assertEquals(response.getResponse(), "Does the car make a clicking noise?");
	}
}
