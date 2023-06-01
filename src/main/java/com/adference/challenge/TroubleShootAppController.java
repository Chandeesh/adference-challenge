package com.adference.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adference.troubleshooting.TroubleShootOperations;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/adference")
public class TroubleShootAppController {

	@Autowired
	TroubleShootOperations troubleShootOperations;

	@GetMapping("/getquestion")
	public String getQuestion() {
		return troubleShootOperations.getFirstQuestion();
	}
	
	@GetMapping("/getanswerorquestion")
	public ResponseEntity<Object> getAnswerOrQuestion(@RequestParam String question, @RequestParam String answer) {
		return ResponseEntity.status(200).body(troubleShootOperations.getAnswerOrQuestion(question, answer));
	}
}
